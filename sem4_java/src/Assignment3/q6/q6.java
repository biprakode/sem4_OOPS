// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// You have the four functions: printFizz, printBuzz, printFizzBuzz and printNumber.
// You are given an instance of FizzBuzz passed to four different threads.
//   Thread A: fizz()  -> "fizz"
//   Thread B: buzz()  -> "buzz"
//   Thread C: fizzbuzz() -> "fizzbuzz"
//   Thread D: number() -> integers only
// Repeat the threads unless different results emerge for repeated executions as a
// consequence of parallel programming. You may use lambda function for only creating
// Runnable objects.

package Assignment3.q6;

import java.util.ArrayList;
import java.util.List;

public class q6 {

    // all four worker methods sit on one instance that shares a counter
    static class FizzBuzz {
        private final int n;
        private int current = 1;

        FizzBuzz(int n) {
            this.n = n;
        }

        // only prints when current is divisible by 3 but not 5
        synchronized void fizz(List<String> output) throws InterruptedException {
            while (current <= n) {
                while (current <= n && !(current % 3 == 0 && current % 5 != 0)) {
                    wait();
                }
                if (current > n) return;
                output.add("fizz");
                current++;
                notifyAll();
            }
        }

        // only prints when current is divisible by 5 but not 3
        synchronized void buzz(List<String> output) throws InterruptedException {
            while (current <= n) {
                while (current <= n && !(current % 5 == 0 && current % 3 != 0)) {
                    wait();
                }
                if (current > n) return;
                output.add("buzz");
                current++;
                notifyAll();
            }
        }

        // only prints when current is divisible by both 3 and 5
        synchronized void fizzbuzz(List<String> output) throws InterruptedException {
            while (current <= n) {
                while (current <= n && !(current % 3 == 0 && current % 5 == 0)) {
                    wait();
                }
                if (current > n) return;
                output.add("fizzbuzz");
                current++;
                notifyAll();
            }
        }

        // only prints when current is divisible by neither 3 nor 5
        synchronized void number(List<String> output) throws InterruptedException {
            while (current <= n) {
                while (current <= n && (current % 3 == 0 || current % 5 == 0)) {
                    wait();
                }
                if (current > n) return;
                output.add(String.valueOf(current));
                current++;
                notifyAll();
            }
        }
    }

    // kick off all four threads and collect the outputs
    static List<String> runFizzBuzz(int n) throws InterruptedException {
        FizzBuzz fb = new FizzBuzz(n);
        List<String> output = new ArrayList<>();

        Thread tFizz = new Thread(() -> {
            try { fb.fizz(output); } catch (InterruptedException ignored) {}
        });
        Thread tBuzz = new Thread(() -> {
            try { fb.buzz(output); } catch (InterruptedException ignored) {}
        });
        Thread tFizzBuzz = new Thread(() -> {
            try { fb.fizzbuzz(output); } catch (InterruptedException ignored) {}
        });
        Thread tNumber = new Thread(() -> {
            try { fb.number(output); } catch (InterruptedException ignored) {}
        });

        tFizz.start(); tBuzz.start(); tFizzBuzz.start(); tNumber.start();
        tFizz.join(); tBuzz.join(); tFizzBuzz.join(); tNumber.join();
        return output;
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 15;
        int maxRuns = 5;

        // run once, then repeat to confirm the output is stable
        List<String> prev = runFizzBuzz(n);
        System.out.println("Run 1: " + prev);

        boolean allIdentical = true;
        for (int run = 2; run <= maxRuns; run++) {
            List<String> curr = runFizzBuzz(n);
            System.out.println("Run " + run + ": " + curr);
            if (!curr.equals(prev)) {
                allIdentical = false;
                System.out.println("Difference found at run " + run + " (unexpected with correct sync).");
                break;
            }
            prev = curr;
        }
        if (allIdentical) {
            System.out.println("All " + maxRuns + " runs produced identical output - synchronization is correct.");
        }
    }
}
