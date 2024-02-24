calc = input().split('-')
result = 0
for c1 in calc[0].split('+'):
    result += int(c1)
for c2 in calc[1:]:
    for num in c2.split('+'):
        result -= int(num)
print(result)
