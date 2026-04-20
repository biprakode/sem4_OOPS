// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q6 - Sicilian style pizza

package Assignmen1.q6;

public class SicillianPizza extends Pizza {

    SicillianPizza() {
        // sicilian defaults
        dough = "Thick Crust Dough";
        toppings = "Mozzarella Cheese, Tomato Sauce, Olives";
    }

    public String GetDough() {
        return dough;
    }

    public String GetToppings() {
        return toppings;
    }

    @Override
    public void bake() {
        System.out.println("Sicilian style pizza is baking");
        // oven time simulation
        try { Thread.sleep(5000); } catch (InterruptedException e) { }
        System.out.println("Sicilian style pizza is baked");
    }

    @Override
    public void cut() {
        System.out.println("Sicilian style pizza is cut");
    }

    @Override
    public void deliver() {
        System.out.println("Sicilian style pizza is delivered");
    }
}
