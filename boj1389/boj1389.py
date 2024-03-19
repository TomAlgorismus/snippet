from collections import deque

N, M = map(int, input().split())
adjl = [[0] * N for _ in range(N)]
for _ in range(M):
    s, e = map(int, input().split())
    adjl[s-1][e-1] = 1
    adjl[e-1][s-1] = 1

results = []
for i in range(N):
    visited = [0] * N
    visited[i] = 1
    qu = deque([(i, 1)])
    sum_val = 0
    while qu:
        idx, num = qu.pop()
        for j in range(N):
            if visited[j]:
                continue
            if not adjl[idx][j]:
                continue
            visited[j] = 1
            sum_val += num
            qu.appendleft((j, num+1))
    # print(i, sum_val)
    results.append((i+1, sum_val))

print(sorted(results, key=lambda x: (x[1], x[0]))[0][0])
