import sys
from collections import Counter

sys.stdin = open('input.txt')

T = int(input())

for _ in range(T):
    a, b = input().split()
    print(Counter(a) == Counter(b) and 'Possible' or 'Impossible')
