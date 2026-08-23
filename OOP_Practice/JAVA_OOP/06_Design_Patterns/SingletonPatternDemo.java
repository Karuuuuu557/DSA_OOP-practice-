/*
 * TOPIC: Singleton pattern
 * Analogy: One control tower coordinates all flights in one airport.
 */
public class SingletonPatternDemo {
    static class AppConfig {
        private static final AppConfig INSTANCE = new AppConfig();
        private AppConfig() {}
        static AppConfig getInstance() { return INSTANCE; }
        String appName() { return "DSA_OOP-practice"; }
    }

    public static void main(String[] args) {
        AppConfig a = AppConfig.getInstance(); // Access single shared instance through static accessor.
        AppConfig b = AppConfig.getInstance(); // Second call returns same object reference.
        System.out.println("Beginner same instance: " + (a == b)); // True confirms singleton behavior.

        System.out.println("Intermediate config value: " + a.appName());
        System.out.println("Pro caution: singletons can hide global state and make tests harder.");
    }
}

/*
 * Pitfalls: non-thread-safe lazy singleton, overusing singleton for unrelated state, hard-to-mock globals.
 * Practice: lazy singleton with holder class, thread-safe logger singleton.
 */

