/*
 * ============================================================================
 *  PATTERN: STRATEGY — Interchangeable Algorithms at Runtime
 * ============================================================================
 *
 *  WHAT IS IT?
 *  -----------
 *  Define a family of algorithms, encapsulate each one, and make them
 *  interchangeable. The CHOICE of algorithm can be selected at runtime.
 *
 *  WHY USE IT?
 *  -----------
 *  - Eliminates long if/else or switch chains for picking behavior.
 *  - New strategies can be added without touching the consumer (OCP).
 *  - Different objects can use different strategies at the same time.
 *
 *  REAL GAME EXAMPLE
 *  -----------------
 *  An `AttackBehavior` interface with `MeleeAttack`, `RangedAttack`,
 *  `MagicAttack` implementations. Each character picks the strategy that
 *  fits them. Mid-game, an archer can swap to melee by changing the
 *  strategy field — no rewrite needed.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. Define a strategy interface (IDamageStrategy)
 *  2. Multiple concrete strategies (Melee, Ranged, Magic)
 *  3. A character that HOLDS a strategy and delegates to it
 *  4. Swapping strategy at runtime
 *  5. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;

public class StrategyPatternDemo
{
    // ---- Strategy interface ----
    public interface IDamageStrategy
    {
        int CalculateDamage(int baseAttack, int targetDefense);
        string Describe();
    }

    // ---- Concrete strategies ----
    public class MeleeStrategy : IDamageStrategy
    {
        public int CalculateDamage(int baseAttack, int targetDefense)
        {
            // Melee ignores part of the defense.
            int reducedDefense = targetDefense / 2;
            return Math.Max(1, baseAttack - reducedDefense);
        }

        public string Describe() => "Melee: halves target's defense.";
    }

    public class RangedStrategy : IDamageStrategy
    {
        public int CalculateDamage(int baseAttack, int targetDefense)
        {
            // Ranged is weaker but consistent (no defense reduction).
            return Math.Max(1, baseAttack - targetDefense / 4);
        }

        public string Describe() => "Ranged: light armor penetration.";
    }

    public class MagicStrategy : IDamageStrategy
    {
        public int CalculateDamage(int baseAttack, int targetDefense)
        {
            // Magic ignores ALL defense but is more variable.
            return baseAttack + (baseAttack / 4); // 125% of base
        }

        public string Describe() => "Magic: ignores defense entirely.";
    }

    // ---- Context: the thing that USES a strategy ----
    public class Character
    {
        public string Name { get; }
        public int Attack { get; }
        public IDamageStrategy Strategy { get; set; }

        public Character(string name, int attack, IDamageStrategy strategy)
        {
            Name = name;
            Attack = attack;
            Strategy = strategy;
        }

        public int Hit(int targetDefense)
        {
            return Strategy.CalculateDamage(Attack, targetDefense);
        }

        public void PrintStrategy() => Console.WriteLine($"{Name}: {Strategy.Describe()}");
    }

    static void DemonstrateStrategy()
    {
        Console.WriteLine("--- Strategy: Swappable Algorithms ---");

        Character warrior = new Character("Warrior", 30, new MeleeStrategy());
        Character archer = new Character("Archer", 25, new RangedStrategy());
        Character mage = new Character("Mage", 20, new MagicStrategy());

        int enemyDefense = 20;

        Console.WriteLine($"Warrior hits: {warrior.Hit(enemyDefense)} (strategy: {warrior.Strategy.Describe()})");
        Console.WriteLine($"Archer hits:  {archer.Hit(enemyDefense)} (strategy: {archer.Strategy.Describe()})");
        Console.WriteLine($"Mage hits:    {mage.Hit(enemyDefense)} (strategy: {mage.Strategy.Describe()})");

        // Swap archer to melee at runtime — maybe they picked up a sword.
        Console.WriteLine("\n(Archer switches to melee!)");
        archer.Strategy = new MeleeStrategy();
        archer.PrintStrategy();
        Console.WriteLine($"Archer hits: {archer.Hit(enemyDefense)}");
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateStrategy();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Define `IPathfindingStrategy` with `List<Point> FindPath(...)`.
 *     Make `BFSPathfinding` and `GreedyPathfinding`. Apply it to a
 *     `Mover` class that can swap strategies per-tile.
 *
 *  2. Define `IDifficultyStrategy` with `int ModifyDamage(int dmg)` and
 *     `float LootMultiplier()`. Make `Easy`, `Normal`, `Hard`. Apply to
 *     a `GameSettings` object.
 *
 *  3. CHALLENGE: Add a `FireStrategy : IDamageStrategy` that adds
 *     burning damage over time. Notice you only had to ADD a class —
 *     Character did not change. Why is this OCP-friendly?
 *
 *  4. CHALLENGE: Without Strategy, this code would have been:
 *
 *         int dmg;
 *         if (charType == "warrior") dmg = baseAttack - targetDefense / 2;
 *         else if (charType == "archer") dmg = baseAttack - targetDefense / 4;
 *         else if (charType == "mage") dmg = baseAttack * 1.25f;
 *
 *     List three problems with this approach that Strategy solves.
 *
 *  5. C#-SPECIFIC: Look at how `Array.Sort` accepts an `IComparer<T>`
 *     parameter — that's Strategy in the .NET standard library. Find
 *     another example in System.Linq (hint: `OrderBy` takes a key selector
 *     function).
 *
 *  6. CRITICAL THINKING: When is Strategy overkill? When is a single
 *     switch statement just as good? (Hint: if the strategies are simple
 *     and there will only ever be 2-3, a switch can be fine.)
 * ============================================================================
 */
