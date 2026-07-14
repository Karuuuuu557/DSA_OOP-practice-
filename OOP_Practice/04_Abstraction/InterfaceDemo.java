/*
 * TOPIC: Interface
 * Analogy: Universal charging port standard that many device brands can implement.
 * Link: Interfaces support loose coupling and DIP from SOLID.
 */
public class InterfaceDemo {
    interface PaymentProcessor {
        boolean pay(double amount);
        default String provider() { return "Unknown"; }
    }
    static class GCashProcessor implements PaymentProcessor {
        @Override public boolean pay(double amount) { return amount > 0; }
        @Override public String provider() { return "GCash"; }
    }

    public static void main(String[] args) {
        PaymentProcessor p = new GCashProcessor(); // Program to interface, not concrete class.
        boolean ok = p.pay(120.50); // Call agreed contract method regardless of implementation details.
        System.out.println("Beginner payment success: " + ok); // Print outcome for direct feedback.

        PaymentProcessor[] options = {new GCashProcessor()};
        for (PaymentProcessor x : options) System.out.println("Intermediate provider: " + x.provider());

        System.out.println("Pro: interfaces allow swapping implementations in tests and production.");
    }
}

/*
 * Pitfalls: putting too many methods in one interface, using interface where simple class is enough, leaking implementation details.
 * Practice: NotificationChannel interface, Logger interface with multiple backends, cache provider interface.
 */

