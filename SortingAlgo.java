import java.util.Scanner;

public class SortingAlgo {
    private static long randomState;
    private static final long RANDOM_MODULUS = 2147483648L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Array size must be greater than 0.");
            scanner.close();
            return;
        }

        char arrayChoice = readArrayGenerationChoice(scanner);
        int[] arr = createArray(size, arrayChoice, scanner);

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

    private static int[] createArray(int size, char choice, Scanner scanner) {
        int[] arr = new int[size];

        if (choice == 'A' || choice == 'D' || choice == 'E') {
            System.out.print("Enter a random seed (use a different seed for a different array): ");
            randomState = scanner.nextLong() % RANDOM_MODULUS;
            if (randomState < 0) {
                randomState = -randomState;
            }
        }

        switch (choice) {
            case 'A':
                for (int i = 0; i < size; i++) {
                    arr[i] = nextRandomValue(201) - 100;
                }
                break;
            case 'B':
                for (int i = 0; i < size; i++) {
                    arr[i] = i + 1;
                }
                break;
            case 'C':
                for (int i = 0; i < size; i++) {
                    arr[i] = size - i;
                }
                break;
            case 'D':
                for (int i = 0; i < size; i++) {
                    arr[i] = i + 1;
                }
                int swaps = size / 10;
                if (swaps < 1) {
                    swaps = 1;
                }
                for (int i = 0; i < swaps && size > 1; i++) {
                    int firstIndex = nextRandomValue(size);
                    int secondIndex = nextRandomValue(size);
                    swap(arr, firstIndex, secondIndex);
                }
                break;
            case 'E':
                int valueRange = size / 3;
                if (valueRange < 1) {
                    valueRange = 1;
                }
                for (int i = 0; i < size; i++) {
                    arr[i] = nextRandomValue(valueRange);
                }
                if (size > 1) {
                    arr[1] = arr[0];
                }
                break;
            case 'F':
                System.out.print("Enter " + size + " array elements: ");
                for (int i = 0; i < size; i++) {
                    arr[i] = scanner.nextInt();
                }
                break;
        }

        return arr;
    }

    private static int nextRandomValue(int bound) {
        randomState = (randomState * 1103515245L + 12345L) % RANDOM_MODULUS;
        return (int) (randomState % bound);
    }

    public static void bubbleSort(int[] arr) {
        for (int pass = 0; pass < arr.length - 1; pass++) {
            System.out.println("\nPass " + (pass + 1) + ":");

            for (int j = 0; j < arr.length - pass - 1; j++) {
                System.out.println("Compare index " + j + " (" + arr[j] + ") and index " + (j + 1) + " (" + arr[j + 1] + ")");

                if (arr[j] > arr[j + 1]) {
                    System.out.println("Swapping " + arr[j] + " and " + arr[j + 1]);
                    swap(arr, j, j + 1);
                } else {
                    System.out.println("No swap needed");
                }
            }
            printArray(arr);
        }

        System.out.println("\nBubble Sort completed.");
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            System.out.println("Step " + (i + 1) + ": Finding minimum from index " + i + " to " + (arr.length - 1));

            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("Compare index " + j + " (" + arr[j] + ") with current minimum index " + arr[minIndex] + " at index " + minIndex);

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    System.out.println("New minimum found at index " + arr[minIndex] + " at index " + minIndex);
                }
            } 
              if (minIndex != i) {
                 System.out.println("Swap index " + i + " (" + arr[i] + ") with index " + minIndex + " (" + arr[minIndex] + ")");
                 swap(arr, i, minIndex);
                } else {
                 System.out.println("The minimum is already in the correct position at index " + i);
                }
            printArray(arr);
        }
        System.out.println("\nSelection Sort completed.");
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            System.out.println("Step " + i + ": Inserting " + key + " into the sorted portion of the array.");

            while (j >= 0 && arr[j] > key) {
                System.out.println("Shift " + arr[j] + " from index " + j + " to index " + (j + 1));
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

            System.out.println("Placed " + key + " at index " + (j + 1));
            System.out.println("Array after insertion:");
            printArray(arr);
        }
        System.out.println("\nInsertion Sort completed.");
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            if(left == right) {
                System.out.println("Index " + left + " has one element (" + arr[left] + "). so it is already sorted.");
            }
            return;//oi
        }

        int middle = left + (right - left) / 2;

        System.out.println("\nSplit indexes " + left + " to " + right + " at index " + middle);
        System.out.println("Left half: indexes " + left + " to " + middle);
        System.out.println("Right half: indexes " + (middle + 1) + " to " + right);
        mergeSort(arr, left, middle);

        System.out.println("Sort right half: indexes " + (middle + 1) +  " to " + right);
        mergeSort(arr, middle + 1, right);
        
        merge(arr, left, middle, right);
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

    private static char readArrayGenerationChoice(Scanner scanner) {
        char choice;

        do {
            System.out.println("\nChoose how to create the array:");
            System.out.println("A. Random array");
            System.out.println("B. Already sorted");
            System.out.println("C. Reverse sorted");
            System.out.println("D. Mostly sorted");
            System.out.println("E. Array with duplicates");
            System.out.println("F. Enter elements manually");
            System.out.print("Enter A, B, C, D, E, or F: ");

            choice = scanner.next().trim().toUpperCase().charAt(0);

            if (choice < 'A' || choice > 'F') {
                System.out.println("Invalid choice! Please enter A, B, C, D, E, or F.");
            }
        } while (choice < 'A' || choice > 'F');

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