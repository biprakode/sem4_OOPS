package Assignment2.q9;

public abstract class Planet {
    private String name;
    private String atmosphere;
    private String surfaceComposition;

    public Planet(String name, String atmosphere, String surfaceComposition) {
        this.name = name;
        this.atmosphere = atmosphere;
        this.surfaceComposition = surfaceComposition;
    }

    public abstract void accept(Explorer explorer);

    public String getName() { return name; }
    public String getAtmosphere() { return atmosphere; }
    public String getSurfaceComposition() { return surfaceComposition; }
}
