import java.util.ArrayDeque;
import java.util.Deque;

/*
 * TOPIC: Deque (double-ended queue)
 * Analogy: A train where passengers can enter/exit from both front and back.
 * Link: Generalizes stack and queue.
 */
public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>(); // Deque supports both ends efficiently.
        dq.addFirst(2); // Add to front when you need LIFO-like control.
        dq.addLast(3); // Add to back when you need FIFO-like flow.
        dq.addFirst(1); // Front now has highest priority in this example.
        System.out.println("Beginner front pop: " + dq.removeFirst()); // Remove from front explicitly.

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Deque<Integer> idx = new ArrayDeque<>();
        System.out.print("Intermediate window max: ");
        for (int i = 0; i < arr.length; i++) {
            while (!idx.isEmpty() && idx.peekFirst() <= i - k) idx.removeFirst();
            while (!idx.isEmpty() && arr[idx.peekLast()] <= arr[i]) idx.removeLast();
            idx.addLast(i);
            if (i >= k - 1) System.out.print(arr[idx.peekFirst()] + " ");
        }
        System.out.println();

        Deque<Character> chars = new ArrayDeque<>();
        String s = "racecar";
        for (char c : s.toCharArray()) chars.addLast(c);
        boolean pal = true;
        while (chars.size() > 1) {
            if (!chars.removeFirst().equals(chars.removeLast())) { pal = false; break; }
        }
        System.out.println("Pro palindrome via deque: " + pal);
    }
}

/*
 * Pitfalls: using null elements (ArrayDeque forbids), wrong end operations, not removing expired indices in window problems.
 * Practice: implement browser history, max in each window, shortest subarray with constraints.
 */
