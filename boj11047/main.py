import sys

input = lambda: sys.stdin.readline().rstrip()

N, K = map(int, input().split())
arr = []
for _ in range(N):
    tmp = int(input())
    if K >= tmp:
        arr.append(tmp)
answer = 0
for a in arr[::-1]:
    while K >= a:
        answer += K // a
        K %= a
    if K == 0:
        break
print(answer)