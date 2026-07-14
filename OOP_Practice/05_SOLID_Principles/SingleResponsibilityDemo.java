/*
 * TOPIC: SRP (Single Responsibility Principle)
 * Analogy: One person should not be cashier, cook, and cleaner at once.
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
        Invoice inv = new Invoice(1000); // Data object stores invoice facts only.
        InvoiceCalculator calc = new InvoiceCalculator(); // Calculation logic stays in separate class.
        InvoicePrinter printer = new InvoicePrinter(); // Output logic separated for easier change/testing.
        System.out.println("Beginner total: " + calc.taxIncluded(inv)); // Show calculation result.
        printer.print(inv); // Show printing responsibility independently.
        System.out.println("Pro: changing print format won't risk tax logic bugs.");
    }
}

/*
 * Pitfalls: "God classes", mixing persistence/UI/domain logic, over-splitting trivial classes.
 * Practice: split UserService into validator/repository/notifier.
 */

