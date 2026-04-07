package Assignment3.q7;

import java.util.ArrayList;
import java.util.List;

public class q7 {

    // Custom rules:
    //   "fizzbuzz" if divisible by 5 AND 7
    //   "fizz"     if divisible by 5 AND NOT 9
    //   "buzz"     if divisible by 7 AND NOT 3
    //   number     if NOT divisible by 7 OR 5  (i.e., not divisible by both 7 and 5 — meaning not div by either)
    //   Some indices match none of these and are skipped.

    enum Category { FIZZBUZZ, FIZZ, BUZZ, NUMBER, SKIP }

    static Category classify(int i) {
        boolean div5 = i % 5 == 0;
        boolean div7 = i % 7 == 0;
        boolean div3 = i % 3 == 0;
        boolean div9 = i % 9 == 0;

        if (div5 && div7) return Category.FIZZBUZZ;
        if (div5 && !div9) return Category.FIZZ;
        if (div7 && !div3) return Category.BUZZ;
        // "not divisible by 7 OR 5" means: not div by 7 AND not div by 5
        if (!div7 && !div5) return Category.NUMBER;
        return Category.SKIP;
    }

    static class FizzBuzz {
        private final int n;
        private int current = 1;

        FizzBuzz(int n) {
            this.n = n;
        }

        synchronized void fizz(List<String> output) throws InterruptedException {
            while (current <= n) {
                while (current <= n && classify(current) != Category.FIZZ) wait();
                if (current > n) return;
                output.add("fizz");
                current++;
                notifyAll();
            }
        }

        synchronized void buzz(List<String> output) throws InterruptedException {
            while (current <= n) {
                while (current <= n && classify(current) != Category.BUZZ) wait();
                if (current > n) return;
                output.add("buzz");
                current++;
                notifyAll();
            }
        }

        synchronized void fizzbuzz(List<String> output) throws InterruptedException {
            while (current <= n) {
                while (current <= n && classify(current) != Category.FIZZBUZZ) wait();
                if (current > n) return;
                output.add("fizzbuzz");
                current++;
                notifyAll();
            }
        }

        synchronized void number(List<String> output) throws InterruptedException {
            while (current <= n) {
                while (current <= n && classify(current) != Category.NUMBER) wait();
                if (current > n) return;
                output.add(String.valueOf(current));
                current++;
                notifyAll();
            }
        }

        // A dedicated "skipper" thread advances past indices that match no category
        synchronized void skipper() throws InterruptedException {
            while (current <= n) {
                while (current <= n && classify(current) != Category.SKIP) wait();
                if (current > n) return;
                current++;
                notifyAll();
            }
        }
    }

    static List<String> runFizzBuzz(int n) throws InterruptedException {
        FizzBuzz fb = new FizzBuzz(n);
        List<String> output = new ArrayList<>();

        Thread tFizz = new Thread(() -> { try { fb.fizz(output); } catch (InterruptedException ignored) {} });
        Thread tBuzz = new Thread(() -> { try { fb.buzz(output); } catch (InterruptedException ignored) {} });
        Thread tFizzBuzz = new Thread(() -> { try { fb.fizzbuzz(output); } catch (InterruptedException ignored) {} });
        Thread tNumber = new Thread(() -> { try { fb.number(output); } catch (InterruptedException ignored) {} });
        Thread tSkip = new Thread(() -> { try { fb.skipper(); } catch (InterruptedException ignored) {} });

        tFizz.start(); tBuzz.start(); tFizzBuzz.start(); tNumber.start(); tSkip.start();
        tFizz.join(); tBuzz.join(); tFizzBuzz.join(); tNumber.join(); tSkip.join();
        return output;
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 10;
        List<String> result = runFizzBuzz(n);
        System.out.println("n=" + n + ": " + result);
        // Expected: [1, 2, 3, 4, fizz, 6, buzz, 8, 9, fizz]

        // Verify
        List<String> expected = List.of("1", "2", "3", "4", "fizz", "6", "buzz", "8", "9", "fizz");
        System.out.println("Matches expected: " + result.equals(expected));

        // Also show n=35 to see fizzbuzz (35 = 5*7)
        System.out.println("\nn=35: " + runFizzBuzz(35));
    }
}
