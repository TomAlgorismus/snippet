from queue import PriorityQueue
import sys

N = int(input())
pq = PriorityQueue()

input = lambda: sys.stdin.readline().rstrip()  # 입력을 받는 함수를 정의합니다.
print = lambda x: sys.stdout.write(str(x) + '\n')

for _ in range(N):
    x = int(input())
    if x:
        pq.put(x)
    else:
        if pq.empty():
            print(0)
        else:
            print(pq.get())
