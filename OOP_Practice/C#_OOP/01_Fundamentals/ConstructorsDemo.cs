/*
 * ============================================================================
 *  TOPIC: CONSTRUCTORS — Setting Up an Object at Birth (C# edition)
 * ============================================================================
 *
 *  WHAT IS A CONSTRUCTOR?
 *  ----------------------
 *  A constructor is a special method that runs automatically when an object
 *  is created with `new`. Its job is to set up the object's initial state
 *  (usually by assigning values to its fields).
 *
 *  RULES:
 *  ------
 *  - A constructor has the SAME NAME as the class.
 *  - A constructor has NO return type (not even `void`).
 *  - If you do not write ANY constructor, C# silently gives you a free
 *    "default constructor" that takes no arguments and does nothing extra.
 *  - The MOMENT you write your own constructor, that free default one
 *    disappears — if you still want a no-argument option, you must write it
 *    yourself.
 *
 *  C# vs JAVA — SMALL TWEAKS YOU WILL SEE HERE
 *  --------------------------------------------
 *  1. C# also supports OBJECT INITIALIZER SYNTAX:
 *         Player p = new Player { Name = "Aragon", Health = 100 };
 *     This only works when there is an accessible (public) constructor with
 *     no required arguments — useful but not a replacement for constructors.
 *  2. Constructor chaining in C# is `this(...)` (same as Java), but it MUST
 *     still be the very first statement of the constructor body.
 *  3. C# does NOT require the file name to match the class name.
 *  4. To print to console: `Console.WriteLine(...)`.
 *  5. C# has `record` and `init`-only setters — fancy stuff for later. For
 *     now, focus on the classic constructor patterns.
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

using System;

public class ConstructorsDemo
{
    // ---- Class demonstrating constructor overloading + chaining ----
    public class Spell
    {
        public string Name;
        public int ManaCost;
        public int Damage;
        public string Element;

        // ---- Constructor 1: full control, all four fields ----
        // This is the "master" constructor — the other two below delegate to
        // this one instead of repeating the same four assignment lines.
        public Spell(string name, int manaCost, int damage, string element)
        {
            Name = name;
            ManaCost = manaCost;
            Damage = damage;
            Element = element;
            Console.WriteLine($"Full constructor called for \"{Name}\"");
        }

        // ---- Constructor 2: no element given, default to "Physical" ----
        // `this(name, manaCost, damage, "Physical")` immediately hands off
        // to Constructor 1. This line MUST be the first line in the body.
        public Spell(string name, int manaCost, int damage)
            : this(name, manaCost, damage, "Physical")
        {
            // NOTE: C# uses a colon `:` and `this(...)` BEFORE the body braces
            // for chaining — slightly different syntax from Java's first-line
            // `this(...)` call. Behavior is identical.
            Console.WriteLine("Three-arg constructor delegated to full constructor");
        }

        // ---- Constructor 3: nothing given, make a 1-damage cantrip ----
        // Chains to Constructor 2, which then chains to Constructor 1.
        public Spell()
            : this("Spark", 0, 1)
        {
            Console.WriteLine("No-arg constructor delegated to three-arg constructor");
        }

        public void Describe()
        {
            Console.WriteLine($"Spell {Name}: costs {ManaCost} MP, deals {Damage} {Element} damage");
        }
    }

    // ---- Class demonstrating the "free" default constructor ----
    // Because we never wrote a constructor for Empty, C# quietly generates
    // one for us: `Empty() { }`. It exists even though we never typed it.
    public class Empty
    {
        public int Value = 42; // field default values still apply
    }

    static void DemonstrateOverloading()
    {
        Console.WriteLine("--- Constructor Overloading & Chaining ---");

        // Each of these calls a DIFFERENT constructor, chosen automatically
        // by C# based on how many arguments you pass and their types.
        Spell fireball = new Spell("Fireball", 25, 40, "Fire");
        Spell slash = new Spell("Slash", 5, 10);      // uses three-arg constructor
        Spell spark = new Spell();                     // uses no-arg constructor

        Console.WriteLine();
        fireball.Describe();
        slash.Describe();
        spark.Describe();
    }

    static void DemonstrateDefaultConstructor()
    {
        Console.WriteLine("\n--- The Free Default Constructor ---");
        Empty e = new Empty(); // works even though we wrote no constructor
        Console.WriteLine($"Empty object created successfully, Value = {e.Value}");
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateOverloading();
        DemonstrateDefaultConstructor();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Write a `Potion` class with fields: Name (string), HealAmount (int),
 *     Charges (int). Give it THREE constructors:
 *       - Potion(string name) → HealAmount 25, Charges 1
 *       - Potion(string name, int healAmount) → Charges 1
 *       - Potion(string name, int healAmount, int charges) → full control
 *     Use constructor chaining (`: this(...)`) so you are not repeating
 *     field assignments.
 *
 *  2. Write a `Room` class where the no-arg constructor sets sensible
 *     defaults (e.g. Name = "Empty Room", Width = 10, Height = 10) and
 *     PRINTS a message showing which constructor ran. Create three Room
 *     objects using different constructors and observe the print order —
 *     this shows you exactly how chaining executes step by step.
 *
 *  3. CHALLENGE — Cause a compiler error on purpose: try writing a second
 *     constructor with `: this(...)` as the SECOND statement (after some
 *     other code), and read the error C# gives you. Write down what it
 *     says and why C# enforces this rule (hint: think about the object
 *     needing to be initialized exactly once before any other code
 *     touches its fields).
 *
 *  4. Explain in your own words (as a comment): what would happen if
 *     Spell had a constructor with parameters (string name, int manaCost)
 *     AND another with (string element, int manaCost)? Would C# allow both?
 *     Try it and see.
 *
 *  5. C#-SPECIFIC: Rewrite Practice #1 using object initializer syntax:
 *         Potion p = new Potion("Heal") { HealAmount = 25, Charges = 3 };
 *     Notice it does NOT require a special constructor — it works on top
 *     of any accessible no-arg constructor.
 * ============================================================================
 */
