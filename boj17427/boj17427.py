import sys

sys.stdin = open('input.txt')

N = int(input())

total_sum = 0
for i in range(1, N + 1):
    total_sum += (N // i) * i

print(total_sum)
