// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q6 - Chicago style pizza

package Assignmen1.q6;

public class ChicagoPizza extends Pizza {

    ChicagoPizza() {
        // Chicago style default dough and toppings
        dough = "Bread Flour, Cornmeal, Yeast";
        toppings = "Mozzarella Cheese, Sausage, Peppers, Onions";
    }

    public String GetDough() {
        return dough;
    }

    public String GetToppings() {
        return toppings;
    }

    @Override
    public void bake() {
        System.out.println("Chicago style pizza is baking");
        // fake the baking time
        try { Thread.sleep(5000); } catch (InterruptedException e) { }
        System.out.println("Chicago style pizza is baked");
    }

    @Override
    public void cut() {
        System.out.println("Chicago style pizza is cut");
    }

    @Override
    public void deliver() {
        System.out.println("Chicago style pizza is delivered");
    }
}
