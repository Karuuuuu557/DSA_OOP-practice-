"""Practice 06: Linked Lists (Singly + Doubly)"""


class SinglyNode:
    def __init__(self, value: str):
        self.value = value
        self.next: SinglyNode | None = None


class SinglyLinkedList:
    def __init__(self):
        self.head: SinglyNode | None = None

    def append(self, value: str) -> None:
        """TODO: append node at end."""
        raise NotImplementedError("Implement SinglyLinkedList.append")

    def to_list(self) -> list[str]:
        """TODO: traverse and return list."""
        raise NotImplementedError("Implement SinglyLinkedList.to_list")


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
        """TODO: append while maintaining head/tail and prev/next pointers."""
        raise NotImplementedError("Implement DoublyLinkedList.append")

    def reverse_iter(self) -> list[str]:
        """TODO: iterate from tail to head."""
        raise NotImplementedError("Implement DoublyLinkedList.reverse_iter")


if __name__ == "__main__":
    sll = SinglyLinkedList()
    for page in ["home", "products", "checkout"]:
        sll.append(page)
    print("singly:", sll.to_list())  # expected ['home', 'products', 'checkout']

    dll = DoublyLinkedList()
    for block in ["block-1", "block-2", "block-3"]:
        dll.append(block)
    print("doubly reverse:", dll.reverse_iter())  # expected ['block-3','block-2','block-1']

