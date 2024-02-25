import sys
input = lambda: sys.stdin.readline().rstrip()
print = lambda x: sys.stdout.write(str(x) + '\n')

N, M = map(int, input().split())
a = list(map(int, input().split()))
cum_sum = [0] * (N+1)
# print(cum_sum)
for i in range(1, N+1):
    cum_sum[i] += cum_sum[i-1] + a[i-1]
# print(cum_sum)
for _ in range(M):
    s, e = map(int, input().split())
    print(cum_sum[e] - cum_sum[s-1])
