from collections import deque

N, K = map(int, input().split())

queue = deque([(N, 0)])
visited = [0] * 100001

while queue:
    i, j = queue.pop()
    if i == K:
        print(j)
        break
    if not (0 <= i < len(visited)) or visited[i]:
        continue
    visited[i] = 1
    queue.appendleft((i-1, j+1))
    queue.appendleft((i+1, j+1))
    queue.appendleft((i*2, j+1))