from collections import deque

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
qu = deque()
visited = [[-1] * m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if arr[i][j] == 2:
            qu.appendleft((i, j, 0))
            visited[i][j] = 0
        elif arr[i][j] == 0:
            visited[i][j] = 0
d = ((-1, 0), (1, 0), (0, -1), (0, 1))
s = set()
while qu:
    i, j, k = qu.pop()
    # print(i, j, k)
    for di, dj in d:
        ni = i + di
        nj = j + dj
        if 0 <= ni < n and 0 <= nj < m:
            if visited[ni][nj] == -1:
                if arr[ni][nj]:
                    qu.appendleft((ni, nj, k+1))
                    visited[ni][nj] = k+1
for v in visited:
    print(*v)