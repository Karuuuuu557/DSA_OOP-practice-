import java.util.Arrays;

/*
 * TOPIC: Merge sort and quick sort
 * Analogy: Merge sort splits and merges piles; quick sort partitions around a pivot.
 * Link: Upgrades from O(n^2) basic sorts to average/guaranteed O(n log n).
 */
public class MergeQuickSortDemo {
    static void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        merge(a, l, m, r);
    }
    static void merge(int[] a, int l, int m, int r) {
        int[] t = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) t[k++] = (a[i] <= a[j]) ? a[i++] : a[j++];
        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];
        for (int p = 0; p < t.length; p++) a[l + p] = t[p];
    }

    static void quickSort(int[] a, int l, int r) {
        if (l >= r) return;
        int p = partition(a, l, r);
        quickSort(a, l, p - 1);
        quickSort(a, p + 1, r);
    }
    static int partition(int[] a, int l, int r) {
        int pivot = a[r], i = l;
        for (int j = l; j < r; j++) if (a[j] <= pivot) { int t = a[i]; a[i] = a[j]; a[j] = t; i++; }
        int t = a[i]; a[i] = a[r]; a[r] = t;
        return i;
    }

    public static void main(String[] args) {
        int[] b = {5, 2, 4, 6, 1, 3}; // Beginner list for merge sort demo.
        mergeSort(b, 0, b.length - 1); // Stable O(n log n) sort; good predictable performance.
        System.out.println("Beginner merge: " + Arrays.toString(b)); // Print final ordered result.

        int[] q = {10, 7, 8, 9, 1, 5};
        quickSort(q, 0, q.length - 1);
        System.out.println("Intermediate quick: " + Arrays.toString(q));

        System.out.println("Pro trade-off: merge=stable+extra-space, quick=in-place+cache-friendly average case.");
    }
}

/*
 * Pitfalls: bad pivot on sorted input, forgetting stable requirement, copying merge ranges incorrectly.
 * Practice: quicksort with random pivot, iterative mergesort, sort linked list with merge sort.
 */

