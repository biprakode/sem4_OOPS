// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// An integer array representing height of length n is given as input. There are n vertical
// lines drawn from the array such that the two endpoints of the ith line are (i, 0) and
// (i, height[i]). Any two lines along with the x-axis form a container that can hold water.
// Find the largest container that can hold maximum water. Collection classes are NOT allowed.

package Assignment2.q1;

public class Rain {
    public static void main(String[] args) {
        // sample heights
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] res = new int[3];
        res = maxArea(heights);
        System.out.println("The area of the largest container is: " + res[0] + " between indices " + res[1] + " & " + res[2]);
    }

    // two-pointer sweep - shrink from the side with the shorter line
    static int[] maxArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return null;
        }

        int i = 0;
        int j = heights.length - 1;
        int res = 0;
        int max_i = -1, max_j = -1;

        while (i < j) {
            // water height is limited by the shorter of the two lines
            int h = Math.min(heights[i], heights[j]);
            res = Math.max(res, (j - i) * h);
            max_i = Math.max(i, max_i);
            max_j = Math.max(j, max_j);
            // move whichever side is shorter inward - we might find a taller line
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{res, max_i, max_j};
    }
}
