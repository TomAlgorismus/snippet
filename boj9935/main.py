from collections import deque
import sys

input = lambda: sys.stdin.readline().rstrip()  # 입력을 받는 함수를 정의합니다.
print = sys.stdout.write  # 출력을 하는 함수를 정의합니다.

text = input()  # 텍스트를 입력받습니다.
bomb = input()  # "폭탄" 문자열을 입력받습니다.
st = deque()  # 스택을 생성합니다.
bomb_len = len(bomb)  # "폭탄" 문자열의 길이를 계산합니다.
for t in text:  # 텍스트의 각 문자에 대해
    st.append(t)  # 문자를 스택에 추가합니다.
    if t == bomb[-1] and len(st) >= bomb_len:  # 추가한 문자가 "폭탄" 문자열의 마지막 문자와 같고 스택의 길이가 "폭탄" 문자열의 길이 이상이라면
        tmp = deque()  # 임시 스택을 생성합니다.
        for i in range(bomb_len):  # "폭탄" 문자열의 각 문자에 대해
            v = st.pop()  # 스택에서 문자를 제거합니다.
            tmp.append(v)  # 제거한 문자를 임시 스택에 추가합니다.
            if v != bomb[bomb_len-1-i]:  # 제거한 문자가 "폭탄" 문자열의 해당 위치의 문자와 다르다면
                while tmp:  # 임시 스택이 빌 때까지
                    st.append(tmp.pop())  # 임시 스택에서 문자를 제거하여 스택에 추가합니다.
                break  # 반복을 종료합니다.
if st:  # 스택에 문자가 남아 있다면
    print(''.join(st))  # 스택의 문자들을 출력합니다.
else:  # 스택이 비어 있다면
    print('FRULA')  # "FRULA"를 출력합니다.

'''
이 코드는 스택을 사용하여 텍스트의 각 문자를 순회하면서
"폭탄" 문자열을 찾아 제거합니다.

1) 스택의 길이가 "폭탄" 문자열의 길이 이상이고,
2) 추가한 문자가 "폭탄" 문자열의 마지막 문자와 같을 때,
"폭탄" 문자열의 각 문자를 스택에서 제거하여 임시 스택에 추가하고,
이 문자들이 "폭탄" 문자열과 일치하는지 확인합니다.
일치하지 않는 경우, 임시 스택의 문자들을 다시 스택에 추가합니다.

모든 문자를 순회한 후 스택에 남아 있는 문자들을 출력하거나,
스택이 비어 있으면 "FRULA"를 출력합니다.
'''