package boj16194;

// https://www.acmicpc.net/problem/16194
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 구매하고자 하는 카드의 개수
        int[] P = new int[N + 1]; // 각 카드팩의 가격을 저장하는 배열
        for (int i = 1; i <= N; i++) {
            P[i] = sc.nextInt(); // 카드팩의 가격 입력
        }

        // 동적 프로그래밍을 위한 배열 초기화
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = P[i]; // i개 카드가 들어 있는 카드팩을 바로 구매하는 경우의 비용
            for (int j = 1; j <= i; j++) {
                // i개를 구매하는 여러 가지 방법 중 최소 비용을 찾음
                // i-j개를 사는 최솟값에 j개 들어있는 카드팩을 사는 경우를 비교
                dp[i] = Math.min(dp[i], dp[i - j] + P[j]);
            }
        }

        System.out.println(dp[N]); // 최소 비용 출력
        sc.close();
    }
}
