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
    }
}