import sys
from collections import Counter
sys.stdin = open('input.txt')

w1 = Counter(input())
w2 = Counter(input())
print(sum(dict((w1 | w2) - (w1 & w2)).values()))
