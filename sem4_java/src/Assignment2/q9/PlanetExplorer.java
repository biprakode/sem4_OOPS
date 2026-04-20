// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q9 - concrete explorer implementation

package Assignment2.q9;

public class PlanetExplorer implements Explorer {

    // exploring Mars - call out its surface facts
    @Override
    public void explore(Mars mars) {
        System.out.println("Exploring = " + mars.getName());
        System.out.println("Atmosphere = " + mars.getAtmosphere());
        System.out.println("Surface Composition = " + mars.getSurfaceComposition());
        System.out.println("Pretty bad place to live");
    }

    // exploring Venus
    @Override
    public void explore(Venus venus) {
        System.out.println("Exploring = " + venus.getName());
        System.out.println("Atmosphere = " + venus.getAtmosphere());
        System.out.println("Surface Composition = " + venus.getSurfaceComposition());
        System.out.println("Tough competition to Delhi");
    }

    // exploring Saturn
    @Override
    public void explore(Saturn saturn) {
        System.out.println("Exploring = " + saturn.getName());
        System.out.println("Atmosphere = " + saturn.getAtmosphere());
        System.out.println("Surface Composition = " + saturn.getSurfaceComposition());
        System.out.println("Cool Ring tho");
    }
}
