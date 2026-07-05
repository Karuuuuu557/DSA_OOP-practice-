public class Arrays {

    static int[] arr = {10, 20, 30, 40, 50}; 
    // create an integer array named arr with 5 elements
    
    static void printArray(int[] arr) {

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

    public static void main(String[] args) {

        printArray(arr);

        // call the printArray method and pass the array as its argument
    }
}