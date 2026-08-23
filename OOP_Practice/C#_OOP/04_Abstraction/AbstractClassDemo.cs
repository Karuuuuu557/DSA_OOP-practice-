/*
 * ============================================================================
 *  TOPIC: ABSTRACT CLASSES — Incomplete Blueprints You Can't Instantiate
 *  (C# edition)
 * ============================================================================
 *
 *  WHAT IS AN ABSTRACT CLASS?
 *  --------------------------
 *  A class declared with the `abstract` keyword. It can declare
 *  "unimplemented methods" (also abstract) that subclasses MUST provide.
 *  You CANNOT directly create an object of an abstract class.
 *
 *  WHY USE ONE?
 *  ------------
 *  Use when classes share a CLOSE, RELATED IDENTITY (e.g. Goblin and
 *  Dragon are both clearly `Enemy`s) AND you want to force subclasses to
 *  fill in some behaviors while sharing others.
 *
 *  C# vs JAVA — MOSTLY THE SAME
 *  ----------------------------
 *  1. Use `abstract class` and `abstract` methods (same as Java).
 *  2. Abstract methods have NO body — just a signature ending in `;`.
 *  3. Concrete subclasses MUST `override` every abstract method, or the
 *     subclass must also be declared abstract.
 *  4. Abstract classes CAN have constructors (for use by subclasses).
 *  5. Abstract classes CAN have non-abstract (concrete) methods.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. An abstract parent with abstract AND concrete methods
 *  2. Two concrete subclasses that fill in the abstract bits
 *  3. Demonstrating why you can't `new` an abstract class
 *  4. Polymorphic collection of abstract-typed references
 *  5. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;
using System.Collections.Generic;

public class AbstractClassDemo
{
    // ---- ABSTRACT parent: an Enemy that MUST have a Loot() and Attack() ----
    public abstract class Enemy
    {
        public string Name;
        public int Health;

        protected Enemy(string name, int health)
        {
            Name = name;
            Health = health;
        }

        // CONCRETE method — shared as-is by all subclasses.
        public void TakeDamage(int amount)
        {
            Health -= amount;
            Console.WriteLine($"{Name} took {amount} damage. HP: {Health}");
        }

        // ABSTRACT method — has NO body. Subclasses MUST implement it.
        public abstract void Attack();

        // Another abstract method — defines part of the contract.
        public abstract string Loot();
    }

    // ---- Concrete subclass #1 ----
    public class Goblin : Enemy
    {
        public Goblin() : base("Goblin", 30) { }

        public override void Attack()
        {
            Console.WriteLine($"{Name} slashes with a rusty dagger for 5 damage.");
        }

        public override string Loot()
        {
            return "3 gold coins";
        }
    }

    // ---- Concrete subclass #2 ----
    public class Dragon : Enemy
    {
        public Dragon() : base("Dragon", 500) { }

        public override void Attack()
        {
            Console.WriteLine($"{Name} breathes FIRE for 80 damage!");
        }

        public override string Loot()
        {
            return "legendary dragon scale";
        }
    }

    // ---- A class that USES the abstract type ----
    public class Battle
    {
        public void Spawn(Enemy enemy)
        {
            Console.WriteLine($"A wild {enemy.Name} appears!");
            enemy.Attack();    // polymorphic call
            Console.WriteLine($"Drops: {enemy.Loot()}");
            Console.WriteLine();
        }
    }

    static void DemonstrateCannotInstantiate()
    {
        Console.WriteLine("--- You CANNOT `new` an Abstract Class ---");
        // Enemy e = new Enemy("Mystery", 100); // <-- would NOT COMPILE
        Console.WriteLine("(The line above would fail with 'cannot create an instance of the abstract class Enemy')");
        Console.WriteLine();
    }

    static void DemonstratePolymorphism()
    {
        Console.WriteLine("--- Polymorphic Use of Abstract Type ---");
        Battle battle = new Battle();

        // Enemy is abstract — but we can hold child instances through it.
        battle.Spawn(new Goblin());
        battle.Spawn(new Dragon());

        // A list of abstract references can hold any concrete subclass.
        List<Enemy> dungeon = new List<Enemy>
        {
            new Goblin(),
            new Dragon(),
            new Goblin(),
        };

        Console.WriteLine("--- Iterating a List<Enemy> ---");
        foreach (Enemy e in dungeon)
        {
            e.Attack();
            Console.WriteLine($"  Drops: {e.Loot()}");
        }
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateCannotInstantiate();
        DemonstratePolymorphism();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Create abstract `Shape` with abstract `double Area()` and abstract
 *     `string Draw()`. Make `Circle : Shape`, `Square : Shape`, and
 *     `Triangle : Shape` fill in both.
 *
 *  2. Create abstract `Quest` with concrete `Start()` and abstract
 *     `Objective()`. Make `KillQuest : Quest` and `CollectQuest : Quest`.
 *
 *  3. CHALLENGE: Try to write `public class HalfGoblin : Enemy` and DO
 *     NOT override the abstract methods. Read the compiler error. Then
 *     either implement the methods OR mark HalfGoblin itself `abstract`.
 *
 *  4. Explain in your own words (as a comment): why does the line
 *     `List<Enemy> dungeon = new List<Enemy> { new Goblin(), new Dragon() };`
 *     work, but `Enemy e = new Enemy();` does not?
 *
 *  5. C#-SPECIFIC: Mark an abstract method as `sealed` in a subclass:
 *     `public sealed override void Attack() { ... }`. Then try to make a
 *     `MegaDragon : Dragon` that overrides Attack again. What error do
 *     you get? Why is `sealed` useful here?
 *
 *  6. CHALLENGE: Define abstract `Weapon` with abstract `int Damage()`.
 *     Create `Sword : Weapon` (fixed 10 damage), `Bow : Weapon` (8 +
 *     random 0-4), and `MagicStaff : Weapon` (Mana-based). Then write a
 *     `Battle` class that takes a Weapon and prints its Damage.
 * ============================================================================
 */
