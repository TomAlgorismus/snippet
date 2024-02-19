import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
stairs = [0] * 301
for i in range(1, N+1):
    stairs[i] = int(input())
memo = [0] * 301
memo[1] = stairs[1]
memo[2] = stairs[1] + stairs[2]
for n in range(3, N+1):
    memo[n] = max(memo[n-3] + stairs[n-1], memo[n-2]) + stairs[n]
print(memo[N])