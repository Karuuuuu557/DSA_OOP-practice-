/*
 * ============================================================================
 *  PATTERN: SINGLETON — One Instance, Global Access Point
 * ============================================================================
 *
 *  WHAT IS IT?
 *  -----------
 *  The Singleton pattern ensures a class has EXACTLY ONE instance, and
 *  provides a global access point to that instance.
 *
 *  WHEN TO USE IT (AND WHEN NOT TO)
 *  --------------------------------
 *  Good fits in games:
 *   - GameManager / GameState (one running game session)
 *   - AudioManager (one mixer)
 *   - SaveSystem (one entry point)
 *   - ResourceManager (one cache)
 *  Bad fits:
 *   - Anything you might reasonably want multiple copies of
 *   - Anything that should be replaceable for testing (use DI instead)
 *
 *  C# vs JAVA — KEY DIFFERENCE
 *  ---------------------------
 *  C# has a built-in `static` keyword for class-level members, but it
 *  does NOT have a "singleton by language feature." You implement the
 *  pattern manually. The standard recipe is:
 *    1. private constructor (so nobody can `new` it from outside)
 *    2. private static instance field
 *    3. public static property/method to access the instance
 *
 *  THREAD SAFETY
 *  -------------
 *  In multi-threaded code, two threads could call GetInstance() at the
 *  same moment and create two instances. The simplest fix is the
 *  `lock` block shown in this file.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. A simple Singleton (single-threaded)
 *  2. A thread-safe Singleton (with `lock`)
 *  3. Demonstrating that two "instances" are actually the same object
 *  4. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;

public class SingletonPatternDemo
{
    // ---- A thread-safe Singleton: GameManager ----
    public class GameManager
    {
        private static GameManager _instance;
        private static readonly object _lock = new object();

        // State shared across the entire game session.
        public string CurrentLevel { get; private set; } = "Menu";
        public int Score { get; private set; } = 0;
        public bool IsPaused { get; private set; } = false;

        // 1) Private constructor — no one can `new GameManager()` from outside.
        private GameManager()
        {
            Console.WriteLine("[GameManager] created (this should print ONLY ONCE).");
        }

        // 2) Public global access point with double-checked locking.
        public static GameManager Instance
        {
            get
            {
                if (_instance == null)            // first check (no lock)
                {
                    lock (_lock)
                    {
                        if (_instance == null)    // second check (with lock)
                        {
                            _instance = new GameManager();
                        }
                    }
                }
                return _instance;
            }
        }

        public void LoadLevel(string name)
        {
            CurrentLevel = name;
            Console.WriteLine($"[GameManager] Loaded level: {name}");
        }

        public void AddScore(int points)
        {
            Score += points;
            Console.WriteLine($"[GameManager] Score: {Score}");
        }

        public void TogglePause()
        {
            IsPaused = !IsPaused;
            Console.WriteLine($"[GameManager] Paused: {IsPaused}");
        }
    }

    static void DemonstrateSingleInstance()
    {
        Console.WriteLine("--- Singleton: Only One Instance ---");

        // Grab the instance twice. Compare them.
        GameManager gm1 = GameManager.Instance;
        gm1.LoadLevel("Forest");

        GameManager gm2 = GameManager.Instance; // should be the SAME object
        gm2.AddScore(100);

        Console.WriteLine($"gm1 == gm2 ? {ReferenceEquals(gm1, gm2)}");
        Console.WriteLine($"gm1.CurrentLevel = {gm1.CurrentLevel}");
        Console.WriteLine($"gm2.Score        = {gm2.Score}");
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateSingleInstance();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Create a `AudioManager` Singleton with `PlaySound(string name)` and
 *     `MasterVolume { get; set; }`. Add a private constructor.
 *
 *  2. Create a `ResourceCache` Singleton with `T Get<T>(string key) where
 *     T : new()` and a private `Dictionary<string, object>` that lazily
 *     creates and caches resources.
 *
 *  3. CHALLENGE: Without the lock, run `GameManager.Instance` from two
 *     threads simultaneously. Can you ever see "created" printed twice?
 *     Why is the lock needed?
 *
 *  4. CHALLENGE: Make the Singleton implement `IDisposable` so the game
 *     can clean up its state between runs (e.g. resetting to Menu). Why
 *     would you want to do this?
 *
 *  5. C#-SPECIFIC: Look at how Unity (a popular game engine) handles
 *     "MonoBehaviour singletons". Why are they slightly different from a
 *     pure C# singleton? (Hint: the GameObject lifecycle.)
 *
 *  6. CRITICAL THINKING: When is a Singleton the WRONG choice? List
 *     three scenarios. (Hint: testing, multiple game modes, networked
 *     multiplayer.)
 * ============================================================================
 */
