/*
 * TOPIC: Builder pattern
 * Analogy: Ordering a custom burger step-by-step.
 */
public class BuilderPatternDemo {
    static class UserProfile {
        final String name;
        final int age;
        final String city;
        private UserProfile(Builder b) { this.name = b.name; this.age = b.age; this.city = b.city; }
        static class Builder {
            String name;
            int age;
            String city = "Unknown";
            Builder name(String name) { this.name = name; return this; }
            Builder age(int age) { this.age = age; return this; }
            Builder city(String city) { this.city = city; return this; }
            UserProfile build() { return new UserProfile(this); }
        }
    }

    public static void main(String[] args) {
        UserProfile p = new UserProfile.Builder().name("Kai").age(21).build(); // Build object incrementally for readability.
        System.out.println("Beginner profile: " + p.name + ", " + p.age + ", " + p.city); // Default city applied if omitted.

        UserProfile p2 = new UserProfile.Builder().name("Mira").age(22).city("Manila").build();
        System.out.println("Intermediate profile: " + p2.name + ", " + p2.city);

        System.out.println("Pro: builder avoids telescoping constructors and supports immutable objects.");
    }
}

/*
 * Pitfalls: builder without validation, mutable built object leaks, too much ceremony for tiny objects.
 * Practice: HTTP request builder, query builder, immutable configuration builder.
 */

