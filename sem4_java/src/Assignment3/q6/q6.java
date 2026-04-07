package Assignment3.q6;

import java.util.ArrayList;
import java.util.List;

public class q6 {

    static class FizzBuzz {
        private final int n;
        private int current = 1;

        FizzBuzz(int n) {
            this.n = n;
        }

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
            System.out.println("All " + maxRuns + " runs produced identical output — synchronization is correct.");
        }
    }
}
