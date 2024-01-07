N, M = map(int, input().split())
trees = list(map(int, input().split()))
s = 0
# e = 10 ** 9
e = max(trees)
while 1:
    mid = (s + e) // 2
    cut = 0
    for t in trees:
        if t > mid:
            cut += t - mid
    if cut == M:
        print(mid)
        break
    elif cut < M:
        e = mid - 1
    elif cut > M:
        s = mid + 1
