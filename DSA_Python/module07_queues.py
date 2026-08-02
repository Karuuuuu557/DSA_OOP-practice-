"""
Module 7 (Week 10): Queues
Real-job scenario theme: print server and task scheduling.
"""

from collections import deque


def linear_queue_demo() -> None:
    q = deque()
    q.append("job-1")
    q.append("job-2")
    q.append("job-3")
    print("Linear queue serve:", q.popleft(), q.popleft())


class CircularQueue:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.data = [None] * capacity
        self.front = 0
        self.rear = 0
        self.size = 0

    def enqueue(self, value: str) -> bool:
        if self.size == self.capacity:
            return False
        self.data[self.rear] = value
        self.rear = (self.rear + 1) % self.capacity
        self.size += 1
        return True

    def dequeue(self) -> str | None:
        if self.size == 0:
            return None
        value = self.data[self.front]
        self.data[self.front] = None
        self.front = (self.front + 1) % self.capacity
        self.size -= 1
        return value


if __name__ == "__main__":
    linear_queue_demo()

    cq = CircularQueue(3)
    print("Enqueue:", cq.enqueue("A"), cq.enqueue("B"), cq.enqueue("C"), cq.enqueue("D"))
    print("Dequeue:", cq.dequeue(), cq.dequeue())
    print("Enqueue wrap:", cq.enqueue("E"), cq.enqueue("F"))
    print("Queue state:", cq.data)

