import sys
from collections import deque

sys.stdin = open('input.txt')

T = int(input())
# print(T)

def dslr(qu, B):
    while qu:
        cmd, val = qu.pop()
        cmd_tmp = cmd + 'D'
        val_tmp = (val * 2) % 10000
        if val_tmp == B:
            return cmd_tmp
        else:
            qu.appendleft((cmd_tmp, val_tmp))
        cmd_tmp = cmd + 'S'
        val_tmp = 9999 if not val < 1 else (val - 1)
        if val_tmp == B:
            return cmd_tmp
        else:
            qu.appendleft((cmd_tmp, val_tmp))
        cmd_tmp = cmd + 'L'
        val_tmp = str(val)
        if len(val_tmp) > 1:
            val_tmp = int(val_tmp[1:] + val_tmp[0])
        else:
            val_tmp = int(val_tmp)
        if val_tmp == B:
            return cmd_tmp
        else:
            qu.appendleft((cmd_tmp, val_tmp))
        cmd_tmp = cmd + 'R'
        val_tmp = str(val)
        if len(val_tmp) > 1:
            val_tmp = int(val_tmp[-1] + val_tmp[:-1])
        else:
            val_tmp = int(val_tmp)
        if val_tmp == B:
            return cmd_tmp
        else:
            qu.appendleft((cmd_tmp, val_tmp))


for _ in range(T):
    A, B = map(int, input().split())
    # print(A, B)
    qu = deque()
    qu.appendleft(('', A))
    print(dslr(qu, B))
