T = int(input())
X = list(map(int, input().split()))
X2 = {}
for x in X:
    X2[x] = X2.get(x, 0) + 1
X3 = {v : k for k, v in enumerate(sorted(X2.keys()))}
for x in X:
    print(X3[x], end=' ')