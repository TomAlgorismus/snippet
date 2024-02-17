from collections import deque

T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    field = [[0] * N for _ in range(M)]
    for _ in range(K):
        X, Y = map(int, input().split())
        field[X][Y] = 1
    visited = [[0] * N for _ in range(M)]
    d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    st = deque()
    for i in range(M):
        for j in range(N):
            if not field[i][j]: continue
            st.append((i, j, i * N + j + 1))
    while st:
        i, j, k = st.pop()
        if not (0 <= i < M): continue
        if not (0 <= j < N): continue
        if visited[i][j]: continue
        if not field[i][j]: continue
        visited[i][j] = k
        for di, dj in d:
            st.append((i + di, j + dj, k))
    tmp = []
    for v in visited:
        tmp += set([a for a in v if a > 0])
    print(len(set(tmp)))