import java.util.Scanner;

public class SortingAlgo {
    public static void bubbleSort(int[] arr) {
        // Store the array length so we can use it to control the sorting loops.
        int n = arr.length;
        System.out.println("Original array:"); // Show the array before bubble sort changes it.
        printArray(arr);

        // Each pass moves the largest unsorted value to the end of the unsorted section.
        for (int i = 0; i < n - 1; i++) { // An array of n values needs at most n - 1 passes.
            System.out.println("\nPass " + (i + 1));
            // The last i values are already sorted, so they do not need to be compared again.
            for (int j = 0; j < n - i - 1; j++) { // Compare neighboring values in this pass.
                System.out.println("Compare: " + arr[j] + " and " + arr[j + 1]);
                // If the left value is larger, exchange the two values to move the larger value right.
                if (arr[j] > arr[j + 1]) {
                    // A temporary variable prevents the original left value from being lost.
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    System.out.println("Swap -> " + arr[j] + " and " + arr[j + 1]);
                    System.out.println("Array now: ");
                    printArray(arr);
                    System.out.println();
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        // The enhanced for loop visits each value in the array from left to right.
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Scanner reads the user's numbers from the keyboard.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        // Create an integer array with the size entered by the user.
        int[] numbers = new int[n];

        System.out.println("Enter the elements of the array:");
        // Read exactly n values and store each one at its matching index.
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Before sorting:");
        printArray(numbers);
        System.out.println();

        // Java passes the array reference to this method, so bubbleSort changes numbers directly.
        bubbleSort(numbers);

        System.out.println("\nAfter sorting:");
        printArray(numbers);
    }
}