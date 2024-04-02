'''
solve 함수는 M, N, x, y를 인자로 받아, 가능한 해를 찾아 반환합니다.

y의 값이 N과 동일한 경우를 처리하기 위해,
y가 N이면 0으로 설정합니다. 이는 문제의 조건에서 년도가 N 또는 0일 때 실제 값은 N이라는 것과 일치합니다.

x를 시작점으로 하여, M의 배수만큼 증가시키면서
각각의 값이 N으로 나누어 떨어지는지(나머지가 y와 일치하는지) 검사합니다.

만약 i % N == y 조건을 만족하는 i가 있다면,
그 i가 정답입니다. 만약 M*N+1까지 검사했음에도 불구하고 조건을 만족하는 i를 찾지 못했다면,
해가 존재하지 않는 것으로 -1을 반환합니다.
'''

import sys

sys.stdin = open('input.txt')
input = lambda: sys.stdin.readline().rstrip()
print = lambda x: sys.stdout.write(str(x) + '\n')


def solve(M, N, x, y):
    # y 값을 조정하기 위해 y가 N을 초과하지 않도록 조정
    y = y if y != N else 0

    # x를 M의 배수로 증가시키면서, 해당 값이 y 조건을 만족하는지 확인
    for i in range(x, M*N+1, M):
        if i % N == y:
            return i
    return -1


T = int(input())

for _ in range(T):
    M, N, x, y = map(int, input().split())
    print(solve(M, N, x, y))
