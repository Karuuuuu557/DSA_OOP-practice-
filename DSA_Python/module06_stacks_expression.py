"""
Module 6 (Weeks 7-8): Stacks + Expression Conversion
Real-job scenario theme: compiler/expression engine basics.
"""


PRECEDENCE = {"+": 1, "-": 1, "*": 2, "/": 2, "^": 3}


def infix_to_postfix(expr: str) -> str:
    output: list[str] = []
    stack: list[str] = []
    tokens = expr.split()
    for token in tokens:
        if token.isalnum():
            output.append(token)
        elif token == "(":
            stack.append(token)
        elif token == ")":
            while stack and stack[-1] != "(":
                output.append(stack.pop())
            if stack and stack[-1] == "(":
                stack.pop()
        else:
            while stack and stack[-1] != "(" and PRECEDENCE.get(stack[-1], 0) >= PRECEDENCE.get(token, 0):
                output.append(stack.pop())
            stack.append(token)
    while stack:
        output.append(stack.pop())
    return " ".join(output)


def infix_to_prefix(expr: str) -> str:
    tokens = expr.split()[::-1]
    swapped = []
    for t in tokens:
        if t == "(":
            swapped.append(")")
        elif t == ")":
            swapped.append("(")
        else:
            swapped.append(t)
    postfix = infix_to_postfix(" ".join(swapped))
    return " ".join(postfix.split()[::-1])


def postfix_to_infix(expr: str) -> str:
    stack: list[str] = []
    for token in expr.split():
        if token.isalnum():
            stack.append(token)
        else:
            b = stack.pop()
            a = stack.pop()
            stack.append(f"( {a} {token} {b} )")
    return stack[-1]


def prefix_to_infix(expr: str) -> str:
    stack: list[str] = []
    for token in expr.split()[::-1]:
        if token.isalnum():
            stack.append(token)
        else:
            a = stack.pop()
            b = stack.pop()
            stack.append(f"( {a} {token} {b} )")
    return stack[-1]


if __name__ == "__main__":
    infix = "( A + B ) * C - D"
    postfix = infix_to_postfix(infix)
    prefix = infix_to_prefix(infix)
    print("Infix   :", infix)
    print("Postfix :", postfix)
    print("Prefix  :", prefix)
    print("Postfix->Infix:", postfix_to_infix(postfix))
    print("Prefix->Infix :", prefix_to_infix(prefix))

