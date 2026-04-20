// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Write a program that accepts radius of a circle and displays area of the circle.
// Overload the constructor to accept radius as input and another circle object as input.
// Then show the effect of shallow vs deep copy of objects. Declare a constant pi equals
// to 3.14 using OOP concept.

package Assignmen1.q2;

public class Circle {
    // constant pi as required by the question
    public static final double PI = 3.14;
    private double r;

    double get_r() {
        return this.r;
    }

    void set_r(double r) {
        this.r = r;
    }

    // constructor that takes a radius directly
    Circle(double r) {
        this.r = r;
    }

    // overloaded constructor that copies from another circle (deep copy)
    Circle(Circle q2_obj) {
        this.r = q2_obj.get_r();
    }

    double area() {
        return PI * this.r * this.r;
    }

    @Override
    public String toString() {
        String res = String.format("%.4f", area());
        return "Area is :- " + res;
    }
}
