from collections import deque
n = int(input())
visited = [0] * (n+1)
m = int(input())
adj = [[0 for _ in range(n+1)] for _ in range(n+1)]
for _ in range(m):
    i, j = map(int, input().split())
    adj[i][j] = 1
    adj[j][i] = 1
answer = 0
visited[1] = 1
st = deque([1])
while st:
    top = st.pop()
    for i in range(1, len(adj[top])):
        if adj[top][i] and not visited[i]:
            visited[i] = 1
            answer += 1
            st.append(i)
print(answer)
