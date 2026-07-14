import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * TOPIC: BFS and DFS
 * Analogy: BFS explores by layers; DFS explores one tunnel deeply first.
 * Link: BFS uses queue, DFS often uses recursion/stack.
 */
public class BFSDemo {
    static void dfs(int u, List<List<Integer>> g, boolean[] vis) {
        vis[u] = true;
        System.out.print(u + " ");
        for (int v : g.get(u)) if (!vis[v]) dfs(v, g, vis);
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        int[][] edges = {{0,1},{0,2},{1,3},{2,4},{4,5}};
        for (int[] e : edges) { g.get(e[0]).add(e[1]); g.get(e[1]).add(e[0]); }

        Queue<Integer> q = new ArrayDeque<>(); // Queue ensures first discovered node is processed first.
        boolean[] vis = new boolean[n]; // Visited array prevents revisiting and infinite loops.
        q.offer(0); // Start from source node 0.
        vis[0] = true; // Mark immediately when enqueued to avoid duplicates.
        System.out.print("Beginner BFS: ");
        while (!q.isEmpty()) { // Standard BFS loop over frontier.
            int cur = q.poll(); // Remove oldest discovered node.
            System.out.print(cur + " "); // Visit node in layer order.
            for (int nxt : g.get(cur)) if (!vis[nxt]) { vis[nxt] = true; q.offer(nxt); } // Enqueue unseen neighbors.
        }
        System.out.println();

        boolean[] vis2 = new boolean[n];
        System.out.print("Intermediate DFS: ");
        dfs(0, g, vis2);
        System.out.println();

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) dist[i] = -1;
        q.offer(0); dist[0] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : g.get(cur)) if (dist[nxt] == -1) { dist[nxt] = dist[cur] + 1; q.offer(nxt); }
        }
        System.out.println("Pro shortest edges 0->5: " + dist[5]);
    }
}

/*
 * Pitfalls: marking visited too late, using BFS for weighted shortest path, recursion depth issues in DFS.
 * Practice: islands count, bipartite check, shortest path in unweighted maze.
 */

