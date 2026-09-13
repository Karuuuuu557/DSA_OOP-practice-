import java.util.Scanner;

public class SortingAlgo {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        System.out.println("Original array:"); // this part is for printing the original array
        printArray(arr);

        for (int i = 0; i < n - 1; i++) { // this part is for the number of passes
            System.out.println("\nPass " + (i + 1));
            for (int j = 0; j < n - i - 1; j++) { //this part is for the number of comaparisons in each pass
                System.out.println("Compare: " + arr[j] + " and " + arr[j + 1]);
                if (arr[j] > arr[j + 1]) { // swap if the element found is greater than the next element
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
        for (int value : arr) { //this part is for printing the array after each pass
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Before sorting:");
        printArray(numbers);
        System.out.println();

        bubbleSort(numbers);

        System.out.println("\nAfter sorting:");
        printArray(numbers);
    }
}