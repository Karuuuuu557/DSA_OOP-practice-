/*
 * TOPIC: Runtime polymorphism (dynamic dispatch)
 * Analogy: One remote control interface, different TV brands respond differently.
 * Link: Uses overriding from 02_Inheritance.
 */
public class RuntimePolymorphismDemo {
    static abstract class Shape { abstract double area(); }
    static class Circle extends Shape {
        double r;
        Circle(double r) { this.r = r; }
        @Override double area() { return Math.PI * r * r; }
    }
    static class Rectangle extends Shape {
        double w, h;
        Rectangle(double w, double h) { this.w = w; this.h = h; }
        @Override double area() { return w * h; }
    }

    public static void main(String[] args) {
        Shape s = new Circle(2); // Parent type reference keeps API generic.
        System.out.println("Beginner area: " + s.area()); // Runtime calls Circle.area().

        Shape[] list = {new Circle(1), new Rectangle(2, 3)};
        double total = 0;
        for (Shape sh : list) total += sh.area();
        System.out.println("Intermediate total area: " + total);

        System.out.println("Pro: code depends on abstraction (Shape), enabling easy new shape types.");
    }
}

/*
 * Pitfalls: casting without instanceof checks, using final methods (cannot override), expecting fields to dispatch polymorphically.
 * Practice: media players, transport fare calculators, game character attacks.
 */
