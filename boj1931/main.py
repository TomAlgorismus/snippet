import sys

input = lambda : sys.stdin.readline().strip()
N = int(input())
meeting = [list(map(int, input().split())) for _ in range(N)]
meeting.sort(key=lambda x: (x[1], x[0]))
tmp = -1
cnt = 0
for s, e in meeting:
    if s >= tmp:
        tmp = e
        cnt += 1
print(cnt)