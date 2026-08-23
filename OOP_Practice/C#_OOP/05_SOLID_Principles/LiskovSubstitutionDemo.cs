/*
 * ============================================================================
 *  SOLID #3: LISKOV SUBSTITUTION PRINCIPLE (LSP)
 * ============================================================================
 *
 *  THE RULE
 *  --------
 *  Objects of a superclass should be replaceable with objects of a
 *  subclass WITHOUT breaking the program's correctness.
 *
 *  In other words: if some code works with a `Bird`, it must also work
 *  correctly when you pass in a `Sparrow` instead of a generic `Bird`.
 *
 *  WHY IT MATTERS
 *  --------------
 *  - Polymorphism only works if subclasses truly behave like their parents.
 *  - Subclasses should EXTEND behavior, not REMOVE or CONTRADICT it.
 *
 *  THE CLASSIC PITFALL
 *  -------------------
 *      class Bird { virtual void Fly() { ... } }
 *      class Penguin : Bird { override void Fly() { throw new Exception(); } }
 *
 *  A Penguin is-a Bird, but it cannot fly. Code that does
 *      MakeBirdFly(bird);
 *  would now crash if you passed a Penguin. LSP is violated.
 *
 *  FIX: split the hierarchy. Maybe `Bird` should not have Fly() at all —
 *  or have an `IFlyable` interface that only flying birds implement.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. A BAD example (Penguin extends Bird but breaks Fly)
 *  2. The GOOD refactor with an IFlyable interface
 *  3. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;
using System.Collections.Generic;

public class LiskovSubstitutionDemo
{
    // ============== BAD: Penguin "is-a" Bird but breaks Fly() ==============
    public class Bird
    {
        public virtual void Fly()
        {
            Console.WriteLine("Flap flap!");
        }
    }

    public class Sparrow : Bird
    {
        public override void Fly()
        {
            Console.WriteLine("Sparrow flits through the air.");
        }
    }

    public class Penguin : Bird
    {
        public override void Fly()
        {
            // Violates LSP: code expecting a Bird that can fly is now broken.
            throw new InvalidOperationException("Penguins cannot fly!");
        }
    }

    // ============== GOOD: split Fly into a capability ==============
    public class BetterBird
    {
        public string Name { get; }
        public BetterBird(string name) { Name = name; }
        public virtual void Speak()
        {
            Console.WriteLine($"{Name} chirps.");
        }
    }

    public interface IFlyable
    {
        void Fly();
    }

    public class BetterSparrow : BetterBird, IFlyable
    {
        public BetterSparrow() : base("Sparrow") { }
        public void Fly()
        {
            Console.WriteLine("Sparrow flits through the air.");
        }
    }

    public class BetterPenguin : BetterBird
    {
        public BetterPenguin() : base("Penguin") { }
        // No Fly() — penguins just don't have that capability.
        public override void Speak()
        {
            Console.WriteLine("Penguin brays.");
        }
        public void Swim()
        {
            Console.WriteLine("Penguin dives into the water.");
        }
    }

    static void MakeBirdFly(Bird bird)
    {
        // This function assumes ALL Birds can fly — but a Penguin breaks it.
        bird.Fly();
    }

    static void MakeFlyableFly(IFlyable flyable)
    {
        // This function takes ONLY things that explicitly CAN fly. Safe.
        flyable.Fly();
    }

    static void DemonstrateBad()
    {
        Console.WriteLine("--- BAD: Penguin breaks the Bird contract ---");
        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();

        MakeBirdFly(sparrow); // OK
        try
        {
            MakeBirdFly(penguin); // CRASH — LSP violation caught!
        }
        catch (InvalidOperationException ex)
        {
            Console.WriteLine($"CAUGHT: {ex.Message}");
        }
        Console.WriteLine();
    }

    static void DemonstrateGood()
    {
        Console.WriteLine("--- GOOD: Only IFlyable things get Fly() ---");
        List<BetterBird> aviary = new List<BetterBird>
        {
            new BetterSparrow(),
            new BetterPenguin(),
        };

        foreach (BetterBird b in aviary)
        {
            b.Speak();
        }

        // Only flyable birds go in this list:
        List<IFlyable> flyers = new List<IFlyable>
        {
            new BetterSparrow(),
            // new BetterPenguin(), // <-- would not compile: not IFlyable
        };

        foreach (IFlyable f in flyers)
        {
            MakeFlyableFly(f); // guaranteed safe
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
 *  1. Create `Square : Rectangle` and override SetWidth/SetHeight so
 *     they keep width == height. Now write a method:
 *
 *         void TestRectangle(Rectangle r)
 *         {
 *             r.SetWidth(5);
 *             r.SetHeight(4);
 *             Console.WriteLine(r.Area()); // expects 20, gets 20 for Square??
 *         }
 *
 *     Pass a Square. Does it print 20? Why does this violate LSP?
 *     Fix: separate `IQuadrilateral` interface or change the test.
 *
 *  2. Create an `Item` parent with `virtual void Use()`. Create
 *     `ReadOnlyBook : Item` that throws on Use(). That's an LSP violation
 *     — fix it by extracting `IUsable` interface.
 *
 *  3. CHALLENGE: Explain in your own words (as a comment): why is the
 *     rule "subclasses should not throw new exceptions from overridden
 *     methods" related to LSP?
 *
 *  4. CHALLENGE: Define `IDuck` with `void Swim()` and `void Quack()`.
 *     Now define `RubberDuck : IDuck`. Implement Swim() as OK and
 *     Quack() as `Console.WriteLine("Squeak")`. Is this an LSP
 *     violation? Why or why not? (Hint: think about what the QUACK
 *     contract means — does a rubber duck "quack"?)
 *
 *  5. C#-SPECIFIC: Look at how `NotImplementedException` is sometimes
 *     thrown by overriding methods. In the .NET standard library, when
 *     WOULD that be considered an LSP violation, and when might it be
 *     acceptable? (Hint: `Stream` is abstract but most subclasses don't
 *     support every operation.)
 * ============================================================================
 */
