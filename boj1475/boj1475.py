import sys
from collections import Counter
from math import ceil
sys.stdin = open('input.txt')

N = input()
c = Counter(N)
c['96'] = ceil((c['6'] + c['9']) / 2)
del c['6']
del c['9']
# print(c)
print(max(c.values()))