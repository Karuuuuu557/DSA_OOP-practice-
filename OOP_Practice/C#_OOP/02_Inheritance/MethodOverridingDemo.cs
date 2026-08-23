/*
 * ============================================================================
 *  TOPIC: METHOD OVERRIDING & base CALLS — Customizing Inherited Behavior
 *  (C# edition)
 * ============================================================================
 *
 *  WHAT IS METHOD OVERRIDING?
 *  ---------------------------
 *  A child class provides its own specific implementation of a method that
 *  is already defined in its parent class. The method must have the SAME
 *  name, SAME parameters, and SAME return type.
 *
 *  C# vs JAVA — IMPORTANT DIFFERENCES
 *  ----------------------------------
 *  1. Java marks methods as `virtual` by default (any method CAN be
 *     overridden). C# requires BOTH sides to opt in:
 *
 *         Parent:  public virtual void MakeSound() { ... }
 *         Child:   public override void MakeSound() { ... }
 *
 *     Forgetting `virtual` or `override` is the #1 source of confusion.
 *
 *  2. To prevent further overriding, use `sealed override`:
 *
 *         public sealed override void MakeSound() { ... }
 *
 *  3. C# also has `new` for HIDING (different from overriding — see bottom).
 *
 *  4. To call the parent's version of an overridden method, use `base.`:
 *
 *         public override void Describe()
 *         {
 *             base.Describe();   // run parent's version first
 *             Console.WriteLine("...and I am also a Mage!");
 *         }
 *
 *  IN THIS FILE:
 *  -------------
 *  1. Overriding a single method
 *  2. Calling the parent's version with `base.MethodName()`
 *  3. Using `sealed` to lock down a method
 *  4. Constructor chaining when overriding matters
 *  5. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;

public class MethodOverridingDemo
{
    // ---- Parent class ----
    public class Character
    {
        public string Name;
        public int Health;

        public Character(string name, int health)
        {
            Name = name;
            Health = health;
        }

        // Mark this `virtual` so children MAY override it.
        public virtual void Describe()
        {
            Console.WriteLine($"I am {Name} with {Health} HP.");
        }

        // This one we will OVERRIDE later.
        public virtual void Attack()
        {
            Console.WriteLine($"{Name} attacks for 5 damage.");
        }

        // This one we will SEAL later (no further overrides allowed).
        public virtual void TakeDamage(int amount)
        {
            Health -= amount;
            Console.WriteLine($"{Name} took {amount} damage. HP: {Health}");
        }
    }

    // ---- Child: overrides Describe AND Attack ----
    public class Warrior : Character
    {
        public int Strength;

        public Warrior(string name, int health, int strength)
            : base(name, health)
        {
            Strength = strength;
        }

        // Override Describe — call base first, then add Warrior-specific info.
        public override void Describe()
        {
            base.Describe(); // run parent's version
            Console.WriteLine($"  Warrior with {Strength} STR.");
        }

        // Override Attack — Warriors hit harder.
        public override void Attack()
        {
            int damage = Strength; // use the new field
            Console.WriteLine($"{Name} swings their sword for {damage} damage!");
        }
    }

    // ---- Child: overrides only Attack ----
    public class Mage : Character
    {
        public int Mana;

        public Mage(string name, int health, int mana)
            : base(name, health)
        {
            Mana = mana;
        }

        public override void Attack()
        {
            if (Mana < 5)
            {
                Console.WriteLine($"{Name} tries to cast but is out of mana!");
                return;
            }
            Mana -= 5;
            Console.WriteLine($"{Name} hurls a spell for 12 magic damage! (Mana: {Mana})");
        }
    }

    // ---- Grandchild: seals TakeDamage so no one can override it again ----
    public class Boss : Warrior
    {
        public Boss(string name, int health, int strength)
            : base(name, health, strength)
        {
        }

        // Lock down TakeDamage — nothing below Boss can change it.
        public sealed override void TakeDamage(int amount)
        {
            int reduced = amount / 2; // bosses take half damage
            base.TakeDamage(reduced);
            Console.WriteLine($"  (Boss armor reduced damage to {reduced}.)");
        }
    }

    static void DemonstrateSimpleOverride()
    {
        Console.WriteLine("--- Simple Override ---");
        Character c = new Character("Bob", 50);
        Warrior w = new Warrior("Ragnar", 150, 20);
        Mage m = new Mage("Elara", 80, 100);

        c.Describe();   // parent version
        w.Describe();   // overridden version (calls base + adds info)
        m.Describe();   // parent version (Mage did not override this one)
        Console.WriteLine();
    }

    static void DemonstratePolymorphicAttack()
    {
        Console.WriteLine("--- Polymorphic Attack (parent ref, child object) ---");

        // Each variable is declared as Character, but holds a DIFFERENT
        // actual object type. Calling Attack() runs the CHILD's version.
        Character[] party = new Character[]
        {
            new Character("Bob", 50),
            new Warrior("Ragnar", 150, 20),
            new Mage("Elara", 80, 100),
        };

        foreach (Character c in party)
        {
            c.Attack(); // calls the CORRECT override at runtime
        }
        Console.WriteLine();
    }

    static void DemonstrateSealed()
    {
        Console.WriteLine("--- Sealed Method ---");
        Boss boss = new Boss("Dragon King", 1000, 50);
        boss.TakeDamage(100); // calls Boss.TakeDamage (sealed override)
        // If we tried to make `public class MiniBoss : Boss { public override
        // void TakeDamage(int amount) {...} }`, the compiler would refuse —
        // because TakeDamage was sealed.
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateSimpleOverride();
        DemonstratePolymorphicAttack();
        DemonstrateSealed();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Create an `Item` parent class with a `virtual void Use()` that prints
 *     "Used the item." Then create `HealthPotion : Item` (overrides Use to
 *     print "Healed 25 HP!") and `Bomb : Item` (overrides Use to print
 *     "BOOM! Area damage!").
 *
 *  2. Add a `Heal(int amount)` virtual method to Character. Override it in
 *     a `Cleric : Character` child so that calling base.Heal(amount) ALSO
 *     restores 5 mana. (Hint: you'll need to add a Mana field.)
 *
 *  3. Create a `final` equivalent in C# by writing `public sealed override
 *     void Attack()` on a class `GodSlayer : Warrior`. Then try to write
 *     a class `EvenMoreSlayer : GodSlayer` that overrides Attack again,
 *     and read the compiler error. Why does C# stop you?
 *
 *  4. CHALLENGE: Predict the output. Then run it:
 *         Character c = new Mage("Elara", 80, 100);
 *         c.Describe();
 *     Does Describe() run the Character version or the Mage version? Why?
 *     (Hint: Mage did NOT override Describe in this file.)
 *
 *  5. C#-SPECIFIC: Try adding the keyword `new` instead of `override` in
 *     Warrior.Describe() — i.e. `public new void Describe()`. Read the
 *     warning the compiler gives. Why is this different from `override`?
 *     (Hint: with `new`, the method HIDES the parent's version only when
 *     you call it through the child's type. Polymorphism breaks.)
 *
 *  6. C#-SPECIFIC: Add `public override string ToString() { return
 *     $"Character: {Name}"; }` to the Character class. Then just do
 *     `Console.WriteLine(character);` and notice C# automatically calls
 *     ToString(). This is how EVERY C# object can be printed usefully —
 *     it's the magic of `System.Object`.
 * ============================================================================
 */
