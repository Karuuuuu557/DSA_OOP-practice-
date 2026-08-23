/*
 * ============================================================================
 *  TOPIC: ENCAPSULATION — Protecting an Object's Data (C# edition)
 * ============================================================================
 *
 *  WHAT IS ENCAPSULATION?
 *  -----------------------
 *  Encapsulation means bundling an object's data (fields) together with the
 *  methods that operate on it, and RESTRICTING direct outside access to that
 *  data. Instead of letting other code freely change a field, you force it
 *  to go through controlled methods (getters/setters) that can validate or
 *  protect the data.
 *
 *  WHY DOES IT MATTER?
 *  --------------------
 *  Without encapsulation, any code anywhere could do:
 *      player.Health = -9999;
 *  ...and there would be nothing stopping an invalid state from happening.
 *  With encapsulation, the field is hidden (`private`) and the ONLY way to
 *  change it is through a method that can enforce rules, e.g. "Health can
 *  never exceed MaxHealth."
 *
 *  ACCESS MODIFIERS IN C# (from most to least restrictive):
 *  ---------------------------------------------------------
 *  - private    : only visible inside the SAME class.
 *  - protected  : visible to the same class and its subclasses.
 *  - internal   : visible inside the SAME assembly (.dll / project).
 *  - public     : visible from anywhere.
 *  (C# does NOT have the "package-private" default that Java has. The
 *  closest equivalent is `internal`.)
 *
 *  THE STANDARD PATTERN:
 *  ----------------------
 *  1. Make fields `private`.
 *  2. Provide `public` PROPERTIES (getters + setters) to read/write them.
 *  3. Use validation logic inside the `set` accessor if needed.
 *  4. If a field should NEVER change after construction, use `readonly` for
 *     fields OR a get-only property — that gives you "immutability".
 *
 *  C# vs JAVA — KEY DIFFERENCE: PROPERTIES
 *  ----------------------------------------
 *  In Java you write getX()/setX() methods explicitly. C# has built-in
 *  PROPERTIES, which look like fields to outside code but are actually
 *  method calls behind the scenes:
 *
 *      private int _health;
 *      public int Health
 *      {
 *          get { return _health; }
 *          set
 *          {
 *              if (value < 0) { Console.WriteLine("Rejected"); return; }
 *              _health = value;
 *          }
 *      }
 *
 *  Then outside code does: `player.Health = 50;` and `Console.WriteLine(
 *  player.Health);` — just like a field, but with validation built in.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. A class WITHOUT encapsulation (showing the problem)
 *  2. The same class WITH encapsulation (showing the fix)
 *  3. An immutable class (read-only fields + get-only properties)
 *  4. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;

public class EncapsulationDemo
{
    // ---- BEFORE: no encapsulation, fields are wide open ----
    public class UnsafePlayer
    {
        public int Health;     // public field = no protection at all
        public int MaxHealth;
    }

    static void DemonstrateProblem()
    {
        Console.WriteLine("--- Without Encapsulation (the problem) ---");
        UnsafePlayer p = new UnsafePlayer();
        p.Health = 100;
        p.MaxHealth = 100;
        Console.WriteLine($"Set Health to: {p.Health}");

        // Nothing stops this — an invalid state slips right through.
        p.Health = -500;
        Console.WriteLine($"Health is now (invalid!): {p.Health}");
    }

    // ---- AFTER: encapsulated, fields are private and guarded by properties ----
    public class SafePlayer
    {
        // `private` fields — NOTHING outside this class can touch them
        // directly, not even by typing `player._health`. It will not compile.
        private int _health;
        private int _maxHealth;

        // Full constructor — routes both values through the properties so the
        // same validation rule applies whether the player is brand new or
        // being updated later. This avoids duplicating the rule.
        public SafePlayer(int startingHealth, int maxHealth)
        {
            MaxHealth = maxHealth;     // uses the property setter
            Health = startingHealth;   // uses the property setter
        }

        // PROPERTY: the only way to read/write Health from outside this class.
        // The getter is `get { ... }` and the setter is `set { ... }`.
        public int Health
        {
            get { return _health; }
            set
            {
                if (value < 0)
                {
                    Console.WriteLine("Rejected: health cannot be negative.");
                    return;
                }
                if (value > _maxHealth)
                {
                    Console.WriteLine("Capped: health cannot exceed MaxHealth.");
                    _health = _maxHealth;
                    return;
                }
                _health = value;
            }
        }

        public int MaxHealth
        {
            get { return _maxHealth; }
            set
            {
                if (value <= 0)
                {
                    Console.WriteLine("Rejected: maxHealth must be positive.");
                    return;
                }
                _maxHealth = value;
            }
        }

        // A behavior method that also goes through validation indirectly,
        // by assigning to the property instead of the field directly.
        public void TakeDamage(int amount)
        {
            if (amount < 0)
            {
                Console.WriteLine("Rejected: damage cannot be negative.");
                return;
            }
            Health = Health - amount; // uses the setter — validation runs
        }

        public void Heal(int amount)
        {
            Health = Health + amount; // uses the setter — caps at MaxHealth
        }
    }

    static void DemonstrateFix()
    {
        Console.WriteLine("\n--- With Encapsulation (the fix) ---");
        SafePlayer p = new SafePlayer(100, 100);
        Console.WriteLine($"Health: {p.Health}");

        p.Health = -500;          // rejected by the setter's validation
        Console.WriteLine($"Health after invalid attempt: {p.Health}");

        p.TakeDamage(30);
        Console.WriteLine($"Health after 30 damage: {p.Health}");

        p.Heal(500);              // tries to heal way over max
        Console.WriteLine($"Health after huge heal (capped): {p.Health}");

        // p._health = 999;       // <-- this line would NOT COMPILE if uncommented,
        //                           because `_health` is private to SafePlayer.
    }

    // ---- IMMUTABLE class: fields are set once and NEVER change again ----
    // Notice there is no setter at all — once a Coordinate is created, its
    // x and y can never be modified. Useful for values that should be safe
    // to share around a program without fear of something else changing them.
    public class Coordinate
    {
        private readonly int _x; // `readonly` means this field can only be assigned in the constructor
        private readonly int _y;

        public Coordinate(int x, int y)
        {
            _x = x;
            _y = y;
        }

        // GET-ONLY PROPERTIES — there is no `set` block at all.
        public int X => _x;       // expression-bodied property (C# 6+)
        public int Y => _y;

        // Instead of a setter, "moving" a Coordinate means creating a BRAND NEW
        // Coordinate object — the original one is left untouched.
        public Coordinate Moved(int dx, int dy)
        {
            return new Coordinate(_x + dx, _y + dy);
        }
    }

    static void DemonstrateImmutability()
    {
        Console.WriteLine("\n--- Immutability (no setters at all) ---");
        Coordinate original = new Coordinate(2, 3);
        Coordinate shifted = original.Moved(5, 5);

        Console.WriteLine($"Original: ({original.X}, {original.Y})");
        Console.WriteLine($"Shifted:  ({shifted.X}, {shifted.Y})");
        // original is completely unchanged — Moved() returned a NEW object.
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateProblem();
        DemonstrateFix();
        DemonstrateImmutability();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Write an encapsulated `Inventory` class with a private `int _gold`
 *     field. Expose it through a `Gold` property whose setter rejects any
 *     value below 0. Test it by attempting to set Gold to -10.
 *
 *  2. Write an encapsulated `ManaPool` class storing `int _mana` as a
 *     private field, but expose it through TWO properties:
 *     `Mana` (raw int) and `ManaPercent` (int 0..100, calculated on the fly).
 *     This shows encapsulation is not just about protection — it also lets
 *     you expose the SAME data in different useful forms.
 *
 *  3. Take the UnsafePlayer class above and figure out: what is the minimum
 *     change needed to make it safe, without adding any properties? (Hint:
 *     making a field private without exposing it creates a different
 *     problem — what is it?)
 *
 *  4. CHALLENGE: Create an immutable `Vector2` class with `readonly` fields
 *     X and Y, plus a method `float Length()` that calculates the length
 *     on demand instead of storing it (a stored length would become stale
 *     if X or Y were ever to change — by being immutable + calculating on
 *     demand, you cannot have that bug).
 *
 *  5. C#-SPECIFIC: Convert any one of the `set { ... }` blocks above into
 *     an EXPRESSION-BODIED property (using `=>`). Try it on a property that
 *     has NO validation logic first to keep it simple.
 *
 *  6. C#-SPECIFIC: Use a `private set` (e.g. `public int Health { get;
 *     private set; }`) on a field that should be readable from outside but
 *     only writable from inside the class. Compare it to the full property
 *     pattern above — when would you pick one over the other?
 * ============================================================================
 */
