# Java Complete Learning Guide (Beginner → Intermediate → Pro)

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

**Beginner**

- Calculator
- Number guessing game
- Student grade manager (array/list)

**Intermediate**

- To-do CLI app (file save/load)
- Library management system (OOP + collections)
- Expense tracker (CSV/JSON)

**Pro**

- REST API with Spring Boot + DB
- Multithreaded file indexer
- Real-time chat backend (WebSocket)

---

## 21) Final Notes

- You do **not** need to memorize everything at once.
- Master one topic, build a project, then move forward.
- Java is huge; this guide covers the full core landscape you should know from beginner to pro.

Keep this file open while practicing and implement every example yourself.
