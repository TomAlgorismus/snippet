package boj9095;

// https://www.acmicpc.net/problem/9095
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수 입력
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt(); // 정수 n 입력 받음
            int[] dp = new int[n + 1]; // 동적 프로그래밍을 위한 배열 초기화

            // 초기 조건 설정
            dp[0] = 1; // 0을 나타내는 방법은 아무것도 선택하지 않는 것 1가지

            // 동적 프로그래밍을 이용한 문제 해결
            for (int j = 1; j <= n; j++) {
                if (j - 1 >= 0) { // j - 1이 0 이상일 경우
                    dp[j] += dp[j - 1]; // 1을 추가하는 경우의 수
                }
                if (j - 2 >= 0) { // j - 2가 0 이상일 경우
                    dp[j] += dp[j - 2]; // 2를 추가하는 경우의 수
                }
                if (j - 3 >= 0) { // j - 3이 0 이상일 경우
                    dp[j] += dp[j - 3]; // 3을 추가하는 경우의 수
                }
                // System.out.println(Arrays.toString(dp)); // 디버깅
            }
            System.out.println(dp[n]); // 결과 출력
        }
        sc.close();
    }

}
