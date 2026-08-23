# C# OOP — Object-Oriented Programming in C# (Game-Project Edition)

> A companion to `JAVA_OOP`, structured the same way but translated to **C#** and themed around **real-world game development** so you can build up to your final OOP game project step by step.

**Language:** C# · **Goal:** Master OOP fundamentals + prepare to build a C# game.

---

## Why C# and Why Games?

Your final OOP project is to build a game in C#. Every example in this folder is built around **game concepts** (Player, Enemy, Damage, Quest, Inventory) so that by the time you finish Phase 7 you will have already designed the skeleton of a small RPG. The Java version teaches OOP in general; this C# version teaches OOP *and* C# syntax *and* game architecture.

---

## Repository Structure

```
C#_OOP/
├── README.md                                   ← You are here
├── 01_Fundamentals/
│   ├── ClassesObjectsDemo.cs                   — classes, objects, fields, methods, `this`, static vs instance
│   ├── ConstructorsDemo.cs                     — default/parameterized constructors, overloading, chaining (`this(...)` syntax)
│   └── EncapsulationDemo.cs                    — access modifiers, properties (C# get/set), data hiding
├── 02_Inheritance/
│   ├── InheritanceBasicsDemo.cs                — `: base(...)`, single/multi-level inheritance
│   └── MethodOverridingDemo.cs                 — `virtual` / `override` / `sealed`, `base.MethodName()`
├── 03_Polymorphism/
│   ├── CompileTimePolymorphismDemo.cs          — method overloading, optional params, `params`
│   └── RuntimePolymorphismDemo.cs              — upcasting, dynamic dispatch, `is` / `as` patterns
├── 04_Abstraction/
│   ├── AbstractClassDemo.cs                    — abstract classes & methods
│   └── InterfaceDemo.cs                        — interfaces, multiple implementation, interface inheritance
├── 05_SOLID_Principles/
│   ├── SingleResponsibilityDemo.cs            — SRP: one class, one reason to change
│   ├── OpenClosedDemo.cs                       — OCP: extend, don't modify
│   ├── LiskovSubstitutionDemo.cs               — LSP: subtypes must be substitutable
│   ├── InterfaceSegregationDemo.cs             — ISP: small focused interfaces
│   └── DependencyInversionDemo.cs              — DIP: depend on abstractions, not concretions
├── 06_Design_Patterns/
│   ├── SingletonPatternDemo.cs                 — One instance, global access (GameManager)
│   ├── FactoryPatternDemo.cs                   — Create objects without exposing logic (EnemyFactory, LootFactory)
│   ├── BuilderPatternDemo.cs                   — Fluent step-by-step construction (CharacterBuilder)
│   ├── ObserverPatternDemo.cs                  — Events / publish-subscribe (player health → UI / sound / save)
│   └── StrategyPatternDemo.cs                  — Swappable algorithms at runtime (DamageStrategy)
└── 07_Capstone/
    └── TextRPGProject.cs                       — Full mini RPG combining all 6 phases + all 5 patterns
```

---

## C# vs Java — What You Need To Know Up Front

| Concept | Java | C# |
|---|---|---|
| Class inheritance | `class Dog extends Animal` | `class Dog : Animal` |
| Interface implementation | `class Duck implements Flyable` | `class Duck : IFlyable` |
| Call parent constructor | `super(...)` (first line of body) | `: base(...)` (in constructor header) |
| Call parent method | `super.method()` | `base.method()` |
| Constructor chaining | `this(...)` (first line) | `: this(...)` (header) |
| Default methods in interface | `default void foo() { }` | `void foo() { }` (C# 8+) |
| Virtual by default? | Yes | No — must mark `virtual` and `override` |
| Properties | getX/setX methods | `public int X { get; set; }` |
| Strings | `"hello"` | `$"Hello {name}"` (interpolation) |
| Print | `System.out.println(...)` | `Console.WriteLine(...)` |
| File names | Must match public class name | Free — any name works |
| Top-level statements | Not in classic Java | Yes (C# 9+); we still use `Main` for consistency |

You do **not** need to memorize this table — each file's header calls out the differences you actually need for that topic.

---

## How to Compile & Run

### Option A — `dotnet` (recommended)

From the `C#_OOP` folder, create a console project for each demo:

```bash
cd 01_Fundamentals
dotnet new console -n DemoRunner
mv DemoRunner/Program.cs ClassesObjectsDemo.cs   # use the file as-is
# Or simpler: just rename the class Main matches the file
dotnet run
```

Easiest one-shot:

```bash
cd 01_Fundamentals
dotnet script ClassesObjectsDemo.cs   # requires `dotnet-script` global tool
```

### Option B — Visual Studio / Rider / VS Code

1. Open the `C#_OOP` folder.
2. Right-click any `.cs` file → *Run* or *Execute*.
3. Or create a console project per phase and add the file to it.

### Option C — `.csx` (C# scripting)

```bash
dotnet tool install -g dotnet-script
dotnet script 01_Fundamentals/ClassesObjectsDemo.cs
```

---

## How Each File Is Structured

Every `.cs` file follows the same format as the Java folder:

```
┌─────────────────────────────────────┐
│  CONCEPT EXPLANATION (top comments)  │  ← Read this first
├─────────────────────────────────────┤
│  Supporting classes                 │
├─────────────────────────────────────┤
│  demonstrate*() methods             │  ← Run these to see examples
├─────────────────────────────────────┤
│  Main() — calls all demonstrations  │
├─────────────────────────────────────┤
│  PRACTICE PROBLEMS (bottom comments)│  ← Solve these on your own!
└─────────────────────────────────────┘
```

---

## How to Study

1. **Read** the concept explanation at the top of each file.
2. **Run** the file and observe the output.
3. **Read** the code line by line — understand HOW and WHY.
4. **Solve** the practice problems at the bottom before moving on.
5. **Compare** with the matching Java file in `JAVA_OOP` to lock in the syntax differences.
6. **Experiment**: tweak values, add new enemy types, add new actions — see what changes and what doesn't (OCP in action).

---

## Learning Phases

| Phase | Folder | Topics | Status |
|:-----:|--------|--------|:------:|
| **1** | `01_Fundamentals` | Classes, Objects, Constructors, Encapsulation (C# properties) | ✅ Ready |
| **2** | `02_Inheritance` | `: base(...)`, virtual/override, sealed, constructor chain | ✅ Ready |
| **3** | `03_Polymorphism` | Overloading, overriding, dynamic dispatch, `is`/`as` | ✅ Ready |
| **4** | `04_Abstraction` | Abstract classes, interfaces, multiple implementation | ✅ Ready |
| **5** | `05_SOLID_Principles` | SRP, OCP, LSP, ISP, DIP | ✅ Ready |
| **6** | `06_Design_Patterns` | Singleton, Factory, Builder, Observer, Strategy | ✅ Ready |
| **7** | `07_Capstone` | Text RPG combining everything | ✅ Ready |

---

## Progress Tracker

### Phase 1 — Fundamentals
- [ ] `ClassesObjectsDemo.cs` — classes, objects, fields, methods, `this`
- [ ] `ConstructorsDemo.cs` — constructors, overloading, `: this(...)` chaining
- [ ] `EncapsulationDemo.cs` — `private`, properties, validation, immutability

### Phase 2 — Inheritance
- [ ] `InheritanceBasicsDemo.cs` — `: base(...)`, multi-level, `protected`
- [ ] `MethodOverridingDemo.cs` — `virtual`/`override`/`sealed`, `base.MethodName()`

### Phase 3 — Polymorphism
- [ ] `CompileTimePolymorphismDemo.cs` — overloading, `params`, optional parameters
- [ ] `RuntimePolymorphismDemo.cs` — dynamic dispatch, upcasting, `is`/`as`

### Phase 4 — Abstraction
- [ ] `AbstractClassDemo.cs` — abstract classes
- [ ] `InterfaceDemo.cs` — interfaces, multiple implementation, interface inheritance

### Phase 5 — SOLID
- [ ] `SingleResponsibilityDemo.cs`
- [ ] `OpenClosedDemo.cs`
- [ ] `LiskovSubstitutionDemo.cs`
- [ ] `InterfaceSegregationDemo.cs`
- [ ] `DependencyInversionDemo.cs`

### Phase 6 — Design Patterns
- [ ] `SingletonPatternDemo.cs`
- [ ] `FactoryPatternDemo.cs`
- [ ] `BuilderPatternDemo.cs`
- [ ] `ObserverPatternDemo.cs`
- [ ] `StrategyPatternDemo.cs`

### Phase 7 — Capstone
- [ ] `TextRPGProject.cs` — combines inheritance, polymorphism, abstraction, all 5 SOLID principles, all 5 patterns

---

## Critical-Thinking Prompts (for your final project)

After each phase, ask yourself:

- **Which SOLID principle is most relevant to the game design I'm picturing?**
- **If I add a new enemy type, how many files will I need to edit? (Lower = better OCP.)**
- **Where could I inject a fake IDataStore for testing instead of touching disk?**
- **If I change my damage formula, which classes need to change? (Strategy helps here.)**
- **If two things both want to react to "player HP changed", how do I avoid coupling them to each other? (Observer helps here.)**

These are exactly the questions you'll face when designing your final game project.

---

<p align="center">
  <em>Built for learning Object-Oriented Programming in C# from scratch — with a game at the end.</em><br>
  <strong>C# edition · game-project focused</strong>
</p>
