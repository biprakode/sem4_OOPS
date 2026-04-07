package Assignment3.q4;

import java.util.*;

public class q4 {

    public static List<Integer> productExceptSelf(List<Integer> scores) {
        int n = scores.size();
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 1));

        // left pass: result[i] = product of everything to the left of i
        int left = 1;
        for (int i = 0; i < n; i++) {
            result.set(i, left);
            left *= scores.get(i);
        }

        // right pass: multiply in the product of everything to the right of i
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result.set(i, result.get(i) * right);
            right *= scores.get(i);
        }

        return result;
    }

    // drop scores that would obviously overflow int when multiplied together
    public static List<Integer> filterHighScorers(List<Integer> scores) {
        List<Integer> safe = new ArrayList<>();
        long running = 1;
        for (int s : scores) {
            if (running != 0 && Math.abs(running) > Integer.MAX_VALUE / Math.max(1, s)) {
                continue; // skip this high scorer
            }
            running *= s;
            safe.add(s);
        }
        return safe;
    }

    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>(Arrays.asList(2, 3, 4, 5));

        List<Integer> safe = filterHighScorers(scores);
        List<Integer> products = productExceptSelf(safe);

        System.out.println("Scores:   " + safe);
        System.out.println("Products: " + products);
        // for [2,3,4,5] -> [60, 40, 30, 24]
    }
}
