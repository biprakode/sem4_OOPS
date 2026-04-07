package Assignment3.q5;

public class q5 {

    // Shared mutable state (no synchronization)
    static int sharedVar;

    // Using a small fixed list of inputs instead of BufferedReader to avoid racy stdin reads.
    static final int[] INPUTS_A1 = {10, 5};
    static final int[] INPUTS_A2 = {3, 7};
    static final int SUBTRACT_AMOUNT = 4;

    static class Adder extends Thread {
        private final int[] values;
        Adder(String name, int[] values) {
            super(name);
            this.values = values;
        }
        public void run() {
            for (int v : values) {
                int tmp = sharedVar;
                // yield to increase chance of race
                Thread.yield();
                sharedVar = tmp + v;
            }
        }
    }

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

    // SAFE version using synchronized

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
        // Expected deterministic result: (10+5+3+7) - (4*4) = 25 - 16 = 9

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

        System.out.println("\n=== SAFE (synchronized) ===");
        for (int run = 1; run <= 5; run++) {
            System.out.println("Run " + run + ": " + runSafe());
        }
        System.out.println("All safe runs produce 9 (deterministic).");
    }
}
