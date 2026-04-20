// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Create a program for ordering Pizza. The user should mention the size of the Pizza
// and the toppings he/she wants. A user may ask for any toppings. Implement this using
// (i) variable arguments concept and (ii) command line arguments.

package Assignmen1.q6;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Pizza Factory");
        // bail out with usage if the user forgets to pass anything
        if (args.length == 0) {
            System.out.println("Usage: java Assignmen1.q6.Main <pizza_type_id1> <pizza_type_id2> ...");
            System.out.println("Types: 1: NY, 2: Chicago, 3: Hawaiian, 4: Sicilian");
            return;
        }
        // every command line arg is a pizza order
        for (String arg : args) {
            try {
                processPizzaChoice(arg);
            } catch (IllegalArgumentException e) {
                System.err.println("Error processing choice '" + arg + "': " + e.getMessage());
            }
        }
        System.out.println("All orders processed. Program Terminated.");
    }

    private static void processPizzaChoice(String arg) {
        int choice;
        // parse first, fail early if the arg is not a number
        try {
            choice = Integer.parseInt(arg);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Input must be a valid number (1-4).");
        }
        Assignmen1.q6.Pizza pizza = Assignmen1.q6.PizzaFactory.createPizza(choice);
        if (pizza == null) {
            throw new IllegalArgumentException("No pizza found for ID: " + choice);
        }
        displayPizzaDetails(pizza);
    }

    // fires the full workflow: dough, toppings, bake, cut, deliver
    static void displayPizzaDetails(Pizza pizza) {
        String dough = pizza.GetDough();
        String toppings = pizza.GetToppings();
        System.out.println("Dough: " + dough);
        System.out.println("Toppings: " + toppings);
        pizza.bake();
        pizza.cut();
        pizza.deliver();
    }
}
