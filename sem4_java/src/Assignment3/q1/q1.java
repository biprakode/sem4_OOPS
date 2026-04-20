// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Subham has n sweets, where the ith sweet is of type "Sandesh" while (i+1)th type is
// "Pithe". So, the types need to be encoded by numerals for the assignment. He noticed
// that he started to gain weight. His classmate Biprarshi advised him to only eat n/2 of
// the sweets and distribute the rest among friends. Subham still wishes to taste the
// maximum number of different types of sweets while not ignoring his classmate's
// suggestion. So, if there are n sweets of k different varieties then Subham can have a
// maximum of n/2 sweets of x (<=k) different types of y different combinations.
// Write an appropriate Java code using collections framework such that the system takes
// n (even or odd) and k as input and provides the value of x along with at least some of
// the y combinations if not all.

package Assignment3.q1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class q1 {
    // returns the maximum number of unique sweet types Subham can eat
    public static int distributeCandies(int[] candyType) {
        // toSet() gives us the unique kinds of sweets
        Set<Integer> uniqueCandy = Arrays.stream(candyType).boxed().collect(Collectors.toSet());
        // he's allowed to eat at most n/2 pieces
        int maxCandies = candyType.length / 2;
        // final answer is min of unique kinds and the eat cap
        return Math.min(maxCandies, uniqueCandy.size());
    }

    public static void main(String[] args) {
        // sample input - 6 sweets of 3 kinds
        int[] input = new int[] {1, 1, 2, 2, 3, 3};
        System.out.println("Types can be eaten = " + distributeCandies(input));
    }
}
