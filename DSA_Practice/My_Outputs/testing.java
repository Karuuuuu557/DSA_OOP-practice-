import java.util.Scanner;
public class testing {

static Scanner input = new Scanner(System.in);

static int[]getInput() {
         
         System.out.print("Enter the size of the array for deletion: ");
         int size = input.nextInt();

         int[] arr = new int[size];

         for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
         }

          return arr;
        }
static int getPosition(int arraySize) {
        
        System.out.print("Enter the position to delete: ");
        int  elementNumber = input.nextInt();

        if (elementNumber < 1 || elementNumber > arraySize) {
            return -1;
        }
        return elementNumber - 1;
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

        System.out.println("Deleted " + deletedElement + " from element " + (position + 1)  + ".");
        return newArr;
    }
  
static void displayArray(int[] arr) {
    System.out.println("Array after deletion:");

    for(int value : arr) {
        System.err.println(value + " ");
    }
    
}

    public static void main(String[] args) {
       int[] arr = getInput();

       int position = getPosition(arr.length);  
       
       arr = deleteAtPosition(arr, position);

       displayArray(arr);

    }
}