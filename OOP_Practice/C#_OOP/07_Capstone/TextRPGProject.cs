/*
 * ============================================================================
 *  CAPSTONE: TEXT RPG COMBAT SYSTEM
 * ============================================================================
 *
 *  This is the BIG one. Every OOP concept from the previous 6 phases is
 *  used here in one program:
 *
 *    Phase 1 (Fundamentals)   : classes, objects, constructors, encapsulation
 *    Phase 2 (Inheritance)    : Combatant hierarchy (Warrior, Mage, Boss, Player)
 *    Phase 3 (Polymorphism)   : TakeTurn() runs differently per character
 *    Phase 4 (Abstraction)    : IDamageable interface, abstract Combatant
 *    Phase 5 (SOLID)          : SRP (each class has one job),
 *                                OCP (new actions added without edit),
 *                                DIP (Battle depends on IDamageable)
 *    Phase 6 (Patterns)       : Singleton (GameState),
 *                                Factory (EnemyFactory),
 *                                Strategy (IDamageStrategy),
 *                                Observer (event-driven HP changes),
 *                                Builder (PlayerBuilder)
 *
 *  Read the WHOLE file once. Then play with it: add a new enemy, add a new
 *  attack action, swap strategies. Notice what does NOT have to change as
 *  you extend.
 *
 *  HOW TO PLAY (auto-pilot for demo)
 *  ----------------------------------
 *  1. Player is built using the Builder.
 *  2. Enemies spawn via the Factory.
 *  3. Each round, the player picks an action (auto-pilot cycles 1-2-3).
 *  4. Damage is calculated via Strategy.
 *  5. The Observer fires on every HP change for UI / sound / save hooks.
 *
 * ============================================================================
 */

using System;
using System.Collections.Generic;

// ============================================================================
//  INTERFACES (Abstraction + DIP)
// ============================================================================

public interface IDamageable
{
    string Name { get; }
    int Health { get; }
    int MaxHealth { get; }
    bool IsAlive { get; }
    void TakeDamage(int amount);
}

public interface IHealable
{
    void Heal(int amount);
}

public interface IAttackAction
{
    string Name { get; }
    void Execute(IDamageable attacker, IDamageable target);
}

// ============================================================================
//  STRATEGY (Phase 6: Strategy pattern)
// ============================================================================

public interface IDamageStrategy
{
    int Calculate(int baseAttack, int targetDefense);
    string Describe();
}

public class MeleeStrategy : IDamageStrategy
{
    public int Calculate(int baseAttack, int targetDefense)
        => Math.Max(1, baseAttack - targetDefense / 2);
    public string Describe() => "Melee (halves defense)";
}

public class MagicStrategy : IDamageStrategy
{
    public int Calculate(int baseAttack, int targetDefense)
        => Math.Max(1, baseAttack - targetDefense / 4);
    public string Describe() => "Magic (light armor pen)";
}

// ============================================================================
//  CHARACTER HIERARCHY (Encapsulation + Inheritance + Polymorphism)
// ============================================================================

public abstract class Combatant : IDamageable
{
    public string Name { get; }
    public int MaxHealth { get; }
    public int Attack { get; }
    public int Defense { get; }
    public IDamageStrategy Strategy { get; set; }       // swappable at runtime

    private int _health;                                 // encapsulation: backing field
    public int Health => _health;
    public bool IsAlive => _health > 0;

    protected Combatant(string name, int maxHealth, int attack, int defense, IDamageStrategy strategy)
    {
        Name = name;
        MaxHealth = maxHealth;
        _health = maxHealth;
        Attack = attack;
        Defense = defense;
        Strategy = strategy;
    }

    public virtual void TakeDamage(int amount)
    {
        int dmg = Strategy.Calculate(amount, Defense);
        _health = Math.Max(0, _health - dmg);
        Console.WriteLine($"  {Name} took {dmg} damage. HP: {_health}/{MaxHealth}");
        GameEvents.RaiseHealthChanged(this);
    }

    // Polymorphic — each subclass decides its own behavior.
    public abstract void TakeTurn(IDamageable target);

    // Helper used by HealAction and Player.Heal.
    protected void SetHealth(int value)
    {
        int newHp = Math.Clamp(value, 0, MaxHealth);
        if (newHp != _health)
        {
            _health = newHp;
            GameEvents.RaiseHealthChanged(this);
        }
    }
}

public class Warrior : Combatant
{
    public Warrior(string name)
        : base(name, maxHealth: 120, attack: 25, defense: 15, strategy: new MeleeStrategy()) { }

    public override void TakeTurn(IDamageable target)
    {
        Console.WriteLine($"  {Name} (Warrior) performs a heroic slash!");
        target.TakeDamage(Attack);
    }
}

public class Mage : Combatant
{
    public Mage(string name)
        : base(name, maxHealth: 80, attack: 30, defense: 8, strategy: new MagicStrategy()) { }

    public override void TakeTurn(IDamageable target)
    {
        Console.WriteLine($"  {Name} (Mage) hurls a fireball!");
        target.TakeDamage(Attack);
    }
}

public class Boss : Combatant
{
    public Boss(string name)
        : base(name, maxHealth: 300, attack: 40, defense: 25, strategy: new MeleeStrategy()) { }

    public override void TakeTurn(IDamageable target)
    {
        Console.WriteLine($"  {Name} (Boss) unleashes a CLEAVE!");
        target.TakeDamage(Attack + 10);
    }
}

public class Player : Combatant, IHealable
{
    public Player(string name, int maxHealth, int attack, int defense, IDamageStrategy strategy)
        : base(name, maxHealth, attack, defense, strategy) { }

    public override void TakeTurn(IDamageable target)
    {
        // Real game would prompt user input; demo auto-pilots from Battle.
    }

    public void Heal(int amount)
    {
        int healed = Math.Min(amount, MaxHealth - Health);
        SetHealth(Health + healed);
        Console.WriteLine($"  {Name} healed for {healed}. HP: {Health}/{MaxHealth}");
    }
}

// ============================================================================
//  ATTACK ACTIONS (Strategy-ish, can be extended without modifying Battle)
// ============================================================================

public class SlashAction : IAttackAction
{
    public string Name => "Slash";
    public void Execute(IDamageable attacker, IDamageable target)
    {
        Console.WriteLine($"  -> {attacker.Name} uses Slash!");
        target.TakeDamage(15);
    }
}

public class FireballAction : IAttackAction
{
    public string Name => "Fireball";
    public void Execute(IDamageable attacker, IDamageable target)
    {
        Console.WriteLine($"  -> {attacker.Name} casts Fireball!");
        target.TakeDamage(25);
    }
}

public class HealAction : IAttackAction
{
    public string Name => "Heal";
    public void Execute(IDamageable attacker, IDamageable target)
    {
        if (attacker is IHealable h)
        {
            h.Heal(20);
        }
        else
        {
            Console.WriteLine($"  -> {attacker.Name} cannot heal!");
        }
    }
}

// ============================================================================
//  GAME EVENTS (Phase 6: Observer — C# event/delegate style)
// ============================================================================

public static class GameEvents
{
    public static event Action<IDamageable> HealthChanged;
    public static void RaiseHealthChanged(IDamageable who) => HealthChanged?.Invoke(who);
}

public class HealthHUD
{
    public HealthHUD()
    {
        GameEvents.HealthChanged += OnHealthChanged;
    }

    private void OnHealthChanged(IDamageable who)
    {
        // This would update a UI bar in a real game.
        Console.WriteLine($"    [HUD] {who.Name} HP -> {who.Health}/{who.MaxHealth}");
    }
}

// ============================================================================
//  SINGLETON (Phase 6)
// ============================================================================

public sealed class GameState
{
    private static GameState _instance;
    private static readonly object _lock = new object();

    public string CurrentLevel { get; private set; } = "Tutorial";
    public int Score { get; private set; } = 0;

    private GameState() { }

    public static GameState Instance
    {
        get
        {
            if (_instance == null)
            {
                lock (_lock) { _instance ??= new GameState(); }
            }
            return _instance;
        }
    }

    public void AddScore(int points) => Score += points;
    public void EnterLevel(string name) => CurrentLevel = name;
}

// ============================================================================
//  FACTORY (Phase 6)
// ============================================================================

public static class EnemyFactory
{
    public static Combatant Spawn(string kind, int level)
    {
        return kind.ToLower() switch
        {
            "goblin" => new Warrior($"Goblin L{level}"),
            "mage"   => new Mage($"Evil Mage L{level}"),
            "boss"   => new Boss($"Dragon Boss L{level}"),
            _        => new Warrior($"Mystery L{level}"),
        };
    }
}

// ============================================================================
//  BUILDER (Phase 6)
// ============================================================================

public class PlayerBuilder
{
    private string _name = "Hero";
    private int _health = 100;
    private int _attack = 20;
    private int _defense = 10;
    private IDamageStrategy _strategy = new MeleeStrategy();

    public PlayerBuilder Named(string n)                      { _name = n; return this; }
    public PlayerBuilder WithHealth(int v)                    { _health = v; return this; }
    public PlayerBuilder WithAttack(int v)                    { _attack = v; return this; }
    public PlayerBuilder WithDefense(int v)                   { _defense = v; return this; }
    public PlayerBuilder WithStrategy(IDamageStrategy s)      { _strategy = s; return this; }

    public Player Build() => new Player(_name, _health, _attack, _defense, _strategy);
}

// ============================================================================
//  BATTLE (SRP: only orchestrates; DIP: depends on IDamageable/IAttackAction)
// ============================================================================

public class Battle
{
    public void RunEncounter(Player player, Combatant enemy)
    {
        Console.WriteLine($"\n=== Encounter: {player.Name} vs {enemy.Name} ===");

        IAttackAction[] actions = { new SlashAction(), new FireballAction(), new HealAction() };

        int turn = 1;
        while (player.IsAlive && enemy.IsAlive && turn <= 12)
        {
            Console.WriteLine($"\n--- Turn {turn} ---");

            // Auto-pilot picks actions so the demo runs without input.
            IAttackAction action = actions[(turn - 1) % actions.Length];
            action.Execute(player, enemy);

            if (enemy.IsAlive)
            {
                enemy.TakeTurn(player);   // polymorphic call
            }

            turn++;
        }

        Console.WriteLine();
        if (player.IsAlive)
        {
            Console.WriteLine($"*** {player.Name} WINS! ***");
            GameState.Instance.AddScore(100);
        }
        else
        {
            Console.WriteLine($"*** {enemy.Name} wins... ***");
        }
    }
}

// ============================================================================
//  MAIN — wires everything together.
// ============================================================================

public class TextRPGProject
{
    public static void Main(string[] args)
    {
        Console.WriteLine("=== TEXT RPG CAPSTONE ===\n");

        // Singleton
        GameState.Instance.EnterLevel("Forest Path");

        // Observer — HUD subscribes once, gets notified for the whole game
        var hud = new HealthHUD();

        // Builder — fluent player construction
        Player hero = new PlayerBuilder()
            .Named("Aragon")
            .WithHealth(120)
            .WithAttack(22)
            .WithDefense(12)
            .WithStrategy(new MeleeStrategy())
            .Build();

        // Factory — enemies via abstract creation
        Combatant goblin = EnemyFactory.Spawn("goblin", 1);
        Combatant boss   = EnemyFactory.Spawn("boss", 5);

        // Strategy swap demo: change hero's damage calc mid-game
        Console.WriteLine($"[Setup] Hero uses: {hero.Strategy.Describe()}");
        hero.Strategy = new MagicStrategy();
        Console.WriteLine($"[Setup] Hero now uses: {hero.Strategy.Describe()}");

        // Battle (orchestrator only — does not log, save, or render)
        Battle battle = new Battle();
        battle.RunEncounter(hero, goblin);
        if (hero.IsAlive)
        {
            battle.RunEncounter(hero, boss);
        }

        Console.WriteLine($"\nFinal Score (from Singleton): {GameState.Instance.Score}");
        Console.WriteLine($"Current Level (from Singleton): {GameState.Instance.CurrentLevel}");
    }
}

/*
 * ============================================================================
 *  CAPSTONE PRACTICE / EXTENSION IDEAS
 * ============================================================================
 *
 *  1. Add a `Skeleton : Combatant` and a corresponding Factory entry.
 *     The Battle class should NOT need changes. (OCP proof.)
 *
 *  2. Add a `Room` class (ISP-friendly) that holds a list of enemies and
 *     a reward. Make the Battle class iterate rooms.
 *
 *  3. Add an `HpObserver` subscriber that updates a SaveSystem class.
 *     Print "SaveSystem: autosaved X HP" on each fire.
 *
 *  4. Swap the player's Strategy at runtime. Notice TakeDamage calc
 *     changes immediately.
 *
 *  5. Refactor Battle so it does NOT auto-pilot. Use Console.ReadLine()
 *     to read a menu choice and map it to an IAttackAction.
 *
 *  6. Extract a `Logger` class with a single responsibility (logging).
 *     Battle should not Console.WriteLine damage directly — it should
 *     call Logger.Log(...).
 *
 *  7. CHALLENGE: Replace the manual Singleton with one injected through
 *     a constructor. Notice how testing becomes easier.
 *
 *  8. CHALLENGE: Add a 2-floor dungeon. Floor 1 has 2 goblins, floor 2
 *     has the boss. Use a `Dungeon` class that owns the rooms.
 *
 *  9. CRITICAL THINKING: Look at Combatant. It has fields, behavior, and
 *     serves as the parent for many subclasses. Does it satisfy SRP?
 *     If not, split into `CombatantStats` (data) + `Combatant` (behavior).
 *
 * 10. C#-SPECIFIC: Move this whole thing into a `dotnet new console`
 *     project and add xUnit tests for each pattern. The DIP-friendly
 *     design pays off here — every piece is testable in isolation.
 * ============================================================================
 */
