/*
 * ============================================================================
 *  TOPIC: CLASSES & OBJECTS — The Foundation of OOP
 * ============================================================================
 *
 *  WHAT IS A CLASS?
 *  -----------------
 *  A class is a BLUEPRINT (template) that describes what data (fields) and
 *  behavior (methods) something will have. It doesn't exist in memory as a
 *  "thing" by itself — it's just the design.
 *
 *  WHAT IS AN OBJECT?
 *  -------------------
 *  An object is an actual INSTANCE created from a class blueprint. You can
 *  make many objects from one class, and each one has its own copy of the
 *  fields (unless a field is marked `static`, in which case it's shared).
 *
 *  ANALOGY:
 *  --------
 *  Class = the blueprint for a house.
 *  Object = an actual house built from that blueprint.
 *  You can build many houses (objects) from one blueprint (class), and each
 *  house can be painted a different color (different field values) even
 *  though they share the same layout (same class).
 *
 *  KEY TERMS
 *  ---------
 *  - FIELD (a.k.a. instance variable): a piece of data that belongs to an object.
 *  - METHOD: a behavior/action an object can perform.
 *  - `this`: refers to "the current object" — used to distinguish a field from
 *    a parameter that has the same name.
 *  - CONSTRUCTOR: a special method that runs when an object is created
 *    (covered in depth in ConstructorsDemo.java).
 *
 *  JAVA NOTE:
 *  ----------
 *  - Every object is created using the `new` keyword, e.g. `new Student(...)`.
 *  - Fields default to 0 / false / null if not explicitly set.
 *  - A .java file's public class name MUST match the file name.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. Defining a simple class (Student)
 *  2. Creating multiple objects from it
 *  3. Using `this` to resolve naming conflicts
 *  4. Instance methods vs static (class-level) methods
 *  5. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

public class ClassesObjectsDemo {

    // ---- A simple class definition ----
    // This describes what EVERY Student object will have: a name, an age,
    // and a course. It also defines what every Student object can DO.
    static class Student {

        // Fields (instance variables) — each Student object gets its own copy.
        String name;
        int age;
        String course;

        // ---- Method using a parameter name that clashes with a field name ----
        // `this.name` means "the field belonging to THIS object".
        // `name` (without `this`) refers to the PARAMETER passed into the method.
        // Without `this`, Java would not know which "name" you mean, and the
        // assignment would just assign the parameter to itself — doing nothing.
        void setName(String name) {
            this.name = name;
        }

        // A method that reads and prints the object's own fields.
        // Notice we don't need `this.` here since there's no naming conflict —
        // but using `this.age` is still valid and sometimes used for clarity.
        void introduce() {
            System.out.println("Hi, I'm " + name + ", " + age + " years old, taking " + course + ".");
        }

        // A method that changes an object's state (its field values).
        // This demonstrates that methods aren't just for reading data —
        // they can also modify it.
        void haveBirthday() {
            age = age + 1;
            System.out.println(name + " is now " + age + " years old.");
        }
    }

    // Demonstrates creating multiple independent objects from the same class.
    static void demonstrateMultipleObjects() {
        System.out.println("--- Multiple Objects from One Class ---");

        // Each `new Student()` call creates a SEPARATE object in memory.
        // Changing student1's fields does NOT affect student2.
        Student student1 = new Student();
        student1.setName("Karu");
        student1.age = 20;
        student1.course = "BS Computer Science";

        Student student2 = new Student();
        student2.setName("Yun-Tzu");
        student2.age = 19;
        student2.course = "BS Computer Science";

        student1.introduce();
        student2.introduce();

        // Proof that they're independent: changing one doesn't touch the other.
        student1.haveBirthday();
        student2.introduce(); // student2's age is unaffected
    }

    // Demonstrates the difference between an INSTANCE method (needs an object)
    // and a STATIC method (belongs to the class itself, no object needed).
    static class MathHelper {
        // Static method — called as MathHelper.square(5), no object required.
        static int square(int n) {
            return n * n;
        }

        // Instance method — requires an object: new MathHelper().doubleIt(5).
        // This is here just to contrast with the static one above.
        int doubleIt(int n) {
            return n * 2;
        }
    }

    static void demonstrateStaticVsInstance() {
        System.out.println("\n--- Static vs Instance Methods ---");

        // Static: called directly on the class, no object needed.
        int squared = MathHelper.square(5);
        System.out.println("Static call MathHelper.square(5) = " + squared);

        // Instance: needs an actual object to call the method on.
        MathHelper helper = new MathHelper();
        int doubled = helper.doubleIt(5);
        System.out.println("Instance call helper.doubleIt(5) = " + doubled);
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {
        demonstrateMultipleObjects();
        demonstrateStaticVsInstance();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself in a separate file or below main()
 * ============================================================================
 *
 *  1. Create a `Book` class with fields: title, author, totalPages, currentPage.
 *     Add a method `readPages(int n)` that advances currentPage by n, but
 *     never lets currentPage exceed totalPages. Print a message when the
 *     book is finished.
 *
 *  2. Create a `BankAccount` class with a private-style balance field (just use
 *     a normal field for now — EncapsulationDemo.java covers true privacy).
 *     Add `deposit(double amount)` and `withdraw(double amount)` methods.
 *     withdraw() should print an error instead of allowing a negative balance.
 *
 *  3. Create THREE Student objects using the Student class above, put them
 *     in an array (Student[] students = new Student[3];), and use a loop to
 *     call introduce() on each one.
 *
 *  4. Add a static field `int totalStudents` to the Student class (declared
 *     as `static int totalStudents = 0;`) and increment it inside a
 *     constructor-like setup method every time a new Student is created.
 *     Print the final count after creating several students. This previews
 *     why `static` fields are shared across ALL objects of a class.
 *
 *  5. CHALLENGE: Explain in your own words (as a comment) why changing
 *     student1's age in demonstrateMultipleObjects() does NOT change
 *     student2's age, even though they came from the same class.
 * ============================================================================
 */
