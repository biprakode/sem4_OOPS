// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// A Planet Explorer routinely travels across the planets in the Solar System to discover
// life form, minerals available, etc. However, the method of exploring is different on
// each planet, due to the difference in atmosphere and surface composition. Every
// explorer should have an explore method that is defined based on the type of the
// explorer and the planet where (s)he is exploring. Consider three planets - Mars, Venus,
// and Saturn. Implement it using interfaces, abstract class, inheritance.

package Assignment2.q9;

public class Main {
    public static void main(String[] args) {
        // one of each planet + a single explorer
        Planet[] planets = { new Mars(), new Venus(), new Saturn() };
        Explorer explorer = new PlanetExplorer();

        // visit every planet - each one picks the right explore method
        for (Planet p : planets) {
            p.accept(explorer);
            System.out.println();
        }
    }
}
