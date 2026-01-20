// Write a program that accepts radius of a circle and displays area of the circle. Overload the 
// constructor to accept radius as input and another circle object as input. Then show the effect of 
// shallow vs deep copy of objects. Declare a constant pi equals to 3.14 using OOP concept. 

// Biprarshi Biswas BCSE-2 94


package q2;
import java.util.Scanner;



public class Circle_Test {
    public static void main(String[] args) {
        double r1 , r2 , r3 , r4;

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter r1:- ");
        r1 = myObj.nextDouble();
        System.out.print("Enter r2:- ");
        r2 = myObj.nextDouble();

        Circle circ1 = new Circle(r1);
        Circle circ2 = new Circle(r2);

        System.out.println(circ1);
        System.out.println(circ2);

        //shallow_copy
        Circle circ3 = circ1;
        System.out.print("Enter r3:- ");
        r3 = myObj.nextDouble();
        circ3.set_r(r3);
        System.out.println(circ3 + "\n" + circ1 + "\n" + "shallow_copy");

        //deep_copy
        Circle circ4 = new Circle(circ2);
        System.out.print("Enter r4:- ");
        r4 = myObj.nextDouble();
        circ4.set_r(r4);
        System.out.println(circ4 + "\n" + circ2 + "\n" + "deep_copy");

        myObj.close();
    }
}
