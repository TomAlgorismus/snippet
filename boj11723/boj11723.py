import sys
input = lambda: sys.stdin.readline().rstrip()
print = lambda x: sys.stdout.write(str(x) + '\n')

M = int(input())
S = 0
for _ in range(M):
    action, *x = input().split()
    if action == 'all':
        S = (1 << 20) - 1
        continue
    elif action == 'empty':
        S = 0
        continue
    element = int(x[0]) - 1
    if action == 'add':
        S |= 1 << element
    elif action == 'check':
        print(1 if S & (1 << element) != 0 else 0)
    elif action == 'remove':
        S &= ~(1 << element)
    elif action == 'toggle':
        S ^= 1 << element
