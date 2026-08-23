/*
 * TOPIC: Method overriding
 * Concept intro:
 * Overriding means child class customizes inherited behavior with same method signature.
 * Why it matters: enables runtime polymorphism (dynamic dispatch).
 * Link: builds directly on inheritance.
 */
public class MethodOverridingDemo {
    static class Animal {
        void sound() { System.out.println("Generic animal sound"); }
    }
    static class Dog extends Animal {
        @Override
        void sound() { System.out.println("Woof"); }
    }
    static class Cat extends Animal {
        @Override
        void sound() { System.out.println("Meow"); }
    }

    public static void main(String[] args) {
        // Beginner example: parent reference, child implementation.
        Animal a = new Dog(); // Parent reference, child object.
        a.sound(); // Runtime chooses Dog.sound() because object type wins.

        // Intermediate example: one loop handling many subtype behaviors.
        Animal[] pets = {new Dog(), new Cat()};
        for (Animal p : pets) p.sound();

        // Pro example: trade-off discussion.
        System.out.println("Pro trade-off: overriding is flexible, but keep contracts consistent across subclasses.");
    }
}

/*
 * Common pitfalls:
 * 1) Changing parameters accidentally (becomes overloading, not overriding).
 * 2) Skipping @Override and missing compiler protection.
 * 3) Violating parent contract behavior in child implementations.
 *
 * Practice problems:
 * Easy: override toString() in a custom class.
 * Medium: Payment hierarchy with different processing fees.
 * Hard: template method style parent class with overridable hooks.
 */
