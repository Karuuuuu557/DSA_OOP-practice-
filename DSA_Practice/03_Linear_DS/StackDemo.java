import java.util.ArrayDeque;
import java.util.Deque;

/*
 * TOPIC: Stack (LIFO)
 * Analogy: Stack of plates; last plate placed is first removed.
 * Link: Uses arrays/linked-list ideas for push/pop.
 */
public class StackDemo {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>(); // Use Deque as stack because java.util.Stack is legacy.
        stack.push(10); // Push item onto top because most recent work should be undone first.
        stack.push(20); // Another push puts 20 above 10.
        stack.push(30); // Top is now 30, so pop will return 30 first.
        System.out.println("Beginner pop: " + stack.pop()); // Remove and return top element (LIFO behavior).

        String expr = "(()())";
        int bal = 0;
        for (char ch : expr.toCharArray()) {
            if (ch == '(') bal++;
            else bal--;
            if (bal < 0) break;
        }
        System.out.println("Intermediate balanced: " + (bal == 0));

        int[] arr = {2, 1, 2, 4, 3};
        int[] nge = new int[arr.length];
        Deque<Integer> idxStack = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!idxStack.isEmpty() && arr[idxStack.peek()] <= arr[i]) idxStack.pop();
            nge[i] = idxStack.isEmpty() ? -1 : arr[idxStack.peek()];
            idxStack.push(i);
        }
        System.out.print("Pro next greater: ");
        for (int x : nge) System.out.print(x + " ");
        System.out.println();
    }
}

/*
 * Pitfalls: popping empty stack, using Stack class blindly, forgetting monotonic stack direction.
 * Practice: min-stack, postfix evaluation, stock span.
 */

