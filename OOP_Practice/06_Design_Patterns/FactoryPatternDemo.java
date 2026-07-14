/*
 * TOPIC: Factory pattern
 * Analogy: Ordering coffee by type from a barista, not manually building machine internals.
 */
public class FactoryPatternDemo {
    interface Animal { void speak(); }
    static class Dog implements Animal { public void speak() { System.out.println("Woof"); } }
    static class Cat implements Animal { public void speak() { System.out.println("Meow"); } }
    static class AnimalFactory {
        static Animal create(String type) {
            if ("dog".equalsIgnoreCase(type)) return new Dog();
            if ("cat".equalsIgnoreCase(type)) return new Cat();
            throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Animal a = AnimalFactory.create("dog"); // Delegate object creation logic to factory.
        a.speak(); // Client only cares about interface behavior.

        Animal b = AnimalFactory.create("cat");
        b.speak();
        System.out.println("Pro: central creation policy simplifies validation and future extension.");
    }
}

/*
 * Pitfalls: giant factory switch everywhere, leaking concrete types to callers, forgetting error handling for unknown types.
 * Practice: payment processor factory, parser factory by file extension.
 */
