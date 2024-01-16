package pg12973;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "baabaa"; // 테스트할 문자열
        // String s = "cdcd"; // 다른 테스트 케이스
        System.out.println(solution.solution(s)); // 결과 출력   
    }

    public int solution(String s) {
        // 문자를 저장할 리스트
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            // 리스트가 비어있지 않고 마지막 문자가 현재 문자와 같다면
            if (list.size() > 0 && list.get(list.size() - 1) == c) {
                list.remove(list.size() - 1); // 마지막 문자 제거
                continue;
            }
            list.add(c); // 현재 문자 추가
            System.out.println(list); // 리스트 상태 출력 (디버깅용)
        }
        // 모든 문자가 제거되었는지 확인
        int answer = list.size() == 0 ? 1 : 0; // 리스트가 비어있으면 1, 아니면 0 반환
        return answer;
    }
}
