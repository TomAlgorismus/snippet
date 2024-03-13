N = int(input())
M = int(input())

buttons = set([i for i in range(10)])
if M:
    broken = list(map(int, input().split()))
    buttons -= set(broken)

N_len = len(str(N))
min_val = abs(N - 100)

def dfs(num, depth):
    global min_val
    if depth > 6:
        return
    if num and len(num) > N_len - 2:
        num_val = int(num)
        min_val = min(abs(N - num_val) + len(num), min_val)
    for b in buttons:
        dfs(num + f'{b}', depth + 1)

dfs('', 0)

print(min_val)