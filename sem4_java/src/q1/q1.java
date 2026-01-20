// Write a program to accept two short integers from user and display the sum. Check what happens 
// when the sum exceeds the maximum range of short.

// Biprarshi Biswas BCSE-2 94


package q1;
import java.util.Scanner;


public class q1 {
    public static void main(String[] args) {
        short num1 , num2;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter num 1:- ");
        num1 = myObj.nextShort();
        System.out.println("Enter num 2:- ");
        num2 = myObj.nextShort();

        System.out.println("Sum = " + (num1+num2));
        myObj.close();
    }
}
