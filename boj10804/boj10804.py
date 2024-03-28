import sys

# sys.stdin = open('input.txt')
# sys.stdin = open('input2.txt')
sys.stdin = open('input3.txt')

a = [i for i in range(21)]  # 0은 안씀
for _ in range(10):
    s, e = map(int, input().split())
    a[s:e+1] = a[e:s-1:-1]
    # print(a)

print(*a[1:])