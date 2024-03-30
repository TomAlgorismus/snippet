import sys

sys.stdin = open('input.txt')
input = sys.stdin.readline
print = lambda x: sys.stdout.write(f'{x}\n')

limit = 1_000_000
memo = [1] * (limit + 1)
memo[1] = 0
for i in range(3, limit, 2):
    if memo[i]:
        for j in range(i*2, limit, i):
            memo[j] = 0

while True:
    n = int(input())
    if n == 0:
        exit()
    for i in range(n-3, 2, -2):
        if memo[i] and memo[n-i]:
            print(f'{n} = {n - i} + {i}')
            break
    else:
        print('Goldbach\'s conjecture is wrong.')
