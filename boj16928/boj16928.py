import sys
from collections import deque

sys.stdin = open('input.txt')
input = lambda: sys.stdin.readline().rstrip()
N, M = map(int, input().split())
k = N + M
print(k)
adj = {}
for _ in range(k):
   x, y = map(int, input().split())
   adj[x] = y
print(adj)
qu = deque([(0, 1)])
memo = set()
while qu:
    t, val = qu.popleft()
    if val == 100:
        print(t)
        break
    for i in range(1, 7):
        val2 = val + i
        if val2 in memo:
            continue
        memo.add(val2)
        if val2 in adj:
            val2 = adj[val2]
        qu.append((t+1, val2))
