/*
 * ============================================================================
 *  PATTERN: OBSERVER — Publish/Subscribe Event Notification
 * ============================================================================
 *
 *  WHAT IS IT?
 *  -----------
 *  A subject maintains a list of "subscribers". When the subject's state
 *  changes, it NOTIFIES all subscribers automatically. Subscribers do not
 *  need to poll — they get pushed updates.
 *
 *  WHY USE IT?
 *  -----------
 *  - Decouples the source of an event from the things that react to it.
 *  - The subject does not need to know WHO is listening.
 *  - Easy to add/remove subscribers at runtime.
 *
 *  C# vs JAVA — IMPORTANT DIFFERENCE: EVENTS
 *  -----------------------------------------
 *  C# has built-in `event` and `delegate` keywords that are purpose-built
 *  for the Observer pattern. They are essentially syntactic sugar over a
 *  manual subscribe/notify system, but they are the IDIOMATIC C# way.
 *  We show BOTH approaches in this file.
 *
 *  REAL GAME EXAMPLE
 *  -----------------
 *  A `PlayerHealthChanged` event. UI bar, audio system, achievement
 *  tracker, and particle effects all subscribe. When health changes,
 *  all of them get notified automatically.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. Manual Observer (subscribe/notify interface)
 *  2. C# event/delegate version (idiomatic)
 *  3. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;

public class ObserverPatternDemo
{
    // ============== APPROACH 1: Manual Observer ==============

    public interface IObserver
    {
        void Update(string eventType, object data);
    }

    public class PlayerHealth
    {
        private int _health = 100;
        private readonly System.Collections.Generic.List<IObserver> _observers = new System.Collections.Generic.List<IObserver>();

        public int Health
        {
            get => _health;
            set
            {
                _health = value;
                Notify("HealthChanged", _health);
            }
        }

        public void Subscribe(IObserver observer) => _observers.Add(observer);
        public void Unsubscribe(IObserver observer) => _observers.Remove(observer);

        private void Notify(string eventType, object data)
        {
            foreach (var obs in _observers)
            {
                obs.Update(eventType, data);
            }
        }
    }

    public class HealthBarUI : IObserver
    {
        public void Update(string eventType, object data)
        {
            if (eventType == "HealthChanged")
            {
                Console.WriteLine($"[HealthBarUI] redrawing bar at {data} HP");
            }
        }
    }

    public class SoundSystem : IObserver
    {
        public void Update(string eventType, object data)
        {
            if (eventType == "HealthChanged")
            {
                int hp = (int)data;
                if (hp < 30) Console.WriteLine("[SoundSystem] playing LOW HP heartbeat");
            }
        }
    }

    // ============== APPROACH 2: C# event/delegate (idiomatic) ==============

    public class Player
    {
        // A delegate type — "a method that takes an int and returns void"
        public delegate void HealthChangedHandler(int newHealth);

        // The event itself. Other classes can += and -= handlers.
        public event HealthChangedHandler HealthChanged;

        private int _health = 100;
        public int Health
        {
            get => _health;
            set
            {
                _health = value;
                HealthChanged?.Invoke(_health); // null-safe fire
            }
        }
    }

    // A subscriber: just any class with a matching method.
    public class AchievementSystem
    {
        public void OnLowHealth(int hp)
        {
            if (hp < 20) Console.WriteLine($"[Achievement] unlocked: 'Iron Will' (survived at {hp} HP)");
        }
    }

    public class SaveSystem
    {
        public int LastSavedHealth { get; private set; } = 100;
        public void OnHealthChanged(int hp)
        {
            LastSavedHealth = hp;
            Console.WriteLine($"[SaveSystem] autosaved health = {hp}");
        }
    }

    static void DemonstrateManualObserver()
    {
        Console.WriteLine("--- Manual Observer Pattern ---");
        var player = new PlayerHealth();
        var ui = new HealthBarUI();
        var sfx = new SoundSystem();

        player.Subscribe(ui);
        player.Subscribe(sfx);

        player.Health = 80;  // both UI and SFX react
        player.Health = 25;  // UI updates, SFX plays heartbeat

        player.Unsubscribe(sfx);
        Console.WriteLine("(SoundSystem unsubscribed.)");
        player.Health = 10;  // only UI reacts now
    }

    static void DemonstrateEventDelegate()
    {
        Console.WriteLine("\n--- C# event/delegate (idiomatic) ---");
        var player = new Player();
        var achievements = new AchievementSystem();
        var save = new SaveSystem();

        player.HealthChanged += achievements.OnLowHealth;
        player.HealthChanged += save.OnHealthChanged;

        player.Health = 90;
        player.Health = 15; // triggers achievement
        player.Health = 5;

        Console.WriteLine($"Final SaveSystem.LastSavedHealth = {save.LastSavedHealth}");
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateManualObserver();
        DemonstrateEventDelegate();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Add a `QuestTracker` that subscribes to `Player.HealthChanged`. When
 *     health drops below 10, it prints "Quest Updated: Survive to 50 HP."
 *
 *  2. Add a `LevelSystem` to Player with a `LevelUp` event. When fired,
 *     a `ParticleSystem` plays fireworks and a `Camera` shakes briefly.
 *
 *  3. CHALLENGE: Why is `event` better than a plain `delegate` field for
 *     exposing the subscription point to outside code? (Hint: try making
 *     it a public delegate (not event) and assigning null to it from
 *     outside — does that compile?)
 *
 *  4. CHALLENGE: Implement a "dead observer" guard. If an observer throws
 *     an exception during Update, the loop crashes for everyone. Add a
 *     try/catch around each subscriber call. Why is this important in
 *     games where one bug should not crash the whole UI?
 *
 *  5. C#-SPECIFIC: Use the modern `Action<int>` delegate instead of
 *     declaring a custom `HealthChangedHandler`. Rewrite Approach 2
 *     using `public event Action<int> HealthChanged;` and notice how
 *     much shorter it is.
 *
 *  6. C#-SPECIFIC: C# 9 added `delegate*` (function pointers). Look at
 *     the .NET documentation. When would you use them in a game engine
 *     where Observer is hot-path code?
 * ============================================================================
 */
