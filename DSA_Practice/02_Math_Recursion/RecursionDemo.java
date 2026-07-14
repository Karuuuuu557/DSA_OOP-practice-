/*
 * TOPIC: Recursion
 * Analogy: Recursion is like opening nested boxes; each box contains a smaller box,
 * and you stop when you reach the smallest box (base case).
 * Link: This builds on loops and arrays from 01_Basics by solving repeated work with self-calls.
 */
public class RecursionDemo {
    static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    static int fibonacciMemo(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n];
        memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
        return memo[n];
    }

    static long fastPower(long base, int exp) {
        if (exp == 0) return 1L;
        long half = fastPower(base, exp / 2);
        long sq = half * half;
        return (exp % 2 == 0) ? sq : sq * base;
    }

    public static void main(String[] args) {
        int n = 5; // We choose 5 so you can manually verify 5! = 120.
        int answer = factorial(n); // Call the recursive function; each call handles one smaller n.
        System.out.println("Beginner factorial: " + answer); // Print result to connect recursion to visible output.

        int target = 10;
        int[] memo = new int[target + 1];
        for (int i = 0; i < memo.length; i++) memo[i] = -1;
        System.out.println("Intermediate fibonacci(10): " + fibonacciMemo(target, memo));

        System.out.println("Pro fastPower(3, 13): " + fastPower(3, 13));
    }
}

/*
 * Common pitfalls:
 * 1) Missing base case -> infinite recursion / StackOverflowError.
 * 2) Doing heavy repeated work (like plain Fibonacci) -> exponential time.
 * 3) Not trusting call stack order -> debug by printing n on entry/exit.
 *
 * Practice:
 * Easy: recursive sum of 1..n.
 * Medium: recursive reverse of a string.
 * Hard: solve Tower of Hanoi and print all moves.
 */
