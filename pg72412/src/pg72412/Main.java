package pg72412;

// https://school.programmers.co.kr/learn/courses/30/lessons/72412
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260",
                "java backend junior chicken 80", "python backend senior chicken 50" };
        String[] query = { "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150", "- and - and - and chicken 100",
                "- and - and - and - 150" };
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(info, query)));
    }
}

class Solution {
    // 주어진 info와 query를 기반으로 쿼리에 해당하는 정보 개수를 반환하는 메서드
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();

        // info 문자열을 처리하여 가능한 모든 조합을 맵에 저장
        for (String s : info) {
            String[] str = s.split(" ");
            int score = Integer.parseInt(str[4]);
            generateCombinations(str, score, 0, "", map);
        }

        // 맵의 각 값(점수 리스트)를 정렬
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            entry.getValue().sort(null);
        }

        // 쿼리 처리
        for (int i = 0; i < query.length; i++) {
            String[] str = query[i].replaceAll("-", "").split(" and | ");
            int score = Integer.parseInt(str[4]);
            String key = String.join("", str[0], str[1], str[2], str[3]);
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            
            // 이진 탐색을 사용하여 점수 조건을 만족하는 개수 계산
            int s = 0, e = list.size();
            while (s < e) {
                int mid = (s + e) / 2;
                if (list.get(mid) < score) {
                    s = mid + 1;
                } else {
                    e = mid;
                }
            }
            answer[i] = list.size() - s;
        }
        return answer;
    }

    // 조합을 생성하고 맵에 저장하는 메서드
    public void generateCombinations(String[] str, int score, int index, String current, Map<String, List<Integer>> map) {
        if (index == str.length) {
            map.computeIfAbsent(current, k -> new ArrayList<>()).add(score);
            return;
        }
        // 현재 원소를 포함하는 경우
        generateCombinations(str, score, index + 1, current + str[index], map);
        // 현재 원소를 포함하지 않는 경우
        generateCombinations(str, score, index + 1, current, map);
    }
}