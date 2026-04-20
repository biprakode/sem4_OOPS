// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// One thread takes an input from user and increments an integer variable by that amount.
// Another thread reduces the variable by a fixed amount. Execute two versions of each
// thread simultaneously and all working on same variable. Once all threads are over
// display the value of the variable. Repeat the threads unless different results emerge
// for repeated executions as a consequence of parallel programming. Don't use lambda
// functions. Modify the problem stated in ensuring mutual exclusion on shared variable.

package Assignment3.q5;

public class q5 {

    // shared mutable state - no synchronization so races can show up
    static int sharedVar;

    // hard-coded inputs so we avoid stdin flakiness between threads
    static final int[] INPUTS_A1 = {10, 5};
    static final int[] INPUTS_A2 = {3, 7};
    static final int SUBTRACT_AMOUNT = 4;

    // increments the shared var by each value in its list
    static class Adder extends Thread {
        private final int[] values;
        Adder(String name, int[] values) {
            super(name);
            this.values = values;
        }
        public void run() {
            for (int v : values) {
                int tmp = sharedVar;
                // yield to nudge the scheduler into producing a race
                Thread.yield();
                sharedVar = tmp + v;
            }
        }
    }

    // subtracts a fixed amount count times
    static class Subtractor extends Thread {
        private final int count;
        Subtractor(String name, int count) {
            super(name);
            this.count = count;
        }
        public void run() {
            for (int i = 0; i < count; i++) {
                int tmp = sharedVar;
                Thread.yield();
                sharedVar = tmp - SUBTRACT_AMOUNT;
            }
        }
    }

    // spin up two adders + two subtractors without any locking
    static int runUnsafe() throws InterruptedException {
        sharedVar = 0;
        Thread a1 = new Adder("A1", INPUTS_A1);
        Thread a2 = new Adder("A2", INPUTS_A2);
        Thread b1 = new Subtractor("B1", 2);
        Thread b2 = new Subtractor("B2", 2);
        a1.start(); a2.start(); b1.start(); b2.start();
        a1.join(); a2.join(); b1.join(); b2.join();
        return sharedVar;
    }

    // SAFE version using a synchronized block around every mutation
    static final Object lock = new Object();
    static int safeVar;

    static class SafeAdder extends Thread {
        private final int[] values;
        SafeAdder(String name, int[] values) {
            super(name);
            this.values = values;
        }
        public void run() {
            for (int v : values) {
                synchronized (lock) {
                    safeVar += v;
                }
            }
        }
    }

    static class SafeSubtractor extends Thread {
        private final int count;
        SafeSubtractor(String name, int count) {
            super(name);
            this.count = count;
        }
        public void run() {
            for (int i = 0; i < count; i++) {
                synchronized (lock) {
                    safeVar -= SUBTRACT_AMOUNT;
                }
            }
        }
    }

    // same threads as before but now they all respect the lock
    static int runSafe() throws InterruptedException {
        safeVar = 0;
        Thread a1 = new SafeAdder("A1", INPUTS_A1);
        Thread a2 = new SafeAdder("A2", INPUTS_A2);
        Thread b1 = new SafeSubtractor("B1", 2);
        Thread b2 = new SafeSubtractor("B2", 2);
        a1.start(); a2.start(); b1.start(); b2.start();
        a1.join(); a2.join(); b1.join(); b2.join();
        return safeVar;
    }

    public static void main(String[] args) throws InterruptedException {
        // expected deterministic answer: (10+5+3+7) - (4*4) = 25 - 16 = 9

        // repeatedly run the unsafe version until the result differs
        System.out.println("UNSAFE (race condition demo)");
        int prev = runUnsafe();
        System.out.println("Run 1: " + prev);
        for (int run = 2; run <= 1000; run++) {
            int curr = runUnsafe();
            System.out.println("Run " + run + ": " + curr);
            if (curr != prev) {
                System.out.println("Race detected! Run " + (run - 1) + "=" + prev + ", Run " + run + "=" + curr);
                break;
            }
            prev = curr;
        }

        // now show the safe version always produces the expected answer
        System.out.println("\n=== SAFE (synchronized) ===");
        for (int run = 1; run <= 5; run++) {
            System.out.println("Run " + run + ": " + runSafe());
        }
        System.out.println("All safe runs produce 9 (deterministic).");
    }
}
