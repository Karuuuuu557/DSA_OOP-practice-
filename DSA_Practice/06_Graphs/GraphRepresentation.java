import java.util.ArrayList;
import java.util.List;

/*
 * TOPIC: Graph representation (matrix and list)
 * Analogy: Cities as nodes, roads as edges.
 * Link: Matrix uses arrays; adjacency list uses lists.
 */
public class GraphRepresentation {
    public static void main(String[] args) {
        int n = 4; // Number of nodes labeled 0..3.
        int[][] matrix = new int[n][n]; // Matrix[i][j] = 1 means edge i->j exists.
        matrix[0][1] = matrix[1][0] = 1; // Undirected edge between 0 and 1.
        matrix[1][2] = matrix[2][1] = 1; // Another undirected edge.
        System.out.println("Beginner matrix edge 0-1: " + matrix[0][1]); // O(1) edge lookup.

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        System.out.println("Intermediate neighbors of 1: " + adj.get(1));

        // Pro note: matrix is better for dense graphs; list is better for sparse graphs.
        int edgeCount = 0;
        for (List<Integer> nei : adj) edgeCount += nei.size();
        System.out.println("Pro sparse memory friendly edge-entries: " + edgeCount);
    }
}

/*
 * Pitfalls: forgetting directed vs undirected insertion rules, wrong node indexing, wasting matrix memory on sparse graph.
 * Practice: convert matrix->list, count connected components input, detect self-loops.
 */

