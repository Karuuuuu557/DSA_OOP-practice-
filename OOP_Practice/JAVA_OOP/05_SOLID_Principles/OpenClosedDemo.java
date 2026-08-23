/*
 * TOPIC: OCP (Open/Closed Principle)
 * Analogy: Power strip accepts new devices without rewiring itself.
 */
public class OpenClosedDemo {
    interface Discount { double apply(double price); }
    static class NoDiscount implements Discount { public double apply(double price) { return price; } }
    static class StudentDiscount implements Discount { public double apply(double price) { return price * 0.9; } }

    static class Checkout {
        double total(double price, Discount discount) { return discount.apply(price); }
    }

    public static void main(String[] args) {
        Checkout co = new Checkout(); // Checkout stays unchanged while discounts vary externally.
        System.out.println("Beginner no discount: " + co.total(100, new NoDiscount())); // Base behavior.
        System.out.println("Intermediate student discount: " + co.total(100, new StudentDiscount())); // Extension via new class.
        System.out.println("Pro: add SeniorDiscount class without modifying Checkout.");
    }
}

/*
 * Pitfalls: giant if-else per type, hard-coded behavior, extending when composition is simpler.
 * Practice: shipping fee strategies, payment fee extensions, report exporters.
 */

