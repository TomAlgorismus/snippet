T = int(input())
# print(T)
wave = [0] * 101
wave[1], wave[2], wave[3] = 1, 1, 1
for i in range(4, 101):
    wave[i] = wave[i-3] + wave[i-2]
# print(wave)
for _ in range(T):
    N = int(input())
    # print(N)
    print(wave[N])
