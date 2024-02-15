from collections import deque
N = int(input())
matrix = [input() for _ in range(N)]
visited = [[0] * N for _ in range(N)]
d = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def dfs(i, j, k):
    if not ((0 <= i < N) and (0 <= j < N)):
        return
    if visited[i][j]:
        return
    if matrix[i][j] == '0':
        return
    # print(f'[{k}]', i, j)
    visited[i][j] = k
    for di, dj in d:
        dfs(i + di, j + dj, k)

result = []
for i in range(N):
    for j in range(N):
        k = i * N + j + 1
        dfs(i, j, k)
        cnt = sum([v.count(k) for v in visited])
        if cnt:
            result.append(cnt)

print(len(result), *sorted(result), sep='\n')
