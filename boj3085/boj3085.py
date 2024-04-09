import sys

sys.stdin = open('input3.txt')

def check(board):
    tmp = 1

    for i in range(N):
        cnt = 1
        for j in range(1, N):
            if board[i][j] == board[i][j - 1]:
                cnt += 1
            else:
                cnt = 1
            tmp = max(tmp, cnt)
        cnt = 1
        for j in range(1, N):
            if board[j][i] == board[j - 1][i]:
                cnt += 1
            else:
                cnt = 1
            tmp = max(tmp, cnt)
    return tmp


N = int(input())
board = [list(input()) for _ in range(N)]
answer = 0

d = [(1, 0), (0, 1)]

for i in range(N):
    for j in range(N):
        for di, dj in d:
            ni, nj = i + di, j + dj
            if not 0 <= ni < N:
                continue
            if not 0 <= nj < N:
                continue
            board[i][j], board[ni][nj] = board[ni][nj], board[i][j]
            answer = max(answer, check(board))
            board[i][j], board[ni][nj] = board[ni][nj], board[i][j]

print(answer)
