// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// You have the number of goals scored by the football teams of the world cup for a year.
// Store them in a collection. Find the product of all the scores except itself. The
// product of any prefix or suffix is expected to fit in Java's int range. Otherwise,
// remove the very high scorers. Write program to display the products for the
// corresponding scores as input. The program should run in less than O(n^2) time and
// should not use '/'.

package Assignment3.q4;

import java.util.*;

public class q4 {

    // classic prefix + suffix product trick - O(n) time, no division
    public static List<Integer> productExceptSelf(List<Integer> scores) {
        int n = scores.size();
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 1));

        // left pass - result[i] holds product of everything to the left of i
        int left = 1;
        for (int i = 0; i < n; i++) {
            result.set(i, left);
            left *= scores.get(i);
        }

        // right pass - fold in the product of everything to the right of i
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result.set(i, result.get(i) * right);
            right *= scores.get(i);
        }

        return result;
    }

    // drop any score that would overflow int when multiplied in
    public static List<Integer> filterHighScorers(List<Integer> scores) {
        List<Integer> safe = new ArrayList<>();
        long running = 1;
        for (int s : scores) {
            // rough overflow check using integer max
            if (running != 0 && Math.abs(running) > Integer.MAX_VALUE / Math.max(1, s)) {
                continue; // skip this high scorer
            }
            running *= s;
            safe.add(s);
        }
        return safe;
    }

    public static void main(String[] args) {
        // sample list of world cup goal tallies
        List<Integer> scores = new ArrayList<>(Arrays.asList(2, 3, 4, 5));

        // throw out anything that would overflow, then compute the products
        List<Integer> safe = filterHighScorers(scores);
        List<Integer> products = productExceptSelf(safe);

        System.out.println("Scores:   " + safe);
        System.out.println("Products: " + products);
        // for [2,3,4,5] -> [60, 40, 30, 24]
    }
}
