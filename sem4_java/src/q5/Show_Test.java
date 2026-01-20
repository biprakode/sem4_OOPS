// Write a program where class contains void show(int) to display the argument passed. Call the 
// function once with short as actual parameter and again double as actual parameter. Add another 
// function as void show(double) . Repeat the calls. Observe the outcomes in each case.

// Biprarshi Biswas BCSE-2 94

package q5;

public class Show_Test {
    public static void main(String[] args) {
        Integer integer = 5;
        Double dbl = 7.1923;
        Short shrt = 12;

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
