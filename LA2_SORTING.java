import java.util.Scanner;

public class LA2_SORTING {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.print("Enter " + size + " array elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        char choice;

        // Repeat until a valid sorting choice is entered
        do {
            System.out.println("\nChoose Sorting Algorithm:");
            System.out.println("A. Bubble Sort");
            System.out.println("B. Selection Sort");
            System.out.println("C. Insertion Sort");
            System.out.println("D. Merge Sort");
            System.out.print("Type (A/B/C/D) only: ");

            choice = scanner.next().toUpperCase().charAt(0);

            if (choice != 'A' && choice != 'B' && choice != 'C' && choice != 'D') {
                System.out.println("\nInvalid choice! Please enter A, B, C, or D.");
            }

        } while (choice != 'A' && choice != 'B' && choice != 'C' && choice != 'D');

        System.out.println();

        // Select the sorting algorithm
        switch (choice) {

            case 'A':
                System.out.println("BUBBLE SORT");
                printArray(arr);
                bubbleSort(arr);
                break;

            case 'B':
                System.out.println("SELECTION SORT");
                printArray(arr);
                selectionSort(arr);
                break;

            case 'C':
                System.out.println("INSERTION SORT");
                printArray(arr);
                insertionSort(arr);
                break;

            case 'D':
                System.out.println("MERGE SORT");
                printArray(arr);
                mergeSort(arr, 0, arr.length - 1);
                break;
        }

        scanner.close();
    }


    // BUBBLE SORT
    public static void bubbleSort(int[] arr) {

        int n = arr.length;

        // Compare neighboring elements and swap if needed
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            printArray(arr);
        }
    }


    // SELECTION SORT
    public static void selectionSort(int[] arr) {

        int n = arr.length;

        // Find the smallest value and place it in the correct position
        for (int i = 0; i < n - 1; i++) {

            int minIdx = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;

            printArray(arr);
        }
    }


    // INSERTION SORT
    public static void insertionSort(int[] arr) {

        int n = arr.length;

        // Take one element and insert it into its correct position
        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

            printArray(arr);
        }
    }


    // MERGE SORT
    public static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            // Divide the array into two smaller parts
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Combine the two sorted parts
            merge(arr, left, middle, right);
        }
    }


    // MERGE
    public static void merge(int[] arr, int left, int middle, int right) {

        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Compare both parts and place the smaller value first
        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }

            k++;
        }

        // Add remaining values from the left part
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Add remaining values from the right part
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }

        printArray(arr);
    }


    public static void printArray(int[] arr) {

        for (int num : arr) {
            System.out.print(num + "\t");
        }

        System.out.println();
    }
}