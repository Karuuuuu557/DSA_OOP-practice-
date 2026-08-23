/*
 * ============================================================================
 *  TOPIC: COMPILE-TIME POLYMORPHISM — Method Overloading (C# edition)
 * ============================================================================
 *
 *  WHAT IS COMPILE-TIME POLYMORPHISM (METHOD OVERLOADING)?
 *  -------------------------------------------------------
 *  Multiple methods in the SAME class with the SAME name but DIFFERENT
 *  parameter lists (different number or type of arguments). The compiler
 *  decides which version to call based on the arguments you pass at the
 *  call site — hence "compile-time".
 *
 *  C# vs JAVA — MOSTLY THE SAME
 *  ----------------------------
 *  1. Overloading rules are nearly identical: same name, different
 *     parameter list. Return type alone is NOT enough to overload.
 *  2. C# has OPTIONAL PARAMETERS (with default values) and `params`
 *     arrays — these can SIMULATE overloading in some cases, but they are
 *     different features. We cover classic overloading here.
 *  3. C# also supports `params int[] numbers` to take variable arguments.
 *
 *  IN THIS FILE:
 *  -------------
 *  1. Overloading by parameter count
 *  2. Overloading by parameter type
 *  3. Overloading by parameter order
 *  4. Constructor overloading (preview, see ConstructorsDemo.cs for depth)
 *  5. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

using System;

public class CompileTimePolymorphismDemo
{
    // ---- Class with overloaded methods: a tiny combat calculator ----
    public class DamageCalculator
    {
        // 1) Different parameter count
        public int Calculate(int baseDamage)
        {
            return baseDamage;
        }

        public int Calculate(int baseDamage, int bonusDamage)
        {
            return baseDamage + bonusDamage;
        }

        public int Calculate(int baseDamage, int bonusDamage, int critMultiplier)
        {
            return (baseDamage + bonusDamage) * critMultiplier;
        }

        // 2) Different parameter TYPE
        public double Calculate(double baseDamage, double armor)
        {
            // armor reduces damage by a flat amount
            double result = baseDamage - armor;
            return result < 0 ? 0 : result;
        }

        // 3) Different parameter ORDER (string first vs int first)
        public string Describe(int damage, string element)
        {
            return $"{damage} {element} damage";
        }

        public string Describe(string element, int damage)
        {
            return $"{element} hit dealing {damage} damage";
        }

        // 4) Using params to accept VARIABLE number of arguments
        public int Sum(params int[] numbers)
        {
            int total = 0;
            foreach (int n in numbers) total += n;
            return total;
        }
    }

    static void DemonstrateOverloadingByCount()
    {
        Console.WriteLine("--- Overloading by Parameter Count ---");
        DamageCalculator calc = new DamageCalculator();
        Console.WriteLine($"calc.Calculate(10)           = {calc.Calculate(10)}");
        Console.WriteLine($"calc.Calculate(10, 5)        = {calc.Calculate(10, 5)}");
        Console.WriteLine($"calc.Calculate(10, 5, 3)     = {calc.Calculate(10, 5, 3)}");
    }

    static void DemonstrateOverloadingByType()
    {
        Console.WriteLine("\n--- Overloading by Parameter Type ---");
        DamageCalculator calc = new DamageCalculator();
        Console.WriteLine($"calc.Calculate(50, 20)  (int)   = {calc.Calculate(50, 20)}");
        Console.WriteLine($"calc.Calculate(50.5, 20.3) (double) = {calc.Calculate(50.5, 20.3):F1}");
    }

    static void DemonstrateOverloadingByOrder()
    {
        Console.WriteLine("\n--- Overloading by Parameter Order ---");
        DamageCalculator calc = new DamageCalculator();
        Console.WriteLine($"calc.Describe(20, \"Fire\")  = {calc.Describe(20, "Fire")}");
        Console.WriteLine($"calc.Describe(\"Fire\", 20) = {calc.Describe("Fire", 20)}");
    }

    static void DemonstrateParams()
    {
        Console.WriteLine("\n--- `params` Keyword (variable arguments) ---");
        DamageCalculator calc = new DamageCalculator();
        Console.WriteLine($"calc.Sum()                = {calc.Sum()}");
        Console.WriteLine($"calc.Sum(5)               = {calc.Sum(5)}");
        Console.WriteLine($"calc.Sum(1, 2, 3, 4, 5)   = {calc.Sum(1, 2, 3, 4, 5)}");
    }

    // ================= MAIN METHOD =================
    public static void Main(string[] args)
    {
        DemonstrateOverloadingByCount();
        DemonstrateOverloadingByType();
        DemonstrateOverloadingByOrder();
        DemonstrateParams();
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Solve these yourself below or in a new file.
 * ============================================================================
 *
 *  1. Create a `MathHelper` class with overloaded `Multiply`:
 *       Multiply(int a, int b)
 *       Multiply(double a, double b)
 *       Multiply(int a, int b, int c)
 *       Multiply(params int[] numbers)   // returns the product of all
 *
 *  2. Create a `Logger` class with overloaded `Log`:
 *       Log(string message)
 *       Log(string tag, string message)
 *       Log(int level, string message)
 *
 *  3. CHALLENGE: Try writing TWO methods that differ ONLY in return type:
 *       public int DoStuff() { ... }
 *       public string DoStuff() { ... }
 *     What error does the C# compiler give? Why?
 *
 *  4. Explain in your own words (as a comment): why does the compiler
 *     complain when you write:
 *       public void DoIt(int a, string b) { }
 *       public void DoIt(string b, int a) { }
 *     ...but it accepts the same pair if the parameter NAMES match? (Hint:
 *     parameter names are not part of the signature — only TYPES are.)
 *
 *  5. C#-SPECIFIC: Replace the 3-arg `Calculate(int, int, int)` overload
 *     with an OPTIONAL PARAMETER version like:
 *       public int Calculate(int baseDamage, int bonusDamage = 0,
 *                            int critMultiplier = 1)
 *     Try calling it with 1, 2, and 3 arguments. Same result, different
 *     mechanism. When would you pick one over the other?
 *
 *  6. C#-SPECIFIC: Try calling `calc.Calculate(10, 5.5)` and see which
 *     overload gets picked. Why? (Hint: implicit numeric conversions.)
 * ============================================================================
 */
