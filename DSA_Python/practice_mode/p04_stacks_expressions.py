"""Practice 04: Stacks + Expression Conversion"""

PRECEDENCE = {"+": 1, "-": 1, "*": 2, "/": 2, "^": 3}


def infix_to_postfix(expr: str) -> str:
    """TODO: implement infix -> postfix (space-separated tokens)."""
    raise NotImplementedError("Implement infix_to_postfix")


def infix_to_prefix(expr: str) -> str:
    """TODO: implement infix -> prefix using reverse/swap strategy."""
    raise NotImplementedError("Implement infix_to_prefix")


def postfix_to_infix(expr: str) -> str:
    """TODO: implement postfix -> infix using stack."""
    raise NotImplementedError("Implement postfix_to_infix")


def prefix_to_infix(expr: str) -> str:
    """TODO: implement prefix -> infix using stack."""
    raise NotImplementedError("Implement prefix_to_infix")


if __name__ == "__main__":
    infix = "( A + B ) * C - D"
    print("postfix:", infix_to_postfix(infix))  # expected A B + C * D -
    print("prefix :", infix_to_prefix(infix))  # expected - * + A B C D
    print("post->in:", postfix_to_infix("A B + C * D -"))
    print("pre->in :", prefix_to_infix("- * + A B C D"))

