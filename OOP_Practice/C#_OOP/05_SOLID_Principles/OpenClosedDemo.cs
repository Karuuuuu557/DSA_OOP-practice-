/*
 * ============================================================================
 *  SOLID #2: OPEN/CLOSED PRINCIPLE (OCP)
 * ============================================================================
 *
 *  THE RULE
 *  --------
 *  Classes should be OPEN for EXTENSION but CLOSED for MODIFICATION.
 *  You should be able to add new behavior without changing existing,
 *  tested code.
 *
 *  WHY IT MATTERS
 *  --------------
 *  - Existing code that already works does not get touched.
 *  - Bugs in old code are not reintroduced.
 *  - New features are added by adding NEW classes, not editing old ones.
 *
 *  REAL GAME EXAMPLE
 *  -----------------
 *  A damage calculator should accept ANY kind of damage modifier without
 *  being rewritten each time. You add new modifier classes, not edit
 *  the calculator.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. BAD: A switch statement that grows every time we add a new enemy
 *  2. GOOD: A base abstract class, with new enemies added by extension
 *  3. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;
using System.Collections.Generic;

public class OpenClosedDemo
{
    // ============== BAD: modifying this class for every new enemy ==============
    public class BadDamageCalculator
    {
        public int Calculate(object enemy)
        {
            // Every new enemy type means editing THIS switch — modifying
            // existing, tested code. OCP violation.
            if (enemy is Goblin) return 5;
            if (enemy is Dragon) return 80;
            if (enemy is Skeleton) return 7;
            // ... imagine 50 more enemies here ...
            return 1;
        }
    }

    // ============== GOOD: extend by adding new classes ==============
    public abstract class Enemy
    {
        public string Name { get; }
        protected Enemy(string name) { Name = name; }
        public abstract int AttackDamage { get; }
    }

    public class Goblin : Enemy
    {
        public Goblin() : base("Goblin") { }
        public override int AttackDamage => 5;
    }

    public class Dragon : Enemy
    {
        public Dragon() : base("Dragon") { }
        public override int AttackDamage => 80;
    }

    public class Skeleton : Enemy
    {
        public Skeleton() : base("Skeleton") { }
        public override int AttackDamage => 7;
    }

    // Adding a NEW enemy? Just add a new class. NO change to this code.
    public class LichKing : Enemy
    {
        public LichKing() : base("Lich King") { }
        public override int AttackDamage => 250;
    }

    // Calculator is CLOSED for modification — its logic never changes.
    public class DamageCalculator
    {
        public int Calculate(Enemy enemy) => enemy.AttackDamage;
    }

    static void DemonstrateBad()
    {
        Console.WriteLine("--- BAD: Every new enemy = edit the calculator ---");
        BadDamageCalculator bad = new BadDamageCalculator();
        Console.WriteLine($"Goblin:   {bad.Calculate(new Goblin())}");
        // Add LichKing? Must edit the if-chain in BadDamageCalculator.
        // (Skipped here because there's no BadLichKing type — exactly the problem!)
    }

    static void DemonstrateGood()
    {
        Console.WriteLine("\n--- GOOD: Add new enemies by creating new classes ---");
        DamageCalculator calc = new DamageCalculator();
        List<Enemy> wave = new List<Enemy>
        {
            new Goblin(),
            new Dragon(),
            new Skeleton(),
            new LichKing(),   // <-- added without touching DamageCalculator
        };

        foreach (Enemy e in wave)
        {
            Console.WriteLine($"{e.Name} hits for {calc.Calculate(e)}");
        }
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateBad();
        DemonstrateGood();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Take the BAD example. Add a `BadLichKing` class and update the
 *     `if (enemy is ...)` chain to include it. Then count how many
 *     places you had to touch. Compare with the GOOD example.
 *
 *  2. Create an abstract `Quest` with abstract `int RewardGold()`. Make
 *     `KillQuest`, `CollectQuest`, `EscortQuest`. Write a `QuestBoard`
 *     class with `int TotalReward(List<Quest>)` — its code should never
 *     change as you add more quest types.
 *
 *  3. CHALLENGE: Create an `IDamageModifier` interface with
 *     `int Modify(int baseDamage)`. Make `CritModifier`, `WeaknessModifier`,
 *     `ArmorModifier`. Write a `FinalDamage(int base, List<IDamageModifier>
 *     modifiers)` method. Add a NEW modifier type without changing
 *     FinalDamage.
 *
 *  4. Explain in your own words (as a comment): if the GOOD DamageCalculator
 *     never changes, how does it still work for new enemy types? (Hint:
 *     virtual dispatch + extension via new subclasses.)
 *
 *  5. C#-SPECIFIC: C# 9 added `switch` expressions. Try:
 *
 *         int damage = enemy switch
 *         {
 *             Dragon d when d.AttackDamage > 50 => d.AttackDamage * 2,
 *             _ => enemy.AttackDamage,
 *         };
 *
 *     Is this "modifying" the calculator or "extending" it? Why is this
 *     borderline OCP-friendly but not perfectly OCP-clean?
 * ============================================================================
 */
