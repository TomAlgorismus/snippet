import sys

sys.stdin = open('input.txt')

N = int(input())
for i in range(1, N):
    print(' ' * (i-1) + '*' * (2 * (N - i) + 1))
for i in range(N, 0, -1):
    print(' ' * (i-1) + '*' * (2 * (N - i) + 1))
