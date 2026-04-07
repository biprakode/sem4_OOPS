package Assignment2.q9;

public class Mars extends Planet {
    private boolean hasWaterIce;

    public Mars() {
        super("Mars", "Thin CO2", "Iron oxide rocky");
        this.hasWaterIce = true;
    }

    @Override
    public void accept(Explorer explorer) { explorer.explore(this); }

    public boolean hasWaterIce() { return hasWaterIce; }
}
