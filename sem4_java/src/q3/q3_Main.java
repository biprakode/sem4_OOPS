// Input n and consider an array of 1 to n natural numbers. Skip every second value and print the 
// resulting series. Then select every third value from the remaining numbers. Print the resulting series. 
// Repeat this process till the skip count becomes greater than the length of the list.
// {1,2,3,4,5,6,7,8,9,10}→{1,3,5,7,9}→{1,7}

// Biprarshi Biswas BCSE-2 94

package q3;
import java.util.Scanner;

public class q3_Main {
    public static boolean flag = true;

    static void display_arr(int arr[]) {
        System.out.println();
        for(int i : arr) {
            System.out.print(i + ",");
        }
    }

    static int[] display_arr(int arr[] , int jump) {
        if(jump >= arr.length-1) {
            flag = false;
            return null;
        }
        int new_size = arr.length / jump , k = 0;
        int[] new_arr = new int[new_size + 1];
        System.out.println();
        for(int i = 0 ; i<arr.length ; i+=jump) {
            new_arr[k] = arr[i];
            System.out.print(arr[i] + ",");
            k+=1;
        }
        return new_arr;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int n , j = 2;
        System.out.print("Enter n:- ");
        n = myObj.nextInt();

        int[] array = new int[n];

        for(int i = 0 ; i<n ; i++) {
            array[i] = i+1;
        }

        display_arr(array);
        while(j < n) {
            array = display_arr(array, j);
            j+=1;
            if(flag == false) {
                break;
            }
        }
        
        myObj.close();
    }
}
