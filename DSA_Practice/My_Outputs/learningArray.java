public class learningArray {
    public static void main(String[] args) {
        System.out.println("=== Program 1: Array Sum ===");
        int[] arr1 = {10, 20, 30, 40, 50};
        int sum = 0;

        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i];
        }

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        System.out.println("Sum of array elements: " + sum);

        System.out.println();
        System.out.println("=== Program 2: Largest Element ===");
        int[] arr2 = {10, 25, 7, 42, 18};
        int largest = arr2[0];

        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i] > largest) {
                largest = arr2[i];
            }
        }

        System.out.println("Largest element in the array: " + largest);

        System.out.println();
        System.out.println("=== Program 3: Smallest Element ===");
        int[] arr3 = {35, 12, 89, 4, 27};
        int smallest = arr3[0];

        for (int i = 1; i < arr3.length; i++) {
            if (arr3[i] < smallest) {
                smallest = arr3[i];
            }
        }

        System.out.println("Smallest element in the array: " + smallest);

        System.out.println();
        System.out.println("=== Program 4: Even and Odd Count ===");
        int[] arr4 = {12, 7, 20, 15, 8, 3, 10};
        int even = 0;
        int odd = 0;

        for (int i = 0; i < arr4.length; i++) {
            if (arr4[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Number of even elements in the array: " + even);
        System.out.println("Number of odd elements in the array: " + odd);

        System.out.println();
        System.out.println("=== Program 5: Average ===");
        int[] arr5 = {10, 20, 30, 40, 50};
        double average = 0;

        for (int i = 0; i < arr5.length; i++) {
            average += arr5[i];
        }

        average /= arr5.length;
        System.out.println("Average of array elements: " + average);

        System.out.println();
        System.out.println("=== Program 6: Search Element ===");
        int[] arr6 = {10, 25, 7, 42, 18};
        int target = 42;

        for (int i = 0; i < arr6.length; i++) {
            if (arr6[i] == target) {
                System.out.println("Element " + target + " found at index: " + i);
                break;
            }
        }

        System.out.println();
        System.out.println("=== Program 7: Search with Flag ===");
        int[] arr7 = {15, 8, 23, 41, 6};
        int target2 = 20;
        boolean found = false;

        for (int i = 0; i < arr7.length; i++) {
            if (arr7[i] == target2) {
                found = true;
                System.out.println("Element " + target2 + " found at index: " + i);
                break;
            }
        }

        if (!found) {
            System.out.println("Element " + target2 + " not found in the array.");
        }

        System.out.println();
        System.out.println("=== Program 8: Compare with Limit ===");
        int[] arr8 = {12, 5, 27, 8, 31, 14, 3};
        int limit = 10;
        int count = 0;

        for (int i = 0; i < arr8.length; i++) {
            if (arr8[i] > limit) {
                System.out.println(arr8[i] + " is greater than " + limit);
                count++;
            } else {
                System.out.println(arr8[i] + " is not greater than " + limit);
            }
        }

        System.out.println("Count of elements greater than " + limit + ": " + count);
    }
}