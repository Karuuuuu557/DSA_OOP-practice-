/*
 * TOPIC: Prime checking, GCD, LCM
 * Analogy: GCD is the largest tile size that can perfectly tile two floors.
 * Link: Uses loops/conditionals from 01_Basics.
 */
public class MathPrimeGCD {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int d = 2; d * d <= n; d++) if (n % d == 0) return false;
        return true;
    }

    static int gcdEuclid(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return Math.abs(a);
    }

    static int lcm(int a, int b) {
        return Math.abs(a / gcdEuclid(a, b) * b);
    }

    public static void main(String[] args) {
        int num = 29; // Candidate number we want to test.
        boolean prime = isPrime(num); // Check divisibility up to sqrt(num) for efficiency.
        System.out.println("Beginner isPrime(29): " + prime); // Print true/false so behavior is clear.

        int a = 48, b = 18;
        System.out.println("Intermediate gcd(48,18): " + gcdEuclid(a, b));

        System.out.println("Pro lcm(48,18): " + lcm(a, b));
    }
}

/*
 * Common pitfalls:
 * 1) Checking prime divisors up to n (too slow for big n).
 * 2) Forgetting absolute values for gcd/lcm with negatives.
 * 3) lcm overflow if multiplying before dividing.
 *
 * Practice:
 * Easy: count primes from 1..N.
 * Medium: print all divisors of N in sorted order.
 * Hard: compute gcd of an entire array.
 */
