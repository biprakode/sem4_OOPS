// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q9 - abstract planet base class

package Assignment2.q9;

public abstract class Planet {
    // every planet shares these three attributes
    private String name;
    private String atmosphere;
    private String surfaceComposition;

    public Planet(String name, String atmosphere, String surfaceComposition) {
        this.name = name;
        this.atmosphere = atmosphere;
        this.surfaceComposition = surfaceComposition;
    }

    // visitor hook - concrete planets call the right overload on the explorer
    public abstract void accept(Explorer explorer);

    public String getName() { return name; }
    public String getAtmosphere() { return atmosphere; }
    public String getSurfaceComposition() { return surfaceComposition; }
}
