"""Practice 09: CPU Scheduling (FCFS + SJF Non-Preemptive)"""

from dataclasses import dataclass


@dataclass
class Process:
    pid: str
    arrival: int
    burst: int


@dataclass
class ScheduleRow:
    pid: str
    start: int
    finish: int
    waiting: int
    turnaround: int


def fcfs(processes: list[Process]) -> list[ScheduleRow]:
    """TODO: implement FCFS scheduling."""
    raise NotImplementedError("Implement fcfs")


def sjf_non_preemptive(processes: list[Process]) -> list[ScheduleRow]:
    """TODO: implement non-preemptive SJF scheduling."""
    raise NotImplementedError("Implement sjf_non_preemptive")


def avg_wait(rows: list[ScheduleRow]) -> float:
    return sum(r.waiting for r in rows) / len(rows)


if __name__ == "__main__":
    data = [
        Process("P1", arrival=0, burst=7),
        Process("P2", arrival=2, burst=4),
        Process("P3", arrival=4, burst=1),
        Process("P4", arrival=5, burst=4),
    ]

    fcfs_rows = fcfs(data)
    sjf_rows = sjf_non_preemptive(data)
    print("FCFS avg wait:", avg_wait(fcfs_rows))  # expected 4.75
    print("SJF avg wait :", avg_wait(sjf_rows))  # expected 4.00

