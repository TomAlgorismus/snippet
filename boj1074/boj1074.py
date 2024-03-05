N, r, c = map(int, input().split())

def divide_and_conquer(N, r, c):
    answer = 0

    while N:
        N -= 1  # 2 ** (n-1)로 4분할
        # 좌상, 우상, 좌하, 우하 순으로
        # 1구역
        if r < 2 ** N and c < 2 ** N:
            pass  # 1구역은 아무 것도 하지 않음
        # 2구역
        elif r < 2 ** N <= c:
            # 우상 -> 열방향을 안쪽으로 당겨야함
            # 2의 N승의 제곱 -> 1, 16, 64, ...
            # 이것은 이전 각 1~4구역 내의 개수를 더하는 것
            answer += (2 ** N) ** 2
            c -= (2 ** N)
        # 3구역
        elif c < 2 ** N <= r:
            # 좌하 -> 행방향을 안쪽으로 당겨야함
            # (2 ** N) ** 2 * 2 -> 2, 32, 128, ...
            answer += (2 ** N) ** 2 * 2
            r -= (2 ** N)
        # 4구역
        else: # r >= 2 ** N and c >= 2 ** N
            # 우하 -> 행,열 방향 모두 (대각선) 안쪽으로 당겨야함
            # (2 ** N) ** 2 * 3 -> 3, 48, 192, ...
            answer += (2 ** N) ** 2 * 3
            r -= (2 ** N)
            c -= (2 ** N)
    print(answer)

def recursion(N, r, c):
    if N == 0:
        return 0
    # 현재가 4구역 중 어느부분인지 확인하고 그 차이만큼을 더해줌
    cursor = 2 * (r % 2) + (c % 2)
    # 압축 -> 반, 반 으로 해서 해당 중심점의 커서를 옮김
    compression = recursion(N - 1, r // 2, c // 2)
    return cursor + 4 * compression

# divide_and_conquer(N, r, c)
print(recursion(N, r, c))