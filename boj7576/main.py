from collections import deque
import sys

input = lambda: sys.stdin.readline().rstrip()

M, N = map(int, input().split())  # M : 가로, N: 세로
tomato = [list(map(int, input().split()))
          for _ in range(N)]

qu = deque()
for i in range(N):
    for j in range(M):
        if tomato[i][j] == 1:
            qu.append((i, j, 0))
d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
days = -1
while qu:
    i, j, k = qu.popleft()
    days = max(days, k)
    # print(k, i, j)
    for di, dj in d:
        ni = i + di
        nj = j + dj
        if not (0 <= ni < N and 0 <= nj < M):
            continue
        if tomato[ni][nj] != 0:
            continue
        else:
            tomato[ni][nj] = 1
            qu.append((ni, nj, k+1))
for i in range(N):
    for j in range(M):
        if tomato[i][j] == 0:
            days = -1
print(days)