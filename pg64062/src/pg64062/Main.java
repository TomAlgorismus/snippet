package pg64062;

// https://school.programmers.co.kr/learn/courses/30/lessons/64062
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
        int k = 3;
        Solution sol = new Solution();
        System.out.println(sol.solution(stones, k));
    }
}

class Solution {
    public int solution(int[] stones, int k) {
        // 이진 탐색을 위한 초기 범위 설정
        int left = 1, right = 200000000;

        // 이진 탐색 시작
        while (left < right) {
            int mid = (left + right) / 2; // 중간값 계산
            if (canCross(stones, k, mid)) {
                // mid 명이 건널 수 있다면 left 증가
                left = mid + 1;
            } else {
                // mid 명이 건널 수 없다면 right 감소
                right = mid;
            }
        }
        return left - 1; // 최대 건널 수 있는 사람 수 반환
    }

    // mid 명이 징검다리를 건널 수 있는지 판별하는 함수
    public boolean canCross(int[] stones, int k, int mid) {
        int cnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < mid) {
                cnt++; // 연속된 돌이 mid 명을 견딜 수 없는 경우
            } else {
                cnt = 0; // 견딜 수 있는 경우 카운터 리셋
            }
            if (cnt >= k) {
                return false; // 연속된 k개 돌이 mid 명을 견디지 못함
            }
        }
        return true; // 건널 수 있음
    }
}