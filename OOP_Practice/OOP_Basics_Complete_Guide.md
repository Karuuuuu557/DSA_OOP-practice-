# Object-Oriented Programming: The Complete Basics (Java)

---

## 1. What Is OOP, and Why Does It Exist?

Before OOP, programs were written in a **procedural** style: a list of instructions and functions that operate on data sitting somewhere else. The problem is that as programs grow, data and the functions that touch it get scattered everywhere, and it becomes hard to track what changes what.

**Object-Oriented Programming (OOP)** solves this by bundling **data** (called *fields* or *attributes*) and the **behavior** that acts on that data (called *methods*) into a single unit: an **object**.

Think of a real-world object, like a car:

- It **has** things: color, speed, fuel level (data/attributes)
- It **does** things: accelerate, brake, honk (behavior/methods)

In OOP, you model your program the same way. Instead of "a function that changes a car's speed using data passed to it," you have "a car object that knows its own speed and has a method to change it."

---

## 2. Classes vs. Objects (The Most Important Distinction)

This trips up almost every beginner, so get this rock solid first.

- A **class** is a **blueprint** or **template**. It defines what attributes and methods something will have. It does not exist "in memory" as a usable thing by itself.
- An **object** is an **instance** of that class — an actual thing built from the blueprint, sitting in memory, with its own real values.

Analogy: `Car` the class is like the *architectural blueprint* for a house. A specific object, like `myCar`, is an *actual house* built from that blueprint. You can build many houses (objects) from one blueprint (class), and each house has its own address, paint color, furniture, etc., even though they were built from the same plan.

```java
public class Car {
    // Attributes (fields) — the data every Car object will have
    String color;
    int speed;

    // Method — behavior every Car object can perform
    void accelerate() {
        speed = speed + 10;
        System.out.println("Speed is now: " + speed);
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        // Creating (instantiating) objects from the Car class
        Car myCar = new Car();
        Car friendsCar = new Car();

        myCar.color = "Red";
        myCar.speed = 0;

        friendsCar.color = "Blue";
        friendsCar.speed = 20;

        myCar.accelerate();       // Speed is now: 10
        friendsCar.accelerate();  // Speed is now: 30
    }
}
```

Notice: `myCar` and `friendsCar` are both `Car` objects, but changing one does **not** affect the other. Each object has its own copy of the fields. This is the core idea of OOP — **state lives inside the object.**

---

## 3. Fields, Methods, and the Class Body

A class is generally made up of:

| Component | What it is | Example |
|---|---|---|
| **Fields** (attributes) | Variables that hold an object's data | `int speed;` |
| **Constructors** | Special methods that set up a new object | `Car() { ... }` |
| **Methods** | Blocks of code representing behavior | `void accelerate() { ... }` |

```java
public class Student {
    // Fields
    String name;
    int age;
    double gpa;

    // Constructor
    Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    // Method
    void displayInfo() {
        System.out.println(name + " is " + age + " years old with a GPA of " + gpa);
    }
}
```

---

## 4. Constructors

A **constructor** is a special method used to initialize a new object. It:
- Has the **exact same name** as the class
- Has **no return type** (not even `void`)
- Runs automatically when you use the `new` keyword

```java
public class Student {
    String name;
    int age;

    // Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

```java
Student s1 = new Student("Carl", 19); // Constructor runs here
```

### The `this` keyword

`this` refers to "the current object." It's mainly used to distinguish between a field and a parameter that share the same name.

```java
Student(String name, int age) {
    this.name = name;  // this.name = the object's field
    this.age = age;    // age (right side) = the parameter passed in
}
```

Without `this.name = name`, Java wouldn't know if you meant the field or the parameter — it would just assign the parameter to itself and the field would stay uninitialized (`null`).

### Default Constructor

If you don't write **any** constructor, Java silently gives you an empty one for free:
```java
Student() { }
```
But the moment you write your own constructor, Java stops providing the free one. If you still want a no-argument option, you must write it yourself.

### Constructor Overloading

You can have multiple constructors with different parameter lists:

```java
public class Student {
    String name;
    int age;

    Student() {
        this.name = "Unknown";
        this.age = 0;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

```java
Student s1 = new Student();              // uses no-arg constructor
Student s2 = new Student("Carl", 19);     // uses the 2-arg constructor
```

---

## 5. The Four Pillars of OOP

Everything in OOP builds on four core principles. Memorize these — they will show up in every exam.

### Pillar 1: Encapsulation

**Definition:** Bundling data (fields) and the methods that operate on it into one unit (the class), and **restricting direct access** to that data from outside the class.

The idea: don't let outside code touch an object's fields directly. Instead, make fields `private`, and provide public methods (**getters** and **setters**) to read or change them in a controlled way.

```java
public class BankAccount {
    private double balance; // private = can't be accessed directly from outside

    // Getter — lets outside code READ the value safely
    public double getBalance() {
        return balance;
    }

    // Setter — lets outside code CHANGE the value, but with control/validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
        }
    }
}
```

Without encapsulation, someone could write `account.balance = -500;` directly and break your program's logic. With encapsulation, the only way to change `balance` is through `deposit()` or `withdraw()`, which enforce rules.

**Why it matters:** protects data integrity, hides internal implementation details, and lets you change the internal logic later without breaking code that uses the class.

---

### Pillar 2: Abstraction

**Definition:** Hiding complex implementation details and showing only the essential features of an object.

Think of driving a car: you press the accelerator pedal, but you don't need to know how fuel injection or combustion works internally. The complexity is hidden behind a simple interface (the pedal).

In Java, abstraction is achieved through **abstract classes** and **interfaces** (see Section 7).

```java
abstract class Shape {
    abstract double calculateArea(); // no body — just a contract
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}
```

The user of `Circle` just calls `calculateArea()` — they don't need to know or care about the math formula hidden inside.

**Encapsulation vs. Abstraction (common confusion):**
- **Encapsulation** = hiding the *data* (protecting fields with private + getters/setters)
- **Abstraction** = hiding the *complexity/implementation* (showing only what's necessary, hiding how it's done)

---

### Pillar 3: Inheritance

**Definition:** A mechanism where one class (**child/subclass**) acquires the fields and methods of another class (**parent/superclass**), allowing code reuse and hierarchical relationships.

Keyword: `extends`

```java
// Parent class
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + " is eating.");
    }
}

// Child class inherits from Animal
class Dog extends Animal {
    Dog(String name) {
        super(name); // calls the parent class's constructor
    }

    void bark() {
        System.out.println(name + " says Woof!");
    }
}
```

```java
Dog myDog = new Dog("Rex");
myDog.eat();   // inherited from Animal: "Rex is eating."
myDog.bark();  // defined in Dog: "Rex says Woof!"
```

`Dog` automatically has access to everything `Animal` has (like `name` and `eat()`), plus its own additional method `bark()`.

### The `super` keyword

`super` refers to the parent class. It's used to:
1. Call the parent's constructor: `super(name);`
2. Call a parent's method that was overridden: `super.eat();`

### Why use inheritance?
- Avoids rewriting the same code in multiple classes
- Models real "is-a" relationships: a Dog **is an** Animal, a Car **is a** Vehicle
- Makes code easier to extend and maintain

### Single Inheritance Only
Java does **not** allow a class to extend more than one class (no `class C extends A, B`). This avoids ambiguity. If you need "multiple inheritance"-like behavior, Java uses **interfaces** instead (Section 7).

---

### Pillar 4: Polymorphism

**Definition:** "Poly" = many, "morph" = forms. The ability for an object, method, or reference to take on many forms — meaning the same method name can behave differently depending on the object or inputs.

There are two types:

#### A) Compile-time Polymorphism (Method Overloading)
Multiple methods in the **same class** with the **same name** but **different parameters** (different number or type of arguments).

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

```java
Calculator calc = new Calculator();
calc.add(2, 3);          // uses int version -> 5
calc.add(2.5, 3.5);      // uses double version -> 6.0
calc.add(1, 2, 3);       // uses 3-parameter version -> 6
```

Java decides which version to run **at compile time**, based on the arguments you pass. This is why it's called compile-time polymorphism.

#### B) Runtime Polymorphism (Method Overriding)
A child class provides its **own specific implementation** of a method that's already defined in its parent class. The method must have the **same name, same parameters, and same return type**.

```java
class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow!");
    }
}
```

```java
Animal myAnimal;

myAnimal = new Dog();
myAnimal.makeSound(); // Woof!

myAnimal = new Cat();
myAnimal.makeSound(); // Meow!
```

Even though `myAnimal` is declared as type `Animal`, Java figures out **at runtime** which actual object it is (`Dog` or `Cat`) and calls the correct overridden version. This is why it's called runtime polymorphism.

**Overloading vs. Overriding (very common exam question):**

| | Overloading | Overriding |
|---|---|---|
| Location | Same class | Parent-child classes |
| Parameters | Must be different | Must be exactly the same |
| Return type | Can differ | Must be same (or covariant) |
| Decided | Compile time | Runtime |
| Purpose | Same action, different inputs | Redefine inherited behavior |

The `@Override` annotation isn't strictly required, but it's best practice — it tells the compiler "I intend to override a parent method," and it will throw an error if you made a typo (e.g., wrong parameter types), catching mistakes early.

---

## 6. Access Modifiers

Access modifiers control **who can see/use** a field, method, or class. This is what makes encapsulation actually enforceable.

| Modifier | Same Class | Same Package | Subclass (different package) | Everywhere |
|---|---|---|---|---|
| `private` | ✅ | ❌ | ❌ | ❌ |
| *(default, no modifier)* | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

```java
public class Example {
    private int secret;       // only visible inside this class
    protected int forFamily;  // visible to subclasses too
    public int forEveryone;   // visible anywhere
    int packageOnly;          // default — visible only within the same package
}
```

**Best practice in OOP:** make fields `private`, and expose them (if needed) through `public` getters/setters. This is the concrete mechanism behind encapsulation.

---

## 7. Abstract Classes vs. Interfaces

Both are tools for abstraction, but they're used differently.

### Abstract Class
- Declared with `abstract class`
- Can have **both** abstract methods (no body) and regular methods (with body)
- Can have fields (including non-static, non-final ones)
- A class can extend **only one** abstract class (single inheritance rule still applies)
- Use when classes share a **close, related identity** (e.g., `Dog` and `Cat` are both clearly `Animal`s)

```java
abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void makeSound(); // must be implemented by subclasses

    void sleep() { // regular method, shared as-is
        System.out.println(name + " is sleeping.");
    }
}
```

You **cannot** do `new Animal("Generic")` — abstract classes can't be instantiated directly. They exist only to be extended.

### Interface
- Declared with `interface`
- Traditionally, all methods were abstract (no body) — a pure "contract" of what a class must do
- (Modern Java allows `default` and `static` methods with bodies too, but the core idea remains: a contract)
- A class can implement **multiple** interfaces (this is how Java gets around single inheritance)
- Use when unrelated classes need to share a **capability**, not an identity

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck is flying.");
    }

    public void swim() {
        System.out.println("Duck is swimming.");
    }
}
```

A `Duck` isn't related to a `Bird` class or a `Fish` class by inheritance — it just happens to be capable of both flying and swimming. Interfaces model "can-do" relationships, while inheritance models "is-a" relationships.

**Quick decision guide:**
- "Is a" relationship + shared code → **abstract class**
- "Can do" capability, possibly shared across unrelated classes → **interface**

---

## 8. Static vs. Instance (Non-Static)

This confuses almost everyone at first, so let's be precise.

- **Instance members** (fields/methods without `static`) belong to **each individual object**. Every object gets its own separate copy.
- **Static members** belong to the **class itself**, shared by **all** objects. There's only ever one copy, no matter how many objects exist.

```java
class Counter {
    static int totalCounters = 0; // shared across ALL objects
    int id;                        // unique to EACH object

    Counter() {
        totalCounters++;   // increments the one shared copy
        id = totalCounters; // this object's own id
    }
}
```

```java
Counter c1 = new Counter(); // totalCounters = 1, c1.id = 1
Counter c2 = new Counter(); // totalCounters = 2, c2.id = 2
Counter c3 = new Counter(); // totalCounters = 3, c3.id = 3

System.out.println(Counter.totalCounters); // 3 — accessed via the CLASS, not an object
```

Notice `totalCounters` is accessed as `Counter.totalCounters` (through the class), while `id` is accessed as `c1.id` (through the specific object), because `id` is different for each one.

**Rule of thumb:**
- If the value should be the *same* for every object, or doesn't depend on any specific object's data → make it `static`.
- If the value is *specific to that one object* → keep it non-static (instance).

`main()` itself is `static` — that's why you can run it without creating an object of your class first; Java just calls it directly on the class.

---

## 9. Packages

A **package** is just a folder/namespace used to organize related classes and avoid naming conflicts.

```java
package com.umak.attendance;

public class Student {
    // ...
}
```

To use a class from another package, you `import` it:
```java
import com.umak.attendance.Student;
```

---

## 10. Putting It All Together — A Full Example

```java
package school;

// Abstraction: define a contract all "Person" types must follow via an abstract class
abstract class Person {
    // Encapsulation: private fields, controlled access
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters (encapsulation)
    public String getName() { return name; }
    public int getAge() { return age; }

    // Abstract method — forces subclasses to define their own version
    abstract void introduce();
}

// Inheritance: Student "is a" Person
class Student extends Person {
    private double gpa;

    public Student(String name, int age, double gpa) {
        super(name, age); // calls Person's constructor
        this.gpa = gpa;
    }

    // Polymorphism: overriding the abstract method
    @Override
    void introduce() {
        System.out.println("Hi, I'm " + getName() + ", age " + getAge() + ", GPA: " + gpa);
    }
}

// Another subclass, same parent
class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    void introduce() {
        System.out.println("Hello, I'm " + getName() + ", age " + getAge() + ", and I teach " + subject);
    }
}

public class Main {
    public static void main(String[] args) {
        // Polymorphism: array of Person references holding different actual object types
        Person[] people = new Person[2];
        people[0] = new Student("Carl", 19, 3.8);
        people[1] = new Teacher("Prof. Santos", 45, "Computer Science");

        // Runtime polymorphism: each calls its own version of introduce()
        for (Person p : people) {
            p.introduce();
        }
    }
}
```

Output:
```
Hi, I'm Carl, age 19, GPA: 3.8
Hello, I'm Prof. Santos, age 45, and I teach Computer Science
```

This one example demonstrates all four pillars working together:
- **Encapsulation** — private fields with public getters
- **Abstraction** — `Person` is abstract; you never create a raw `Person`, only specific types
- **Inheritance** — `Student` and `Teacher` both extend `Person`
- **Polymorphism** — a `Person[]` array holds different object types, and calling `introduce()` runs the correct version for each

---

## 11. Key Vocabulary Cheat Sheet

| Term | Meaning |
|---|---|
| Class | Blueprint/template for creating objects |
| Object | An instance of a class, existing in memory |
| Field / Attribute | A variable inside a class representing data |
| Method | A function inside a class representing behavior |
| Constructor | Special method that initializes a new object |
| `this` | Refers to the current object |
| `super` | Refers to the parent class |
| Encapsulation | Hiding data, exposing controlled access via getters/setters |
| Abstraction | Hiding implementation complexity, showing only essentials |
| Inheritance | A class acquiring fields/methods from a parent class |
| Polymorphism | Same method name behaving differently (overloading/overriding) |
| Overloading | Same method name, different parameters, same class |
| Overriding | Subclass redefines a parent's method, same signature |
| Abstract class | Cannot be instantiated; may mix abstract + concrete methods |
| Interface | A pure contract of behavior; a class can implement many |
| `private` | Accessible only within the same class |
| `protected` | Accessible within package + subclasses |
| `public` | Accessible from anywhere |
| `static` | Belongs to the class, shared by all objects |
| Instance member | Belongs to each individual object separately |

---

## 12. Common Beginner Mistakes to Avoid

1. **Forgetting `this`** when a constructor parameter has the same name as a field — leads to fields staying `null`/`0`.
2. **Making all fields `public`** — defeats the purpose of encapsulation. Default to `private` + getters/setters.
3. **Confusing overloading and overriding** — overloading is same class/different parameters; overriding is parent-child/same signature.
4. **Trying to instantiate an abstract class** — `new Animal()` where `Animal` is abstract will not compile.
5. **Forgetting `extends` vs `implements`** — a class `extends` another class, but `implements` an interface.
6. **Thinking static fields belong to each object** — they don't; there's only one shared copy per class.
7. **Not calling `super()`** in a child constructor when the parent doesn't have a no-argument constructor — this causes a compile error.

---

You now have the full foundation: classes, objects, constructors, the four pillars (encapsulation, abstraction, inheritance, polymorphism), access modifiers, abstract classes vs. interfaces, and static vs. instance. Everything else in OOP (design patterns, SOLID principles, more advanced Java features) builds directly on top of these concepts.
