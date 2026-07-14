/*
 * TOPIC: Compile-time polymorphism (overloading)
 * Analogy: Same button label "print" but different behavior based on input type.
 * Link: Contrasts runtime polymorphism from overriding.
 */
public class CompileTimePolymorphismDemo {
    static int add(int a, int b) { return a + b; }
    static double add(double a, double b) { return a + b; }
    static int add(int a, int b, int c) { return a + b + c; }

    public static void main(String[] args) {
        int s1 = add(2, 3); // Compiler selects add(int,int) from argument types.
        System.out.println("Beginner int add: " + s1); // Result is integer addition.

        double s2 = add(2.5, 3.1);
        System.out.println("Intermediate double add: " + s2);

        int s3 = add(1, 2, 3);
        System.out.println("Pro overloaded 3 args: " + s3);
    }
}

/*
 * Pitfalls: ambiguous overloads, changing only return type (not allowed), overloading too much hurts readability.
 * Practice: overload print methods, constructor overloading, parse() variants.
 */

