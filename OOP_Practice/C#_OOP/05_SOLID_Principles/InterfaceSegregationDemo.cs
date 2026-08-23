/*
 * ============================================================================
 *  SOLID #4: INTERFACE SEGREGATION PRINCIPLE (ISP)
 * ============================================================================
 *
 *  THE RULE
 *  --------
 *  Clients should not be forced to depend on methods they do not use.
 *  Prefer many small, focused interfaces over one big "fat" interface.
 *
 *  WHY IT MATTERS
 *  --------------
 *  - A class implementing an interface shouldn't have to throw
 *    `NotImplementedException` for methods it doesn't need.
 *  - Small interfaces are easier to implement and reuse.
 *
 *  REAL GAME EXAMPLE
 *  -----------------
 *  An `IItem` interface with `Equip()`, `Consume()`, `Sell()`, AND
 *  `Examine()` would force every item type to implement ALL of them.
 *  A sword can't be consumed, a potion can't be equipped. Split into
 *  `IEquippable`, `IConsumable`, `ISellable`, `IExaminable`.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. BAD: One fat interface with too many methods
 *  2. GOOD: Small, focused interfaces that classes combine as needed
 *  3. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;

public class InterfaceSegregationDemo
{
    // ============== BAD: one fat interface ==============
    public interface IItem
    {
        void Equip();
        void Consume();
        void Sell();
        void Examine();
    }

    public class BadSword : IItem
    {
        public void Equip() => Console.WriteLine("Sword equipped.");
        public void Consume() => throw new NotImplementedException();
        public void Sell() => Console.WriteLine("Sword sold for 50g.");
        public void Examine() => Console.WriteLine("A sharp blade.");
    }

    public class BadPotion : IItem
    {
        public void Equip() => throw new NotImplementedException();
        public void Consume() => Console.WriteLine("Potion drank. +25 HP.");
        public void Sell() => Console.WriteLine("Potion sold for 15g.");
        public void Examine() => Console.WriteLine("A red flask.");
    }

    // ============== GOOD: small, focused interfaces ==============
    public interface IEquippable { void Equip(); }
    public interface IConsumable { void Consume(); }
    public interface ISellable    { void Sell(); }
    public interface IExaminable  { void Examine(); }

    public class Sword : IEquippable, ISellable, IExaminable
    {
        public void Equip()    => Console.WriteLine("Sword equipped.");
        public void Sell()     => Console.WriteLine("Sword sold for 50g.");
        public void Examine()  => Console.WriteLine("A sharp blade.");
    }

    public class Potion : IConsumable, ISellable, IExaminable
    {
        public void Consume()  => Console.WriteLine("Potion drank. +25 HP.");
        public void Sell()     => Console.WriteLine("Potion sold for 15g.");
        public void Examine()  => Console.WriteLine("A red flask.");
    }

    public class TreasureMap : IExaminable
    {
        // Only examinable. Nothing else needed.
        public void Examine() => Console.WriteLine("Marks the location of X.");
    }

    static void DemonstrateBad()
    {
        Console.WriteLine("--- BAD: Fat interface, classes throw NotImplementedException ---");
        BadSword sword = new BadSword();
        try { sword.Consume(); } catch (NotImplementedException) { Console.WriteLine("Sword.Consume() threw!"); }
        BadPotion potion = new BadPotion();
        try { potion.Equip(); } catch (NotImplementedException) { Console.WriteLine("Potion.Equip() threw!"); }
        Console.WriteLine();
    }

    static void DemonstrateGood()
    {
        Console.WriteLine("--- GOOD: Each class only implements what it needs ---");
        Sword sword = new Sword();
        sword.Equip();
        sword.Sell();
        sword.Examine();

        Potion potion = new Potion();
        potion.Consume();
        potion.Sell();
        potion.Examine();

        TreasureMap map = new TreasureMap();
        map.Examine();
        // map.Consume(); // <-- would NOT compile — good!
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
 *  1. Create a fat `ICharacterAction` interface with Attack(), Defend(),
 *     Cast(), Steal(), Pray(). Notice that no single character type can
 *     realistically do ALL of those. Split into focused interfaces.
 *
 *  2. Take the GOOD Sword and Potion above. Define a method
 *     `void SellAll(IEnumerable<ISellable> items)` and pass a mixed
 *     list containing both.
 *
 *  3. CHALLENGE: Read about how `System.Collections.IEnumerable` is
 *     "fat" in older .NET (it requires MoveNext, Reset, and Current).
 *     How does LINQ's `IEnumerable<T>` differ? Is IEnumerable<T> more
 *     ISP-friendly?
 *
 *  4. Explain in your own words (as a comment): why is having an
 *     interface with 20 methods generally a code smell? (Hint: think
 *     about how many classes will need to throw NotImplementedException.)
 *
 *  5. C#-SPECIFIC: Use C# 8 default interface methods to provide a
 *     "default Sell()" on a base interface that prints "Cannot sell
 *     this item." Then `Sword` can choose to override it while a
 *     non-sellable item can just inherit the default. Try it.
 * ============================================================================
 */
