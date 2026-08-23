/*
 * ============================================================================
 *  TOPIC: ENCAPSULATION — Protecting an Object's Data
 * ============================================================================
 *
 *  WHAT IS ENCAPSULATION?
 *  -----------------------
 *  Encapsulation means bundling an object's data (fields) together with the
 *  methods that operate on it, and RESTRICTING direct outside access to that
 *  data. Instead of letting other code freely change a field, you force it
 *  to go through controlled methods (getters/setters) that can validate or
 *  protect the data.
 *
 *  WHY DOES IT MATTER?
 *  --------------------
 *  Without encapsulation, any code anywhere could do:
 *      account.balance = -99999;
 *  ...and there would be nothing stopping an invalid state from happening.
 *  With encapsulation, the field is hidden (`private`) and the ONLY way to
 *  change it is through a method that can enforce rules, e.g. "balance can
 *  never go negative."
 *
 *  ACCESS MODIFIERS IN JAVA (from most to least restrictive):
 *  -------------------------------------------------------------
 *  - private    : only visible inside the SAME class.
 *  - (default)  : visible to the same package (no keyword written at all).
 *  - protected  : visible to the same package + subclasses (see Inheritance).
 *  - public     : visible from anywhere.
 *
 *  THE STANDARD PATTERN:
 *  ----------------------
 *  1. Make fields `private`.
 *  2. Provide `public` GETTER methods to read them (e.g. getBalance()).
 *  3. Provide `public` SETTER methods to change them (e.g. setBalance(...)),
 *     with validation logic inside if needed.
 *  4. If a field should NEVER change after construction, don't give it a
 *     setter at all — that's how you create an "immutable" field.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. A class WITHOUT encapsulation (showing the problem)
 *  2. The same class WITH encapsulation (showing the fix)
 *  3. An immutable class (no setters at all)
 *  4. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

public class EncapsulationDemo {

    // ---- BEFORE: no encapsulation, fields are wide open ----
    // Any code anywhere can set balance to anything, including nonsense
    // values like -500. There's no gatekeeper.
    static class UnsafeAccount {
        public double balance; // public field = no protection at all
    }

    static void demonstrateProblem() {
        System.out.println("--- Without Encapsulation (the problem) ---");
        UnsafeAccount acc = new UnsafeAccount();
        acc.balance = 1000;
        System.out.println("Balance set to: " + acc.balance);

        // Nothing stops this — an invalid state slips right through.
        acc.balance = -500;
        System.out.println("Balance is now (invalid!): " + acc.balance);
    }

    // ---- AFTER: encapsulated, field is private and guarded by methods ----
    static class SafeAccount {

        // `private` means NOTHING outside this class can touch `balance`
        // directly — not even by typing `account.balance`. It won't compile.
        private double balance;

        SafeAccount(double startingBalance) {
            // Even the constructor routes through the setter, so the same
            // validation rule applies whether the account is brand new or
            // being updated later. This avoids duplicating the rule.
            setBalance(startingBalance);
        }

        // GETTER: the only way to read the balance from outside this class.
        public double getBalance() {
            return balance;
        }

        // SETTER: the only way to change the balance from outside this class.
        // Because it's a real method (not a raw field), it can validate.
        public void setBalance(double newBalance) {
            if (newBalance < 0) {
                System.out.println("Rejected: balance cannot be negative.");
                return; // refuse the change, leave balance as it was
            }
            balance = newBalance;
        }

        // A behavior method that also goes through validation indirectly,
        // by calling setBalance() instead of touching the field directly.
        public void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Rejected: insufficient funds.");
                return;
            }
            setBalance(balance - amount);
        }
    }

    static void demonstrateFix() {
        System.out.println("\n--- With Encapsulation (the fix) ---");
        SafeAccount acc = new SafeAccount(1000);
        System.out.println("Balance: " + acc.getBalance());

        acc.setBalance(-500); // rejected by the setter's validation
        System.out.println("Balance after invalid attempt: " + acc.getBalance());

        acc.withdraw(200);
        System.out.println("Balance after withdrawing 200: " + acc.getBalance());

        // acc.balance = 999;  // <-- this line would NOT COMPILE if uncommented,
        //                         because `balance` is private to SafeAccount.
    }

    // ---- IMMUTABLE class: fields are set once and NEVER change again ----
    // Notice there is no setter at all — once a Point is created, its x and y
    // can never be modified. This is useful for values that should be safe
    // to share around a program without fear of something else changing them.
    static class Point {
        private final int x; // `final` means this field can only be assigned once
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return x; }
        public int getY() { return y; }

        // Instead of a setter, "changing" a Point means creating a BRAND NEW
        // Point object — the original one is left untouched.
        public Point moved(int dx, int dy) {
            return new Point(x + dx, y + dy);
        }
    }

    static void demonstrateImmutability() {
        System.out.println("\n--- Immutability (no setters at all) ---");
        Point original = new Point(2, 3);
        Point shifted = original.moved(5, 5);

        System.out.println("Original: (" + original.getX() + ", " + original.getY() + ")");
        System.out.println("Shifted:  (" + shifted.getX() + ", " + shifted.getY() + ")");
        // original is completely unchanged — moved() returned a NEW object.
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {
        demonstrateProblem();
        demonstrateFix();
        demonstrateImmutability();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself in a separate file or below main()
 * ============================================================================
 *
 *  1. Write an encapsulated `Student` class with a private `int grade` field
 *     (0-100 only). The setter should reject any value outside that range
 *     and print an error instead. Test it by attempting to set grade to 150.
 *
 *  2. Write an encapsulated `Temperature` class storing degrees in Celsius
 *     as a private field, but expose it through TWO getters:
 *     getCelsius() and getFahrenheit() (which converts on the fly). This
 *     shows encapsulation isn't just about protection — it also lets you
 *     expose the SAME data in different useful forms.
 *
 *  3. Take the UnsafeAccount class above and figure out: what's the minimum
 *     change needed to make it safe, without adding any new methods? (Hint:
 *     making a field private without adding a getter/setter creates a
 *     different problem — what is it?)
 *
 *  4. CHALLENGE: Create an immutable `Person` class with private final fields
 *     `name` and `birthYear`, plus a method `int getAge(int currentYear)`
 *     that calculates age on demand instead of storing it (since a stored
 *     age would become outdated — calculating it fresh avoids that bug).
 * ============================================================================
 */
