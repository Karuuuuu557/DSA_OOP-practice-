import java.util.Scanner; // Import Scanner so we can read numbers and other input from the console.

public class ArraysOutputs {

    // ===== CLASS-LEVEL (STATIC) VARIABLES =====
    // These variables are declared at the class level using the static keyword.
    // That means they belong to the class itself, not to any single method call.
    // In this simple example, the methods can share the same array and parameters
    // without passing them as arguments from one method to the next.
    // This is useful for small demonstration programs, though larger programs
    // usually use method parameters and return values instead of shared state.

    // This array holds the numbers the user enters for each example.
    // It is reused by multiple examples in sequence, and each getInputX method
    // assigns a new array when it needs fresh data.
    static int[] arr;

    // The target value to search for in the search example.
    static int target;

    // The step size used in the step/skip traversal example.
    static int step;

    // ================= EXAMPLE 1: REVERSE TRAVERSAL =================

    // Read input for the first example and build the array used for reverse traversal.
    // The method asks the user for the array size, allocates an array of that length,
    // then reads each element into the array.
    static void getInput1() {
        // Create a Scanner object so the program can read keyboard input line by line.
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array for reverse traversal: ");
        int size = input.nextInt(); // Read how many numbers the user wants to enter.

        // Allocate an integer array with the size specified by the user.
        // The array is zero-indexed, so valid indexes are 0 through size-1.
        arr = new int[size];

        // Fill the array by reading one number for each index.
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt(); // Store the input value at index i, index i is the first index of the array, which is 0.
        }
    }

    // Print the contents of the array in reverse order, from the last element
    // back to the first element.
    static void printArrayTraversalReverse(int[] arr) {
        System.out.print("Reverse Traversal: ");

        // The last index in an array is always length - 1 because indexes start at 0.
        for (int i = arr.length - 1; i >= 0; i--) {
        
            System.out.print(arr[i]);

            // Print commas between values for readability, but not after the final value.
            if (i > 0) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("Size: " + arr.length + " elements");
    }

    // ================= EXAMPLE 2: NORMAL TRAVERSAL =================

    // Read input for the second example and build a new array for normal traversal.
    // This example shows a standard forward read of array elements.
    static void getInput2() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter the size of the array for normal traversal: ");
        int size = input.nextInt();

        // Allocate a fresh array for this example. This replaces the previous array
        // stored in the class variable 'arr'. That's okay because we are running
        // each example one after the other.
        arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": "); //this gets the i which starts at 0 then add 1 to be user friendly
            arr[i] = input.nextInt();
        }
    }

    // Print the array in the same order the user entered the values.
    static void printArrayTraversal(int[] arr) {
        System.out.print("Normal Traversal: ");

        // Loop from 0 to arr.length - 1. This is the most common way to traverse an array.
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            // Print commas between values so the output is easier to read.
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("Size: " + arr.length + " elements");
    }

    // ================= EXAMPLE 3: CONDITIONAL TRAVERSAL =================

    // Read input for the third example and build a new array to demonstrate conditional traversal.
    // Conditional traversal means we look at every element, but only act on values that satisfy a condition.
    static void getInput3() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter the size of the array for conditional traversal: ");
        int size = input.nextInt();

        arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }
    }

    // Print only values that match a specific condition. In this example, that condition is "is even".
    // This shows how traversal can be combined with filtering to process only some array elements.
    static void printConditionalTraversal(int[] arr) {
        System.out.print("Conditional Traversal (Even Numbers): ");

        boolean found = false;

        for (int i = 0; i < arr.length; i++) { //this goes through all the array elements and checks if they are even or not
            // An integer is even when the remainder of dividing by 2 is zero.
            if (arr[i] % 2 == 0) { //if the value of the array at index i is even, then print it
                if (found) { 
                    System.out.print(", ");//if we found another even number, this prints a comma after the first even number
                }

                System.out.print(arr[i]);//prints the currrent value of the array at index i if it is even
                found = true; //from the set boolean value false, we change it to true when we find the first even number, so that we can print the comma before the next even number.
            }
        }

        if (!found) { //if nothing is found, this prints a message to the user that no even numbers were found in the array.
            System.out.print("No even numbers found.");
        }

        System.out.println();
        System.out.println("Size: " + arr.length + " elements");
    }

    // ================= EXAMPLE 4: SEARCH TRAVERSAL =================

    // Read input for the fourth example and build an array to demonstrate searching.
    // This example teaches how to look for a single value inside an array.
    static void getInput4() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter the size of the array for search traversal: ");
        int size = input.nextInt();

        arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }

        System.out.print("Enter the value to search: ");
        target = input.nextInt();
    }

    // Search the array for the target value using a simple linear search.
    // Linear search means checking each element in order until we either find
    // the item or reach the end of the array.
    static void printSearchTraversal(int[] arr) {
        boolean found = false;
         
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) { //if the value of the index at current i is equal to the target value, then print the index of the value and set found to true
                System.out.println("Value " + target + " found at index " + i + ".");//prints the index of the value that was found in the array
                found = true; //the default value of found is false, but if we find the value in the array we set it to true so that we can print the message that it was found
                break; // Stop right away once the value is found.
            }
        }

        if (!found) {
            System.out.println("Value " + target + " was not found in the array.");
        }

        System.out.println("Size: " + arr.length + " elements");
    }

    // ================= EXAMPLE 5: MODIFICATION TRAVERSAL =================

    // Read input for the fifth example and build an array for modification.
    // This example will show how to change the values stored in the array itself.
    static void getInput5() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter the size of the array for modification traversal: ");
        int size = input.nextInt();

        arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }
    }

    // ================= EXAMPLE 6: SUMMATION/AVERAGE TRAVERSAL =================
    // Takes input for the sixth example: summation/average traversal.
    static void getInput6() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter the size of the array for summation/average traversal: ");
        int size = input.nextInt();

        // Create a new array using the user's chosen size.
        arr = new int[size];

        // Store each value in the array.
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }
    }

    // Modifies each element in the array by multiplying it by 2, then prints the result.
    static void printModificationTraversal(int[] arr) {

        System.out.print("Modified Array: ");

        // Traverse the array and modify each element as we go.
        for (int i = 0; i < arr.length; i++) {

            // Multiply the current element by 2 and store the result back into the
            // SAME array (arr[i] = ...). This is different from the other print
            // methods above — this one actually changes the original data, it
            // doesn't just read and display it.
            arr[i] = arr[i] * 2;

            // Print the newly modified value (not the original one).
            System.out.print(arr[i]);

            // Add a comma between values, except after the last one.
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("Size: " + arr.length + " elements");
    }

    // Calculates the sum and average of the array elements.
    static void printSummationAverageTraversal(int[] arr) {

        int sum = 0;        // Will accumulate the total of all elements.
        double average;     // Declared as double so it can hold decimal values (e.g. 2.5).

        // Traverse all of the array elements and add them to the sum. This is a standard pattern for summing values in an array.
        for (int i = 0; i < arr.length; i++) { 
            sum += arr[i]; // sum = sum + arr[i], arr i is the current index of the array, and arr[i] is the value at that index. This adds the value to the sum.       
        }

        // Calculate the average by dividing the sum by the number of elements.
        // "(double) sum" converts sum to a double BEFORE dividing, so we get a
        // proper decimal result instead of integer division (which would cut off
        // any decimal places, e.g. 7 / 2 would give 3 instead of 3.5).
        average = (double) sum / arr.length;

        System.out.println("Summation/Average Traversal");
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Size: " + arr.length + " elements");
    }

    // ================= EXAMPLE 7: STEP/SKIP TRAVERSAL =================

    // Takes input for the seventh example: step/skip traversal.
    static void getInput7() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter the size of the array for step/skip traversal: ");
        int size = input.nextInt();

        // Create a new array using the user's chosen size.
        arr = new int[size];

        // Store each value in the array.
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }

        // Ask the user how many elements to skip on each step (the "step size").
        // A step size of 2 means "visit every other element", 3 means "visit every
        // third element", and so on. A step size of 1 would just be a normal traversal.
        System.out.print("Enter the step size (how many elements to skip each time): ");
        step = input.nextInt();
    }

    // Prints only every Nth element of the array, where N is the step size.
    // Unlike printConditionalTraversal (which filters based on a VALUE check like
    // "is it even?"), this filters based on POSITION — it doesn't care what the
    // value is, only whether its index lines up with the step.
    static void printStepTraversal(int[] arr) {

        System.out.print("Step/Skip Traversal (every " + step + getOrdinalSuffix(step) + " element): ");

        // Guard against a step size of 0 or less, which would either freeze the
        // loop (0) or cause it to never move forward correctly (negative).
        if (step <= 0) {
            System.out.println("Invalid step size. Step must be 1 or greater.");
            return;
        }

        // This flag works the same way as in printConditionalTraversal: it tracks
        // whether we've already printed something, so we know when to print a
        // leading comma before the next value.
        boolean found = false;

        // The key difference from a normal traversal: instead of "i++" (move forward
        // by 1 every time), we use "i += step" so the loop jumps forward by however
        // many positions the user chose. For example, with step = 2, i goes 0, 2, 4, 6...
        // which means arr[1], arr[3], arr[5]... are skipped over entirely.
        for (int i = 0; i < arr.length; i += step) {

            if (found) {
                System.out.print(", ");
            }

            System.out.print(arr[i]);
            found = true;
        }

        System.out.println();
        System.out.println("Size: " + arr.length + " elements");
    }

    // Small helper method just for nicer output (e.g. "every 2nd element" instead
    // of "every 2 element"). This isn't required for the traversal logic itself —
    // it's purely cosmetic, so feel free to remove it if your assignment only
    // wants the core traversal pattern.
    static String getOrdinalSuffix(int number) {
        if (number % 10 == 1 && number % 100 != 11) return "st";
        if (number % 10 == 2 && number % 100 != 12) return "nd";
        if (number % 10 == 3 && number % 100 != 13) return "rd";
        return "th";
    }

    // ================= MAIN METHOD =================
    // This is the entry point of the program — where execution starts.
    // It runs through all seven examples in order, each time collecting input
    // and then processing/printing that input in a different way.
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

        // Fourth example: collect input and search for a value in the array.
        getInput4();
        printSearchTraversal(arr);

        // Fifth example: modification traversal.
        // getInput5() reads in the array size and its elements from the user.
        getInput5();

        // printModificationTraversal(arr) doubles every value in the array
        // (modifying the actual array, not just displaying it), then prints
        // the updated values and the array's size.
        printModificationTraversal(arr);

        // Sixth example: collect input and calculate the sum and average.
        getInput6();
        printSummationAverageTraversal(arr);

        // Seventh example: collect input (including a step size) and print
        // only every Nth element of the array.
        getInput7();
        printStepTraversal(arr);
    }
}