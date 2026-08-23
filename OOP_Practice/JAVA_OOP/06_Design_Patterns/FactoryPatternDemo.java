/*
 * TOPIC: Factory pattern
 * Concept intro:
 * Factory centralizes object creation so callers depend on abstraction, not construction details.
 * Analogy: ordering coffee from a barista instead of operating the machine internals yourself.
 * Link: supports OCP and DIP from SOLID section.
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
        // Beginner example: request object by type and use via interface.
        Animal a = AnimalFactory.create("dog"); // Construction logic stays inside factory.
        a.speak(); // Caller only needs Animal behavior contract.

        // Intermediate example: another product type through same creation API.
        Animal b = AnimalFactory.create("cat");
        b.speak();

        // Pro example: extension guidance.
        System.out.println("Pro: add new subtype + one factory branch, callers stay unchanged.");
    }
}

/*
 * Common pitfalls:
 * 1) Returning concrete types to callers instead of interface types.
 * 2) Silent fallback for unknown types (prefer explicit error).
 * 3) Letting one giant factory grow without modular boundaries.
 *
 * Practice problems:
 * Easy: ShapeFactory with Circle/Rectangle.
 * Medium: NotificationFactory for email/sms/push.
 * Hard: registry-based factory to avoid long if/else chains.
 */
