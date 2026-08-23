/*
 * TOPIC: Inheritance basics
 * Concept intro:
 * Inheritance is an "is-a" relationship: a Car is a Vehicle with extra details.
 * Why it matters: reuse shared behavior while specializing where needed.
 * Link: extends classes/objects and constructors from 01_Fundamentals.
 */
public class InheritanceBasicsDemo {
    static class Vehicle {
        String brand;
        Vehicle(String brand) { this.brand = brand; }
        void move() { System.out.println(brand + " moves."); }
    }
    static class Car extends Vehicle {
        int doors;
        Car(String brand, int doors) { super(brand); this.doors = doors; }
        void honk() { System.out.println("Car honk with " + doors + " doors."); }
    }

    public static void main(String[] args) {
        // Beginner example: create child object and call inherited + own methods.
        Car car = new Car("Toyota", 4); // Child constructor calls parent via super(brand).
        car.move(); // Inherited method from Vehicle works directly on Car object.
        car.honk(); // Child-specific behavior adds specialization.

        // Intermediate example: upcasting for API flexibility.
        Vehicle v = new Car("Honda", 2);
        v.move(); // Parent reference can hold any subtype instance.
        System.out.println("Intermediate: upcasting lets one method accept many Vehicle subtypes.");

        // Pro example: design guidance trade-off.
        System.out.println("Pro note: prefer composition when relationship is 'has-a', not 'is-a'.");
    }
}

/*
 * Common pitfalls:
 * 1) Using inheritance for code reuse when there is no true "is-a" relation.
 * 2) Forgetting super(...) in child constructor initialization.
 * 3) Creating deep inheritance chains that become hard to reason about.
 *
 * Practice problems:
 * Easy: Person -> Student with extra field.
 * Medium: Vehicle -> ElectricCar with overridden move().
 * Hard: redesign an overly deep hierarchy using composition.
 */
