// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Create a program for ordering Pizza. The user should mention the size of the Pizza
// and the toppings he/she wants. A user may ask for any toppings. Implement this using
// (i) variable arguments concept and (ii) command line arguments.

package Assignmen1.q6;

// abstract parent - every pizza style must fill in these steps
public abstract class Pizza {
    protected String dough = "";
    protected String toppings = "";

    abstract public void bake();
    abstract public void cut();
    abstract public void deliver();
    abstract public String GetDough();
    abstract public String GetToppings();
}
