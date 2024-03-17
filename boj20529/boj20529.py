from itertools import combinations
import sys

input = lambda: sys.stdin.readline().rstrip()
print = lambda x: sys.stdout.write(str(x) + '\n')

T = int(input())
types = ['I', 'N', 'T', 'J']

def comb():
    global answer
    tmp = 0
    for i in range(len(c)):
        for j in range(i + 1, len(c)):
            n1 = c[i]
            n2 = c[j]
            # print(f'{n1:b} {n2:b} {n1^n2:b}')
            tmp += f'{n1 ^ n2:b}'.count('1')
            if tmp >= answer:
                return
    answer = min(tmp, answer)

for _ in range(T):
    N = int(input())
    answer = 0
    if N < 33:
        attributes = [
             int(''.join(['1' if at[i] == types[i] else '0'
             for i in range(4)]), 2)
             for at in input().split()]
        answer = 12
        for c in combinations(attributes, 3):
            comb()
    else:
        input()
    print(answer)
