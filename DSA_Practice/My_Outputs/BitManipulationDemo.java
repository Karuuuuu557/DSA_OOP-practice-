public class BitManipulationDemo {
    public static void main(String[] args) {
        int num = 10; // binary: 1010

        // Check if the 2nd bit is on (0-based from right)
        int mask = 1 << 1; // binary: 0010
        if ((num & mask) != 0) {
            System.out.println("Bit is ON");
        } else {
            System.out.println("Bit is OFF");
        }

        // Turn on the 0th bit
        num = num | (1 << 0); // 1010 -> 1011
        System.out.println(num);

        // Turn off the 3rd bit
        num = num & ~(1 << 3); // 1011 -> 0011
        System.out.println(num);
    }
}