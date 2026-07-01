/*
 * ============================================================================
 *  TOPIC: BIT MANIPULATION — Working with Binary in Java
 * ============================================================================
 *
 *  WHY LEARN BIT MANIPULATION?
 *  --------------------------
 *  - Makes your code FASTER (bit operations are the fastest CPU operations)
 *  - Essential for competitive programming and technical interviews
 *  - Understanding how computers ACTUALLY store data
 *  - Used in: compression, encryption, graphics, networking
 *
 *  THE 6 CORE BITWISE OPERATORS
 *  ----------------------------
 *  Operator  Name          Description                    Example (5 & 3)
 *  --------  -----------   ---------------------------    ---------------
 *    &       AND           1 only if BOTH bits are 1       5 & 3 = 1
 *    |       OR            1 if AT LEAST ONE bit is 1     5 | 3 = 7
 *    ^       XOR           1 if bits are DIFFERENT        5 ^ 3 = 6
 *    ~       NOT           Flips all bits (complement)     ~5  = -6
 *    <<      Left Shift    Shift bits LEFT = multiply by 2    5 << 1 = 10
 *    >>      Right Shift   Shift bits RIGHT = divide by 2     5 >> 1 = 2
 *
 *  VISUAL EXAMPLE (5 AND 3 in binary):
 *    5 = 0 1 0 1
 *    3 = 0 0 1 1
 *    ---------- AND
 *    1 = 0 0 0 1
 *
 *  JAVA NOTE:
 *  -----------
 *  - Java int is 32 bits (not 8 like the examples above)
 *  - Use >>> for UNSIGNED right shift (fills with 0s instead of sign bit)
 *  - Be careful with ~ (NOT) — it works on 32-bit ints, so ~5 = -6
 *  - char, byte, short are promoted to int during bitwise operations
 *
 *  IN THIS FILE:
 *  -------------
 *  1. Binary representation of numbers
 *  2. All 6 bitwise operators demonstrated
 *  3. Common bit tricks (check odd/even, swap without temp, set/toggle/clear bits)
 *  4. Count set bits (Kernighan's algorithm)
 *  5. Check if a number is a power of 2
 *  6. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

public class BitManipulationDemo {

    // ---- HELPER: Print binary of a number (8-bit representation) ----
    static void printBinary(int n) {
        String binary = Integer.toBinaryString(n & 0xFF); // Mask to 8 bits
        // Pad with leading zeros to 8 digits
        while (binary.length() < 8) {
            binary = "0" + binary;
        }
        System.out.println(n + " = " + binary + " (binary)");
    }

    // ---- 1. BINARY REPRESENTATION ----
    static void demonstrateBinary() {
        System.out.println("\n=== 1. BINARY REPRESENTATION ===");

        int[] numbers = {5, 8, 15, 255};
        for (int n : numbers) {
            printBinary(n);
        }
    }

    // ---- 2. ALL 6 BITWISE OPERATORS ----
    static void demonstrateOperators() {
        System.out.println("\n=== 2. BITWISE OPERATORS ===");

        int a = 5;  // 0101
        int b = 3;  // 0011

        System.out.println("a = "); printBinary(a);
        System.out.println("b = "); printBinary(b);
        System.out.println("-----------------------------");

        System.out.print("a & b  (AND)  = "); printBinary(a & b);
        System.out.print("a | b  (OR)   = "); printBinary(a | b);
        System.out.print("a ^ b  (XOR)  = "); printBinary(a ^ b);
        System.out.println("~a     (NOT)  = " + (~a));
        System.out.print("a << 1 (LEFT) = "); printBinary(a << 1);
        System.out.println("         (same as a * 2 = " + (a << 1) + ")");
        System.out.print("a >> 1 (RIGHT)= "); printBinary(a >> 1);
        System.out.println("         (same as a / 2 = " + (a >> 1) + ")");
    }

    // ---- 3. COMMON BIT TRICKS ----
    static void demonstrateTricks() {
        System.out.println("\n=== 3. COMMON BIT TRICKS ===");

        // Trick 1: Check if a number is ODD or EVEN
        int num = 7;
        System.out.println("\n--- Odd/Even Check ---");
        System.out.println(num + " is " + ((num & 1) == 1 ? "ODD" : "EVEN")
                + "  (using: num & 1 = " + (num & 1) + ")");

        // Trick 2: Multiply / Divide by 2 using shifts
        num = 20;
        System.out.println("\n--- Multiply/Divide by 2 ---");
        System.out.println(num + " << 1 = " + (num << 1) + " (multiply by 2)");
        System.out.println(num + " >> 1 = " + (num >> 1) + " (divide by 2)");

        // Trick 3: Swap two numbers WITHOUT a temp variable (using XOR)
        int x = 10, y = 25;
        System.out.println("\n--- Swap without temp (XOR) ---");
        System.out.println("Before: x=" + x + ", y=" + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After:  x=" + x + ", y=" + y);

        // Trick 4: Set, Toggle, and Clear a specific bit
        num = 12; // 1100
        int bitPos = 1; // 0-indexed from right
        System.out.println("\n--- Set / Toggle / Clear bit at position " + bitPos + " ---");
        printBinary(num);
        System.out.println("         = original");

        // SET bit (turn ON)
        int setBit = num | (1 << bitPos);
        System.out.print("         = after SET bit " + bitPos + ": ");
        printBinary(setBit);

        // TOGGLE bit (flip)
        int toggleBit = num ^ (1 << bitPos);
        System.out.print("         = after TOGGLE bit " + bitPos + ": ");
        printBinary(toggleBit);

        // CLEAR bit (turn OFF)
        int clearBit = num & ~(1 << bitPos);
        System.out.print("         = after CLEAR bit " + bitPos + ": ");
        printBinary(clearBit);

        // CHECK bit (is it 1?)
        int checkBit = (num >> bitPos) & 1;
        System.out.println("Bit " + bitPos + " of original = " + checkBit);
    }

    // ---- 4. COUNT SET BITS (Kernighan's Algorithm) ----
    // Counts the number of 1-bits in a number — O(number of set bits)
    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1); // This REMOVES the rightmost set bit!
            count++;
        }
        return count;
    }

    static void demonstrateCountBits() {
        System.out.println("\n=== 4. COUNT SET BITS (Kernighan's) ===");

        int[] numbers = {7, 13, 0, 255};
        for (int n : numbers) {
            printBinary(n);
            System.out.println("   → " + countSetBits(n) + " set bit(s)");
        }
    }

    // ---- 5. CHECK POWER OF 2 ----
    // A number is power of 2 if it has exactly ONE set bit
    // Example: 1(1), 2(10), 4(100), 8(1000) — all have one '1'
    static boolean isPowerOf2(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    static void demonstratePowerOf2() {
        System.out.println("\n=== 5. POWER OF 2 CHECK ===");

        int[] numbers = {1, 2, 3, 4, 7, 8, 16, 20, 32};
        for (int n : numbers) {
            System.out.print(n + " = ");
            printBinary(n);
            System.out.println("   → " + (isPowerOf2(n) ? "YES, power of 2" : "NO"));
        }
    }

    // ---- MAIN ----
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   BIT MANIPULATION — Data Structures   ");
        System.out.println("========================================");

        demonstrateBinary();
        demonstrateOperators();
        demonstrateTricks();
        demonstrateCountBits();
        demonstratePowerOf2();

        System.out.println("\n========================================");
        System.out.println("   All demonstrations complete!         ");
        System.out.println("========================================");
    }
}

/*
 * ============================================================================
 *  PRACTICE PROBLEMS — Try these on your own!
 * ============================================================================
 *
 *  EASY:
 *  ------
 *  1. Write a method getBit(int n, int pos) that returns the Nth bit of
 *     a number (0-indexed from right).
 *     Example: getBit(13, 2) → 1 because 13 = 1101, bit at pos 2 = 1
 *
 *  2. Write a method countOdd(int[] arr) that counts how many ODD numbers
 *     are in an array using ONLY bitwise operations (no modulo %).
 *
 *  3. Write a method toBinary(int n) that converts a DECIMAL number to a
 *     BINARY String manually (don't use Integer.toBinaryString()).
 *     Example: 10 → "1010"
 *
 *  MEDIUM:
 *  -------
 *  4. Write a method findUnique(int[] arr) that finds the UNIQUE number
 *     where every other number appears EXACTLY TWICE.
 *     Example: [2, 3, 5, 3, 2] → 5 is unique
 *     (Hint: XOR all elements together!)
 *
 *  5. Write a method findTwoUnique(int[] arr) that finds TWO unique numbers
 *     where every other number appears EXACTLY TWICE.
 *     Example: [2, 4, 5, 4, 2, 7] → 5 and 7 are unique
 *     (Hint: XOR partition + group separation)
 *
 *  HARD:
 *  -----
 *  6. Write a method bitsToFlip(int a, int b) that returns the number of
 *     bits needed to FLIP to convert integer A into integer B.
 *     Example: A=10 (1010), B=7 (0111) → need to flip 3 bits
 *     (Hint: XOR them first, then count set bits)
 *
 *  7. Given a number N and two positions i and j, write a method that
 *     SWAPS only the bits at those two positions.
 *     Example: N=28 (11100), i=0, j=3 → swap bit 0 and bit 3 → 29 (11101)
 *
 * ============================================================================
 */
