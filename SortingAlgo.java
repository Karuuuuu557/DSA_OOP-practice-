import java.util.Scanner;

public class SortingAlgo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Array size must be greater than 0.");
            scanner.close();
            return;
        }

        int[] arr = new int[size];
        System.out.print("Enter " + size + " array elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        char choice = readChoice(scanner);

        int[] workingArray = arr.clone();

        System.out.println();
        System.out.println("Original array:");
        printArray(workingArray);

        switch (choice) {
            case 'A':
                System.out.println("\nBUBBLE SORT");
                bubbleSort(workingArray);
                break;
            case 'B':
                System.out.println("\nSELECTION SORT");
                selectionSort(workingArray);
                break;
            case 'C':
                System.out.println("\nINSERTION SORT");
                insertionSort(workingArray);
                break;
            case 'D':
                System.out.println("\nMERGE SORT");
                mergeSort(workingArray, 0, workingArray.length - 1);
                break;
        }

        System.out.println("\nFinal sorted array:");
        printArray(workingArray);
        scanner.close();
    }

    public static void bubbleSort(int[] arr) {
        for (int pass = 0; pass < arr.length - 1; pass++) {
            System.out.println("\nPass " + (pass + 1) + ":");
            for (int j = 0; j < arr.length - pass - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
            printArray(arr);
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);

            System.out.println("\nStep " + (i + 1) + ":");
            printArray(arr);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
            System.out.println("\nInsert position " + i + ":");
            printArray(arr);
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

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

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }

        System.out.println("\nMerged section:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static char readChoice(Scanner scanner) {
        char choice;

        do {
            System.out.println("\nChoose a sorting algorithm:");
            System.out.println("A. Bubble Sort");
            System.out.println("B. Selection Sort");
            System.out.println("C. Insertion Sort");
            System.out.println("D. Merge Sort");
            System.out.print("Enter A, B, C, or D: ");

            choice = scanner.next().trim().toUpperCase().charAt(0);

            if (!isValidChoice(choice)) {
                System.out.println("Invalid choice! Please enter A, B, C, or D.");
            }
        } while (!isValidChoice(choice));

        return choice;
    }

    private static boolean isValidChoice(char choice) {
        return choice >= 'A' && choice <= 'D';
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temporary = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temporary;
    }
}