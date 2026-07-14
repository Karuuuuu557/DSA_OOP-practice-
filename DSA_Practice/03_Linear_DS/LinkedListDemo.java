/*
 * TOPIC: Singly Linked List
 * Analogy: A treasure hunt where each clue tells you where the next clue is.
 * Link: Unlike arrays, nodes are not contiguous in memory.
 */
public class LinkedListDemo {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    static Node insertFront(Node head, int x) {
        Node n = new Node(x);
        n.next = head;
        return n;
    }

    static Node deleteFirstMatch(Node head, int target) {
        if (head == null) return null;
        if (head.val == target) return head.next;
        Node cur = head;
        while (cur.next != null && cur.next.val != target) cur = cur.next;
        if (cur.next != null) cur.next = cur.next.next;
        return head;
    }

    static void print(Node head) {
        for (Node c = head; c != null; c = c.next) System.out.print(c.val + (c.next != null ? " -> " : "\n"));
    }

    public static void main(String[] args) {
        Node head = null; // Empty list start, so insertion builds list step by step.
        head = insertFront(head, 30); // Insert at front: O(1), no shifting needed.
        head = insertFront(head, 20); // New head points to old head, preserving list.
        head = insertFront(head, 10); // Final list becomes 10 -> 20 -> 30.
        print(head); // Print traversal to verify node links.

        head = deleteFirstMatch(head, 20);
        print(head);

        head = deleteFirstMatch(head, 99);
        print(head);
    }
}

/*
 * Pitfalls:
 * 1) Losing head reference while inserting/deleting.
 * 2) NullPointerException from cur.next without null checks.
 * 3) Forgetting edge case when deleting first node.
 *
 * Practice: reverse list, detect cycle (Floyd), merge two sorted lists.
 */

