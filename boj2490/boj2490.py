# import sys
#
# sys.stdin = open('input.txt')
a = ['D', 'C', 'B', 'A', 'E']
for _ in range(3):
    print(a[sum(map(int, input().split()))])
