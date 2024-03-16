import sys
limit_number = 1_000_000
sys.setrecursionlimit(limit_number)

N, M = map(int, input().split())
maze = [input() for _ in range(N)]
visited = [[0] * M for _ in range(N)]


def search_start():
    for i in range(N):
        for j in range(M):
            if maze[i][j] == 'I':
                return i, j


d = (-1, 0), (1, 0), (0, -1), (0, 1)
answer = 0


def dfs(i, j):
    global answer
    for di, dj in d:
        ni = i + di
        nj = j + dj
        if not 0 <= ni < N:
            continue
        if not 0 <= nj < M:
            continue
        if visited[ni][nj]:
            continue
        if maze[ni][nj] == 'X':
            visited[ni][nj] = 1
            continue
        if maze[ni][nj] == 'P':
            answer += 1
        visited[ni][nj] = 1
        dfs(ni, nj)


si, sj = search_start()
visited[si][sj] = 1
dfs(si, sj)
print(answer or 'TT')
