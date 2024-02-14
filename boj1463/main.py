N = int(input())
memo = [0] * max(4, (N+1))
for i in range(2, N+1):
    possible = []
    if not i % 2: possible.append(memo[i // 2])
    if not i % 3: possible.append(memo[i // 3])
    possible.append(memo[i - 1])
    memo[i] = min(possible) + 1
print(memo[N])