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
    }

    // Prints the array from the first index to the last index.
    static void printArrayTraversal(int[] arr) {
        System.out.print("Array: ");

        // Start from the first element and move forward.
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            // Add a comma between values, except after the last one.
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();

        System.out.println("Size: " + arr.length + " elements");
    }

    // Takes input for the third example: conditional traversal.
    static void getInput3() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array for conditional traversal: ");
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

    // Prints only the even numbers in the array.
    static void printConditionalTraversal(int[] arr) {
        System.out.print("Even Numbers: ");

        boolean found = false;

        // Traverse the array from the first index to the last index.
        for (int i = 0; i < arr.length; i++) {

            // Check if the current element is even.
            if (arr[i] % 2 == 0) {

                // Print a comma before the next even number.
                if (found) {
                    System.out.print(", ");
                }

                System.out.print(arr[i]);
                found = true;
            }
        }

        // If no even numbers were found, display a message.
        if (!found) {
            System.out.print("No even numbers found.");
        }

        System.out.println();

        System.out.println("Size: " + arr.length + " elements");
    }

    public static void main(String[] args) {

        // First example: collect input and print the array in reverse order.
        getInput1();
        printArrayTraversalReverse(arr);

        // Second example: collect input and print the array in normal order.
        getInput2();
        printArrayTraversal(arr);

        // Third example: collect input and print only the even numbers.
        getInput3();
        printConditionalTraversal(arr);
    }
}