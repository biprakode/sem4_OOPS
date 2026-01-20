package q2;
public class Circle {
    public static final double PI = 3.14;
    private double r;
    
    double get_r() {
        return this.r;
    }

    void set_r(double r) {
        this.r = r;
    }

    Circle(double r) {
        this.r = r;
    }
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
