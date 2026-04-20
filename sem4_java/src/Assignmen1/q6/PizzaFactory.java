// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q6 - creates the right pizza object based on user choice

package Assignmen1.q6;

public class PizzaFactory {
    // numeric menu -> concrete pizza subclass
    public static Pizza createPizza(int choice) {
        switch (choice) {
            case 1:
                return new NewYorkPizza();
            case 2:
                return new ChicagoPizza();
            case 3:
                return new HawaiianPizza();
            case 4:
                return new SicillianPizza();
            default:
                return null;
        }
    }
}
