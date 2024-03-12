import sys
limit_number = 5000
sys.setrecursionlimit(limit_number)

N = int(input())
m = [input() for _ in range(N)]
d = ((-1, 0), (1, 0), (0, -1), (0, 1))
visited1 = [[0] * N for _ in range(N)]
visited2 = [[0] * N for _ in range(N)]
result1 = set()
result2 = set()


def dfs1(r, c, color, area):
    if visited1[r][c]:
        return
    visited1[r][c] = 1
    result1.add(area)
    for di, dj in d:
        ni = r + di
        nj = c + dj
        if not 0 <= ni < N:
            continue
        if not 0 <= nj < N:
            continue
        if m[ni][nj] != color:
            continue
        dfs1(ni, nj, color, area)

def dfs2(r, c, color, area):
    if visited2[r][c]:
        return
    visited2[r][c] = 1
    result2.add(area)
    for di, dj in d:
        ni = r + di
        nj = c + dj
        if not 0 <= ni < N:
            continue
        if not 0 <= nj < N:
            continue
        next_color = m[ni][nj]
        if color in 'RG':
            if next_color == 'B':
                continue
        else:
            if next_color != 'B':
                continue
        dfs2(ni, nj, color, area)


for i in range(N):
    for j in range(N):
        dfs1(i, j, m[i][j], i * N + j + 1)
        dfs2(i, j, m[i][j], i * N + j + 1)

print(len(result1), len(result2))
