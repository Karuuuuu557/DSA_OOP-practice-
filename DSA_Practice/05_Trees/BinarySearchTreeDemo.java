/*
 * TOPIC: Binary Search Tree
 * Analogy: A dictionary where words are placed left/right by alphabet rule.
 * Link: Builds on binary tree and binary search thinking.
 */
public class BinarySearchTreeDemo {
    static class Node { int v; Node l, r; Node(int v) { this.v = v; } }

    static Node insert(Node n, int x) {
        if (n == null) return new Node(x);
        if (x < n.v) n.l = insert(n.l, x); else if (x > n.v) n.r = insert(n.r, x);
        return n;
    }

    static boolean search(Node n, int x) {
        while (n != null) {
            if (x == n.v) return true;
            n = (x < n.v) ? n.l : n.r;
        }
        return false;
    }

    static Node min(Node n) { while (n.l != null) n = n.l; return n; }
    static Node delete(Node n, int x) {
        if (n == null) return null;
        if (x < n.v) n.l = delete(n.l, x);
        else if (x > n.v) n.r = delete(n.r, x);
        else {
            if (n.l == null) return n.r;
            if (n.r == null) return n.l;
            Node succ = min(n.r);
            n.v = succ.v;
            n.r = delete(n.r, succ.v);
        }
        return n;
    }
    static void inorder(Node n) { if (n == null) return; inorder(n.l); System.out.print(n.v + " "); inorder(n.r); }

    public static void main(String[] args) {
        Node root = null; // Start empty because BST grows with inserts.
        int[] vals = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int v : vals) root = insert(root, v);
        System.out.println("Beginner search 6: " + search(root, 6));
        root = delete(root, 3);
        System.out.print("Pro inorder after delete: "); inorder(root); System.out.println();
    }
}

/*
 * Pitfalls: not handling 2-child delete, allowing duplicates without policy, confusing BST with generic binary tree.
 * Practice: validate BST, kth smallest, lowest common ancestor.
 */

