N, M = map(int, input().split())  # 보드의 크기 N, M을 입력받음
result = 64  # 최소 변경 횟수를 저장할 변수. 최대값인 64로 초기화

# 보드의 상태를 입력받음
board = [list(input()) for _ in range(N)]

def row_to_score(idx, row):
    # 각 행의 색을 바꾸는 횟수를 계산하는 함수
    # 행의 인덱스가 짝수이면 'B', 홀수이면 'W'가 되어야 함
    scores = [(v == 'B') if (i % 2) else (v == 'W') for i, v in enumerate(row)]
    sum_val = sum(scores)
    return sum_val if idx % 2 else 8 - sum_val  # 행의 인덱스에 따라 색을 바꾸는 횟수를 반환

# 보드의 모든 8x8 크기의 체스판을 순회
for i in range(N - 8 + 1):
    for j in range(M - 8 + 1):
        # 현재 체스판을 추출
        square = [board[k][j:j + 8] for k in range(i, i + 8)]
        # 체스판의 색을 바꾸는 횟수를 계산
        score = sum([row_to_score(idx, row) for idx, row in enumerate(square)])
        # 최소 변경 횟수를 업데이트
        result = min((result, score, 64 - score))

# 최소 변경 횟수를 출력
print(result)