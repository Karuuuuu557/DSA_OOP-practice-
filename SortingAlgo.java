import java.util.Scanner;

public class SortingAlgo {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        System.out.println("Bubble Sort in progress...");
        System.out.println("Initial array: ");
        printArray(arr);

        for (int i = 0; i < n - 1; i++) {
            System.out.println("\nPass " + (i + 1));
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            printArray(arr);
        }

        System.out.println("\nSorted array: ");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
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
        System.out.println(" BUBBLE SORTING ALGORITHM ");
        System.out.println("Enter the elements of the array:");
        // Read exactly n values and store each one at its matching index.
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Before sorting:");
        printArray(numbers);
        System.out.println();

        bubbleSort(numbers);

        System.out.println("\nFinal result:");
        printArray(numbers);
    }
}