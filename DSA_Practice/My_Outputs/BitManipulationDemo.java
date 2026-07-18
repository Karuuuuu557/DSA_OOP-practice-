public class BitManipulationDemo {
    public static void main(String[] args) {
        int num = 5; // binary: 101

        // Check if the 2nd bit is on (0-based from right)
        int mask = 1 << 2; // binary: 0100
        if ((num & mask) != 0) {
            System.out.println("Bit is ON");
        } else {
            System.out.println("Bit is OFF");
        }

        // Turn on the 0th bit
        num = num | (1 << 0); // 101 -> 1011
        System.out.println(num);

        // Turn off the 3rd bit
        num = num & ~(1 << 3); // 1011 -> 0011
        System.out.println(num);
    }
}