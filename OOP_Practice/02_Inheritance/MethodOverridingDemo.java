/*
 * TOPIC: Method overriding
 * Analogy: Same job title, different working style per person.
 * Link: Builds directly on inheritance.
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
        Animal a = new Dog(); // Parent reference, child object.
        a.sound(); // Runtime chooses Dog.sound() because object type wins.

        Animal[] pets = {new Dog(), new Cat()};
        for (Animal p : pets) p.sound();

        System.out.println("Pro trade-off: overriding gives extensibility, but too many overrides can hide flow.");
    }
}

/*
 * Pitfalls: mismatched method signature, forgetting @Override, confusing overloading with overriding.
 * Practice: Payment.process(), Notification.send(), Shape.area() override hierarchy.
 */

