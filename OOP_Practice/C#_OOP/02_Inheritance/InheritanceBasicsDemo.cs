/*
 * ============================================================================
 *  TOPIC: INHERITANCE BASICS — Reusing Code Through "is-a" Relationships
 *  (C# edition)
 * ============================================================================
 *
 *  WHAT IS INHERITANCE?
 *  --------------------
 *  A mechanism where one class (child/subclass) acquires the fields and
 *  methods of another class (parent/superclass), allowing code reuse and
 *  hierarchical modeling of "is-a" relationships.
 *
 *  Keyword in C#: `:` (colon) — same syntax as C++ but DIFFERENT from
 *  Java's `extends` keyword.
 *
 *      class Warrior : Character
 *      {
 *          // ...
 *      }
 *
 *  C# vs JAVA — KEY DIFFERENCES
 *  ----------------------------
 *  1. Use `:` instead of `extends`:
 *         C#  : class Dog : Animal
 *         Java: class Dog extends Animal
 *
 *  2. C# also does NOT support multiple class inheritance. Just like Java,
 *     a class can only have ONE direct base class. For "multiple
 *     inheritance-like" behavior, you use INTERFACES (see InterfaceDemo.cs).
 *
 *  3. To call the parent constructor, use `: base(...)` in the constructor
 *     header (not `super(...)` like Java).
 *
 *         public Warrior(string name) : base(name, 100) { }
 *
 *  4. To call a parent's method, use `base.MethodName()` (instead of Java's
 *     `super.MethodName()`).
 *
 *  5. EVERY C# class implicitly inherits from `System.Object` (also
 *     accessible as `object`). That is why every object has methods like
 *     `ToString()`, `Equals()`, and `GetHashCode()` for free.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. Defining a parent class (Character)
 *  2. Single-level inheritance (Warrior : Character)
 *  3. Multi-level inheritance (EliteWarrior : Warrior : Character)
 *  4. Calling the base constructor with `: base(...)`
 *  5. Calling a base method with `base.MethodName()`
 *  6. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;

public class InheritanceBasicsDemo
{
    // ---- Parent class (a.k.a. base class / superclass) ----
    public class Character
    {
        // Common fields that ALL characters share.
        protected string Name;     // `protected` = visible to subclasses
        protected int Health;
        protected int Level;

        // Parent constructor — sets up the common stuff.
        public Character(string name, int health, int level)
        {
            Name = name;
            Health = health;
            Level = level;
            Console.WriteLine($"Character constructor: {Name} (Lv {Level}, HP {Health})");
        }

        // Common behavior every character inherits.
        public void Introduce()
        {
            Console.WriteLine($"I'm {Name}, level {Level}, with {Health} HP.");
        }

        public void TakeDamage(int amount)
        {
            Health -= amount;
            Console.WriteLine($"{Name} took {amount} damage. HP is now {Health}.");
        }
    }

    // ---- Child class: Warrior is-a Character ----
    public class Warrior : Character
    {
        // Warriors have their own unique field.
        public int Strength;

        // Calling the base constructor: `: base(name, health, 1)`
        // Level is hard-coded to 1 for now — could be a parameter later.
        public Warrior(string name, int health, int strength)
            : base(name, health, 1)
        {
            Strength = strength;
            Console.WriteLine($"Warrior constructor: +{Strength} STR");
        }

        // Warriors can do something characters in general cannot.
        public void PowerSlash()
        {
            Console.WriteLine($"{Name} performs a Power Slash for {Strength * 2} damage!");
        }
    }

    // ---- Another child class: Mage is-a Character ----
    public class Mage : Character
    {
        public int Mana;

        public Mage(string name, int health, int mana)
            : base(name, health, 1)
        {
            Mana = mana;
            Console.WriteLine($"Mage constructor: +{Mana} MP");
        }

        public void CastSpell(string spellName)
        {
            if (Mana < 10)
            {
                Console.WriteLine($"{Name} is out of mana!");
                return;
            }
            Mana -= 10;
            Console.WriteLine($"{Name} casts {spellName}! (Mana: {Mana})");
        }
    }

    // ---- Multi-level inheritance: EliteWarrior is-a Warrior is-a Character ----
    public class EliteWarrior : Warrior
    {
        public string Title;

        // Calls Warrior's constructor, which itself calls Character's.
        public EliteWarrior(string name, int health, int strength, string title)
            : base(name, health, strength)
        {
            Title = title;
            Console.WriteLine($"EliteWarrior constructor: title \"{Title}\"");
        }

        // Override-friendly: uses base.Introduce() to prepend the title.
        public void FormalIntroduce()
        {
            Console.Write($"[{Title}] ");
            base.Introduce(); // explicit call to Character.Introduce()
        }
    }

    static void DemonstrateSingleLevel()
    {
        Console.WriteLine("--- Single-Level Inheritance ---");
        Warrior w = new Warrior("Ragnar", 150, 20);
        w.Introduce();       // inherited from Character
        w.PowerSlash();      // defined in Warrior
        w.TakeDamage(20);    // inherited from Character
        Console.WriteLine();
    }

    static void DemonstrateMultiLevel()
    {
        Console.WriteLine("--- Multi-Level Inheritance ---");
        // See how the constructor chain runs:
        //   EliteWarrior -> Warrior -> Character
        EliteWarrior boss = new EliteWarrior("Boss", 500, 50, "Dragon Slayer");
        boss.FormalIntroduce(); // uses base.Introduce()
        boss.PowerSlash();      // inherited from Warrior
        Console.WriteLine();
    }

    static void DemonstrateSiblings()
    {
        Console.WriteLine("--- Siblings (Warrior & Mage) Share a Parent ---");
        Warrior w = new Warrior("Bjorn", 120, 25);
        Mage m = new Mage("Elara", 80, 100);

        Console.WriteLine();
        w.Introduce();   // both call the SAME Character.Introduce()
        m.Introduce();   // but they are completely separate objects
        m.CastSpell("Fireball");
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateSingleLevel();
        DemonstrateMultiLevel();
        DemonstrateSiblings();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Create an `Item` parent class with fields `Name`, `Value`, and a
 *     method `Describe()`. Then create `Weapon : Item` (adds `Damage`) and
 *     `Potion : Item` (adds `HealAmount`). Make sure the child constructors
 *     call `: base(...)` properly.
 *
 *  2. Create a multi-level chain: `Vehicle` -> `Car` -> `SportsCar`. Each
 *     level adds one new field and one new method. Print the constructor
 *     chain messages to confirm `SportsCar` triggers `Car` which triggers
 *     `Vehicle`.
 *
 *  3. Create `Archer : Character` (sibling to Warrior and Mage) with a
 *     field `Arrows` and a method `Shoot()` that decreases Arrows by 1.
 *     Demonstrate that Archer can use Character.Introduce() too.
 *
 *  4. CHALLENGE: Without changing Character, add a method `Heal(int amount)`
 *     to Warrior that uses `base.TakeDamage(-amount)` to heal by calling
 *     the parent method in reverse. (Trick question: does this actually
 *     work cleanly? Why or why not? Try it.)
 *
 *  5. Explain in your own words (as a comment): why does the line
 *     `Name = name;` inside the Character constructor NOT need `this.`?
 *     And why would a Warrior constructor NOT be able to write
 *     `Name = name;` directly without going through `base(...)` first?
 *
 *  6. C#-SPECIFIC: Replace `protected string Name;` with a `protected
 *     string Name { get; set; }` PROPERTY. Confirm subclasses still work.
 *     What changes for the child class?
 * ============================================================================
 */
