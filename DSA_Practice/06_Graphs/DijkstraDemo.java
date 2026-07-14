import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * TOPIC: Dijkstra shortest path (non-negative weights)
 * Analogy: GPS repeatedly chooses the nearest unfinished location.
 * Link: Combines graph adjacency list + heap priority queue.
 */
public class DijkstraDemo {
    static class Edge { int to, w; Edge(int to, int w) { this.to = to; this.w = w; } }

    public static void main(String[] args) {
        int n = 5;
        List<List<Edge>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        add(g,0,1,4); add(g,0,2,1); add(g,2,1,2); add(g,1,3,1); add(g,2,3,5); add(g,3,4,3);

        int src = 0; // Starting node from which we compute all shortest distances.
        int[] dist = new int[n]; // dist[i] stores best known distance from src to i.
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize as "infinite" until we discover a path.
        dist[src] = 0; // Distance to source itself is zero by definition.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, src}); // Pair format: {distance, node}, min-distance first.

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (d != dist[u]) continue;
            for (Edge e : g.get(u)) {
                int nd = d + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.offer(new int[]{nd, e.to});
                }
            }
        }
        System.out.println("Shortest distances from 0: " + Arrays.toString(dist));
    }

    static void add(List<List<Edge>> g, int u, int v, int w) {
        g.get(u).add(new Edge(v, w));
        g.get(v).add(new Edge(u, w));
    }
}

/*
 * Pitfalls: negative edges (use Bellman-Ford), missing stale-state skip, integer overflow in distances.
 * Practice: path reconstruction with parent array, directed graph variant, multi-source shortest path.
 */

