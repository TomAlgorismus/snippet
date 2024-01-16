package boj1157;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 반복적으로 문자열을 입력받음
        while (sc.hasNext()) {
            String text = sc.next().toUpperCase(); // 입력된 문자열을 대문자로 변환
            findMostUsedCharacter(text); // 가장 많이 사용된 문자 찾기
        }
        sc.close(); // Scanner 객체 종료
    }// 가장 많이 사용된 문자를 찾는 메서드

    public static void findMostUsedCharacter(String text) {
        // 알파벳 별 사용 빈도를 저장할 배열 초기화
        int[] count = new int[26];

        // 문자열의 각 문자에 대해 빈도 계산
        for (int i = 0; i < text.length(); i++) {
            int num = text.charAt(i) - 'A'; // 문자를 정수로 변환 (A = 0, B = 1, ...)
            count[num]++; // 해당 문자의 빈도 증가
        }

        // 가장 많이 사용된 문자의 빈도와 그 문자를 저장할 변수
        int max = 0; // 가장 많이 사용된 문자의 빈도
        char answer = '?'; // 가장 많이 사용된 문자

        // 가장 많이 사용된 문자 탐색
        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i]; // 최대 빈도 갱신
                answer = (char) (i + 'A'); // 해당 문자 저장
            } else if (max == count[i]) {
                answer = '?'; // 가장 많이 사용된 문자가 여러 개인 경우
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}
