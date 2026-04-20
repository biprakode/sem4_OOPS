// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Write a program to accept two short integers from user and display the sum.
// Check what happens when the sum exceeds the maximum range of short.

package Assignmen1.q1;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        short num1, num2;
        // grab two shorts from the user
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter num 1:- ");
        num1 = myObj.nextShort();
        System.out.println("Enter num 2:- ");
        num2 = myObj.nextShort();

        // note - java auto promotes shorts to int for the addition, so overflow is hidden
        System.out.println("Sum = " + (num1 + num2));
        myObj.close();
    }
}
