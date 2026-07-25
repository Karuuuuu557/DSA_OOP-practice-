import java.util.Scanner;

public class testing {
    static int[] arr;

static void getInput() {
         try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter size of array for deletion: ");
             int size = input.nextInt();

            arr = new int[size];

            for (int i = 0; i < size; i++) {
                System.out.print("Enter element " + (i + 1) + ": ");
                arr[i] = input.nextInt();
            }
        }
            // try-with-resources will auto-close the scanner
    }
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
  

    public static void main(String[] args) {
        getInput();
        printDeletionTraversal(arr);
    }
}