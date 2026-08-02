"""
Module 2 (Week 3): Introduction to Data Structures
Real-job scenario theme: e-commerce order processing pipeline.
"""

from collections import deque


def arrays_demo() -> None:
    orders = ["ORD-100", "ORD-101", "ORD-102"]
    print("Array/List - latest order:", orders[-1])


def stack_demo() -> None:
    undo_stack = []
    undo_stack.append("added item A")
    undo_stack.append("removed item B")
    print("Stack pop (undo latest):", undo_stack.pop())


def queue_demo() -> None:
    support_queue = deque(["ticket-1", "ticket-2", "ticket-3"])
    print("Queue popleft (serve first):", support_queue.popleft())


class Node:
    def __init__(self, value: int):
        self.value = value
        self.next: Node | None = None


def linked_list_demo() -> None:
    head = Node(10)
    head.next = Node(20)
    head.next.next = Node(30)
    cur = head
    result = []
    while cur:
        result.append(cur.value)
        cur = cur.next
    print("Linked list traversal:", result)


class TreeNode:
    def __init__(self, value: str):
        self.value = value
        self.left: TreeNode | None = None
        self.right: TreeNode | None = None


def trees_demo() -> None:
    root = TreeNode("CEO")
    root.left = TreeNode("Engineering Manager")
    root.right = TreeNode("Sales Manager")
    print("Tree root:", root.value, "| left:", root.left.value, "| right:", root.right.value)


def graph_set_demo() -> None:
    graph = {
        "A": ["B", "C"],
        "B": ["D"],
        "C": ["D"],
        "D": [],
    }
    permissions = {"read", "write", "read"}
    print("Graph neighbors of A:", graph["A"])
    print("Set removes duplicates:", permissions)


def hash_table_demo() -> None:
    user_by_email = {
        "alice@company.com": {"name": "Alice", "role": "admin"},
        "bob@company.com": {"name": "Bob", "role": "analyst"},
    }
    print("Hash table lookup O(1)-ish:", user_by_email["alice@company.com"]["role"])


def todo_build_your_own_stack() -> None:
    """TODO: implement push, pop, peek using list and test with sample values."""
    pass


if __name__ == "__main__":
    arrays_demo()
    stack_demo()
    queue_demo()
    linked_list_demo()
    trees_demo()
    graph_set_demo()
    hash_table_demo()

