import java.util.HashMap;
import java.util.Map;

/*
 * TOPIC: Hash tables (HashMap)
 * Analogy: A locker system where key hash picks a locker fast.
 * Link: Uses arrays concept internally but gives key-based lookup.
 */
public class HashTableDemo {
    public static void main(String[] args) {
        Map<String, Integer> freq = new HashMap<>(); // Create map to store key->count pairs for quick updates.
        String[] words = {"java", "dsa", "java"};
        for (String w : words) freq.put(w, freq.getOrDefault(w, 0) + 1); // Increment count; default 0 avoids null checks.
        System.out.println("Beginner frequency map: " + freq); // Print map so key-value structure is visible.

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (seen.containsKey(need)) {
                System.out.println("Intermediate two-sum indices: " + seen.get(need) + ", " + i);
                break;
            }
            seen.put(nums[i], i);
        }

        String text = "abracadabra";
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : text.toCharArray()) charFreq.merge(c, 1, Integer::sum);
        System.out.println("Pro character frequency: " + charFreq);
    }
}

/*
 * Pitfalls: relying on map order, forgetting null checks with get(), poor key choice.
 * Practice: first non-repeating char, group anagrams, longest consecutive sequence.
 */

