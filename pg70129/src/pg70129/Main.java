package pg70129;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "110010101001"; // 테스트할 문자열
        // 결과 출력
        System.out.println(Arrays.toString(solution.solution(s)));  
    }
}

class Solution {
    public int[] solution(String s) {
        System.out.println(s); // 초기 문자열 출력 (디버깅용)
        int countTransitions = 0; // 이진 변환 횟수
        int countZero = 0; // 제거된 0의 개수

        // 문자열이 "1"이 될 때까지 반복
        while (!s.equals("1")) {
            String temp = ""; // 0을 제거한 후의 새로운 문자열
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    // 0이면 제거하고 카운트 증가
                    countZero++;
                } else {
                    // 1이면 temp 문자열에 추가
                    temp += "1";
                }
            }
            // 남은 1의 개수에 대한 이진수로 변환
            s = Integer.toBinaryString(temp.length());
            System.out.println(s); // 변환된 문자열 출력 (디버깅용)
            countTransitions++; // 변환 횟수 증가
        }
        int[] answer = {countTransitions, countZero}; // 결과 배열
        return answer; // 결과 반환
    }
}