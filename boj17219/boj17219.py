import sys

input = lambda: sys.stdin.readline().rstrip()
print = lambda x: sys.stdout.write(str(x) + '\n')

N, M = map(int, input().split())
sites = {}

for _ in range(N):
    k, v = input().split()
    sites[k] = v

for _ in range(M):
    k = input()
    print(sites[k])