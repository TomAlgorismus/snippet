import sys
from collections import deque

# sys.stdin = open('input.txt')
# sys.stdin = open('input2.txt')
sys.stdin = open('input3.txt')
input = lambda: sys.stdin.readline().strip()
print = lambda x: sys.stdout.write(str(x))

text = input()

st1 = deque(text)
st2 = deque()

M = int(input())
for _ in range(M):
    cmd = input()
    if cmd[0] == 'L':
        if st1:
            st2.append(st1.pop())
    if cmd[0] == 'D':
        if st2:
            st1.append(st2.pop())
    if cmd[0] == 'B':
        if st1:
            st1.pop()
    if cmd[0] == 'P':
        st1.append(cmd[2])

print(''.join(list(st1) + list(st2)[::-1]))