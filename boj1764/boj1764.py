import sys

input = lambda: sys.stdin.readline().rstrip()
print = lambda x: sys.stdout.write(str(x) + '\n')

N, M = map(int, input().split())
set1 = set([input() for _ in range(N)])
set2 = set([input() for _ in range(M)])
# print(set1, set2)
# print(set1 & set2)
set3 = sorted(list(set1 & set2))
print(len(set3))
for v in list(set3):
    print(v)