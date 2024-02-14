memo0 = [0] * (40 + 1)
memo1 = [0] * (40 + 1)
memo0[0] = 1
memo1[1] = 1
for i in range(2, 40 + 1):
    memo0[i] = memo0[i-1] + memo0[i-2]
    memo1[i] = memo1[i-1] + memo1[i-2]

T = int(input())
for _ in range(T):
    N = int(input())
    print(memo0[N], memo1[N])
