/*
 * TOPIC: Binary search and variants
 * Analogy: Looking up a word in a dictionary by halving range each step.
 * Link: Requires sorted arrays (from sorting lessons).
 */
public class BinarySearchDemo {
    static int binarySearch(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == target) return m;
            if (a[m] < target) l = m + 1; else r = m - 1;
        }
        return -1;
    }

    static int lowerBound(int[] a, int target) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] < target) l = m + 1; else r = m;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9}; // Sorted array is mandatory for correctness.
        int idx = binarySearch(a, 7); // Repeatedly halves search space to find target fast.
        System.out.println("Beginner index of 7: " + idx); // Show found index or -1 when missing.

        int[] b = {1, 2, 2, 2, 4, 5};
        System.out.println("Intermediate lowerBound(2): " + lowerBound(b, 2));

        int pos = lowerBound(b, 3);
        System.out.println("Pro insertion position for 3: " + pos);
    }
}

/*
 * Pitfalls: using on unsorted data, overflow in midpoint (use l + (r-l)/2), wrong loop condition for bounds variants.
 * Practice: first/last occurrence, search in rotated array, peak element.
 */

