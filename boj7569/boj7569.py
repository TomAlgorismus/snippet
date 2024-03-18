import sys
from collections import deque

m, n, h = map(int, input().split())  # m, n은 상자의 크기, h는 상자의 수
graph = []  # 그래프를 저장할 리스트
queue = deque()  # BFS를 위한 큐

input = lambda: sys.stdin.readline()  # 입력을 빠르게 받기 위한 람다 함수

# 그래프를 입력받는 부분
for i in range(h):  # 각 상자마다
    tmp = []  # 임시 리스트
    for j in range(n):  # 각 상자의 n행마다
        tmp.append(list(map(int, input().split())))  # 토마토의 상태를 입력받아 리스트에 추가
        for k in range(m):  # 각 상자의 m열마다
            if tmp[j][k] == 1:  # 만약 토마토가 익었다면
                queue.append([i, j, k])  # 큐에 추가
    graph.append(tmp)  # 그래프에 상자 추가

# 이동할 방향
d = (-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1)

# BFS
while queue:
    i, j, k = queue.popleft()  # 큐에서 좌표를 꺼냄

    for di, dj, dk in d:  # 각 방향에 대해
        ni, nj, nk = i + di, j + dj, k + dk  # 새로운 좌표를 계산
        if not all([0 <= ni < h, 0 <= nj < n, 0 <= nk < m]):  # 만약 새로운 좌표가 상자를 벗어나면 무시
            continue
        if graph[ni][nj][nk]:  # 만약 새로운 좌표의 토마토가 이미 익었거나 빈 칸이면 무시
            continue
        queue.append((ni, nj, nk))  # 큐에 새로운 좌표를 추가
        graph[ni][nj][nk] = graph[i][j][k] + 1  # 새로운 좌표의 토마토를 익힘

day = 0  # 걸린 날짜
flag = False  # 모든 토마토가 익었는지 확인하는 플래그
for i in graph:  # 각 상자마다
    for j in i:  # 각 행마다
        for k in j:  # 각 열마다
            if k == 0:  # 만약 토마토가 아직 안 익었다면
                flag = True  # 플래그를 설정
            day = max(day, k)  # 걸린 날짜를 최댓값으로 갱신
print(-1 if flag else day - 1)  # 만약 모든 토마토가 익지 않았다면 -1, 아니면 걸린 날짜를 출력