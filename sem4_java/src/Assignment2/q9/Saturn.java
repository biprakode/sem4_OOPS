// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q9 - Saturn planet

package Assignment2.q9;

public class Saturn extends Planet {
    private boolean hasRings;

    public Saturn() {
        super("Saturn", "Hydrogen and helium", "Gas giant no solid surface");
        this.hasRings = true;
    }

    @Override
    public void accept(Explorer explorer) { explorer.explore(this); }

    public boolean hasRings() { return hasRings; }
}
