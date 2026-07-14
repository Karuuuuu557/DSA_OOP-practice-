import java.util.ArrayDeque;
import java.util.Queue;

/*
 * TOPIC: Binary tree traversals
 * Analogy: A family tree where each person can have left/right child links.
 * Link: BFS uses queue from 03_Linear_DS.
 */
public class BinaryTreeDemo {
    static class Node { int v; Node l, r; Node(int v) { this.v = v; } }

    static void preorder(Node n) { if (n == null) return; System.out.print(n.v + " "); preorder(n.l); preorder(n.r); }
    static void inorder(Node n)  { if (n == null) return; inorder(n.l); System.out.print(n.v + " "); inorder(n.r); }
    static void postorder(Node n){ if (n == null) return; postorder(n.l); postorder(n.r); System.out.print(n.v + " "); }
    static void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.v + " ");
            if (cur.l != null) q.offer(cur.l);
            if (cur.r != null) q.offer(cur.r);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1); // Root is entry node for the whole tree.
        root.l = new Node(2); // Left child models smaller/earlier branch in many tree tasks.
        root.r = new Node(3); // Right child is symmetrical branch.
        root.l.l = new Node(4);
        root.l.r = new Node(5);

        System.out.print("Beginner preorder: "); preorder(root); System.out.println();
        System.out.print("Intermediate inorder: "); inorder(root); System.out.println();
        System.out.print("Postorder: "); postorder(root); System.out.println();
        System.out.print("Pro level-order: "); levelOrder(root); System.out.println();
    }
}

/*
 * Pitfalls: null handling, mixing traversal orders, forgetting recursion base case.
 * Practice: tree height, count leaves, zigzag level order.
 */

