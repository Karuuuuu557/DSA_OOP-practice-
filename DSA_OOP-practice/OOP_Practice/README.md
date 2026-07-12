# 📚 OOP Practice — Object-Oriented Programming in Java

> [!NOTE]
> A companion to `DSA_Practice`, structured the same way.
> **Language:** Java · **Focus:** OOP fundamentals through design patterns & SOLID

---

## 📂 Repository Structure

```
OOP_Practice/
├── README.md                                  ← You are here
├── 01_Fundamentals/
│   ├── ClassesObjectsDemo.java                — Classes, objects, fields, methods, `this`
│   ├── ConstructorsDemo.java                  — Default/parameterized constructors, overloading
│   └── EncapsulationDemo.java                 — Access modifiers, getters/setters, data hiding
├── 02_Inheritance/
│   ├── InheritanceBasicsDemo.java             — extends, super, single/multilevel inheritance
│   └── MethodOverridingDemo.java              — @Override, super calls, constructor chaining
├── 03_Polymorphism/
│   ├── CompileTimePolymorphismDemo.java       — Method overloading
│   └── RuntimePolymorphismDemo.java           — Method overriding, dynamic dispatch, upcasting
├── 04_Abstraction/
│   ├── AbstractClassDemo.java                 — abstract classes & methods
│   └── InterfaceDemo.java                     — interfaces, multiple inheritance of type, default methods
├── 05_SOLID_Principles/
│   ├── SingleResponsibilityDemo.java          — SRP: one reason to change
│   ├── OpenClosedDemo.java                    — OCP: open for extension, closed for modification
│   ├── LiskovSubstitutionDemo.java            — LSP: subtypes must be substitutable
│   ├── InterfaceSegregationDemo.java          — ISP: no fat interfaces
│   └── DependencyInversionDemo.java           — DIP: depend on abstractions, not concretions
├── 06_Design_Patterns/
│   ├── SingletonPatternDemo.java              — One instance, global access point
│   ├── FactoryPatternDemo.java                — Object creation without exposing logic
│   ├── BuilderPatternDemo.java                — Step-by-step object construction
│   ├── ObserverPatternDemo.java                — Publish/subscribe, event notification
│   └── StrategyPatternDemo.java               — Interchangeable algorithms at runtime
└── 07_Capstone/
    └── LibrarySystemProject.java              — Mini project combining everything above
```

---

## 📋 Learning Phases

| Phase | Folder | Topics | Status |
|:-----:|--------|--------|:------:|
| **1** | `01_Fundamentals` | Classes, Objects, Constructors, Encapsulation | ✅ Ready |
| **2** | `02_Inheritance` | extends, super, overriding, constructor chaining | 🔜 Upcoming |
| **3** | `03_Polymorphism` | Overloading vs overriding, dynamic dispatch | 🔜 Upcoming |
| **4** | `04_Abstraction` | Abstract classes, interfaces | 🔜 Upcoming |
| **5** | `05_SOLID_Principles` | SRP, OCP, LSP, ISP, DIP | 🔜 Upcoming |
| **6** | `06_Design_Patterns` | Singleton, Factory, Builder, Observer, Strategy | 🔜 Upcoming |
| **7** | `07_Capstone` | Mini project tying it all together | 🔜 Upcoming |

---

## ⚙️ How to Compile & Run

### Prerequisites
- **Java JDK** (8 or higher)

### Run one file
```bash
cd 01_Fundamentals
javac ClassesObjectsDemo.java
java ClassesObjectsDemo
```

### Compile all files in a folder
```bash
cd 01_Fundamentals
javac *.java
java ClassesObjectsDemo
```

---

## 📖 How Each File is Structured

Every `.java` file follows the same format as your DSA_Practice files:

```
┌─────────────────────────────────────┐
│  CONCEPT EXPLANATION (top comments)  │  ← Read this first
├─────────────────────────────────────┤
│  Supporting classes                 │
├─────────────────────────────────────┤
│  demonstrateTopic() methods         │  ← Run these to see examples
├─────────────────────────────────────┤
│  main() — calls all demonstrations  │
├─────────────────────────────────────┤
│  PRACTICE PROBLEMS (bottom comments)│  ← Solve these on your own!
└─────────────────────────────────────┘
```

## 🚀 How to Study

1. **Read** the concept explanation at the top of each file
2. **Compile & Run** the file to see the demonstrations
3. **Read** the code line by line — understand HOW and WHY, not just what
4. **Try** the practice problems at the bottom of each file
5. **Ask** for help when stuck — no shame in that!
6. **Move** to the next topic when comfortable

---

## 📝 Progress Tracker

### Phase 1 — Fundamentals
- [ ] `ClassesObjectsDemo.java` — classes, objects, fields, methods, `this`
- [ ] `ConstructorsDemo.java` — default/parameterized constructors, overloading
- [ ] `EncapsulationDemo.java` — access modifiers, getters/setters, data hiding

### Phase 2 — Inheritance
- [ ] `InheritanceBasicsDemo.java` — extends, super, single/multilevel inheritance
- [ ] `MethodOverridingDemo.java` — @Override, super calls, constructor chaining

### Phase 3 — Polymorphism
- [ ] `CompileTimePolymorphismDemo.java` — method overloading
- [ ] `RuntimePolymorphismDemo.java` — method overriding, dynamic dispatch

### Phase 4 — Abstraction
- [ ] `AbstractClassDemo.java` — abstract classes & methods
- [ ] `InterfaceDemo.java` — interfaces, default methods

### Phase 5 — SOLID Principles
- [ ] `SingleResponsibilityDemo.java`
- [ ] `OpenClosedDemo.java`
- [ ] `LiskovSubstitutionDemo.java`
- [ ] `InterfaceSegregationDemo.java`
- [ ] `DependencyInversionDemo.java`

### Phase 6 — Design Patterns
- [ ] `SingletonPatternDemo.java`
- [ ] `FactoryPatternDemo.java`
- [ ] `BuilderPatternDemo.java`
- [ ] `ObserverPatternDemo.java`
- [ ] `StrategyPatternDemo.java`

### Phase 7 — Capstone
- [ ] `LibrarySystemProject.java` — combines inheritance, polymorphism, abstraction, and at least 2 patterns

---

## 📌 Topics Covered

| Category | Topics |
|----------|--------|
| **Fundamentals** | Classes, objects, fields, methods, constructors, overloading, `this` |
| **Encapsulation** | Access modifiers, getters/setters, data hiding, immutability |
| **Inheritance** *(upcoming)* | extends, super, single/multilevel inheritance, constructor chaining |
| **Polymorphism** *(upcoming)* | Overloading, overriding, dynamic dispatch, upcasting/downcasting |
| **Abstraction** *(upcoming)* | Abstract classes, interfaces, default methods |
| **SOLID** *(upcoming)* | SRP, OCP, LSP, ISP, DIP |
| **Design Patterns** *(upcoming)* | Singleton, Factory, Builder, Observer, Strategy |
| **Capstone** *(upcoming)* | A mini project applying everything together |

---

<p align="center">
  <em>Built for learning Object-Oriented Programming from scratch.</em><br>
  <strong>Java edition</strong>
</p>
