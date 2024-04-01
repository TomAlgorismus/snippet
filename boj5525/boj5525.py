N = int(input()) # 패턴에서 'I'와 'O'가 반복되는 횟수
M = int(input()) # 전체 문자열의 길이
S = input() # 주어진 문자열

pattern = 0 # 현재까지 찾은 패턴의 수
i = 1 # 문자열의 현재 인덱스
cnt = 0

while i < M-1:
    if S[i-1] == 'I' and S[i] == 'O' and S[i+1] == 'I':
        pattern += 1
        if pattern == N:
            cnt += 1
            pattern -= 1
        i += 1 # 'O' 다음 'I'를 확인하기 위해 인덱스 추가 증가
    else:
        pattern = 0 # 패턴이 끊기면 카운트를 리셋
    i += 1

print(cnt)