package Assignment2.q9;

public class Venus extends Planet {
    private double surfaceTemp;

    public Venus() {
        super("Venus", "Dense CO2 sulfuric acid clouds", "Volcanic basaltic rock");
        this.surfaceTemp = 465;
    }

    @Override
    public void accept(Explorer explorer) { explorer.explore(this); }

    public double getSurfaceTemp() { return surfaceTemp; }
}
