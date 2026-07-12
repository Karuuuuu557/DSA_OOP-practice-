/*
 * ============================================================================
 *  TOPIC: STRINGS — Text Manipulation in Java
 * ============================================================================
 *
 *  WHAT IS A STRING?
 *  -----------------
 *  A String in Java is a SEQUENCE OF CHARACTERS. Unlike C++, Java Strings
 *  are IMMUTABLE — once created, they cannot be changed. Any modification
 *  creates a NEW String object.
 *
 *  WHY STRINGS MATTER?
 *  ------------------
 *  - Text processing is everywhere (search, validation, parsing)
 *  - String problems are the most common in coding interviews/exams
 *  - Understanding strings helps with parsing input, file I/O, etc.
 *
 *  KEY STRING METHODS IN JAVA
 *  ---------------------------
 *  - str.length()              : Number of characters
 *  - str.charAt(i)             : Character at index i
 *  - str.substring(start, end) : Characters from start to end (exclusive)
 *  - str.indexOf("word")       : First occurrence index (or -1 if not found)
 *  - str.toUpperCase()        : Convert to uppercase
 *  - str.toLowerCase()        : Convert to lowercase
 *  - str.equals(other)        : Compare content (NOT == !)
 *  - str.contains("word")      : Check if substring exists
 *  - str.replace("old", "new") : Replace all occurrences
 *  - str.split("delimiter")   : Split into an array of Strings
 *  - str.toCharArray()        : Convert to char[] array
 *  - str.trim()               : Remove leading/trailing whitespace
 *  - new StringBuilder()      : Use this for MUTABLE string operations!
 *
 *  IMPORTANT: ALWAYS use .equals() to compare strings in Java!
 *  Using == compares REFERENCES (memory addresses), not content!
 *
 *  IN THIS FILE:
 *  -------------
 *  1. String basics & iteration
 *  2. Reversing a string
 *  3. Checking palindrome
 *  4. Counting characters (frequency)
 *  5. Finding & replacing substrings
 *  6. Tokenizing (splitting) a string
 *  7. Practice problems (for you to solve!)
 *
 * ============================================================================
 */

public class StringsDemo {

    // ---- 1. STRING BASICS ----
    static void demonstrateBasics() {
        System.out.println("\n=== 1. STRING BASICS ===");

        String name = "Computer Science";
        String greeting = "Hello, ";

        // Concatenation
        String full = greeting + name;
        System.out.println("Concatenated: " + full);

        // Length
        System.out.println("Length: " + full.length() + " characters");

        // Access by index
        System.out.println("First char: " + full.charAt(0));
        System.out.println("Last char:  " + full.charAt(full.length() - 1));

        // Substring (start index, end index — exclusive!)
        System.out.println("Substring (0,5): " + full.substring(0, 5));

        // Character iteration
        System.out.print("Characters: ");
        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i) + " ");
        }
        System.out.println();

        // For-each with toCharArray
        System.out.print("Uppercase:  ");
        for (char c : name.toCharArray()) {
            System.out.print(Character.toUpperCase(c));
        }
        System.out.println();

        // String comparison — ALWAYS use .equals()!
        String a = "hello";
        String b = new String("hello");
        System.out.println("\nString comparison demo:");
        System.out.println("a == b        : " + (a == b));         // false (different objects!)
        System.out.println("a.equals(b)  : " + a.equals(b));     // true  (same content!)
    }

    // ---- 2. REVERSE A STRING ----
    static void demonstrateReverse() {
        System.out.println("\n=== 2. REVERSE A STRING ===");

        String str = "algorithm";

        System.out.println("Original: " + str);

        // Method 1: Manual two-pointer swap using StringBuilder (mutable!)
        StringBuilder sb = new StringBuilder(str);
        int start = 0, end = sb.length() - 1;
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        System.out.println("Reversed (manual):    " + sb.toString());

        // Method 2: Using built-in reverse()
        StringBuilder sb2 = new StringBuilder(str);
        sb2.reverse();
        System.out.println("Reversed (built-in):  " + sb2.toString());
    }

    // ---- 3. PALINDROME CHECK ----
    // A palindrome reads the same forwards and backwards (e.g., "racecar")
    static boolean isPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    static void demonstratePalindrome() {
        System.out.println("\n=== 3. PALINDROME CHECK ===");

        String[] words = {"racecar", "hello", "level", "dsa"};

        for (String word : words) {
            if (isPalindrome(word)) {
                System.out.println("\"" + word + "\" is a palindrome.");
            } else {
                System.out.println("\"" + word + "\" is NOT a palindrome.");
            }
        }
    }

    // ---- 4. CHARACTER FREQUENCY COUNT ----
    static void demonstrateFrequency() {
        System.out.println("\n=== 4. CHARACTER FREQUENCY ===");

        String str = "data structures";

        // Count using an int array (works for ASCII)
        int[] freq = new int[256]; // All initialized to 0 by default

        for (char c : str.toCharArray()) {
            freq[(int) c]++; // Increment count for this character
        }

        System.out.println("Frequency of each character in \"" + str + "\":");
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0 && (char) i != ' ') { // Skip spaces
                System.out.println("  '" + (char) i + "' : " + freq[i]);
            }
        }
    }

    // ---- 5. FIND & REPLACE ----
    static void demonstrateFindReplace() {
        System.out.println("\n=== 5. FIND & REPLACE ===");

        String sentence = "I love Java programming. Java is great.";

        // indexOf returns the starting index, or -1 if not found
        int pos = sentence.indexOf("Java");
        System.out.println("Original: " + sentence);

        if (pos != -1) {
            System.out.println("\"Java\" first found at index: " + pos);

            // Replace ALL occurrences
            String replaced = sentence.replace("Java", "C++");
            System.out.println("After replacing all: " + replaced);
        }

        // Find all occurrences
        System.out.println("\nSearching for \"Java\" in: " + sentence);
        String searchWord = "Java";
        pos = sentence.indexOf(searchWord);
        while (pos != -1) {
            System.out.println("  Found at index: " + pos);
            pos = sentence.indexOf(searchWord, pos + 1); // Search from next position
        }
    }

    // ---- 6. TOKENIZE (SPLIT) A STRING ----
    static void demonstrateTokenize() {
        System.out.println("\n=== 6. TOKENIZING A STRING ===");

        String sentence = "Data Structures and Algorithms";

        System.out.println("Original: \"" + sentence + "\"");

        // Method 1: Using built-in split()
        String[] words = sentence.split(" ");
        System.out.println("Words split by space (using split()):");
        for (int i = 0; i < words.length; i++) {
            System.out.println("  Word " + (i + 1) + ": \"" + words[i] + "\"");
        }

        // Method 2: Manual tokenizing (good to understand the logic)
        System.out.println("\nWords split manually:");
        StringBuilder word = new StringBuilder();
        int wordCount = 0;

        for (int i = 0; i <= sentence.length(); i++) {
            if (i == sentence.length() || sentence.charAt(i) == ' ') {
                if (word.length() > 0) {
                    System.out.println("  Word " + (++wordCount) + ": \"" + word + "\"");
                    word = new StringBuilder();
                }
            } else {
                word.append(sentence.charAt(i));
            }
        }
        System.out.println("Total words: " + wordCount);
    }

    // ---- MAIN ----
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   STRINGS — Data Structures Basics      ");
        System.out.println("========================================");

        demonstrateBasics();
        demonstrateReverse();
        demonstratePalindrome();
        demonstrateFrequency();
        demonstrateFindReplace();
        demonstrateTokenize();

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
 *  1. Write a method countVowels(String str) that returns the number
 *     of VOWELS (a, e, i, o, u) in a string. Handle both cases.
 *
 *  2. Write a method to convert a string to ALTERNATING CASE.
 *     Example: "hello" → "HeLlO"
 *
 *  3. Write a method removeSpaces(String str) that removes all SPACES.
 *     Example: "a b c d" → "abcd"
 *
 *  MEDIUM:
 *  -------
 *  4. Write a method areAnagrams(String s1, String s2) that checks if two
 *     strings are ANAGRAMS (contain the same characters in different order).
 *     Example: "listen" and "silent" are anagrams.
 *     (Hint: Sort both strings and compare, or use a frequency array)
 *
 *  5. Write a method findLongestWord(String sentence) that finds the LONGEST
 *     WORD in a sentence.
 *     Example: "I love programming" → "programming" (length 11)
 *
 *  6. Given a string, compress it using RUN-LENGTH ENCODING.
 *     Example: "aaabbc" → "a3b2c1"
 *
 *  HARD:
 *  -----
 *  7. Write a method longestPalindromicSubstring(String str) that finds the
 *     LONGEST palindrome within a string.
 *     Example: "babad" → "bab" (or "aba")
 *
 *  8. Given two strings, find the LENGTH of the LONGEST COMMON SUBSTRING.
 *     Example: "abcdef" and "zcdemf" → 3 (for "cde")
 *
 * ============================================================================
 */
