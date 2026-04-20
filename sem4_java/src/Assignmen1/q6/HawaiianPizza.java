// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q6 - Hawaiian style pizza

package Assignmen1.q6;

public class HawaiianPizza extends Pizza {

    HawaiianPizza() {
        // classic dough and ham+pineapple combo
        dough = "Classic Pizza Dough";
        toppings = "Mozzarella Cheese, Ham, Pineapple";
    }

    public String GetDough() {
        return dough;
    }

    public String GetToppings() {
        return toppings;
    }

    @Override
    public void bake() {
        System.out.println("Hawaiian style pizza is baking");
        // simulate oven time
        try { Thread.sleep(5000); } catch (InterruptedException e) { }
        System.out.println("Hawaiian style pizza is baked");
    }

    @Override
    public void cut() {
        System.out.println("Hawaiian style pizza is cut");
    }

    @Override
    public void deliver() {
        System.out.println("Hawaiian style pizza is delivered");
    }
}
