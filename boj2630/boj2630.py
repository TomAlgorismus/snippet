N = int(input())
paper = [list(map(int, input().split()))
         for _ in range(N)]
white_cnt = 0
blue_cnt = 0
N2 = N
while N2:
    # print(N2)
    for i in range(0, N, N2):
        for j in range(0, N, N2):
            if paper[i][j] == -1:
                continue
            sum_val = sum([sum(row[j:j+N2]) for row in paper[i:i+N2]])
            if sum_val != 0 and sum_val != N2 ** 2:
                continue
            if not sum_val:
                white_cnt += 1
            if sum_val:
                blue_cnt += 1
            for ii in range(i, i+N2):
                for jj in range(j, j+N2):
                    paper[ii][jj] = -1
    N2 //= 2
print(white_cnt, blue_cnt, sep='\n')