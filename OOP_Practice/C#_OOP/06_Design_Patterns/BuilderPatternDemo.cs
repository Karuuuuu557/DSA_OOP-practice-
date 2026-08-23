/*
 * ============================================================================
 *  PATTERN: BUILDER — Step-by-Step Object Construction
 * ============================================================================
 *
 *  WHAT IS IT?
 *  -----------
 *  Builder separates the construction of a complex object from its
 *  representation. You build it step by step, then ask the builder for
 *  the final result.
 *
 *  WHY USE IT?
 *  -----------
 *  - Constructors with many optional parameters get unreadable quickly
 *    (the "telescoping constructor" anti-pattern).
 *  - Builder lets you name each step (.SetName(...).SetDamage(...)) and
 *    ignore the ones you don't care about.
 *
 *  REAL GAME EXAMPLE
 *  -----------------
 *  Building a complex `Character` for an RPG (name, class, stats, gear,
 *  spells). With a builder: `new CharacterBuilder().Named("Aragon")
 *  .WithClass("Warrior").WithStrength(20).Build()`.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. A Character class with too many fields for a clean constructor
 *  2. The Builder that constructs it step by step
 *  3. Comparing the old constructor to the new fluent API
 *  4. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;
using System.Collections.Generic;

public class BuilderPatternDemo
{
    // ---- The complex object we want to build ----
    public class Character
    {
        public string Name { get; }
        public string Class { get; }
        public int Strength { get; }
        public int Dexterity { get; }
        public int Intelligence { get; }
        public int Health { get; }
        public List<string> Skills { get; }

        // Internal constructor — only the Builder is supposed to call this.
        internal Character(string name, string cls, int str, int dex, int intel, int hp, List<string> skills)
        {
            Name = name;
            Class = cls;
            Strength = str;
            Dexterity = dex;
            Intelligence = intel;
            Health = hp;
            Skills = skills;
        }

        public override string ToString()
        {
            return $"{Name} the {Class} (STR {Strength}, DEX {Dexterity}, INT {Intelligence}, HP {Health}) " +
                   $"Skills: [{string.Join(", ", Skills)}]";
        }
    }

    // ---- The Builder ----
    public class CharacterBuilder
    {
        private string _name = "Unnamed";
        private string _class = "Peasant";
        private int _strength = 10;
        private int _dexterity = 10;
        private int _intelligence = 10;
        private int _health = 100;
        private List<string> _skills = new List<string>();

        public CharacterBuilder Named(string name)
        {
            _name = name;
            return this; // returns the builder for chaining
        }

        public CharacterBuilder WithClass(string cls)
        {
            _class = cls;
            return this;
        }

        public CharacterBuilder WithStrength(int v)
        {
            _strength = v;
            return this;
        }

        public CharacterBuilder WithDexterity(int v)
        {
            _dexterity = v;
            return this;
        }

        public CharacterBuilder WithIntelligence(int v)
        {
            _intelligence = v;
            return this;
        }

        public CharacterBuilder WithHealth(int v)
        {
            _health = v;
            return this;
        }

        public CharacterBuilder AddSkill(string skill)
        {
            _skills.Add(skill);
            return this;
        }

        // Final step — produces the finished Character.
        public Character Build()
        {
            return new Character(_name, _class, _strength, _dexterity, _intelligence, _health, _skills);
        }
    }

    static void DemonstrateBuilder()
    {
        Console.WriteLine("--- Builder: Fluent Step-by-Step Construction ---");

        // Compared to: new Character("Aragon", "Warrior", 20, 12, 8, 150, ...)
        // ...which is unreadable. The builder is self-documenting.
        Character hero = new CharacterBuilder()
            .Named("Aragon")
            .WithClass("Warrior")
            .WithStrength(20)
            .WithDexterity(12)
            .WithHealth(150)
            .AddSkill("Slash")
            .AddSkill("Power Strike")
            .Build();

        Console.WriteLine(hero);

        // Different character, totally different stats, same builder.
        Character mage = new CharacterBuilder()
            .Named("Elara")
            .WithClass("Mage")
            .WithIntelligence(25)
            .WithHealth(80)
            .AddSkill("Fireball")
            .AddSkill("Teleport")
            .Build();

        Console.WriteLine(mage);
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateBuilder();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Build a `PizzaBuilder` for a Pizza with size, crust, multiple
 *     toppings, and cheese. Use `.AddTopping("pepperoni")` style.
 *
 *  2. Build a `LevelBuilder` for a game level with width, height, list of
 *     enemies, list of items, music track. Add `.AddEnemy(...)` and
 *     `.AddItem(...)`.
 *
 *  3. CHALLENGE: Add validation in the Builder's Build() — if Name is
 *     empty, throw an exception. This way the Character is GUARANTEED
 *     valid when Build() returns. Try breaking the contract (empty name)
 *     and see what happens.
 *
 *  4. CHALLENGE: Create a `WeaponBuilder` with sensible DEFAULTS (e.g.
 *     Damage = 5). Then call `.WithDamage(50)` to override. Notice the
 *     builder lets you change only what you care about — the rest stay
 *     at defaults. This is a big advantage over constructors with
 *     optional parameters.
 *
 *  5. C#-SPECIFIC: C# has "named arguments" that solve a similar problem:
 *     `new Character(name: "X", strength: 20, class: "Y")`. When does
 *     named arguments make Builder unnecessary, and when is Builder still
 *     better? (Hint: when there is construction LOGIC, not just values.)
 *
 *  6. CRITICAL THINKING: Why might Builder be overkill for a class with
 *     only 2-3 fields? At what point does the pattern start paying off?
 * ============================================================================
 */
