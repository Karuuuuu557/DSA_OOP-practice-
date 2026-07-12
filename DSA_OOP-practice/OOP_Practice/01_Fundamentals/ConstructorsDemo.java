/*
 * ============================================================================
 *  TOPIC: CONSTRUCTORS — Setting Up an Object at Birth
 * ============================================================================
 *
 *  WHAT IS A CONSTRUCTOR?
 *  -----------------------
 *  A constructor is a special method that runs automatically when an object
 *  is created with `new`. Its job is to set up the object's initial state
 *  (usually by assigning values to its fields).
 *
 *  RULES:
 *  ------
 *  - A constructor has the SAME NAME as the class.
 *  - A constructor has NO return type (not even `void`).
 *  - If you don't write ANY constructor, Java silently gives you a free
 *    "default constructor" that takes no arguments and does nothing extra.
 *  - The MOMENT you write your own constructor, that free default one
 *    disappears — if you still want a no-argument option, you must write it
 *    yourself.
 *
 *  CONSTRUCTOR OVERLOADING:
 *  -------------------------
 *  A class can have MULTIPLE constructors, as long as they have different
 *  parameter lists (different number or types of parameters). This lets you
 *  create objects in different ways depending on what info you have.
 *
 *  CONSTRUCTOR CHAINING (this(...)):
 *  ----------------------------------
 *  One constructor can call ANOTHER constructor in the same class using
 *  `this(...)`. This avoids repeating the same setup code in multiple
 *  constructors. `this(...)` MUST be the very first line if used.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. The free default constructor
 *  2. A custom no-argument constructor
 *  3. A parameterized constructor
 *  4. Constructor overloading (multiple versions)
 *  5. Constructor chaining with this(...)
 *  6. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

public class ConstructorsDemo {

    // ---- Class demonstrating constructor overloading + chaining ----
    static class Rectangle {

        double width;
        double height;
        String label;

        // ---- Constructor 1: full control, all three fields ----
        // This is the "master" constructor — the other two below delegate to
        // this one instead of repeating the same three assignment lines.
        Rectangle(double width, double height, String label) {
            this.width = width;
            this.height = height;
            this.label = label;
            System.out.println("Full constructor called for \"" + label + "\"");
        }

        // ---- Constructor 2: no label given, so we invent a default one ----
        // `this(width, height, "Unnamed Rectangle")` immediately hands off to
        // Constructor 1 above. This line MUST be the first line in the body.
        Rectangle(double width, double height) {
            this(width, height, "Unnamed Rectangle");
            System.out.println("Two-arg constructor delegated to full constructor");
        }

        // ---- Constructor 3: nothing given, so we make a 1x1 square ----
        // Chains to Constructor 2, which then chains to Constructor 1.
        // This is constructor chaining: each constructor reuses the next
        // one's logic instead of duplicating field assignments everywhere.
        Rectangle() {
            this(1, 1);
            System.out.println("No-arg constructor delegated to two-arg constructor");
        }

        double area() {
            return width * height;
        }

        void describe() {
            System.out.println(label + ": " + width + " x " + height + " = " + area() + " area");
        }
    }

    static void demonstrateOverloading() {
        System.out.println("--- Constructor Overloading & Chaining ---");

        // Each of these calls a DIFFERENT constructor, chosen automatically
        // by Java based on how many arguments you pass and their types.
        Rectangle r1 = new Rectangle(4, 5, "Whiteboard");
        Rectangle r2 = new Rectangle(3, 3);      // uses the two-arg constructor
        Rectangle r3 = new Rectangle();          // uses the no-arg constructor

        System.out.println();
        r1.describe();
        r2.describe();
        r3.describe();
    }

    // ---- Class demonstrating the "free" default constructor ----
    // Because we never write a constructor for Empty, Java quietly generates
    // one for us behind the scenes: `Empty() { }`. It exists even though you
    // never typed it.
    static class Empty {
        int value = 42; // field default values still apply
    }

    static void demonstrateDefaultConstructor() {
        System.out.println("\n--- The Free Default Constructor ---");
        Empty e = new Empty(); // works even though we wrote no constructor at all
        System.out.println("Empty object created successfully, value = " + e.value);
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {
        demonstrateOverloading();
        demonstrateDefaultConstructor();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself in a separate file or below main()
 * ============================================================================
 *
 *  1. Write a `Pizza` class with fields: size (String, e.g. "Medium"),
 *     toppings (int, count of toppings), hasExtraCheese (boolean).
 *     Give it THREE constructors:
 *       - Pizza(String size) → 0 toppings, no extra cheese
 *       - Pizza(String size, int toppings) → chains to the one above logic,
 *         no extra cheese
 *       - Pizza(String size, int toppings, boolean hasExtraCheese) → full control
 *     Use this(...) chaining so you're not repeating field assignments.
 *
 *  2. Write a `Car` class where the no-arg constructor sets sensible defaults
 *     (e.g. brand = "Unknown", speed = 0) and PRINTS a message showing which
 *     constructor ran. Create three Car objects using different constructors
 *     and observe the print order — this shows you exactly how chaining
 *     executes step by step.
 *
 *  3. CHALLENGE — Cause a compiler error on purpose: try writing a second
 *     constructor with `this(...)` as the SECOND line instead of the first,
 *     and read the error Java gives you. Write down what it says and why
 *     Java enforces this rule (hint: think about the object needing to be
 *     initialized exactly once before any other code touches its fields).
 *
 *  4. Explain in your own words (as a comment): what would happen if
 *     Rectangle had a constructor with parameters (double width, double height)
 *     AND another with (double height, double width)? Would Java allow both?
 *     Try it and see.
 * ============================================================================
 */
