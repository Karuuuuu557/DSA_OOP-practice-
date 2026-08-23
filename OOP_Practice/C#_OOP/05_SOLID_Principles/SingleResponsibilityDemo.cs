/*
 * ============================================================================
 *  SOLID #1: SINGLE RESPONSIBILITY PRINCIPLE (SRP)
 * ============================================================================
 *
 *  THE RULE
 *  --------
 *  A class should have ONE reason to change — meaning it should have
 *  one clearly defined responsibility. If a class is doing multiple
 *  unrelated jobs (saving to file AND rendering AND calculating damage),
 *  it has multiple reasons to change, and SRP is violated.
 *
 *  WHY IT MATTERS
 *  --------------
 *  - When requirements change, you change ONLY the class responsible for
 *    that requirement. Other code is untouched.
 *  - Classes become smaller, easier to test, easier to reuse.
 *
 *  REAL GAME EXAMPLE
 *  -----------------
 *  An Enemy should NOT also know how to save itself to disk or render
 *  itself to the screen. Those are separate responsibilities. Splitting
 *  them lets the Enemy class focus on combat logic while other classes
 *  focus on persistence or rendering.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. A BAD class that violates SRP (Enemy doing too much)
 *  2. The GOOD refactor: split into Enemy, EnemyRenderer, EnemySaver
 *  3. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;
using System.IO;

public class SingleResponsibilityDemo
{
    // ============== BAD: One class doing everything ==============
    public class BadEnemy
    {
        public string Name;
        public int Health;

        public int CalculateDamage()
        {
            return 10; // some combat logic
        }

        // WRONG: persistence is NOT the Enemy's job.
        public void SaveToFile(string path)
        {
            File.WriteAllText(path, $"{Name},{Health}");
        }

        // WRONG: rendering is NOT the Enemy's job.
        public string Render()
        {
            return $"[{Name} HP:{Health}]";
        }
    }

    // ============== GOOD: Each class has ONE job ==============

    // Responsibility 1: game data + behavior only.
    public class Enemy
    {
        public string Name;
        public int Health;

        public Enemy(string name, int health)
        {
            Name = name;
            Health = health;
        }

        public int CalculateDamage() => 10;

        public bool IsAlive => Health > 0;
    }

    // Responsibility 2: rendering (presentation concern).
    public class EnemyRenderer
    {
        public string Render(Enemy enemy)
        {
            return $"[{enemy.Name} HP:{enemy.Health}]";
        }
    }

    // Responsibility 3: persistence (storage concern).
    public class EnemySaver
    {
        public void SaveToFile(Enemy enemy, string path)
        {
            File.WriteAllText(path, $"{enemy.Name},{enemy.Health}");
        }

        public Enemy LoadFromFile(string path)
        {
            var parts = File.ReadAllText(path).Split(',');
            return new Enemy(parts[0], int.Parse(parts[1]));
        }
    }

    static void DemonstrateBad()
    {
        Console.WriteLine("--- BAD: Enemy doing everything ---");
        BadEnemy goblin = new BadEnemy { Name = "Goblin", Health = 30 };
        Console.WriteLine($"Render:  {goblin.Render()}");
        goblin.SaveToFile("goblin.txt");
        Console.WriteLine("(Goblin can also save itself — too many jobs!)\n");
    }

    static void DemonstrateGood()
    {
        Console.WriteLine("--- GOOD: Each class has one responsibility ---");
        Enemy goblin = new Enemy("Goblin", 30);

        EnemyRenderer renderer = new EnemyRenderer();
        EnemySaver saver = new EnemySaver();

        Console.WriteLine($"Render:  {renderer.Render(goblin)}");
        saver.SaveToFile(goblin, "goblin.txt");
        Console.WriteLine("Saved to file via EnemySaver.\n");

        Enemy loaded = saver.LoadFromFile("goblin.txt");
        Console.WriteLine($"Loaded:  {renderer.Render(loaded)}");
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
 *  1. A `Player` class currently has `LevelUp()`, `SaveToDatabase()`, and
 *     `RenderHUD()`. Refactor into `Player`, `PlayerRepository`, and
 *     `HUD`.
 *
 *  2. Take the BAD `BadEnemy` above and identify AT LEAST three reasons
 *     it might have to change (e.g. "if damage formula changes", "if we
 *     switch from CSV to JSON storage", "if we add a sprite").
 *
 *  3. CHALLENGE: Write a class that violates SRP on purpose (e.g.
 *     `GameManager` that loads levels, plays sounds, AND saves scores).
 *     Then refactor it into three classes. Notice how the refactored
 *     version is easier to test in isolation.
 *
 *  4. Explain in your own words (as a comment): how does SRP relate to
 *     the concept of "high cohesion"? (Hint: a class whose methods all
 *     relate to one job is highly cohesive — the opposite of doing
 *     unrelated things.)
 *
 *  5. C#-SPECIFIC: Look at how `System.IO.File.WriteAllText` is in
 *     `System.IO` and `Console.WriteLine` is in `System`. These are
 *     SINGLE classes in single namespaces — Microsoft applies SRP all
 *     over the .NET standard library. Spot another example.
 * ============================================================================
 */
