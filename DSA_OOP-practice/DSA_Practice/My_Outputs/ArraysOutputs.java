import java.util.Scanner; // Import Scanner so we can read input from the user via the keyboard/console.

public class ArraysOutputs {

    // ===== CLASS-LEVEL (STATIC) VARIABLES =====
    // These are declared outside any method, at the class level, using "static".
    // That means all methods in this class share the SAME copy of these variables,
    // so one method can fill 'arr' with data and another method can use that same 'arr'
    // without needing to pass it around manually every time.

    // This is the array that will store all values entered by the user.
    static int[] arr;

    // Stores the value that will be searched in the array (used in the search example).
    static int target;

    // Stores how many positions to jump forward each time (used in the step/skip example).
    static int step;

    // ================= EXAMPLE 1: REVERSE TRAVERSAL =================

    // Takes input for the first example: reverse traversal.
    static void getInput1() {
        // Create a Scanner object to read from the console (System.in = keyboard input).
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array for reverse traversal: ");
        int size = input.nextInt(); // Read a whole number typed by the user (the array size).

        // Create an array with the size the user entered.
        // Note: this assigns to the class-level 'arr', so it's now available to other methods too.
        arr = new int[size];

        // Fill the array with values from the user, one element at a time.
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt(); // Store the typed number into the array at index i.
        }
    }

    // Prints the array from the last index to the first index (i.e., backwards).
    static void printArrayTraversalReverse(int[] arr) {
        System.out.print("Reverse Traversal: ");

        // Start from the last valid index (arr.length - 1) and decrease i until we hit 0.
        for (int i = arr.length - 1; i >= 0; i--) {

            System.out.print(arr[i]); // Print the current element.

            // Add a comma between values, except after the very last one we print (i == 0).
            if (i > 0) {
                System.out.print(", ");
            }
        }

        System.out.println(); // Move to a new line after printing all elements.
        System.out.println("Size: " + arr.length + " elements"); // Show how many elements were in the array.
    }

    // ================= EXAMPLE 2: NORMAL TRAVERSAL =================

    // Takes input for the second example: normal (forward) traversal.
    static void getInput2() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter the size of the array for normal traversal: ");
        int size = input.nextInt();

        // Create a new array using the user's chosen size.
        // This REPLACES whatever was in 'arr' before (from getInput1), since we're
        // pointing 'arr' at a brand-new array object.
        arr = new int[size];

        // Store each value in the array, same pattern as getInput1.
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }
    }

    // Prints the array from the first index to the last index (in the order entered).
    static void printArrayTraversal(int[] arr) {
        System.out.print("Normal Traversal: ");

        // Start at index 0 and move forward to the end of the array.
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]);

            // Add a comma between values, except after the last element (i == arr.length - 1).
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("Size: " + arr.length + " elements");
    }

    // ================= EXAMPLE 3: CONDITIONAL TRAVERSAL =================

    // Takes input for the third example: conditional traversal (filtering values).
    static void getInput3() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter the size of the array for conditional traversal: ");
        int size = input.nextInt();

        // Create a new array using the user's chosen size.
        arr = new int[size];

        // Store each value in the array.
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }
    }

    // Prints only the even numbers in the array (values that pass a condition).
    static void printConditionalTraversal(int[] arr) {

        System.out.print("Conditional Traversal (Even Numbers): ");

        // This flag tracks whether we've found at least one even number so far.
        // It's used to decide whether to print a leading comma before a new value.
        boolean found = false;

        // Traverse the array and check each value against our condition.
        for (int i = 0; i < arr.length; i++) {

            // Condition: checks if the number is even (no remainder when divided by 2).
            if (arr[i] % 2 == 0) {

                // If we already printed an even number before this one, add a comma first.
                if (found) {
                    System.out.print(", ");
                }

                System.out.print(arr[i]);
                found = true; // Mark that we've now found at least one even number.
            }
        }

        // If we never found any even numbers, let the user know instead of printing nothing.
        if (!found) {
            System.out.print("No even numbers found.");
        }

        System.out.println();
        System.out.println("Size: " + arr.length + " elements");
    }

    // ================= EXAMPLE 4: SEARCH TRAVERSAL =================

    // Takes input for the fourth example: search traversal.
    static void getInput4() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter the size of the array for search traversal: ");
        int size = input.nextInt();

        // Create a new array using the user's chosen size.
        arr = new int[size];

        // Store each value in the array.
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }

        // Get the value the user wants to search for, and store it in the
        // class-level 'target' variable so printSearchTraversal() can use it.
        System.out.print("Enter the value to search: ");
        target = input.nextInt();
    }

    // Searches for a specific value (target) in the array using a linear search.
    static void printSearchTraversal(int[] arr) {

        // Tracks whether we found the target value while looping.
        boolean found = false;

        // Traverse the array from first index to last index, checking each element.
        for (int i = 0; i < arr.length; i++) {

            // Check if the current element matches the target value.
            if (arr[i] == target) {

                System.out.println("Value " + target + " found at index " + i + ".");
                found = true;
                break; // Stop looping immediately — no need to keep searching once found.
            }
        }

        // Display a message if the loop finished without finding the value.
        if (!found) {
            System.out.println("Value " + target + " was not found in the array.");
        }

        System.out.println("Size: " + arr.length + " elements");
    }

    // ================= EXAMPLE 5: MODIFICATION TRAVERSAL =================

    // Takes input for the fifth example: modification traversal.
    static void getInput5() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter the size of the array for modification traversal: ");
        int size = input.nextInt();

        // Create a new array using the user's chosen size.
        arr = new int[size];

        // Store each value in the array.
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }

        // Close the Scanner to release the input resource since we're done reading
        // keyboard input in this method. (Note: getInput6() below opens its own new
        // Scanner afterward, which still works fine since it's a separate object —
        // but closing System.in-based Scanners mid-program is something to be
        // mindful of, since it's generally cleaner to close resources once at the
        // very end of a program rather than in the middle.)
        input.close();
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

        // Traverse the array and add each element to the running total.
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Same as: sum = sum + arr[i];
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
        // getInput5() reads in the array size and its elements from the user,
        // then closes the Scanner since input-reading is done at this point
        // in the flow.
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