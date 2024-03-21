n = int(input())
sq = [0 if i ** 0.5 % 1 else 1 for i in range(n + 1)]

min_val = 4
for i in range(int(n ** 0.5), 0, -1):
    if sq[n]:
        min_val = 1
        break
    elif sq[n - i ** 2]:
        min_val = 2
        break
    else:
        for j in range(int((n - i ** 2) ** 0.5), 0, -1):
            if sq[(n - i ** 2) - j ** 2]:
                min_val = 3

print(min_val)
