import java.util.PriorityQueue;

/*
 * TOPIC: Heap and PriorityQueue
 * Analogy: Hospital triage line where highest priority is served first.
 * Link: Uses complete-tree idea with efficient top access.
 */
public class HeapPriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min-heap gives smallest element first.
        minHeap.offer(5); // Insert value while preserving heap property.
        minHeap.offer(1); // Heap reorders internally so peek stays minimum.
        minHeap.offer(3); // Insertion is O(log n), not full sort.
        System.out.println("Beginner min peek: " + minHeap.peek()); // Read top without removing.

        int[] stream = {7, 2, 9, 4, 1};
        PriorityQueue<Integer> top3 = new PriorityQueue<>();
        for (int x : stream) {
            top3.offer(x);
            if (top3.size() > 3) top3.poll();
        }
        System.out.println("Intermediate 3rd largest: " + top3.peek());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int x : stream) maxHeap.offer(x);
        System.out.println("Pro max order: " + maxHeap.poll() + " " + maxHeap.poll() + " " + maxHeap.poll());
    }
}

/*
 * Pitfalls: assuming full sort order inside heap, wrong comparator sign, forgetting size control for top-k.
 * Practice: kth smallest matrix, merge k sorted lists, task scheduler.
 */
