public class SortingAlgo {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

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
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Before sorting:");
        printArray(numbers);
        System.out.println();

        bubbleSort(numbers);

        System.out.println("\nAfter sorting:");
        printArray(numbers);
    }
}