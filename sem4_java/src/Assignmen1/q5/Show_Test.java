// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Write a program where class contains void show(int) to display the argument passed.
// Call the function once with short as actual parameter and again double as actual
// parameter. Add another function as void show(double). Repeat the calls.
// Observe the outcomes in each case.

package Assignmen1.q5;

public class Show_Test {
    public static void main(String[] args) {
        // one value of each relevant type
        Integer integer = 5;
        Double dbl = 7.1923;
        Short shrt = 12;

        // generic T_Show wraps any type and prints it
        T_Show<Short> cl1 = new T_Show<Short>(shrt);
        System.out.print("Short:- ");
        cl1.show();

        T_Show<Integer> cl2 = new T_Show<Integer>(integer);
        System.out.print("Integer:- ");
        cl2.show();

        T_Show<Double> cl3 = new T_Show<Double>(dbl);
        System.out.print("Double:- ");
        cl3.show();
    }
}
