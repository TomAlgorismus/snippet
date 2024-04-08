import sys

sys.stdin = open('input.txt')

n = input()
result = 0
for i in range(1, len(n)):
    result += 9 * 10 ** (i-1) * i
# 맨 끝 자리수를 제외한 모든 자리수만큼 들어갈 개수를 세놓는다
result += (int(n) - 10 ** (len(n) - 1) + 1) * len(n)
# 맨 끝 자리수는 모든 걸 9로 채운 걸 오버하는 갯수만큼 넣으면 된다
print(result)
