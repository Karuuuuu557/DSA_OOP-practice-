import java.util.Scanner;

public class ArraysOutputs {

    // This is the array that will store all values entered by the user.
    static int[] arr;

    // Takes input for the first example: reverse traversal.
    static void getInput1() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array for reverse traversal: ");
        int size = input.nextInt();

        // Create an array with the size the user entered.
        arr = new int[size];

        // Fill the array with values from the user.
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }
    }

    // Prints the array from the last index to the first index.
    static void printArrayTraversalReverse(int[] arr) {
        System.out.print("Array: ");

        // Start from the last element and move backward.
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);

            // Add a comma between values, except after the last one.
            if (i > 0) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("Size: " + arr.length + " elements");
    }

    // Takes input for the second example: normal traversal.
    static void getInput2() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array for normal traversal: ");
        int size = input.nextInt();

        // Create a new array using the user's chosen size.
        arr = new int[size];

        // Store each value in the array.
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }
        input.close();
    }

    // Prints the array using the same loop idea as the reverse example.
    static void printArrayTraversal(int[] arr) {
        System.out.print("Array: ");

        // This loop still goes backward, so the output will be reversed.
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);

            if (i > 0) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("Size: " + arr.length + " elements");
    }

    public static void main(String[] args) {
        // First example: collect input and print the array in reverse order.
        getInput1();
        printArrayTraversalReverse(arr);

        // Second example: collect input and print the array again.
        getInput2();
        printArrayTraversal(arr);
    }
}