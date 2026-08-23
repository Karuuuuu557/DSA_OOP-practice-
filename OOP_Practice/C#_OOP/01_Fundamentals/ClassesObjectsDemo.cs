/*
 * ============================================================================
 *  TOPIC: CLASSES & OBJECTS — The Foundation of OOP (in C#)
 * ============================================================================
 *
 *  Welcome to your first C# file. Every example here is built around a tiny
 *  RPG idea (Player, Enemy, Damage numbers) so that by the time you finish
 *  this folder you will have already designed the bones of a game.
 *
 *  WHAT IS A CLASS?
 *  ----------------
 *  A class is a BLUEPRINT (template) that describes what data (fields) and
 *  behavior (methods) something will have. It does not exist in memory as a
 *  "thing" by itself — it is just the design.
 *
 *  WHAT IS AN OBJECT?
 *  ------------------
 *  An object is an actual INSTANCE created from a class blueprint. You can
 *  make many objects from one class, and each one has its own copy of the
 *  fields (unless a field is `static`, in which case it is shared).
 *
 *  C# vs JAVA — KEY SYNTAX DIFFERENCES YOU WILL SEE IN THIS FILE
 *  --------------------------------------------------------------
 *  1. File names do NOT have to match class names (unlike Java).
 *     You can put many classes in one .cs file.
 *  2. The "entry point" (where the program starts running) is:
 *         static void Main(string[] args) { }
 *     Capital M, lowercase args type, and `string` is lowercase in C#.
 *  3. Top-level statements: since C# 9 you can write code without a Main
 *     method. To keep these files close to the Java version, we still use
 *     an explicit `Main` method.
 *  4. `Console.WriteLine(...)` is C#'s version of `System.out.println(...)`.
 *  5. Fields in C# are usually declared as `private` with PascalCase
 *     properties OR as `_camelCase` fields. We will start simple and use
 *     plain `public` fields only inside this first file so the focus stays
 *     on classes/objects (EncapsulationDemo covers `private` properly).
 *  6. There is NO `static class` for instantiable classes in C# (only for
 *     "utility holders" with all-static members). So a nested helper class
 *     that you want to instantiate is just `class`, not `static class`.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. Defining a simple class (Player)
 *  2. Creating multiple objects from it (three different heroes)
 *  3. Using `this` to resolve naming conflicts (same name as Java)
 *  4. Instance methods vs static (class-level) methods
 *  5. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;

public class ClassesObjectsDemo
{
    // ---- A simple class definition ----
    // This describes what EVERY Player object will have: a name, health,
    // mana, and an attack power. It also defines what every Player can DO.
    public class Player
    {
        // Fields (instance variables) — each Player object gets its own copy.
        public string Name;
        public int Health;
        public int Mana;
        public int AttackPower;

        // ---- Method using a parameter name that clashes with a field name ----
        // `this.Name` means "the field belonging to THIS object".
        // `Name` (without `this`) refers to the PARAMETER passed into the method.
        // Without `this`, the C# compiler would issue CS0053 ambiguity and the
        // assignment would assign the parameter to itself.
        public void Rename(string Name)
        {
            this.Name = Name;
        }

        // A method that reads and prints the object's own fields.
        public void Introduce()
        {
            Console.WriteLine($"I'm {Name} | HP {Health} | MP {Mana} | ATK {AttackPower}");
        }

        // A method that changes an object's state (its field values).
        // This demonstrates that methods are not just for reading data —
        // they can also modify it.
        public void TakeDamage(int amount)
        {
            Health = Health - amount;
            Console.WriteLine($"{Name} took {amount} damage. HP is now {Health}.");
        }

        // Methods can call OTHER methods on the same object using `this`.
        public void TakeDamageAndIntroduce(int amount)
        {
            this.TakeDamage(amount);
            this.Introduce();
        }
    }

    // ---- A "static" class: a class you cannot instantiate, only use as a
    // bag of related functions. Think of it like a toolbox.
    public static class Dice
    {
        // Static method — called as Dice.Roll(20), no object required.
        public static int Roll(int sides)
        {
            return new Random().Next(1, sides + 1);
        }
    }

    // ---- A class with both a static field (shared) and instance fields ----
    public class Enemy
    {
        // Static field — there is only ONE copy across ALL Enemy objects.
        public static int TotalEnemiesSpawned = 0;

        // Instance fields — each Enemy has its own.
        public string Type;
        public int Health;

        public Enemy(string type, int health)
        {
            Type = type;
            Health = health;
            TotalEnemiesSpawned++; // every new Enemy bumps the shared counter
        }
    }

    static void DemonstrateMultipleObjects()
    {
        Console.WriteLine("--- Multiple Objects from One Class ---");

        // Each `new Player()` call creates a SEPARATE object in memory.
        // Changing hero1's fields does NOT affect hero2.
        Player hero1 = new Player();
        hero1.Rename("Aragon");
        hero1.Health = 100;
        hero1.Mana = 30;
        hero1.AttackPower = 15;

        Player hero2 = new Player();
        hero2.Rename("Lyra");
        hero2.Health = 80;
        hero2.Mana = 60;
        hero2.AttackPower = 10;

        hero1.Introduce();
        hero2.Introduce();

        // Proof that they are independent: changing one does not touch the other.
        hero1.TakeDamage(20);
        hero2.Introduce(); // hero2's Health is unaffected
    }

    static void DemonstrateStaticVsInstance()
    {
        Console.WriteLine("\n--- Static vs Instance Methods ---");

        // Static: called directly on the class, no object needed.
        int d20 = Dice.Roll(20);
        Console.WriteLine($"Static call Dice.Roll(20) = {d20}");

        // Static field — accessed through the class, not an object.
        Enemy e1 = new Enemy("Goblin", 30);
        Enemy e2 = new Enemy("Orc", 50);
        Enemy e3 = new Enemy("Dragon", 200);
        Console.WriteLine($"Static field Enemy.TotalEnemiesSpawned = {Enemy.TotalEnemiesSpawned}");

        // Instance field — accessed through the specific object.
        Console.WriteLine($"Instance field e2.Type = {e2.Type}, HP = {e2.Health}");
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateMultipleObjects();
        DemonstrateStaticVsInstance();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Create a `Weapon` class with fields: Name, Damage, Durability (int),
 *     Element (string). Add a method `Use()` that prints "{Name} swings for
 *     {Damage} damage!" and decreases Durability by 1 (but never below 0).
 *
 *  2. Create an `Inventory` class with a single field `Gold` and methods
 *     `AddGold(int amount)` and `SpendGold(int amount)`. SpendGold should
 *     print an error instead of allowing Gold to go negative.
 *
 *  3. Create THREE Player objects using the Player class above, put them
 *     in an array (Player[] party = new Player[3];), and use a `foreach`
 *     loop to call Introduce() on each one.
 *
 *  4. Add a static field `int PlayerCount` to the Player class and bump it
 *     inside a setup method each time you "spawn" a player. Print the
 *     final count after creating several players. This previews why static
 *     fields are shared across ALL objects of a class.
 *
 *  5. CHALLENGE: Explain in your own words (as a comment) why changing
 *     hero1's Health in DemonstrateMultipleObjects() does NOT change
 *     hero2's Health, even though they came from the same class.
 *
 *  6. EXTRA (C#-specific): Convert the `Introduce` method to use C#'s
 *     string interpolation with `$"..."` — already done above. Now try
 *     writing the same thing with string concatenation (`+`) to feel the
 *     difference.
 * ============================================================================
 */
