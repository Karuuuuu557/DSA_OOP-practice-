# 🚀 Java Starter Guide — How to Start Coding

> This guide will take you from **"I know what variables are"** to **"I can write programs on my own"**.

---

## 📌 Step 1: Understand What a Java Program ALWAYS Needs

Every Java program has this skeleton. **Memorize this** — it's your starting point every time:

```java
public class MyProgram {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
    }
}
```

| Part | What it means |
|------|---------------|
| `public class MyProgram` | The name of your program. **File name MUST match this exactly.** |
| `public static void main(String[] args)` | The entry point — Java starts executing from here. |
| `// YOUR CODE GOES HERE` | Where you write your actual logic |

> ⚠️ **Rule #1:** If your class is `HelloWorld`, your file MUST be named `HelloWorld.java`

---

## 📌 Step 2: The 5 Things You'll Use 90% of the Time

### 1. Variables — Store data
```java
int age = 20;                  // whole number
double price = 99.99;          // decimal number
String name = "Carl";          // text (use double quotes!)
boolean isStudent = true;      // true or false
char grade = 'A';              // single character (use single quotes!)
```

### 2. Output — Show things on screen
```java
System.out.println("Hello!");      // prints with new line
System.out.print("No newline");   // prints without new line
System.out.println("Age: " + age); // combine text + variable
```

### 3. Input — Get things from the user
```java
import java.util.Scanner;  // put this AT THE VERY TOP of your file

Scanner input = new Scanner(System.in);

System.out.print("Enter your name: ");
String name = input.nextLine();        // read a whole line (text)

System.out.print("Enter your age: ");
int age = input.nextInt();             // read a whole number
input.nextLine();                      // IMPORTANT: clear the leftover newline!

System.out.print("Enter price: ");
double price = input.nextDouble();     // read a decimal number
input.nextLine();                      // clear again!
```

> ⚠️ **Rule #2:** After `nextInt()` or `nextDouble()`, ALWAYS call `input.nextLine()` once to clear the leftover newline character!

### 4. Conditions — Make decisions
```java
if (age >= 18) {
    System.out.println("Adult");
} else if (age >= 13) {
    System.out.println("Teenager");
} else {
    System.out.println("Child");
}
```

### 5. Loops — Repeat things
```java
// FOR loop — when you know HOW MANY TIMES to repeat
for (int i = 0; i < 5; i++) {
    System.out.println("Count: " + i);
}

// WHILE loop — when you DON'T know how many times
int count = 0;
while (count < 5) {
    System.out.println("Count: " + count);
    count++;
}
```

---

## 📌 Step 3: How to Write a Program (The Thinking Process)

Don't just jump into typing. Follow this process:

### Example: "Write a program that asks for 3 numbers and prints the largest"

**Step 1 — What do I need?**
- 3 number variables
- A way to compare them
- A Scanner for input

**Step 2 — Write the skeleton**
```java
import java.util.Scanner;

public class FindLargest {
    public static void main(String[] args) {

    }
}
```

**Step 3 — Add variables**
```java
import java.util.Scanner;

public class FindLargest {
    public static void main(String[] args) {
        int num1, num2, num3;
        int largest;
        Scanner input = new Scanner(System.in);
    }
}
```

**Step 4 — Add input**
```java
System.out.print("Enter first number: ");
num1 = input.nextInt();
input.nextLine();

System.out.print("Enter second number: ");
num2 = input.nextInt();
input.nextLine();

System.out.print("Enter third number: ");
num3 = input.nextInt();
input.nextLine();
```

**Step 5 — Add logic**
```java
largest = num1;                 // assume first is largest
if (num2 > largest) largest = num2;
if (num3 > largest) largest = num3;

System.out.println("The largest number is: " + largest);
```

**Done!** That's the process — skeleton → variables → input → logic → output.

---

## 📌 Step 4: How to Run Java in VS Code

### One-time setup:
1. Install [VS Code](https://code.visualstudio.com/) if you haven't
2. Install the **"Extension Pack for Java"** extension (by Microsoft)
3. Install **JDK** — [Download here](https://adoptium.net/temurin/releases/)

### To run a Java file:
- **Option A:** Click the ▶️ **Run** button above your `main` method
- **Option B:** Open terminal in VS Code (`Ctrl + ~`) and type:
  ```bash
  javac MyProgram.java
  java MyProgram
  ```

### Folder setup for VS Code:
```
MyProject/
├── MyProgram.java    ← your code goes here
```
No packages needed for simple programs! Just put the `.java` file in a folder and run it.

---

## 📌 Step 5: Common Mistakes Beginners Make

| Mistake | ❌ Wrong | ✅ Correct | Why |
|---------|---------|-----------|-----|
| Comparing Strings | `if (name == "Carl")` | `if (name.equals("Carl"))` | `==` compares memory address, not content |
| Forgetting semicolons | `int x = 5` | `int x = 5;` | Every statement needs `;` |
| File vs class mismatch | File: `Hello.java`<br>Class: `public class Hi` | File: `Hello.java`<br>Class: `public class Hello` | They must match exactly |
| Not clearing Scanner | `nextInt(); nextLine();` | `nextInt(); nextLine();`<br>`nextLine();` | Extra `nextLine()` clears leftover newline |
| Array length | `arr.length()` | `arr.length` | No parentheses for arrays! |
| String length | `str.length` | `str.length()` | Needs parentheses for Strings! |

---

## 📌 Step 6: Your First Assignment

Open **`StarterExercises.java`** (in the same folder as this file) and try to complete the exercises inside. Each exercise gets slightly harder. Don't worry if you get stuck — that's how you learn!

**Tips while coding:**
- ✅ **Start with the skeleton** (class + main) — always
- ✅ **Write ONE line at a time** — compile/run after every few lines
- ✅ **Print variables** to check if your code is doing what you expect
- ✅ **Read error messages** — they tell you exactly which line has the problem
- ❌ Don't write 50 lines and then run — you'll have no idea where the error is

---

*You got this. Start small, break things, fix them, repeat. That's how everyone learns.*
