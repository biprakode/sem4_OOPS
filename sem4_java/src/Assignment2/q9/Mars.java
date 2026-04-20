// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q9 - Mars planet

package Assignment2.q9;

public class Mars extends Planet {
    private boolean hasWaterIce;

    public Mars() {
        super("Mars", "Thin CO2", "Iron oxide rocky");
        this.hasWaterIce = true;
    }

    // hands itself to the explorer so the right overload fires
    @Override
    public void accept(Explorer explorer) { explorer.explore(this); }

    public boolean hasWaterIce() { return hasWaterIce; }
}
