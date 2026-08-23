/*
 * ============================================================================
 *  TOPIC: RUNTIME POLYMORPHISM — Dynamic Dispatch via virtual/override
 *  (C# edition)
 * ============================================================================
 *
 *  WHAT IS RUNTIME POLYMORPHISM?
 *  ------------------------------
 *  A child class provides its own specific implementation of a method that
 *  is already defined in its parent class. Even when you hold a parent
 *  reference, calling that method at RUNTIME runs the CHILD's version.
 *
 *  C# vs JAVA — IMPORTANT DIFFERENCES
 *  ----------------------------------
 *  1. Java methods are virtual by default; C# requires EXPLICIT `virtual`
 *     on the parent and `override` on the child.
 *
 *         Parent:  public virtual void Speak() { ... }
 *         Child:   public override void Speak() { ... }
 *
 *  2. Runtime dispatch happens in BOTH languages — same behavior, just
 *     different syntax.
 *
 *  3. In C#, you can use `is` and `as` for type checking/conversion:
 *
 *         if (enemy is Boss b) { b.SpecialAbility(); }   // C# 7+ pattern
 *         Boss b = enemy as Boss;
 *         if (b != null) { b.SpecialAbility(); }
 *
 *  IN THIS FILE:
 *  -------------
 *  1. Upcasting (child -> parent reference, automatic)
 *  2. Dynamic dispatch (parent reference, child method runs)
 *  3. Downcasting with `as` and `is`
 *  4. Polymorphic collections (list of base type, mixed children)
 *  5. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;
using System.Collections.Generic;

public class RuntimePolymorphismDemo
{
    public class Enemy
    {
        public string Name;
        public int Health;

        public Enemy(string name, int health)
        {
            Name = name;
            Health = health;
        }

        public virtual void Speak()
        {
            Console.WriteLine($"{Name} growls menacingly.");
        }
    }

    public class Goblin : Enemy
    {
        public Goblin() : base("Goblin", 30) { }

        public override void Speak()
        {
            Console.WriteLine($"{Name} squeaks: \"Grrr!\"");
        }
    }

    public class Dragon : Enemy
    {
        public Dragon() : base("Dragon", 500) { }

        public override void Speak()
        {
            Console.WriteLine($"{Name} ROARS with fire-breathing fury!");
        }
    }

    public class Slime : Enemy
    {
        public Slime() : base("Slime", 15) { }
        // Slime does NOT override Speak — so it inherits Enemy's version.
    }

    // ---- A helper class that takes a parent reference ----
    public class Encounter
    {
        public void Interact(Enemy enemy)
        {
            Console.Write($"Player meets a {enemy.Name}. ");
            enemy.Speak(); // runtime polymorphism — calls the CORRECT override
        }
    }

    static void DemonstrateUpcasting()
    {
        Console.WriteLine("--- Upcasting (child -> parent reference) ---");
        Goblin g = new Goblin();
        // Upcast: a Goblin IS-A Enemy. C# does this implicitly (no cast needed).
        Enemy e = g;
        Console.WriteLine($"Goblin upcast to Enemy. Type still Goblin: {e is Goblin}");
        e.Speak(); // calls Goblin.Speak() — runtime polymorphism
    }

    static void DemonstrateDynamicDispatch()
    {
        Console.WriteLine("\n--- Dynamic Dispatch ---");
        Encounter enc = new Encounter();

        // We pass DIFFERENT child objects as the parent type. Each call
        // resolves to the correct override at RUNTIME.
        enc.Interact(new Goblin());
        enc.Interact(new Dragon());
        enc.Interact(new Slime()); // falls back to Enemy.Speak()
    }

    static void DemonstratePolymorphicCollection()
    {
        Console.WriteLine("\n--- Polymorphic Collection ---");
        List<Enemy> dungeon = new List<Enemy>
        {
            new Goblin(),
            new Dragon(),
            new Slime(),
            new Goblin(),
        };

        foreach (Enemy e in dungeon)
        {
            e.Speak(); // each one calls its own override (or inherited default)
        }
    }

    static void DemonstrateDowncasting()
    {
        Console.WriteLine("\n--- Downcasting with `as` and `is` ---");
        Enemy e = new Dragon();

        // `is` check before casting — the safe pattern.
        if (e is Dragon d)
        {
            Console.WriteLine($"It's a Dragon with {d.Health} HP.");
        }

        // `as` returns null if the cast fails (instead of throwing).
        Goblin g = e as Goblin; // null, because e is actually a Dragon
        Console.WriteLine($"Tried to cast Dragon as Goblin. Result is null: {g == null}");

        // The unsafe alternative would be `(Goblin)e` — throws InvalidCastException
        // if the actual type doesn't match. Prefer `as` + null check.
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateUpcasting();
        DemonstrateDynamicDispatch();
        DemonstratePolymorphicCollection();
        DemonstrateDowncasting();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Create `Shape` (parent) with `virtual double Area()`. Create
 *     `Circle : Shape`, `Rectangle : Shape`, `Triangle : Shape`. Build a
 *     `List<Shape>` with mixed shapes and sum the areas via polymorphism.
 *
 *  2. Create a `GameLoop` class with method `Render(Entity e)` that calls
 *     `e.Draw()`. Define `Entity`, `Player : Entity`, `Coin : Entity`,
 *     `Enemy : Entity`, each with their own `Draw()`. Pass them into
 *     Render() and watch the right version fire.
 *
 *  3. CHALLENGE: Given `Enemy e = new Slime();`, write the SAFEST possible
 *     code to call a `Split()` method that only exists on Slime. Use `is`
 *     or `as`. (Hint: the `is` pattern is the cleanest.)
 *
 *  4. Predict the output of this snippet BEFORE running it:
 *         Enemy[] arr = new Enemy[] { new Goblin(), new Slime(), new Dragon() };
 *         foreach (Enemy e in arr)
 *         {
 *             Console.WriteLine(e.GetType().Name);
 *         }
 *     Why does `GetType()` always return the real type, not the reference type?
 *
 *  5. CHALLENGE: Make a `Pet` parent with `virtual void MakeSound()`. Then
 *     `Dog`, `Cat`, and `Duck` children. Add a method `HearPet(Pet p)` that
 *     calls MakeSound. Now create a `Trainer` class with a `List<Pet> pets`
 *     and a `HearAll()` method that loops and calls HearPet on each. Print
 *     the resulting symphony.
 *
 *  6. C#-SPECIFIC: C# 9 added `is not` for negative checks. Try writing
 *     `if (e is not Dragon) { Console.WriteLine("Not a dragon!"); }`.
 *     Also try the newer switch expression with type patterns:
 *
 *         string sound = e switch
 *         {
 *             Dragon _ => "ROAR",
 *             Goblin _ => "squeak",
 *             _        => "..."
 *         };
 * ============================================================================
 */
