import java.util.Arrays;

/*
 * TOPIC: Bubble, Selection, Insertion Sort
 * Analogy: Sorting books by height on a shelf.
 * Link: Array traversal from 01_Basics.
 */
public class SortingBasicsDemo {
    static void bubbleSort(int[] a) {
        for (int pass = 0; pass < a.length - 1; pass++) {
            boolean swapped = false;
            for (int i = 0; i < a.length - 1 - pass; i++) {
                if (a[i] > a[i + 1]) {
                    int t = a[i]; a[i] = a[i + 1]; a[i + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) if (a[j] < a[min]) min = j;
            int t = a[i]; a[i] = a[min]; a[min] = t;
        }
    }

    public static void main(String[] args) {
        int[] beginner = {5, 1, 4, 2}; // Small unsorted sample so swaps are easy to trace.
        bubbleSort(beginner); // Bubble largest value rightward each pass.
        System.out.println("Beginner bubble: " + Arrays.toString(beginner)); // Show final sorted order.

        int[] intermediate = {9, 7, 5, 3, 1, 2};
        insertionSort(intermediate);
        System.out.println("Intermediate insertion: " + Arrays.toString(intermediate));

        int[] pro = {10, -1, 7, 7, 3, 0};
        selectionSort(pro);
        System.out.println("Pro selection: " + Arrays.toString(pro));
    }
}

/*
 * Pitfalls:
 * 1) Off-by-one boundaries in inner loops.
 * 2) Forgetting stability differences (selection sort is not stable by default).
 * 3) Using O(n^2) sorts for large data when merge/quick is better.
 *
 * Practice: easy swap-count bubble pass, medium stable insertion by key, hard compare times on random arrays.
 */

