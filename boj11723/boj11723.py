import sys
input = lambda: sys.stdin.readline().rstrip()
print = lambda x: sys.stdout.write(str(x) + '\n')

M = int(input())
S = 0
for _ in range(M):
    action, *x = input().split()
    if action == 'all': S = (1 << 21) - 1
    elif action == 'empty': S = 0
    elif action == 'add': S |= 1 << int(x[0])
    elif action == 'check':
        print(1 if S & (1 << int(x[0])) != 0 else 0)
    elif action == 'remove': S &= ~(1 << int(x[0]))
    elif action == 'toggle': S ^= 1 << int(x[0])
