/*
 * ============================================================================
 *  SOLID #5: DEPENDENCY INVERSION PRINCIPLE (DIP)
 * ============================================================================
 *
 *  THE RULE
 *  --------
 *  High-level modules should NOT depend on low-level modules. Both
 *  should depend on ABSTRACTIONS (interfaces or abstract classes).
 *
 *  Abstractions should NOT depend on details. Details should depend on
 *  abstractions.
 *
 *  WHY IT MATTERS
 *  --------------
 *  - High-level policy (e.g. "save the game") stays separate from
 *    low-level mechanism (e.g. "write to disk", "write to cloud").
 *  - You can swap the mechanism without touching the policy.
 *
 *  REAL GAME EXAMPLE
 *  -----------------
 *  A `GameSaver` should depend on an `IDataStore` interface, NOT on a
 *  concrete `FileDataStore` class. That way, in tests you can swap in a
 *  `FakeMemoryDataStore`, and in production you can swap in a
 *  `CloudDataStore` — both without changing `GameSaver`.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. BAD: High-level class directly using a low-level concrete class
 *  2. GOOD: Both depend on an interface
 *  3. Swapping implementations at runtime (e.g. fake for testing)
 *  4. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;
using System.Collections.Generic;

public class DependencyInversionDemo
{
    // ============== LOW-LEVEL detail ==============
    public class FileDataStore
    {
        private Dictionary<string, string> _data = new Dictionary<string, string>();
        public void Save(string key, string value) => _data[key] = value;
        public string Load(string key) => _data.TryGetValue(key, out var v) ? v : null;
    }

    // ============== BAD: high-level directly depends on concrete ==============
    public class BadGameSaver
    {
        // HIGH-LEVEL policy knows about LOW-LEVEL mechanism. DIP violation.
        private FileDataStore _store = new FileDataStore();

        public void SaveProgress(PlayerProgress progress)
        {
            _store.Save("player", $"{progress.Name},{progress.Level}");
        }

        public PlayerProgress LoadProgress()
        {
            var data = _store.Load("player").Split(',');
            return new PlayerProgress { Name = data[0], Level = int.Parse(data[1]) };
        }
    }

    // ============== GOOD: define an abstraction ==============
    public interface IDataStore
    {
        void Save(string key, string value);
        string Load(string key);
    }

    // Low-level detail that DEPENDS on the abstraction (it implements it).
    public class MemoryDataStore : IDataStore
    {
        private Dictionary<string, string> _data = new Dictionary<string, string>();
        public void Save(string key, string value) => _data[key] = value;
        public string Load(string key) => _data.TryGetValue(key, out var v) ? v : null;
    }

    public class FakeDataStore : IDataStore
    {
        // Useful for unit tests — no file system, no DB.
        public Dictionary<string, string> Captured = new Dictionary<string, string>();
        public void Save(string key, string value) => Captured[key] = value;
        public string Load(string key) => Captured.TryGetValue(key, out var v) ? v : null;
    }

    public class PlayerProgress
    {
        public string Name;
        public int Level;
    }

    // High-level policy that ALSO depends on the abstraction.
    // It does not know whether the storage is file-based, memory-based, or
    // cloud-based. It just calls Save/Load on an IDataStore.
    public class GameSaver
    {
        private readonly IDataStore _store;

        // Constructor injection — caller decides which IDataStore to use.
        public GameSaver(IDataStore store)
        {
            _store = store;
        }

        public void SaveProgress(PlayerProgress progress)
        {
            _store.Save("player", $"{progress.Name},{progress.Level}");
        }

        public PlayerProgress LoadProgress()
        {
            var data = _store.Load("player").Split(',');
            return new PlayerProgress { Name = data[0], Level = int.Parse(data[1]) };
        }
    }

    static void DemonstrateBad()
    {
        Console.WriteLine("--- BAD: Hard-coded to FileDataStore ---");
        BadGameSaver saver = new BadGameSaver();
        saver.SaveProgress(new PlayerProgress { Name = "Carl", Level = 5 });
        var loaded = saver.LoadProgress();
        Console.WriteLine($"Loaded: {loaded.Name} L{loaded.Level}");
        Console.WriteLine("(Cannot test without touching the file system.)\n");
    }

    static void DemonstrateGoodWithFake()
    {
        Console.WriteLine("--- GOOD: Inject any IDataStore (Fake for tests) ---");
        var fake = new FakeDataStore();
        var saver = new GameSaver(fake);

        saver.SaveProgress(new PlayerProgress { Name = "Carl", Level = 5 });

        Console.WriteLine($"Fake captured: {fake.Captured["player"]}");
        var loaded = saver.LoadProgress();
        Console.WriteLine($"Loaded: {loaded.Name} L{loaded.Level}");
    }

    static void DemonstrateGoodWithMemory()
    {
        Console.WriteLine("\n--- Swap implementation to MemoryDataStore ---");
        var mem = new MemoryDataStore();
        var saver = new GameSaver(mem);
        saver.SaveProgress(new PlayerProgress { Name = "Lyra", Level = 12 });
        Console.WriteLine($"Memory loaded: {saver.LoadProgress().Name}");
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateBad();
        DemonstrateGoodWithFake();
        DemonstrateGoodWithMemory();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Define `ILogger` with `void Log(string message)`. Make
 *     `ConsoleLogger : ILogger` and `FileLogger : ILogger`. Inject into
 *     a `Player` class via constructor. Show that you can swap loggers
 *     without changing Player.
 *
 *  2. Define `IInputSource` with `string ReadCommand()`. Make
 *     `ConsoleInputSource` and `ScriptedInputSource` (returns canned
 *     commands from a list). Inject into a `GameEngine` class.
 *
 *  3. CHALLENGE: Take the BAD `BadGameSaver`. Identify ONE concrete
 *     dependency that makes it hard to test. Then refactor.
 *
 *  4. CHALLENGE: Without DIP, how would you unit-test a class that
 *     directly calls `Console.WriteLine` and `File.WriteAllText`? Why
 *     is DIP the foundation of testable code?
 *
 *  5. Explain in your own words (as a comment): why is DIP often called
 *     "the most important SOLID principle"? (Hint: it makes ALL the
 *     other principles easier to follow.)
 *
 *  6. C#-SPECIFIC: Look at how .NET uses dependency injection in ASP.NET
 *     Core (`services.AddSingleton<I...>()`). How is this a real-world
 *     application of DIP? Why is it especially valuable in web apps?
 * ============================================================================
 */
