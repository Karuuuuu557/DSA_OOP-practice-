/*
 * ============================================================================
 *  PATTERN: FACTORY — Object Creation Without Exposing Construction Logic
 * ============================================================================
 *
 *  WHAT IS IT?
 *  -----------
 *  A Factory is a method (or class) whose job is to CREATE objects.
 *  Callers ask the factory for what they need, instead of using `new`
 *  directly. The factory decides which concrete class to instantiate.
 *
 *  WHY USE IT?
 *  -----------
 *  - Hides construction details (which class, what defaults).
 *  - Makes it easy to change WHAT gets created without changing every
 *    place that needs it (OCP-friendly).
 *  - Centralizes logic that picks the right type based on input.
 *
 *  COMMON VARIANTS
 *  ---------------
 *  1. Simple Factory: a static method that returns one of several types.
 *  2. Factory Method: a method in a base class that subclasses override
 *     to decide which concrete type to make.
 *  3. Abstract Factory: a class for creating FAMILIES of related objects.
 *
 *  REAL GAME EXAMPLE
 *  -----------------
 *  A `LootFactory.DropLoot(enemyLevel)` that returns a Sword, Potion, or
 *  Gold based on the enemy's level. The caller doesn't need to know
 *  which concrete class is returned.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. Simple Factory (static method)
 *  2. Factory Method (overridden in subclasses)
 *  3. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;

public class FactoryPatternDemo
{
    // ---- Common product interface ----
    public interface IItem
    {
        string Name { get; }
        int Value { get; }
    }

    public class Sword : IItem
    {
        public string Name => "Iron Sword";
        public int Value => 50;
    }

    public class Potion : IItem
    {
        public string Name => "Health Potion";
        public int Value => 15;
    }

    public class Gold : IItem
    {
        public int Amount;
        public Gold(int amount) { Amount = amount; }
        public string Name => $"{Amount} Gold";
        public int Value => Amount;
    }

    // ============== Simple Factory ==============
    public static class LootFactory
    {
        public static IItem DropLoot(int enemyLevel)
        {
            if (enemyLevel >= 10) return new Sword();
            if (enemyLevel >= 5)  return new Potion();
            return new Gold(enemyLevel * 5);
        }
    }

    // ============== Factory Method ==============
    public abstract class Enemy
    {
        public abstract IItem CreateLoot();
    }

    public class Goblin : Enemy
    {
        public override IItem CreateLoot() => new Gold(10);
    }

    public class Dragon : Enemy
    {
        public override IItem CreateLoot() => new Sword();
    }

    // ============== Abstract Factory (families of items) ==============
    public interface IItemFactory
    {
        IItem CreateWeapon();
        IItem CreatePotion();
    }

    public class BeginnerItemFactory : IItemFactory
    {
        public IItem CreateWeapon() => new Sword();           // weak iron sword
        public IItem CreatePotion() => new Potion();           // basic potion
    }

    public class EndgameItemFactory : IItemFactory
    {
        public class LegendaryBlade : IItem { public string Name => "Excalibur"; public int Value => 9999; }
        public class MegaPotion   : IItem { public string Name => "Mega Potion"; public int Value => 500; }

        public IItem CreateWeapon() => new LegendaryBlade();
        public IItem CreatePotion() => new MegaPotion();
    }

    static void DemonstrateSimpleFactory()
    {
        Console.WriteLine("--- Simple Factory: DropLoot(level) ---");
        Console.WriteLine($"Level 1 enemy drops: {LootFactory.DropLoot(1).Name}");
        Console.WriteLine($"Level 6 enemy drops: {LootFactory.DropLoot(6).Name}");
        Console.WriteLine($"Level 15 enemy drops: {LootFactory.DropLoot(15).Name}");
    }

    static void DemonstrateFactoryMethod()
    {
        Console.WriteLine("\n--- Factory Method: Each enemy creates its own loot ---");
        Enemy goblin = new Goblin();
        Enemy dragon = new Dragon();
        Console.WriteLine($"Goblin drops: {goblin.CreateLoot().Name}");
        Console.WriteLine($"Dragon drops: {dragon.CreateLoot().Name}");
    }

    static void DemonstrateAbstractFactory()
    {
        Console.WriteLine("\n--- Abstract Factory: Families of items ---");
        IItemFactory factory = new EndgameItemFactory();
        Console.WriteLine($"Weapon: {factory.CreateWeapon().Name}");
        Console.WriteLine($"Potion: {factory.CreatePotion().Name}");
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateSimpleFactory();
        DemonstrateFactoryMethod();
        DemonstrateAbstractFactory();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Build a `QuestFactory` that returns a `KillQuest`, `CollectQuest`,
 *     or `EscortQuest` based on a quest ID or string name.
 *
 *  2. Build an abstract `EnemyFactory` with `CreateEnemy()`. Subclasses
 *     `ForestEnemyFactory` (goblins, wolves) and `CaveEnemyFactory`
 *     (bats, dragons). A `Level` class picks the right factory at runtime.
 *
 *  3. CHALLENGE: Add a new loot type `RareGem` to the Simple Factory
 *     example. Notice you only need to edit LootFactory — the caller
 *     code (`DropLoot` users) does not change. Why is this OCP-friendly?
 *
 *  4. CHALLENGE: Compare LootFactory with `new Sword()` directly used by
 *     the caller. Why is the factory better when many places need loot?
 *     When would direct `new` be fine?
 *
 *  5. C#-SPECIFIC: C# 9 added `new()` target-typed expressions. Try
 *     `Sword s = new();` instead of `new Sword()`. Does this change the
 *     factory pattern's value? Why or why not?
 *
 *  6. CRITICAL THINKING: If a Factory returns an interface (`IItem`), why
 *     can the caller still call `Name` and `Value`? What can't it call?
 *     (Hint: interface defines the contract.)
 * ============================================================================
 */
