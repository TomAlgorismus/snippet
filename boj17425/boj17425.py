import sys
# sys.stdin = open('input.txt')
input = sys.stdin.readline

limit = 1_000_000
T = int(input())
memo = [0] * (limit + 1)

for i in range(1, limit + 1):
    for j in range(i, limit + 1, i):
        memo[j] += i
    memo[i] += memo[i - 1]

answer = []
for _ in range(T):
    a = int(input())
    answer.append(memo[a])

print(*answer, sep='\n')