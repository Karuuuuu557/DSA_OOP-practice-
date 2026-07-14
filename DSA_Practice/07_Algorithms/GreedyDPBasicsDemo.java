import java.util.Arrays;

/*
 * TOPIC: Greedy vs Dynamic Programming basics
 * Analogy: Greedy picks best immediate snack; DP plans meals for the whole week.
 * Link: Builds on recursion + arrays.
 */
public class GreedyDPBasicsDemo {
    static int coinGreedy(int amount, int[] coins) {
        int used = 0;
        for (int c : coins) { used += amount / c; amount %= c; }
        return amount == 0 ? used : -1;
    }

    static int fibDP(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    static int minCoinsDP(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int x = 1; x <= amount; x++) {
            for (int c : coins) if (c <= x) dp[x] = Math.min(dp[x], 1 + dp[x - c]);
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] canonical = {25, 10, 5, 1}; // US-like coin system where greedy usually works.
        System.out.println("Beginner greedy coins for 41: " + coinGreedy(41, canonical)); // Quick local-choice strategy.

        System.out.println("Intermediate DP fibonacci(10): " + fibDP(10));

        int[] tricky = {1, 3, 4};
        System.out.println("Pro min coins DP for 6: " + minCoinsDP(6, tricky) + " (greedy would wrongly pick 4+1+1)");
    }
}

/*
 * Pitfalls: assuming greedy is always optimal, wrong DP state definition, forgetting base dp[0].
 * Practice: activity selection (greedy), 0/1 knapsack (DP), longest increasing subsequence.
 */
