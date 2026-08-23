/*
 * TOPIC: Strategy pattern
 * Analogy: Choosing travel mode (car, train, bike) depending on situation.
 */
public class StrategyPatternDemo {
    interface SortStrategy { void sort(int[] arr); }
    static class BubbleStrategy implements SortStrategy {
        @Override public void sort(int[] arr) {
            for (int p = 0; p < arr.length - 1; p++)
                for (int i = 0; i < arr.length - 1 - p; i++)
                    if (arr[i] > arr[i + 1]) { int t = arr[i]; arr[i] = arr[i + 1]; arr[i + 1] = t; }
        }
    }
    static class BuiltInStrategy implements SortStrategy {
        @Override public void sort(int[] arr) { java.util.Arrays.sort(arr); }
    }
    static class SortContext {
        private SortStrategy strategy;
        SortContext(SortStrategy strategy) { this.strategy = strategy; }
        void setStrategy(SortStrategy strategy) { this.strategy = strategy; }
        void execute(int[] arr) { strategy.sort(arr); }
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 2};
        SortContext ctx = new SortContext(new BubbleStrategy()); // Inject algorithm as interchangeable behavior.
        ctx.execute(a); // Run chosen strategy without changing context class.
        System.out.println("Beginner sorted first: " + java.util.Arrays.toString(a)); // Output confirms behavior.

        int[] b = {5, 4, 6, 1};
        ctx.setStrategy(new BuiltInStrategy());
        ctx.execute(b);
        System.out.println("Intermediate sorted second: " + java.util.Arrays.toString(b));

        System.out.println("Pro: strategy removes large if-else blocks and supports open extension.");
    }
}

/*
 * Pitfalls: too many tiny strategy classes without need, state leakage between strategies, forgetting defaults.
 * Practice: payment methods, compression algorithms, route planning strategies.
 */

