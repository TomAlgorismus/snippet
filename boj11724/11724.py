from collections import deque
import sys

input = lambda: sys.stdin.readline().rstrip()
N, M = map(int, input().split())
# print(N, M)
adj = [[0] * (N+1) for _ in range(N+1)]
for _ in range(M):
    s, e = map(int, input().split())
    adj[s][e] = 1
    adj[e][s] = 1
# print(adj)
visited = [0] * (N+1)
st = deque([(n, n) for n in range(1, N+1)])
# print(st)
while st:
    node, group = st.pop()
    if visited[node]:
        continue
    visited[node] = group
    for i in range(1, len(adj[node])):
        if not adj[node][i] or visited[i]:
            continue
        st.append((i, group))
print(len(set(visited))-1)
