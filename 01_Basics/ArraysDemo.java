/*
 * ============================================================================
 *  TOPIC: ARRAYS — The Foundation of Data Structures
 * ============================================================================
 *
 *  WHAT IS AN ARRAY?
 *  ----------------
 *  An array is a collection of elements stored at CONTIGUOUS (adjacent) memory
 *  locations. Each element is accessed using an INDEX starting from 0.
 *
 *  WHY ARRAYS MATTER?
 *  -----------------
 *  - O(1) access by index — instant lookup!
 *  - Foundation for almost every other data structure
 *  - Used in matrices, hash tables, dynamic programming, etc.
 *
 *  KEY OPERATIONS & TIME COMPLEXITIES
 *  ----------------------------------
 *  - Access by index    : O(1)
 *  - Search (unsorted)  : O(n)
 *  - Search (sorted)    : O(log n) with binary search
 *  - Insertion at end   : O(1)
 *  - Insertion at start : O(n) — must shift all elements
 *  - Deletion at end    : O(1)
 *  - Deletion at start  : O(n) — must shift all elements
 *
 *  JAVA NOTE:
 *  -----------
 *  - Java arrays have a FIXED size — you cannot resize after creation.
 *  - Use .length to get the size (NOT .length() — that's for Strings!)
 *  - Arrays are OBJECTS in Java (not primitives)
 *  - For dynamic sizing, use ArrayList (covered in later topics)
 *
 *  IN THIS FILE:
 *  -------------
 *  1. Array declaration & initialization
 *  2. Traversal (printing all elements)
 *  3. Searching (linear search)
 *  4. Insertion (at position)
 *  5. Deletion (at position)
 *  6. Finding max, min, and sum
 *  7. Reversing an array
 *  8. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

import java.util.Arrays;

public class ArraysDemo {

    // ---- HELPER: Print an array ----
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    // ---- 1. TRAVERSAL ----
    // Just visiting and printing every element
    static void demonstrateTraversal() {
        System.out.println("\n=== 1. ARRAY TRAVERSAL ===");

        int[] arr = {10, 20, 30, 40, 50};

        System.out.print("Array: ");
        printArray(arr);
        System.out.println("Size: " + arr.length + " elements");

        // For-each loop (enhanced for loop)
        System.out.print("Using for-each: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // ---- 2. LINEAR SEARCH ----
    // Check each element one by one — O(n)
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found! Return index
            }
        }
        return -1; // Not found
    }

    static void demonstrateSearch() {
        System.out.println("\n=== 2. LINEAR SEARCH ===");

        int[] arr = {5, 15, 25, 35, 45};
        int target = 25;
        int result = linearSearch(arr, target);

        if (result != -1) {
            System.out.println(target + " found at index " + result);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }

    // ---- 3. INSERTION ----
    // Insert a value at a specific position — requires shifting elements
    // Returns a NEW array (Java arrays are fixed-size!)
    static int[] insertAtPosition(int[] arr, int element, int position) {
        // Check: is the position valid?
        if (position < 0 || position > arr.length) {
            System.out.println("Invalid position!");
            return arr;
        }

        // Create a new array with size + 1
        int[] newArr = new int[arr.length + 1];

        // Copy elements before the insertion point
        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }

        // Insert the new element
        newArr[position] = element;

        // Copy elements after the insertion point
        for (int i = position; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        System.out.println("Inserted " + element + " at position " + position);
        return newArr;
    }

    static void demonstrateInsertion() {
        System.out.println("\n=== 3. INSERTION ===");

        int[] arr = {10, 20, 30, 40, 50};

        System.out.print("Before: ");
        printArray(arr);

        arr = insertAtPosition(arr, 99, 2); // Insert 99 at index 2

        System.out.print("After:  ");
        printArray(arr);
    }

    // ---- 4. DELETION ----
    // Remove element at a position — requires shifting elements left
    // Returns a NEW array (Java arrays are fixed-size!)
    static int[] deleteAtPosition(int[] arr, int position) {
        if (position < 0 || position >= arr.length) {
            System.out.println("Invalid position!");
            return arr;
        }

        int deletedElement = arr[position];

        // Create a new array with size - 1
        int[] newArr = new int[arr.length - 1];

        // Copy elements, skipping the deleted one
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i == position) continue; // Skip the deleted element
            newArr[j++] = arr[i];
        }

        System.out.println("Deleted " + deletedElement + " from position " + position);
        return newArr;
    }

    static void demonstrateDeletion() {
        System.out.println("\n=== 4. DELETION ===");

        int[] arr = {10, 99, 20, 30, 40, 50};

        System.out.print("Before: ");
        printArray(arr);

        arr = deleteAtPosition(arr, 2); // Delete element at index 2

        System.out.print("After:  ");
        printArray(arr);
    }

    // ---- 5. FIND MAX, MIN, SUM ----
    static void demonstrateMaxMinSum() {
        System.out.println("\n=== 5. MAX, MIN, SUM ===");

        int[] arr = {12, 5, 27, 3, 49, 18};

        int maxVal = arr[0], minVal = arr[0], sum = 0;

        for (int num : arr) {
            if (num > maxVal) maxVal = num;
            if (num < minVal) minVal = num;
            sum += num;
        }

        System.out.print("Array: ");
        printArray(arr);
        System.out.println("Max  = " + maxVal);
        System.out.println("Min  = " + minVal);
        System.out.println("Sum  = " + sum);
        System.out.println("Avg  = " + (double) sum / arr.length);
    }

    // ---- 6. REVERSE AN ARRAY ----
    static void demonstrateReverse() {
        System.out.println("\n=== 6. REVERSE AN ARRAY ===");

        int[] arr = {1, 2, 3, 4, 5, 6};

        System.out.print("Before: ");
        printArray(arr);

        // Two-pointer technique: swap first<->last, second<->second-to-last, etc.
        int start = 0, end = arr.length - 1;
        while (start < end) {
            // Swap arr[start] and arr[end]
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        System.out.print("After:  ");
        printArray(arr);
    }

    // ---- MAIN ----
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   ARRAYS — Data Structures Basics      ");
        System.out.println("========================================");

        demonstrateTraversal();
        demonstrateSearch();
        demonstrateInsertion();
        demonstrateDeletion();
        demonstrateMaxMinSum();
        demonstrateReverse();

        System.out.println("\n========================================");
        System.out.println("   All demonstrations complete!         ");
        System.out.println("========================================");
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Try these on your own!
 * ============================================================================
 *
 *  EASY:
 *  ------
 *  1. Write a method countEven(int[] arr) that returns the number of
 *     EVEN elements in the array.
 *
 *  2. Write a method isSorted(int[] arr) that checks if an array is SORTED
 *     in ascending order. Return true if sorted, false otherwise.
 *
 *  3. Write a method to find the SECOND LARGEST element in an array.
 *     (Don't sort the array — do it in one pass!)
 *
 *  MEDIUM:
 *  -------
 *  4. Write a method removeDuplicates(int[] arr) that removes duplicate
 *     values from a SORTED array and returns the new array.
 *     Example: [1,1,2,2,3,4,4] → [1,2,3,4]
 *
 *  5. Given an array, move all ZEROS to the end while keeping the order
 *     of non-zero elements.
 *     Example: [0,1,0,3,12] → [1,3,12,0,0]
 *
 *  6. Write a method that ROTATES an array to the LEFT by K positions.
 *     Example: rotate [1,2,3,4,5] by 2 → [3,4,5,1,2]
 *
 *  HARD:
 *  -----
 *  7. Given a 2D array (matrix), print it in SPIRAL order.
 *     Example: [[1,2,3],[4,5,6],[7,8,9]] → 1,2,3,6,9,8,7,4,5
 *
 *  8. Find the "majority element" — an element that appears MORE THAN n/2
 *     times in the array. Do it in O(n) time and O(1) space.
 *     (Hint: Boyer-Moore Voting Algorithm)
 *
 * ============================================================================
 */
