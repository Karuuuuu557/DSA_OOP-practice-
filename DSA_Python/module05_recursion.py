"""
Module 5 (Week 6): Recursion
Real-job scenario theme: hierarchical data traversal and combinatorics.
"""


def triangular_number(n: int) -> int:
    if n <= 1:
        return n
    return n + triangular_number(n - 1)


def factorial(n: int) -> int:
    if n <= 1:
        return 1
    return n * factorial(n - 1)


def anagrams(prefix: str, remaining: str, out: list[str]) -> None:
    if not remaining:
        out.append(prefix)
        return
    for i, ch in enumerate(remaining):
        anagrams(prefix + ch, remaining[:i] + remaining[i + 1 :], out)


def towers_of_hanoi(n: int, src: str, aux: str, dst: str, moves: list[str]) -> None:
    if n == 1:
        moves.append(f"Move disk 1 from {src} -> {dst}")
        return
    towers_of_hanoi(n - 1, src, dst, aux, moves)
    moves.append(f"Move disk {n} from {src} -> {dst}")
    towers_of_hanoi(n - 1, aux, src, dst, moves)


if __name__ == "__main__":
    print("Triangular(7):", triangular_number(7))
    print("Factorial(5):", factorial(5))

    perms: list[str] = []
    anagrams("", "ABC", perms)
    print("Anagrams(ABC):", perms)

    hanoi_moves: list[str] = []
    towers_of_hanoi(3, "A", "B", "C", hanoi_moves)
    print("Hanoi moves:")
    for step in hanoi_moves:
        print(" ", step)

