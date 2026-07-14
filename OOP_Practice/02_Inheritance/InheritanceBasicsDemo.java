/*
 * TOPIC: Inheritance basics
 * Analogy: Child classes inherit family traits from a parent class.
 * Link: Extends classes/objects and constructors from 01_Fundamentals.
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
        Car car = new Car("Toyota", 4); // Create child object; parent state initialized via super.
        car.move(); // Child inherits parent method directly.
        car.honk(); // Child adds its own behavior beyond parent class.

        Vehicle v = new Car("Honda", 2);
        v.move();
        System.out.println("Intermediate: upcasting lets one API handle many subtypes.");

        System.out.println("Pro note: use inheritance for 'is-a' relationships, not just code reuse.");
    }
}

/*
 * Pitfalls: forcing wrong inheritance, forgetting super(), abusing deep inheritance chains.
 * Practice: Animal->Dog/Cat, Employee->Manager, multilevel inheritance demo.
 */

