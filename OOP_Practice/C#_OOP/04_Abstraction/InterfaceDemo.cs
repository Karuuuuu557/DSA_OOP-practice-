/*
 * ============================================================================
 *  TOPIC: INTERFACES — Pure Behavior Contracts (C# edition)
 * ============================================================================
 *
 *  WHAT IS AN INTERFACE?
 *  ---------------------
 *  A pure "contract" — a list of methods/properties a class MUST
 *  implement, with no implementation provided by the interface itself.
 *  Any class that "signs" the contract must fill in all the methods.
 *
 *  WHY USE ONE?
 *  ------------
 *  Use when unrelated classes need to share a CAPABILITY, not an identity.
 *  Example: a Dragon, an Arrow, and a Magic Spell might all be `IDamageable`
 *  or `IFlammable`, even though they have no common parent.
 *
 *  C# vs JAVA — IMPORTANT DIFFERENCES
 *  ----------------------------------
 *  1. C# 8+ supports DEFAULT interface methods (with a body) — similar to
 *     Java 8+. We will use traditional interface contracts here.
 *  2. C# uses `:` for both class inheritance AND interface implementation.
 *     If you implement MULTIPLE interfaces, separate them with commas:
 *
 *         class Duck : Animal, IFlyable, ISwimmable
 *
 *  3. C# 8+ also allows `new` interface members with default implementations.
 *     We avoid that here for clarity.
 *
 *  4. Use `interface INameable` — by convention, C# interface names start
 *     with capital `I`.
 *
 *  5. All interface members are PUBLIC by default. You cannot use access
 *     modifiers on interface members (in older C#; C# 8+ allows `private`
 *     for default methods only).
 *
 *  IN THIS FILE:
 *  -------------
 *  1. Defining and implementing a basic interface
 *  2. Implementing multiple interfaces (the alternative to multiple
 *     inheritance)
 *  3. Interface inheritance (one interface extending another)
 *  4. Polymorphism through interface references
 *  5. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;
using System.Collections.Generic;

public class InterfaceDemo
{
    // ---- Interface: a contract for "anything that can take damage" ----
    public interface IDamageable
    {
        void TakeDamage(int amount);
        int Health { get; }   // interface can declare properties too
    }

    // ---- Interface: a contract for "anything that can attack" ----
    public interface IAttacker
    {
        void Attack(IDamageable target);
    }

    // ---- Interface: a contract for "anything that can be looted" ----
    public interface ILootable
    {
        string Loot();
    }

    // ---- A class that implements MULTIPLE interfaces (no shared parent!) ----
    public class Goblin : IDamageable, IAttacker, ILootable
    {
        public string Name { get; } = "Goblin";
        public int Health { get; private set; } = 30;

        public void TakeDamage(int amount)
        {
            Health -= amount;
            Console.WriteLine($"{Name} took {amount} damage. HP: {Health}");
        }

        public void Attack(IDamageable target)
        {
            Console.WriteLine($"{Name} slashes the target for 5 damage!");
            target.TakeDamage(5);
        }

        public string Loot() => "3 gold coins";
    }

    public class Dragon : IDamageable, IAttacker
    {
        public string Name { get; } = "Dragon";
        public int Health { get; private set; } = 500;

        public void TakeDamage(int amount)
        {
            Health -= amount;
            Console.WriteLine($"{Name} took {amount} damage. HP: {Health}");
        }

        public void Attack(IDamageable target)
        {
            Console.WriteLine($"{Name} breathes FIRE for 80 damage!");
            target.TakeDamage(80);
        }
        // Note: Dragon does NOT implement ILootable — that's fine. Interfaces
        // are optional capabilities, not mandatory identities.
    }

    // ---- A class that is IDamageable but NOT IAttacker (a destructible wall) ----
    public class DestructibleWall : IDamageable, ILootable
    {
        public string Name { get; } = "Stone Wall";
        public int Health { get; private set; } = 100;

        public void TakeDamage(int amount)
        {
            Health -= amount;
            Console.WriteLine($"{Name} cracks! HP: {Health}");
        }

        public string Loot() => "a pile of rubble";
    }

    // ---- Interface inheritance: one interface extending another ----
    public interface ICombatant : IDamageable, IAttacker
    {
        // Empty body, but now anything that is ICombatant must implement
        // BOTH IDamageable AND IAttacker.
    }

    public class Skeleton : ICombatant
    {
        public string Name { get; } = "Skeleton";
        public int Health { get; private set; } = 50;

        public void TakeDamage(int amount)
        {
            Health -= amount;
            Console.WriteLine($"{Name} rattles. HP: {Health}");
        }

        public void Attack(IDamageable target)
        {
            Console.WriteLine($"{Name} swipes for 7 damage!");
            target.TakeDamage(7);
        }
    }

    static void DemonstrateSingleInterface()
    {
        Console.WriteLine("--- Single Interface Implementation ---");
        Goblin goblin = new Goblin();
        goblin.Attack(new DestructibleWall()); // Goblin attacks a wall
        Console.WriteLine();
    }

    static void DemonstrateInterfacePolymorphism()
    {
        Console.WriteLine("--- Polymorphism Through Interface References ---");

        // A list of IDamageable — different actual types, same capability.
        List<IDamageable> thingsThatCanBeHurt = new List<IDamageable>
        {
            new Goblin(),
            new Dragon(),
            new DestructibleWall(),
        };

        foreach (IDamageable thing in thingsThatCanBeHurt)
        {
            thing.TakeDamage(10);
        }
        Console.WriteLine();
    }

    static void DemonstrateOptionalCapability()
    {
        Console.WriteLine("--- Optional Capability (ILootable) ---");

        // A list of ILootable — only objects that are lootable go here.
        List<ILootable> lootables = new List<ILootable>
        {
            new Goblin(),
            new DestructibleWall(),
            // new Dragon(), // <-- this line would NOT COMPILE: Dragon is not ILootable
        };

        foreach (ILootable thing in lootables)
        {
            Console.WriteLine($"Loot: {thing.Loot()}");
        }
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateSingleInterface();
        DemonstrateInterfacePolymorphism();
        DemonstrateOptionalCapability();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Define `IFlyable` with `void Fly()`. Implement it on `Dragon`,
 *     `Phoenix`, and `MagicCarpet`. Build a `List<IFlyable>` and call Fly()
 *     on each.
 *
 *  2. Define `ISaveable` with `string Save()` and `void Load(string data)`.
 *     Implement it on `Player`, `Inventory`, and `QuestLog`.
 *
 *  3. Define `IPickupable` and `IUsable`. Make a `HealthPotion` implement
 *     both. Make a `GoldCoin` implement only IPickupable. Use a single
 *     `List<IPickupable>` to gather loot and call PickUp() on each.
 *
 *  4. CHALLENGE: Try to write `public class Duck : IDamageable` without
 *     implementing `TakeDamage` or `Health`. What error does the C#
 *     compiler give? Why?
 *
 *  5. CHALLENGE: Define `IHealable` with `void Heal(int amount)`. Make
 *     `Player` implement BOTH `IDamageable` and `IHealable`. Then write
 *     a `HealAll` method that takes `List<IDamageable>` AND a separate
 *     method that takes `List<IHealable>`. Why can't a single list hold
 *     both at the same time?
 *
 *  6. C#-SPECIFIC: C# 8+ supports DEFAULT interface methods. Try writing:
 *
 *         public interface ILoggable
 *         {
 *             void Log(string msg);
 *             void LogError(string msg) => Log($"ERROR: {msg}");
 *         }
 *
 *     Now a class that only implements `Log` automatically gets `LogError`.
 *     When would you use this in a real game (e.g. debug logging)?
 *
 *  7. C#-SPECIFIC: Add a `where T : IDamageable` constraint to a generic
 *     method `public static void AttackAll<T>(List<T> targets) where T :
 *     IDamageable` so it can call `TakeDamage` on each.
 * ============================================================================
 */
