"""
Module 10 (Week 14): Hash Tables
Real-job scenario theme: URL shortener and caching.
"""


class OpenAddressHashTable:
    def __init__(self, size: int = 11):
        self.size = size
        self.keys: list[str | None] = [None] * size
        self.values: list[str | None] = [None] * size

    def _hash(self, key: str) -> int:
        return sum(ord(c) for c in key) % self.size

    def _step(self, key: str) -> int:
        # simple second hash step for double hashing; must not be 0
        return 1 + (sum(ord(c) for c in key) % (self.size - 1))

    def put(self, key: str, value: str) -> bool:
        idx = self._hash(key)
        step = self._step(key)
        for _ in range(self.size):
            if self.keys[idx] is None or self.keys[idx] == key:
                self.keys[idx] = key
                self.values[idx] = value
                return True
            idx = (idx + step) % self.size
        return False

    def get(self, key: str) -> str | None:
        idx = self._hash(key)
        step = self._step(key)
        for _ in range(self.size):
            if self.keys[idx] is None:
                return None
            if self.keys[idx] == key:
                return self.values[idx]
            idx = (idx + step) % self.size
        return None


if __name__ == "__main__":
    table = OpenAddressHashTable()
    table.put("abc123", "https://example.com/jobs/123")
    table.put("xyz888", "https://example.com/jobs/888")
    table.put("demo777", "https://example.com/jobs/777")
    print("Lookup abc123:", table.get("abc123"))
    print("Lookup unknown:", table.get("missing"))

