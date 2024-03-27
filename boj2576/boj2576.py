import sys

sys.stdin = open('input.txt')

sum_val = 0
min_val = 100
for _ in range(7):
    num = int(input())
    if num % 2:
        sum_val += num
        min_val = min(min_val, num)
if sum_val > 0:
    print(sum_val, min_val, sep='\n')
else:
    print(-1)