"""
Module 9 (Weeks 12-13): Trees, Graphs, Sets
Real-job scenario theme: org charts, dependency graphs, and permissions.
"""

from collections import deque


class TreeNode:
    def __init__(self, value: int):
        self.value = value
        self.left: TreeNode | None = None
        self.right: TreeNode | None = None


def insert_bst(root: TreeNode | None, value: int) -> TreeNode:
    if root is None:
        return TreeNode(value)
    if value < root.value:
        root.left = insert_bst(root.left, value)
    else:
        root.right = insert_bst(root.right, value)
    return root


def inorder(root: TreeNode | None, out: list[int]) -> None:
    if root is None:
        return
    inorder(root.left, out)
    out.append(root.value)
    inorder(root.right, out)


def bfs_graph(start: str, graph: dict[str, list[str]]) -> list[str]:
    visited = set([start])
    q = deque([start])
    order = []
    while q:
        node = q.popleft()
        order.append(node)
        for nei in graph.get(node, []):
            if nei not in visited:
                visited.add(nei)
                q.append(nei)
    return order


if __name__ == "__main__":
    root = None
    for num in [7, 4, 9, 2, 5, 8, 10]:
        root = insert_bst(root, num)
    traversal: list[int] = []
    inorder(root, traversal)
    print("BST inorder traversal:", traversal)

    service_graph = {
        "API": ["Auth", "Payments"],
        "Auth": ["DB"],
        "Payments": ["DB", "Queue"],
        "DB": [],
        "Queue": [],
    }
    print("Graph BFS from API:", bfs_graph("API", service_graph))

    role_set = {"read", "write", "read", "deploy"}
    print("Set unique permissions:", role_set)

