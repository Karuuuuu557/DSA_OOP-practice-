/*
 * TOPIC: SRP (Single Responsibility Principle)
 * Concept intro:
 * A class should have one reason to change.
 * Analogy: one staff role should not be cashier, cook, and cleaner all at once.
 * Link: cleaner separation makes OCP/DIP easier in later SOLID lessons.
 */
public class SingleResponsibilityDemo {
    static class Invoice {
        double amount;
        Invoice(double amount) { this.amount = amount; }
    }
    static class InvoiceCalculator {
        double taxIncluded(Invoice inv) { return inv.amount * 1.12; }
    }
    static class InvoicePrinter {
        void print(Invoice inv) { System.out.println("Invoice amount: " + inv.amount); }
    }

    public static void main(String[] args) {
        // Beginner example: each class handles one focused concern.
        Invoice inv = new Invoice(1000); // Data object stores invoice facts only.
        InvoiceCalculator calc = new InvoiceCalculator(); // Calculation logic stays in separate class.
        InvoicePrinter printer = new InvoicePrinter(); // Output logic separated for easier change/testing.
        System.out.println("Beginner total: " + calc.taxIncluded(inv)); // Show calculation result.
        printer.print(inv); // Show printing responsibility independently.

        // Intermediate example: show independent evolution.
        System.out.println("Intermediate: you can change tax rule without touching print class.");

        // Pro example: architecture trade-off.
        System.out.println("Pro: SRP improves testability and reduces bug ripple effects across features.");
    }
}

/*
 * Common pitfalls:
 * 1) God class that handles validation, business logic, IO, and persistence together.
 * 2) Mixing UI concerns with core domain logic.
 * 3) Over-splitting tiny classes without meaningful boundaries.
 *
 * Practice problems:
 * Easy: split StudentReport into Calculator + Printer.
 * Medium: break monolithic UserService into validator/repository/notifier.
 * Hard: refactor a large controller into layered responsibilities.
 */
