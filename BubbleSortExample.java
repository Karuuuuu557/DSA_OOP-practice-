import java.util.Arrays;

public class BubbleSortExample {
    public static void main(String[] args) {
        int[] numbers = {7, 3, 9, 2, 5};

        System.out.println("Before sorting: " + Arrays.toString(numbers));
        bubbleSort(numbers);
        System.out.println("After sorting:  " + Arrays.toString(numbers));
    }

    public static void bubbleSort(int[] numbers) {
        for (int pass = 0; pass < numbers.length - 1; pass++) {
            boolean swapped = false;

            for (int index = 0; index < numbers.length - 1 - pass; index++) {
                if (numbers[index] > numbers[index + 1]) {
                    int temporary = numbers[index];
                    numbers[index] = numbers[index + 1];
                    numbers[index + 1] = temporary;
                    swapped = true;
                }
            }

            System.out.println("Pass " + (pass + 1) + ": " + Arrays.toString(numbers));

            if (!swapped) {
                break;
            }
        }
    }
}
