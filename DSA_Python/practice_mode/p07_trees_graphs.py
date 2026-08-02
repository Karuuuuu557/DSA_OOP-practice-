"""Practice 07: Trees, BST, Graph BFS"""

from collections import deque


class TreeNode:
    def __init__(self, value: int):
        self.value = value
        self.left: TreeNode | None = None
        self.right: TreeNode | None = None


def insert_bst(root: TreeNode | None, value: int) -> TreeNode:
    """TODO: insert value in BST and return root."""
    raise NotImplementedError("Implement insert_bst")


def inorder(root: TreeNode | None, out: list[int]) -> None:
    """TODO: inorder traversal."""
    raise NotImplementedError("Implement inorder")


def bfs_graph(start: str, graph: dict[str, list[str]]) -> list[str]:
    """TODO: BFS traversal for directed graph."""
    raise NotImplementedError("Implement bfs_graph")


if __name__ == "__main__":
    root = None
    for value in [7, 4, 9, 2, 5, 8, 10]:
        root = insert_bst(root, value)
    out: list[int] = []
    inorder(root, out)
    print("inorder:", out)  # expected [2,4,5,7,8,9,10]

    graph = {
        "API": ["Auth", "Payments"],
        "Auth": ["DB"],
        "Payments": ["DB", "Queue"],
        "DB": [],
        "Queue": [],
    }
    print("bfs:", bfs_graph("API", graph))  # expected ['API','Auth','Payments','DB','Queue']

