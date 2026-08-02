"""Practice 01: Arrays (1D, 2D, 3D)"""


def rotate_right(values: list[int], k: int) -> list[int]:
    """TODO: rotate array to the right by k."""
    raise NotImplementedError("Implement rotate_right")


def matrix_sum(matrix: list[list[int]]) -> int:
    """TODO: sum all values in 2D matrix."""
    raise NotImplementedError("Implement matrix_sum")


def cube_total(cube: list[list[list[int]]]) -> int:
    """TODO: sum all values in 3D list."""
    raise NotImplementedError("Implement cube_total")


if __name__ == "__main__":
    print("rotate_right:", rotate_right([1, 2, 3, 4, 5], 2))  # expected [4,5,1,2,3]
    print("matrix_sum:", matrix_sum([[1, 2], [3, 4], [5, 6]]))  # expected 21
    sample_cube = [[[1, 2], [3, 4]], [[5, 6], [7, 8]]]
    print("cube_total:", cube_total(sample_cube))  # expected 36

