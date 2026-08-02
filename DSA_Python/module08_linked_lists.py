"""
Module 8 (Week 11): Linked Lists
Real-job scenario theme: browser history and blockchain-like chaining.
"""


class SinglyNode:
    def __init__(self, value: str):
        self.value = value
        self.next: SinglyNode | None = None


class SinglyLinkedList:
    def __init__(self):
        self.head: SinglyNode | None = None

    def append(self, value: str) -> None:
        node = SinglyNode(value)
        if self.head is None:
            self.head = node
            return
        cur = self.head
        while cur.next:
            cur = cur.next
        cur.next = node

    def to_list(self) -> list[str]:
        out = []
        cur = self.head
        while cur:
            out.append(cur.value)
            cur = cur.next
        return out


class DoublyNode:
    def __init__(self, value: str):
        self.value = value
        self.prev: DoublyNode | None = None
        self.next: DoublyNode | None = None


class DoublyLinkedList:
    def __init__(self):
        self.head: DoublyNode | None = None
        self.tail: DoublyNode | None = None

    def append(self, value: str) -> None:
        node = DoublyNode(value)
        if self.tail is None:
            self.head = self.tail = node
            return
        self.tail.next = node
        node.prev = self.tail
        self.tail = node

    def reverse_iter(self) -> list[str]:
        out = []
        cur = self.tail
        while cur:
            out.append(cur.value)
            cur = cur.prev
        return out


if __name__ == "__main__":
    sll = SinglyLinkedList()
    sll.append("home")
    sll.append("products")
    sll.append("checkout")
    print("Singly list:", sll.to_list())

    dll = DoublyLinkedList()
    dll.append("block-1")
    dll.append("block-2")
    dll.append("block-3")
    print("Doubly reverse traversal:", dll.reverse_iter())

