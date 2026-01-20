// Write a program that accepts a String and assigns it to another. Check the outcome of 
// comparison with == and equals() method. Take two Strings and put same input for them. Repeat the 
// equality checking. Observe the outcome. 

// Biprarshi Biswas BCSE-2 94

package q4;
import java.util.Scanner;

public class String_Test {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.print("Enter str:- ");
        String str1 = myObj.nextLine();

        String str2 = str1;

        System.out.println("After assignment");
        System.out.println("equals = " + str1.equals(str2));
        System.out.println("== :" + (str2 == str1));

        System.out.print("Enter str:- ");
        String str3 = myObj.nextLine();
        System.out.print("Enter same str:- ");
        String str4 = myObj.nextLine();

        System.out.println("equals = " + str3.equals(str4));
        System.out.println("== = " + (str3 == str4));
        myObj.close();
    }
}
