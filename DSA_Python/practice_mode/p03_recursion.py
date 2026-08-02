"""Practice 03: Recursion"""


def triangular_number(n: int) -> int:
    """TODO: implement triangular number recursively."""
    raise NotImplementedError("Implement triangular_number")


def factorial(n: int) -> int:
    """TODO: implement factorial recursively."""
    raise NotImplementedError("Implement factorial")


def anagrams(prefix: str, remaining: str, out: list[str]) -> None:
    """TODO: generate all anagrams recursively."""
    raise NotImplementedError("Implement anagrams")


def hanoi(n: int, src: str, aux: str, dst: str, moves: list[str]) -> None:
    """TODO: implement Towers of Hanoi recursively."""
    raise NotImplementedError("Implement hanoi")


if __name__ == "__main__":
    print("triangular_number(7):", triangular_number(7))  # expected 28
    print("factorial(5):", factorial(5))  # expected 120

    perms: list[str] = []
    anagrams("", "ABC", perms)
    print("anagrams(ABC):", sorted(perms))  # expected 6 permutations

    steps: list[str] = []
    hanoi(3, "A", "B", "C", steps)
    print("hanoi move count:", len(steps))  # expected 7

