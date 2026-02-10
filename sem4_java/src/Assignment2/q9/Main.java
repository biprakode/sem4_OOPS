package Assignment2.q9;

public class Main {
    public static void main(String[] args) {
        Planet[] planets = { new Mars(), new Venus(), new Saturn() };
        Explorer explorer = new PlanetExplorer();

        for (Planet p : planets) {
            p.accept(explorer);
            System.out.println();
        }
    }
}
