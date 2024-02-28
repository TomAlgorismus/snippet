from collections import deque
import sys

input = lambda : sys.stdin.readline().strip()

N = int(input())
matrix = [list(map(int, input().split()))
          for _ in range(N)]
# 굳이?
# max_height = max(map(max, matrix))
# min_height = min(map(min, matrix))

def dfs(row, col, group, water):
    visited[row][col] = group
    d = ((-1, 0), (1, 0), (0, -1), (0, 1))
    for di, dj in d:
        ni = row + di
        nj = col + dj
        if not (0 <= ni < N): continue
        if not (0 <= nj < N): continue
        if visited[ni][nj]: continue
        if matrix[ni][nj] <= water: continue
        dfs(ni, nj, group, water)

cnt = 0
# for w in range(min_height - 1, max_height):
for w in range(100):
    visited = [[0] * N for _ in range(N)]

    # 재귀 풀이 (Recursion Error)
    # for r in range(N):
    #     for c in range(N):
    #         if matrix[r][c] < w:
    #             continue
    #         # if matrix[r][c] <= w or visited[r][c]:
    #         #     continue
    #         # g = r * N + c + 1
    #         # dfs(r, c, g, w)

    # 스택 풀이
    st = deque([(r, c, r * N + c + 1)
                for c in range(N) for r in range(N)])
    # print(st)
    d = ((-1, 0), (1, 0), (0, -1), (0, 1))
    while st:
        row, col, group = st.pop()
        if not (0 <= row < N): continue
        if not (0 <= col < N): continue
        if visited[row][col]: continue
        if matrix[row][col] <= w: continue
        visited[row][col] = group
        for di, dj in d:
            ni = row + di
            nj = col + dj
            st.append((ni, nj, group))

    # 방문 리스트 처리
    visited_set = set()
    for v in visited:
        for el in v:
            if el != 0:
                visited_set.add(el)
    # print(visited_set)
    cnt = max(cnt, len(visited_set))
print(cnt)