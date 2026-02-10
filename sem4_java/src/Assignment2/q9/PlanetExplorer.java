package Assignment2.q9;

public class PlanetExplorer implements Explorer{

    @Override
    public void explore(Mars mars) {
        System.out.println("Exploring = " + mars.getName());
        System.out.println("Atmosphere = " + mars.getAtmosphere());
        System.out.println("Surface Composition = " + mars.getSurfaceComposition());

        System.out.println("Pretty bad place to live");
    }

    @Override
    public void explore(Venus venus) {
        System.out.println("Exploring = " + venus.getName());
        System.out.println("Atmosphere = " + venus.getAtmosphere());
        System.out.println("Surface Composition = " + venus.getSurfaceComposition());

        System.out.println("Tough competition to Delhi");
    }

    @Override
    public void explore(Saturn saturn) {
        System.out.println("Exploring = " + saturn.getName());
        System.out.println("Atmosphere = " + saturn.getAtmosphere());
        System.out.println("Surface Composition = " + saturn.getSurfaceComposition());

        System.out.println("Cool Ring tho");
    }
}
