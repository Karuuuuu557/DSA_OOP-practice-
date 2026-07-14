/*
 * TOPIC: ISP (Interface Segregation Principle)
 * Analogy: Don't force everyone to carry a giant Swiss-army tool if they only need a screwdriver.
 */
public class InterfaceSegregationDemo {
    interface Printer { void print(String doc); }
    interface Scanner { void scan(String target); }

    static class BasicPrinter implements Printer {
        @Override public void print(String doc) { System.out.println("Printing: " + doc); }
    }
    static class MultiFunctionMachine implements Printer, Scanner {
        @Override public void print(String doc) { System.out.println("MFP print: " + doc); }
        @Override public void scan(String target) { System.out.println("MFP scan to: " + target); }
    }

    public static void main(String[] args) {
        Printer p = new BasicPrinter(); // Basic device only depends on print behavior.
        p.print("Beginner report"); // Works without fake scan methods.

        MultiFunctionMachine m = new MultiFunctionMachine();
        m.print("Intermediate contract");
        m.scan("cloud");

        System.out.println("Pro: small interfaces reduce accidental coupling and test complexity.");
    }
}

/*
 * Pitfalls: fat interfaces, throwing UnsupportedOperationException in required methods, leaking unrelated methods to clients.
 * Practice: split media controls (play/pause/record), split repository read/write interfaces.
 */

