import sys

input = lambda: sys.stdin.readline().rstrip()
print = lambda x: sys.stdout.write(str(x) + '\n')

N, M = map(int, input().split())
book1 = {
    input(): str(k) for k in range(1, N+1)
}
book2 = {
    v: k for k, v in book1.items()
}
for m in range(M):
    data = input()
    if data in book1:
        print(book1[data])
    else:
        print(book2[data])
    