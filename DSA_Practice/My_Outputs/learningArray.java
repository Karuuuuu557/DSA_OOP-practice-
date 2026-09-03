public class learningArray {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40, 50};
        int sum = 0;

        for (int i = 0; i < arr1.length; i++) {
           sum += arr1[i];
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        System.out.println("Sum of array elements: " + sum);

        int [] arr2 = {10, 25, 7, 42, 18};
        int largest = arr2[0];


        for (int i = 1; i <arr2.length; i++) {
            if (arr2[i] > largest) {
                largest = arr2[i];
            }
        }
        System.out.println("");
        System.out.println("Largest element in the array: " + largest);
        

        int[] arr3 = {35, 12, 89, 4, 27};
        int smallest = arr3[0];

        for (int i = 1; i < arr3.length; i++) {
            if (arr3[i] < smallest) {
                smallest = arr3[i];
            }
        }
        System.out.println("Smallest element in the array: " + smallest);

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
    }
}