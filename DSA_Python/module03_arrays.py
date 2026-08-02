"""
Module 3 (Week 4): Arrays (1D, 2D, Multidimensional)
Real-job scenario theme: analytics dashboard metrics.
"""


def one_dimensional_arrays() -> None:
    daily_signups = [43, 50, 47, 52, 60, 58, 49]
    print("1D total weekly signups:", sum(daily_signups))
    print("1D peak signups:", max(daily_signups))


def two_dimensional_arrays() -> None:
    # rows=products, cols=regions
    sales = [
        [120, 150, 130],  # Product A
        [80, 110, 95],    # Product B
        [200, 210, 205],  # Product C
    ]
    product_a_total = sum(sales[0])
    region_2_total = sum(row[1] for row in sales)
    print("2D Product A total:", product_a_total)
    print("2D Region 2 total:", region_2_total)


def multidimensional_arrays() -> None:
    # [quarter][month][region]
    revenue = [
        [  # Q1
            [1000, 1200],  # Month 1
            [1100, 1250],  # Month 2
            [1050, 1300],  # Month 3
        ],
        [  # Q2
            [1150, 1350],
            [1200, 1400],
            [1250, 1450],
        ],
    ]
    q1_total = sum(sum(month) for month in revenue[0])
    print("3D Q1 revenue:", q1_total)


def rotate_array_right(values: list[int], k: int) -> list[int]:
    if not values:
        return values
    k %= len(values)
    return values[-k:] + values[:-k]


def todo_from_scratch_matrix_sum(matrix: list[list[int]]) -> int:
    """TODO: return matrix sum without using built-in sum on nested structure."""
    total = 0
    for row in matrix:
        for value in row:
            total += value
    return total


if __name__ == "__main__":
    one_dimensional_arrays()
    two_dimensional_arrays()
    multidimensional_arrays()
    print("Rotate [1,2,3,4,5] by 2 ->", rotate_array_right([1, 2, 3, 4, 5], 2))
    print("From-scratch matrix sum ->", todo_from_scratch_matrix_sum([[1, 2], [3, 4], [5, 6]]))

