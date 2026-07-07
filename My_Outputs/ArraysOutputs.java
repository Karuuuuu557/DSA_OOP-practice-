import java.util.Scanner;
public class ArraysOutputs {

    static int[] arr;

    static void getInput1() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array for reverse traversal: ");
        int size = input.nextInt();

        arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }
    }

    static void printArrayTraversalReverse(int[] arr) {

        System.out.print("Array: ");

        for (int i = arr.length - 1; i >= 0; i--) {

            // i = arr.length, arr.length = 5, minus 1 to get the last index, which is 4.
            // So i = 4, 3, 2, 1, 0
            // if i >= 0, then print arr[i], which is arr[4], arr[3], arr[2], arr[1], arr[0]
            // if i < 0, then stop the loop

            System.out.print(arr[i]);

            // print the element at index i

            if (i > 0)
                System.out.print(", ");

            // if i > 0, print a comma and space to enhance typography
        }

        System.out.println();

        // print a new line after printing the array

        System.out.println("Size: " + arr.length + " elements");

        // print the size of the array
    }
     
        static void getInput2() {

            Scanner input = new Scanner(System.in);

            System.out.print("Enter the size of the array for normal traversal: ");
            int size = input.nextInt();

            arr = new int[size];

            for (int i = 0; i < size; i++) {
                System.out.print("Enter element " + (i + 1) + ": ");
                arr[i] = input.nextInt();
            }
            input.close();
        }

        static void printArrayTraversal(int[] arr) {

            System.out.print("Array: ");

            for (int i = arr.length - 1; i >= 0; i--) {

                // i = 4, 3, 2, 1, 0
                // if i >= 0, then print arr[i], which is arr[4], arr[3], arr[2], arr[1], arr[0]
                // if i < 0, then stop the loop

                System.out.print(arr[i]);

                // print the element at index i

                if (i > 0)
                    System.out.print(", ");

                // if i > 0, print a comma and space to enhance typography
            }

            System.out.println();

            // print a new line after printing the array

            System.out.println("Size: " + arr.length + " elements");

            // print the size of the array
        }

    public static void main(String[] args) {

        getInput1();
        printArrayTraversalReverse(arr);

        getInput2();
        printArrayTraversal(arr);

        // call the printArray method and pass the array as its argument
    }
}