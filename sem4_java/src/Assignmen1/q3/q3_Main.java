// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Input n and consider an array of 1 to n natural numbers. Skip every second value and
// print the resulting series. Then select every third value from the remaining numbers.
// Print the resulting series. Repeat this process till the skip count becomes greater
// than the length of the list. {1,2,3,4,5,6,7,8,9,10} -> {1,3,5,7,9} -> {1,7}

package Assignmen1.q3;
import java.util.Scanner;

public class q3_Main {
    // flag that tells main to stop when the jump outgrows the array
    public static boolean flag = true;

    // simple printing helper
    static void display_arr(int arr[]) {
        System.out.println();
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    // overloaded version: prints and returns a new array picking every jump-th element
    static int[] display_arr(int arr[], int jump) {
        if (jump >= arr.length - 1) {
            flag = false;
            return null;
        }
        int new_size = arr.length / jump, k = 0;
        int[] new_arr = new int[new_size + 1];
        System.out.println();
        // walk through and keep only indices 0, jump, 2*jump...
        for (int i = 0; i < arr.length; i += jump) {
            new_arr[k] = arr[i];
            System.out.print(arr[i] + ",");
            k += 1;
        }
        return new_arr;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int n, j = 2;
        System.out.print("Enter n:- ");
        n = myObj.nextInt();

        // build 1..n
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        display_arr(array);
        // keep thinning the array with bigger and bigger jumps
        while (j < n) {
            array = display_arr(array, j);
            j += 1;
            if (flag == false) {
                break;
            }
        }

        myObj.close();
    }
}
