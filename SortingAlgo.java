public class SortingAlgo {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            System.out.println("\nPass " + (i + 1));
            for (int j = 0; j < n - i - 1; j++) {
                System.out.println("Compare: " + arr[j] + " and " + arr[j + 1]);
                if (arr[j] > arr[j + 1]) {
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
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Before sorting:");
        printArray(numbers);
        System.out.println();

        bubbleSort(numbers);

        System.out.println("\nAfter sorting:");
        printArray(numbers);
    }
}