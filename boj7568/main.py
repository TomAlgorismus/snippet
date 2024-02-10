N = int(input())
a = [list(map(int, input().split()))
     for _ in range(N)]
result = []
for i in range(N):
    tmp = 1
    for j in range(N):
        if i == j: continue
        x1, y1 = a[i]
        x2, y2 = a[j]
        if x1 < x2 and y1 < y2: tmp += 1
    result.append(tmp)
print(*result)