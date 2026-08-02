"""
Final Project (Weeks 15-17): CPU Scheduling System
Focus: DSA + algorithm analysis + practical simulation.

Implemented:
- FCFS (First-Come, First-Served)
- SJF Non-Preemptive (Shortest Job First)
"""

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
    time = 0
    rows: list[ScheduleRow] = []
    for p in sorted(processes, key=lambda x: x.arrival):
        start = max(time, p.arrival)
        finish = start + p.burst
        waiting = start - p.arrival
        turnaround = finish - p.arrival
        rows.append(ScheduleRow(p.pid, start, finish, waiting, turnaround))
        time = finish
    return rows


def sjf_non_preemptive(processes: list[Process]) -> list[ScheduleRow]:
    remaining = processes[:]
    time = min(p.arrival for p in remaining)
    rows: list[ScheduleRow] = []
    while remaining:
        ready = [p for p in remaining if p.arrival <= time]
        if not ready:
            time = min(p.arrival for p in remaining)
            continue
        p = min(ready, key=lambda x: x.burst)
        start = time
        finish = start + p.burst
        waiting = start - p.arrival
        turnaround = finish - p.arrival
        rows.append(ScheduleRow(p.pid, start, finish, waiting, turnaround))
        time = finish
        remaining.remove(p)
    return rows


def print_report(title: str, rows: list[ScheduleRow]) -> None:
    print("\n===", title, "===")
    print("PID | Start | Finish | Waiting | Turnaround")
    for r in rows:
        print(f"{r.pid:>3} | {r.start:>5} | {r.finish:>6} | {r.waiting:>7} | {r.turnaround:>10}")
    avg_wait = sum(r.waiting for r in rows) / len(rows)
    avg_turn = sum(r.turnaround for r in rows) / len(rows)
    print(f"Average waiting time   : {avg_wait:.2f}")
    print(f"Average turnaround time: {avg_turn:.2f}")


if __name__ == "__main__":
    dataset = [
        Process("P1", arrival=0, burst=7),
        Process("P2", arrival=2, burst=4),
        Process("P3", arrival=4, burst=1),
        Process("P4", arrival=5, burst=4),
    ]

    print_report("FCFS", fcfs(dataset))
    print_report("SJF (Non-Preemptive)", sjf_non_preemptive(dataset))

    print("\nChallenge:")
    print("1) Add Round Robin.")
    print("2) Add Priority Scheduling.")
    print("3) Load process list from CSV file.")

