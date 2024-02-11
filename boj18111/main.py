import math
import sys

input = lambda: sys.stdin.readline().rstrip()
N, M, B = map(int, input().split())
blocks = [0] * 257
max_block = 0
min_block = 256
total = 0
for i in range(N):
    tmp = list(map(int, input().split()))
    for j in range(M):
        blocks[tmp[j]] += 1
        total += tmp[j]
        max_block = max(tmp[j], max_block)
        min_block = min(tmp[j], min_block)
# blocks.sort()
min_val = math.inf
answer = 0
for i in range(max_block, min_block - 1, -1):
    if total + B >= i * N * M: # 평탄화 가능 체크
        tmp = 0
        for j in range(min_block, max_block + 1):
            diff = j - i
            tmp += (diff * 2 if diff > 0 else -diff) * blocks[j]
        if tmp < min_val:
            min_val = tmp
            answer = i
print(min_val, answer)

