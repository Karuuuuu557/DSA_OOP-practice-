import java.util.Arrays;

/*
 * TOPIC: Two pointers
 * Analogy: Two people walking from opposite ends to meet in the middle.
 * Link: Strongly tied to sorted arrays from sorting lessons.
 */
public class TwoPointersDemo {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 6}; // Sorted input is required for this two-sum variant.
        int target = 7; // We seek two numbers whose sum equals target.
        int l = 0, r = a.length - 1; // Left pointer starts low, right pointer starts high.
        while (l < r) { // Move pointers until they cross; crossing means no valid pair.
            int sum = a[l] + a[r]; // Compute current pair sum for decision making.
            if (sum == target) { System.out.println("Beginner pair: " + a[l] + ", " + a[r]); break; } // Found exact answer.
            if (sum < target) l++; else r--; // Increase sum by moving left rightward, or decrease by moving right leftward.
        }

        String s = "A man, a plan, a canal: Panama";
        int i = 0, j = s.length() - 1;
        boolean pal = true;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) { pal = false; break; }
            i++; j--;
        }
        System.out.println("Intermediate valid palindrome: " + pal);

        int[] nums = {3, 2, 2, 3, 4, 3};
        int val = 3, write = 0;
        for (int read = 0; read < nums.length; read++) if (nums[read] != val) nums[write++] = nums[read];
        System.out.println("Pro remove-element length: " + write + ", array prefix: " + Arrays.toString(Arrays.copyOf(nums, write)));
    }
}

/*
 * Pitfalls: using on unsorted data, not proving pointer movement correctness, off-by-one when loop ends.
 * Practice: container with most water, remove duplicates sorted array, 3-sum.
 */

