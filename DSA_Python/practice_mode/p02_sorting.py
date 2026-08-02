"""Practice 02: Sorting Algorithms"""


def bubble_sort(values: list[int]) -> list[int]:
    """TODO: implement bubble sort."""
    raise NotImplementedError("Implement bubble_sort")


def selection_sort(values: list[int]) -> list[int]:
    """TODO: implement selection sort."""
    raise NotImplementedError("Implement selection_sort")


def insertion_sort(values: list[int]) -> list[int]:
    """TODO: implement insertion sort."""
    raise NotImplementedError("Implement insertion_sort")


def merge_sort(values: list[int]) -> list[int]:
    """TODO: implement merge sort."""
    raise NotImplementedError("Implement merge_sort")


if __name__ == "__main__":
    arr = [78, 92, 65, 88, 99, 72]
    print("bubble:", bubble_sort(arr))
    print("selection:", selection_sort(arr))
    print("insertion:", insertion_sort(arr))
    print("merge:", merge_sort(arr))
    # expected all: [65, 72, 78, 88, 92, 99]

