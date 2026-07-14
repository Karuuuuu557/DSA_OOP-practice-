import java.util.ArrayDeque;
import java.util.Queue;

/*
 * TOPIC: Queue (FIFO)
 * Analogy: Checkout line; first person in line is served first.
 * Link: Complements stack by reversing removal order.
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> q = new ArrayDeque<>(); // ArrayDeque gives efficient add/remove at both ends.
        q.offer("A"); // Enqueue at rear so arrival order is preserved.
        q.offer("B"); // B is behind A.
        q.offer("C"); // C is last in line.
        System.out.println("Beginner poll: " + q.poll()); // Dequeue from front, so A leaves first.

        int[] tasks = {3, 1, 2};
        Queue<Integer> process = new ArrayDeque<>();
        for (int t : tasks) process.offer(t);
        int time = 0;
        while (!process.isEmpty()) time += process.poll();
        System.out.println("Intermediate total time: " + time);

        int[][] grid = {
            {1, 1, 0},
            {0, 1, 1},
            {0, 0, 1}
        };
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> bfs = new ArrayDeque<>();
        bfs.offer(new int[]{0, 0});
        vis[0][0] = true;
        int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
        while (!bfs.isEmpty()) {
            int[] cur = bfs.poll();
            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k], nc = cur[1] + dc[k];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (!vis[nr][nc] && grid[nr][nc] == 1) {
                    vis[nr][nc] = true;
                    bfs.offer(new int[]{nr, nc});
                }
            }
        }
        System.out.println("Pro BFS reached end: " + vis[n - 1][m - 1]);
    }
}

/*
 * Pitfalls: using remove() on empty queue, forgetting visited in BFS, confusing offer/poll with push/pop.
 * Practice: circular queue, rotten oranges, level-order traversal.
 */

