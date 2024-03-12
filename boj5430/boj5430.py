from collections import deque
T = int(input())
for _ in range(T):
    p = input()
    _ = input()
    raw = input()[1:-1]
    x = []
    if raw:
        x = deque(raw.split(','))
    direction = False
    # print(p)
    for c in p:
        # print(c)
        if c == 'R':
            direction = not direction
        else:
            # print('is D')
            if not len(x):
                print('error')
                break
            if direction:
                x.pop()
            else:
                x.popleft()
    else:
        _x = list(x)[::-1] if direction else list(x)
        print('[' + ','.join(_x) + ']')
