# 📚 DSA Practice — Data Structures & Algorithms in Java

> [!NOTE]
> A step-by-step learning journey through Data Structures & Algorithms, from beginner to exam-ready.
> **Language:** Java · **Focus:** Academic foundations & exam preparation
> Part of the [`DSA_OOP-practice`](../README.md) repo — see the root README for the OOP track.

---

## 📑 Table of Contents

- [Repository Structure](#-repository-structure)
- [Learning Phases](#-learning-phases)
- [How to Compile & Run](#️-how-to-compile--run)
- [How Each File is Structured](#-how-each-file-is-structured)
- [How to Study](#-how-to-study)
- [Progress Tracker](#-progress-tracker)
- [Topics Covered](#-topics-covered)

---

## 📂 Repository Structure

```
DSA_Practice/
├── README.md                           ← You are here
├── START_HERE_Java_Starter_Guide.md    — Read this first if Java itself is new to you
├── 01_Basics/
│   ├── ArraysDemo.java                 — Traversal, search, insert, delete, reverse
│   ├── StringsDemo.java                — String manipulation, palindrome, frequency
│   └── BitManipulationDemo.java        — Bitwise operators, tricks, Kernighan's
├── 02_Math_Recursion/
│   ├── RecursionDemo.java              — Factorial, Fibonacci, power
│   ├── MathPrimeGCD.java               — Prime checking, GCD/LCM
│   └── SortingBasicsDemo.java          — Bubble, selection, insertion sort
├── 03_Linear_DS/
│   ├── LinkedListDemo.java             — Singly linked list operations
│   ├── StackDemo.java                  — Stack (array & node based)
│   ├── QueueDemo.java                  — Queue (array & node based)
│   └── DequeDemo.java                  — Double-ended queue
├── 04_Hashing/
│   ├── HashTableDemo.java              — Hash map, collision handling
│   └── TwoPointersDemo.java            — Two pointer technique
├── 05_Trees/
│   ├── BinaryTreeDemo.java             — Tree traversals (4 types)
│   ├── BinarySearchTreeDemo.java       — BST insert, search, delete
│   └── HeapPriorityQueueDemo.java      — Min/Max heap, priority queue
├── 06_Graphs/
│   ├── GraphRepresentation.java        — Adjacency matrix & list
│   ├── BFSDemo.java                    — Breadth-first & Depth-first search
│   └── DijkstraDemo.java               — Dijkstra's shortest path
├── 07_Algorithms/
│   ├── MergeQuickSortDemo.java         — Merge sort & Quick sort
│   ├── BinarySearchDemo.java           — Binary search & variants
│   └── GreedyDPBasicsDemo.java         — Greedy & Dynamic programming intro
└── My_Outputs/                         — Your own assignment work & practice attempts
```

---

## 📋 Learning Phases

| Phase | Folder | Topics | Status |
|:-----:|--------|--------|:------:|
| **1** | `01_Basics` | Arrays, Strings, Bit Manipulation | ✅ Ready |
| **2** | `02_Math_Recursion` | Recursion, Prime, GCD, Basic Sorting | 🔜 Upcoming |
| **3** | `03_Linear_DS` | Linked List, Stack, Queue, Deque | 🔜 Upcoming |
| **4** | `04_Hashing` | Hash Tables, Two Pointers | 🔜 Upcoming |
| **5** | `05_Trees` | Binary Trees, BST, Heaps | 🔜 Upcoming |
| **6** | `06_Graphs` | BFS/DFS, Graph Representation, Shortest Path | 🔜 Upcoming |
| **7** | `07_Algorithms` | Merge/Quick Sort, Binary Search, Greedy/DP | 🔜 Upcoming |

> ✅ Ready = files exist and are ready to study. It doesn't mean you've finished them —
> use the [Progress Tracker](#-progress-tracker) below to track your own completion.

---

## ⚙️ How to Compile & Run

### Prerequisites
- **Java JDK** (8 or higher)

### Run one file
```bash
cd 01_Basics
javac ArraysDemo.java
java ArraysDemo
```

### Compile all files in a folder
```bash
cd 01_Basics
javac *.java
java ArraysDemo
```

---

## 📖 How Each File is Structured

Every `.java` file follows this format:

```
┌─────────────────────────────────────┐
│  CONCEPT EXPLANATION (top comments)  │  ← Read this first
├─────────────────────────────────────┤
│  import statements                  │
├─────────────────────────────────────┤
│  Helper methods                     │
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
3. **Read** the code line by line — understand HOW it works
4. **Try** the practice problems at the bottom of each file
5. **Save your attempts** in `My_Outputs/` so your own work stays separate from the demo files
6. **Ask** for help when stuck — no shame in that!
7. **Move** to the next topic when comfortable

---

## 📝 Progress Tracker

> Check off topics as you complete them.

### Phase 1 — Basics
- [ ] `ArraysDemo.java` — traversal, search, insert, delete, reverse
- [ ] `StringsDemo.java` — reverse, palindrome, frequency, tokenize
- [ ] `BitManipulationDemo.java` — AND/OR/XOR, tricks, Kernighan's

### Phase 2 — Math & Recursion
- [ ] `RecursionDemo.java` — factorial, Fibonacci, power
- [ ] `MathPrimeGCD.java` — prime checking, GCD/LCM
- [ ] `SortingBasicsDemo.java` — bubble, selection, insertion sort

### Phase 3 — Linear Data Structures
- [ ] `LinkedListDemo.java` — create, traverse, insert, delete
- [ ] `StackDemo.java` — array & node based implementation
- [ ] `QueueDemo.java` — array & node based implementation
- [ ] `DequeDemo.java` — double-ended queue

### Phase 4 — Hashing
- [ ] `HashTableDemo.java` — hash map, collision handling
- [ ] `TwoPointersDemo.java` — two pointer technique

### Phase 5 — Trees
- [ ] `BinaryTreeDemo.java` — 4 traversal methods
- [ ] `BinarySearchTreeDemo.java` — insert, search, delete
- [ ] `HeapPriorityQueueDemo.java` — min/max heap, priority queue

### Phase 6 — Graphs
- [ ] `GraphRepresentation.java` — adjacency matrix & list
- [ ] `BFSDemo.java` — breadth-first & depth-first search
- [ ] `DijkstraDemo.java` — shortest path algorithm

### Phase 7 — Algorithms
- [ ] `MergeQuickSortDemo.java` — merge sort & quick sort
- [ ] `BinarySearchDemo.java` — binary search & variants
- [ ] `GreedyDPBasicsDemo.java` — greedy & dynamic programming basics

---

## 📌 Topics Covered

| Category | Topics |
|----------|--------|
| **Arrays** | Traversal, linear search, insertion, deletion, max/min/sum, reversing |
| **Strings** | Concatenation, substring, reversing, palindrome, frequency counting, tokenizing |
| **Bit Manipulation** | AND, OR, XOR, NOT, shifts, set/toggle/clear bits, Kernighan's algorithm |
| **Recursion** *(upcoming)* | Base cases, call stack, factorial, Fibonacci, power |
| **Math** *(upcoming)* | Prime numbers, GCD/LCM |
| **Sorting** *(upcoming)* | Bubble, selection, insertion, merge, quick sort |
| **Linked Lists** *(upcoming)* | Nodes, pointers, traverse, insert, delete |
| **Stack/Queue** *(upcoming)* | LIFO/FIFO, array & pointer implementations |
| **Hashing** *(upcoming)* | Hash maps, collision handling, two pointers |
| **Trees** *(upcoming)* | Traversals, BST, heaps |
| **Graphs** *(upcoming)* | Representation, BFS, DFS, Dijkstra |
| **Algorithms** *(upcoming)* | Binary search, greedy, dynamic programming |

> 💡 Not covered yet but worth adding later: **Backtracking**, **Tries**,
> **Union-Find / Disjoint Set**, and **Minimum Spanning Tree / Topological Sort**
> in the Graphs phase. These show up often in exams and coding interviews.

---

<p align="center">
  <em>Built for learning Data Structures & Algorithms from scratch.</em><br>
  <strong>Java edition</strong>
</p>
