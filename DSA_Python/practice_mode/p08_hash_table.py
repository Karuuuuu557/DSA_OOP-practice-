"""Practice 08: Hash Table (Open Addressing + Double Hashing)"""


class OpenAddressHashTable:
    def __init__(self, size: int = 11):
        self.size = size
        self.keys: list[str | None] = [None] * size
        self.values: list[str | None] = [None] * size

    def _hash(self, key: str) -> int:
        """TODO: primary hash."""
        raise NotImplementedError("Implement _hash")

    def _step(self, key: str) -> int:
        """TODO: second hash step (must not be 0)."""
        raise NotImplementedError("Implement _step")

    def put(self, key: str, value: str) -> bool:
        """TODO: insert/update with open addressing."""
        raise NotImplementedError("Implement put")

    def get(self, key: str) -> str | None:
        """TODO: retrieve value or None."""
        raise NotImplementedError("Implement get")


if __name__ == "__main__":
    table = OpenAddressHashTable()
    table.put("abc123", "https://example.com/jobs/123")
    table.put("xyz888", "https://example.com/jobs/888")
    table.put("demo777", "https://example.com/jobs/777")
    print(table.get("abc123"))  # expected valid URL
    print(table.get("missing"))  # expected None

