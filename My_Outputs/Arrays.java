public class Arrays {
    @SuppressWarnings("empty-statement")
    static void printArray(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) { 
            // i = arr.length, arr.length = 5, minus 1 to get the last index, which is 4. So i = 4, 3, 2, 1, 0
            //if i >= 0, then print arr[i], which is arr[4], arr[3], arr[2], arr[1], arr[0]
            //if i < 0, then stop the loop
            System.out.print(arr[i]); 
            // print the element at index i
            if (i > 0) System.out.print(", ");
            // if i > 0, print a coma and space to enhance typography
        }
        System.out.println();
        // print a new line after printing the array
    }
    public static void main(String[] args) {
        int numbers[] = {10, 20, 30, 40, 50};
        System.out.print("Array: ");
        printArray(numbers);
    }
}
