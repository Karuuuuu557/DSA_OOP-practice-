# 🚀 Java Starter Guide — How to Start Coding

> This guide will take you from **"I know what variables are"** to **"I can write programs on my own"**.

---

## 📑 Table of Contents

**Part A — Getting Started**
- [Step 1: What a Java Program Always Needs](#-step-1-understand-what-a-java-program-always-needs)
- [Step 2: The 5 Things You'll Use 90% of the Time](#-step-2-the-5-things-youll-use-90-of-the-time)
- [Step 3: How to Write a Program (The Thinking Process)](#-step-3-how-to-write-a-program-the-thinking-process)
- [Step 3.5: Building Programming Logic](#-step-35-building-programming-logic-how-to-think-like-a-programmer)
- [Step 4: How to Run Java in VS Code](#-step-4-how-to-run-java-in-vs-code)
- [Step 5: Common Mistakes Beginners Make](#-step-5-common-mistakes-beginners-make)
- [Step 6: Your First Assignment](#-step-6-your-first-assignment)

**Part B — The Complete Roadmap**
- [0–2: Setup & Fundamentals](#0-what-java-is)
- [3: OOP Core](#3-oop-core-intermediate-entry)
- [4–9: Collections, Exceptions, File I/O, Generics, Streams, Date/Time](#4-collections-framework)
- [10–12: Concurrency, Networking, JDBC](#10-multithreading-and-concurrency-pro-foundation)
- [13–17: Modern Language Features, Testing, Build Tools, Pro Topics, Mistakes](#13-important-java-language-features-to-know)
- [18–21: DSA Prep, Learning Path, Practice Projects, Final Notes](#18-dsa--interview-ready-java)

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

| Part                                     | What it means                                                    |
| ---------------------------------------- | ---------------------------------------------------------------- |
| `public class MyProgram`                 | The name of your program. **File name MUST match this exactly.** |
| `public static void main(String[] args)` | The entry point — Java starts executing from here.               |
| `// YOUR CODE GOES HERE`                 | Where you write your actual logic                                |

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

#### Step 1 — What do I need?

- 3 number variables
- A way to compare them
- A Scanner for input

#### Step 2 — Write the skeleton

```java
import java.util.Scanner;

public class FindLargest {
    public static void main(String[] args) {

    }
}
```

#### Step 3 — Add variables

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

#### Step 4 — Add input

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

#### Step 5 — Add logic

```java
largest = num1;                 // assume first is largest
if (num2 > largest) largest = num2;
if (num3 > largest) largest = num3;

System.out.println("The largest number is: " + largest);
```

**Done!** That's the process — skeleton → variables → input → logic → output.

---

## 📌 Step 3.5: Building Programming Logic (How to Think Like a Programmer)

Knowing Java's syntax (`if`, `for`, `int`) is not the same skill as knowing HOW to
turn a problem into steps. That second skill — **programming logic** — is what
actually gets harder as problems get harder, and it's rarely taught explicitly.
Here's how to build it deliberately.

### 1. The IPO Method — break every problem into 3 boxes

Before writing any code, answer these three questions on paper or in comments:

| Box | Question | Example: "Find the average of 5 grades" |
|-----|----------|-------------------------------------------|
| **I**nput | What do I already have, or need to ask for? | 5 grades from the user |
| **P**rocess | What has to happen to turn Input into Output? | Add them up, divide by 5 |
| **O**utput | What do I need to show/return at the end? | The average, printed to the screen |

If you can't fill in these three boxes, you're not ready to write code yet —
go back and understand the problem first. This single habit prevents most of
the "I don't know where to start" freeze-ups.

### 2. Write PSEUDOCODE before real code

Pseudocode is writing your logic in plain English/Filipino, structured like
code, but without worrying about Java syntax. It lets you debug your THINKING
before you debug your SYNTAX — two different skills, easier to do one at a time.

```
START
  ask user for 3 numbers
  assume the first number is the largest
  IF second number is bigger than current largest
      update largest
  IF third number is bigger than current largest
      update largest
  print largest
END
```

Only after this makes sense do you translate it line-by-line into Java. This
is exactly what Step 3's "Add logic" phase already showed you — pseudocode is
just making that thinking step explicit and repeatable for HARDER problems too.

### 3. Trace your code by hand (a.k.a. "dry running")

Before you even compile, pretend you ARE the computer. Take a small example
input and walk through your own code line by line, writing down what every
variable holds after each line. Use a simple table:

```
Input: num1 = 7, num2 = 3, num3 = 9

Line                          | largest
-------------------------------|--------
largest = num1;                | 7
if (num2 > largest) ...        | 7   (3 > 7 is false, no change)
if (num3 > largest) largest=n3 | 9   (9 > 7 is true, updated)
```

If your hand-traced result matches what the problem expects, your LOGIC is
correct — any remaining bugs are just syntax. If it doesn't match, you found
a logic error before ever running the program, which is much faster to fix
than staring at wrong output wondering why.

### 4. Recognize the recurring "logic patterns"

Most beginner problems are built from a small set of reusable patterns.
Once you recognize which pattern fits, half the thinking is already done:

| Pattern | Used for | Looks like |
|---------|----------|------------|
| **Accumulator** | Totals, sums, averages | `total = total + value;` inside a loop |
| **Counter** | Counting how many meet a condition | `count++;` inside an `if` inside a loop |
| **Flag (boolean)** | "Did something happen at all?" | `boolean found = false;` set to `true` when it does |
| **Max/Min tracker** | Largest/smallest value | Assume the first is the answer, then compare and update |
| **Swap** | Exchanging two values | Needs a temporary variable: `temp = a; a = b; b = temp;` |
| **Sentinel/loop guard** | Repeat "until" something specific happens | `while (!done)` or `while (input != -1)` |

You've already used three of these without necessarily naming them — the
`found` flag in `printConditionalTraversal`, the `sum` accumulator in
`printSummationAverageTraversal`, and the max-tracker idea in `printSearchTraversal`'s
`largest` example above. Naming the pattern makes it easier to spot in a NEW
problem you haven't seen before.

### 5. When stuck, shrink the problem

If a problem feels too big, don't stare at it — make it smaller until you
CAN solve it, then build back up:

- Can't solve it for "any array"? Solve it for an array of exactly 3 elements first.
- Can't solve the general case? Solve one specific example by hand, THEN
  generalize your hand-solution into code.
- Too many steps at once? Solve step 1 alone, print the result, confirm it's
  right, THEN add step 2.

### 6. A simple way to think about *why* one solution is "better" than another

You don't need Big-O notation yet, but you can start noticing:
- **Does my solution redo work it's already done?** (e.g. searching the whole
  array again every loop instead of remembering what you found)
- **Does my solution use more variables/loops than it needs to?** Fewer moving
  parts usually means fewer bugs.
- **Would this still work if the input were 10x bigger?** If a solution only
  "works" because the test input is tiny, it's not really solved yet.

This mindset is the seed of complexity analysis, which is covered formally
later in your `DSA_Practice` track — but the instinct to ask these questions
should start now, on simple problems, so it's already a habit by the time the
problems get harder.

---

## 📌 Step 4: How to Run Java in VS Code

### One-time setup

1. Install [VS Code](https://code.visualstudio.com/) if you haven't
2. Install the **"Extension Pack for Java"** extension (by Microsoft)
3. Install **JDK** — [Download here](https://adoptium.net/temurin/releases/)

### To run a Java file

- **Option A:** Click the ▶️ **Run** button above your `main` method
- **Option B:** Open terminal in VS Code (`Ctrl + ~`) and type:

  ```bash
  javac MyProgram.java
  java MyProgram
  ```

### Folder setup for VS Code

```text
MyProject/
├── MyProgram.java    ← your code goes here
```

No packages needed for simple programs! Just put the `.java` file in a folder and run it.

---

## 📌 Step 5: Common Mistakes Beginners Make

| Mistake                | ❌ Wrong                                     | ✅ Correct                                      | Why                                        |
| ---------------------- | -------------------------------------------- | ----------------------------------------------- | ------------------------------------------ |
| Comparing Strings      | `if (name == "Carl")`                        | `if (name.equals("Carl"))`                      | `==` compares memory address, not content  |
| Forgetting semicolons  | `int x = 5`                                  | `int x = 5;`                                    | Every statement needs `;`                  |
| File vs class mismatch | File: `Hello.java`; Class: `public class Hi` | File: `Hello.java`; Class: `public class Hello` | They must match exactly                    |
| Not clearing Scanner   | `nextInt(); nextLine();`                     | `nextInt(); nextLine(); nextLine();`            | Extra `nextLine()` clears leftover newline |
| Array length           | `arr.length()`                               | `arr.length`                                    | No parentheses for arrays!                 |
| String length          | `str.length`                                 | `str.length()`                                  | Needs parentheses for Strings!             |

---

## 📌 Step 6: Your First Assignment

Open **`StarterExercises.java`** (in the same folder as this file) and try to complete the exercises inside. Each exercise gets slightly harder. Don't worry if you get stuck — that's how you learn!

### Tips while coding

- ✅ **Start with the skeleton** (class + main) — always
- ✅ **Write ONE line at a time** — compile/run after every few lines
- ✅ **Print variables** to check if your code is doing what you expect
- ✅ **Read error messages** — they tell you exactly which line has the problem
- ❌ Don't write 50 lines and then run — you'll have no idea where the error is

---

_You got this. Start small, break things, fix them, repeat. That's how everyone learns._

---
---

# Part B: The Complete Roadmap

> [!NOTE]
> Part A (above) gets you writing your first working programs. Everything below
> is the longer road map for AFTER that — come back to this part once Part A
> and your `StarterExercises.java` feel comfortable, not before. Trying to
> absorb both parts at once will slow you down more than it helps.

## Java Complete Learning Guide (Beginner → Intermediate → Pro)

> This file is a **full teaching roadmap** with examples. Study top to bottom, code every snippet, and build mini-projects as you go.

---

## 0) What Java Is

Java is a general-purpose, object-oriented, strongly typed language that runs on the JVM (Java Virtual Machine).  
Write code once, run on Windows/Linux/macOS (with a compatible JVM).

---

## 1) Setup and First Program

Install:

1. JDK 17+ (recommended: 21 LTS)
2. VS Code + Extension Pack for Java

Run in terminal:

```bash
javac Hello.java
java Hello
```

`Hello.java`:

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

---

## 2) Java Fundamentals (Beginner)

### 2.1 Variables and Types

```java
int age = 20;
double price = 19.99;
boolean isActive = true;
char grade = 'A';
String name = "Carl";
```

Primitive types: `byte short int long float double char boolean`  
Reference types: `String`, arrays, classes, interfaces, etc.

### 2.2 Operators

```java
int a = 10, b = 3;
System.out.println(a + b);   // 13
System.out.println(a - b);   // 7
System.out.println(a * b);   // 30
System.out.println(a / b);   // 3 (int division)
System.out.println(a % b);   // 1
System.out.println(a > b);   // true
```

### 2.3 Input (Scanner)

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
System.out.print("Enter age: ");
int age = sc.nextInt();
sc.nextLine(); // clear newline
System.out.print("Enter name: ");
String name = sc.nextLine();
```

### 2.4 Conditionals

```java
if (age >= 18) {
    System.out.println("Adult");
} else {
    System.out.println("Minor");
}
```

Switch expression (modern Java):

```java
int day = 2;
String label = switch (day) {
    case 1 -> "Mon";
    case 2 -> "Tue";
    default -> "Other";
};
```

### 2.5 Loops

```java
for (int i = 0; i < 3; i++) System.out.println(i);

int n = 3;
while (n > 0) {
    System.out.println(n);
    n--;
}
```

### 2.6 Arrays

```java
int[] nums = {4, 1, 9};
System.out.println(nums[0]);     // 4
System.out.println(nums.length); // 3
```

### 2.7 Methods

```java
static int add(int x, int y) {
    return x + y;
}
```

### 2.8 String Basics

```java
String s = "Java";
System.out.println(s.length());       // 4
System.out.println(s.toUpperCase());  // JAVA
System.out.println(s.substring(1));   // ava
```

---

## 3) OOP Core (Intermediate Entry)

### 3.1 Class and Object

```java
class Car {
    String brand;
    int year;

    Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    void drive() {
        System.out.println(brand + " is driving");
    }
}
```

### 3.2 Encapsulation

```java
class Account {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
```

### 3.3 Inheritance + Polymorphism

```java
class Animal {
    void sound() { System.out.println("Some sound"); }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Woof"); }
}

Animal a = new Dog();
a.sound(); // Woof
```

### 3.4 Abstract Class + Interface

```java
abstract class Shape {
    abstract double area();
}

interface Printable {
    void print();
}
```

### 3.5 `final`, `static`, `this`, `super`

- `final`: constant / non-overridable
- `static`: class-level member
- `this`: current object
- `super`: parent class reference

---

## 4) Collections Framework

### 4.1 List, Set, Map

```java
import java.util.*;

List<String> names = new ArrayList<>();
names.add("Ana");
names.add("Bob");

Set<Integer> unique = new HashSet<>();
unique.add(1);
unique.add(1); // ignored

Map<String, Integer> scores = new HashMap<>();
scores.put("Math", 95);
System.out.println(scores.get("Math"));
```

Choose by need:

- `ArrayList`: fast random access
- `LinkedList`: frequent insertion/removal in middle
- `HashSet`: unique elements, fast lookup
- `TreeSet`: sorted unique
- `HashMap`: key-value fast lookup
- `TreeMap`: sorted keys

---

## 5) Exception Handling

```java
try {
    int x = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
} finally {
    System.out.println("Always runs");
}
```

Custom exception:

```java
class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) { super(msg); }
}
```

---

## 6) File I/O and NIO

### 6.1 Classic I/O

```java
import java.io.*;

try (BufferedWriter bw = new BufferedWriter(new FileWriter("note.txt"))) {
    bw.write("Hello file");
}
```

### 6.2 NIO (modern, preferred)

```java
import java.nio.file.*;
import java.util.List;

Path p = Path.of("data.txt");
Files.writeString(p, "Line 1");
String text = Files.readString(p);
List<String> lines = Files.readAllLines(p);
```

---

## 7) Generics

```java
class Box<T> {
    private T value;
    void set(T value) { this.value = value; }
    T get() { return value; }
}

Box<Integer> b = new Box<>();
b.set(10);
```

Wildcard examples:

```java
List<? extends Number> nums = List.of(1, 2, 3);
List<? super Integer> sink = new ArrayList<Number>();
```

---

## 8) Functional Programming (Lambda + Streams)

Lambda:

```java
Runnable r = () -> System.out.println("Run");
r.run();
```

Streams:

```java
import java.util.List;

List<Integer> data = List.of(1, 2, 3, 4, 5);
int sumEvenSquares = data.stream()
    .filter(x -> x % 2 == 0)
    .map(x -> x * x)
    .reduce(0, Integer::sum);
```

Common stream ops: `map`, `filter`, `sorted`, `distinct`, `limit`, `reduce`, `collect`.

---

## 9) Date/Time API (`java.time`)

```java
import java.time.*;

LocalDate today = LocalDate.now();
LocalDate nextWeek = today.plusWeeks(1);
Duration d = Duration.between(
    LocalTime.of(9, 0),
    LocalTime.of(10, 30)
);
System.out.println(d.toMinutes()); // 90
```

---

## 10) Multithreading and Concurrency (Pro Foundation)

Thread:

```java
Thread t = new Thread(() -> System.out.println("From thread"));
t.start();
```

ExecutorService:

```java
import java.util.concurrent.*;

ExecutorService pool = Executors.newFixedThreadPool(2);
Future<Integer> f = pool.submit(() -> 42);
System.out.println(f.get());
pool.shutdown();
```

Key tools:

- `synchronized`, `volatile`
- `Lock`, `ReentrantLock`
- `ConcurrentHashMap`
- `CompletableFuture`

---

## 11) Networking and HTTP

Modern HTTP client:

```java
import java.net.URI;
import java.net.http.*;

HttpClient client = HttpClient.newHttpClient();
HttpRequest req = HttpRequest.newBuilder()
    .uri(URI.create("https://api.github.com"))
    .build();
HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
System.out.println(res.statusCode());
```

---

## 12) Database Access (JDBC)

```java
import java.sql.*;

String url = "jdbc:mysql://localhost:3306/school";
try (Connection con = DriverManager.getConnection(url, "user", "pass");
     PreparedStatement ps = con.prepareStatement(
         "SELECT name FROM students WHERE id = ?")) {
    ps.setInt(1, 1);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) System.out.println(rs.getString("name"));
}
```

Use `PreparedStatement` to avoid SQL injection.

---

## 13) Important Java Language Features to Know

### 13.1 Enums

```java
enum Level { LOW, MEDIUM, HIGH }
```

### 13.2 Records (immutable data carriers)

```java
record User(String name, int age) {}
```

### 13.3 Sealed classes

```java
sealed interface Payment permits CardPayment, CashPayment {}
final class CardPayment implements Payment {}
final class CashPayment implements Payment {}
```

### 13.4 Pattern matching (`instanceof`)

```java
Object o = "hello";
if (o instanceof String s) {
    System.out.println(s.toUpperCase());
}
```

### 13.5 Optional

```java
import java.util.Optional;
Optional<String> maybe = Optional.ofNullable(null);
System.out.println(maybe.orElse("default"));
```

---

## 14) Testing

Use JUnit:

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MathTest {
    @Test
    void adds() {
        assertEquals(5, 2 + 3);
    }
}
```

Also learn:

- parameterized tests
- mocking (Mockito)
- integration tests

---

## 15) Build and Project Tools

- **Maven** or **Gradle** for dependencies/builds
- Standard project layout (`src/main/java`, `src/test/java`)
- Use `jar` for packaging
- Learn Spring Boot after core Java is solid

---

## 16) Pro-Level Topics (What Senior Java Devs Use)

1. JVM internals: heap, stack, GC (G1/ZGC), JIT
2. Performance: profiling with JFR/JMC, avoid premature optimization
3. Memory-safe coding: avoid leaks (close resources), object churn awareness
4. Concurrency correctness: race conditions, deadlocks, lock contention
5. API design: immutability, clear contracts, domain modeling
6. Security: input validation, dependency scanning, secure secrets handling
7. Architecture: layered, hexagonal, event-driven, microservices
8. Observability: logs, metrics, tracing

---

## 17) Common Beginner-to-Pro Mistakes

| Mistake                               | Better practice                                |
| ------------------------------------- | ---------------------------------------------- |
| Using `==` for strings                | Use `equals()`                                 |
| Catching broad `Exception` everywhere | Catch specific exceptions                      |
| Ignoring null handling                | Use checks / `Optional` when appropriate       |
| Huge methods/classes                  | Refactor into small focused units              |
| Mutable shared state in threads       | Prefer immutability and thread-safe structures |
| String concat in loops                | Use `StringBuilder`                            |

---

## 18) DSA + Interview-Ready Java

Focus on:

- Arrays, Strings, Hashing
- Two pointers, sliding window
- Stack, Queue, Heap (`PriorityQueue`)
- Trees, Graphs
- Recursion + Backtracking
- Dynamic Programming

Example (`PriorityQueue` min-heap):

```java
import java.util.PriorityQueue;

PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(5); pq.add(1); pq.add(3);
System.out.println(pq.poll()); // 1
```

---

## 19) Learning Path (Recommended Order)

1. Syntax + control flow + methods
2. OOP + collections + exceptions
3. Generics + streams + file I/O
4. Testing + JDBC + HTTP
5. Concurrency + JVM + architecture
6. Frameworks (Spring Boot), then system design

---

## 20) Practice Projects by Level

### Beginner

- Calculator
- Number guessing game
- Student grade manager (array/list)

### Intermediate

- To-do CLI app (file save/load)
- Library management system (OOP + collections)
- Expense tracker (CSV/JSON)

### Pro

- REST API with Spring Boot + DB
- Multithreaded file indexer
- Real-time chat backend (WebSocket)

---

## 21) Final Notes

- You do **not** need to memorize everything at once.
- Master one topic, build a project, then move forward.
- Java is huge; this guide covers the full core landscape you should know from beginner to pro.

Keep this file open while practicing and implement every example yourself.

---

## 🔗 Where to Practice What You Learn Here

Once you're comfortable with a topic from this guide, go build it out hands-on:

- **Section 18 (DSA + Interview-Ready Java)** → practice in [`DSA_Practice/`](./README.md) (this folder)
- **Section 3 (OOP Core)** and beyond → practice in [`OOP_Practice/`](../OOP_Practice/README.md)

Both tracks follow the same "concept → demo → practice problems" format this
guide uses, so the transition should feel familiar.
