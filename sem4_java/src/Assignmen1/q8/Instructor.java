// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q8 - describes an instructor with name and contact number

package Assignmen1.q8;

public class Instructor {
    private String number;
    private String name;

    Instructor(String number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Instructor: %s (ID: %s)", name, number);
    }

    // basic getters and setters
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
