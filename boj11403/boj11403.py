N = int(input())
adj = [list(map(int, input().split())) for _ in range(N)]
result = [[0] * N for i in range(N)]


def dfs(nxt, start):
    for i in range(N):
        if not visited[i] and adj[nxt][i] and not result[start][i]:
            visited[i] = 1
            result[start][i] = 1
            dfs(i, start)


for i in range(N):
    visited = [0] * N
    dfs(i, i)

for r in result:
    print(*r)
