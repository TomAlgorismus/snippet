from functools import reduce
import sys

input = lambda: sys.stdin.readline().rstrip()

T = int(input())
for _ in range(T):
    N = int(input())
    answer = 0
    if N:
        wear = dict()
        for _ in range(N):
            a, b = input().split()
            wear[b] = wear.get(b, []) + [a]
        answer = reduce(lambda acc, cur: acc * cur,
                        [len(v) + 1 for v in wear.values()]) - 1
    print(answer)
