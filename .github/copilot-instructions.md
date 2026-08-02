# Copilot Instructions for `DSA_OOP-practice`

## Build, run, and validation commands

This repository is plain Java source files (no Maven/Gradle wrapper in repo root). Use `javac` and `java` directly from the folder containing the target file.

```bash
# Run a single DSA demo file
cd DSA_Practice/01_Basics
javac ArraysDemo.java
java ArraysDemo
```

```bash
# Run a single OOP demo file
cd OOP_Practice/01_Fundamentals
javac ClassesObjectsDemo.java
java ClassesObjectsDemo
```

```bash
# Compile all files in one topic folder, then run one class
cd OOP_Practice/01_Fundamentals
javac *.java
java ClassesObjectsDemo
```

For this repo, “single test” effectively means “run one standalone demo class,” since files are educational demos with `main()` methods rather than a test framework.

## High-level architecture

The repository is intentionally split into two parallel learning tracks:

1. `DSA_Practice/` — algorithm and data-structure progression (`01_Basics` through `07_Algorithms`).
2. `OOP_Practice/` — OOP progression (`01_Fundamentals` through `07_Capstone`).

Each track is phase-based and each phase contains standalone demo classes. The architectural unit is **one concept per file**, executed independently via `main()`, rather than shared library modules.

Within files, content follows an educational flow:

1. Top-of-file concept explanation comments.
2. Demo/support classes and helper methods.
3. `demonstrate...()` methods and `main()` orchestration.
4. Bottom-of-file practice prompts.

The capstone (`OOP_Practice/07_Capstone/LibrarySystemProject.java`) combines abstraction, inheritance, polymorphism, and dependency inversion in one self-contained example; treat it as an integration example, not a reusable framework module.

## Key repository conventions

- **Public class name matches file name** is enforced consistently (also emphasized in `START_HERE_Java_Starter_Guide.md`).
- **Educational, verbose inline explanation style** is a core convention: large concept blocks and practice sections are part of the intended format, not noise.
- **Standalone execution model**: avoid introducing cross-file coupling unless explicitly requested; most files are designed to compile/run in isolation.
- **Naming pattern**: most files use `*Demo.java` suffix, with one capstone project file (`LibrarySystemProject.java`).
- **Two-track parity**: DSA and OOP tracks mirror each other structurally (phased folders, concept-first demos), so new content should preserve that learning progression.
