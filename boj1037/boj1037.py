import sys

# sys.stdin = open('input.txt')
input = sys.stdin.readline

_ = input()
# a = sorted(map(int, input().split()))
# print(a[0] * a[-1])
min_val = 1_000_000
max_val = 2
for v in map(int, input().split()):
    min_val = min(min_val, v)
    max_val = max(max_val, v)
print(min_val * max_val)