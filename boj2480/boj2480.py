# 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
# 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
# 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.

import sys
sys.stdin = open('input.txt')

A, B, C = sorted(map(int, input().split()))
if A == B == C:
    print(10000 + A * 1000)
elif A != B and A != C and B != C:
    print(max((A, B, C)) * 100)
else:
    print(1000 + B * 100)

