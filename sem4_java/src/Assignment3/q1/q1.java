package Assignment3.q1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class q1 {
    public static int distributeCandies(int[] candyType) {
        Set<Integer> uniqueCandy = Arrays.stream(candyType).boxed().collect(Collectors.toSet());
        int maxCandies = candyType.length / 2;
        return Math.min(maxCandies , uniqueCandy.size());
    }


    public static void main(String[] args) {
        int[] input = new int[] {1,1,2,2,3,3};
        System.out.println("Types can be eaten = " + distributeCandies(input));
    }
}
