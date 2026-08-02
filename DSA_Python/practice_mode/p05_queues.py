"""Practice 05: Queues (Linear + Circular)"""

from collections import deque


def linear_queue_ops() -> tuple[str, str]:
    """TODO: enqueue job-1, job-2, job-3 and dequeue twice."""
    raise NotImplementedError("Implement linear_queue_ops")


class CircularQueue:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.data = [None] * capacity
        self.front = 0
        self.rear = 0
        self.size = 0

    def enqueue(self, value: str) -> bool:
        """TODO: implement circular enqueue."""
        raise NotImplementedError("Implement CircularQueue.enqueue")

    def dequeue(self) -> str | None:
        """TODO: implement circular dequeue."""
        raise NotImplementedError("Implement CircularQueue.dequeue")


if __name__ == "__main__":
    print("linear queue:", linear_queue_ops())  # expected ('job-1', 'job-2')
    cq = CircularQueue(3)
    print(cq.enqueue("A"), cq.enqueue("B"), cq.enqueue("C"), cq.enqueue("D"))  # expected True True True False
    print(cq.dequeue(), cq.dequeue())  # expected A B
    print(cq.enqueue("E"), cq.enqueue("F"))  # expected True True
    print(cq.data)  # final buffer state should show wrap-around behavior

