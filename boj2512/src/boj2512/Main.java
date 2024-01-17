package boj2512;

// https://www.acmicpc.net/problem/2512
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 3 이상 10,000 이하
        int[] budget = new int[N];
        for (int i = 0; i < N; i++) {
            budget[i] = sc.nextInt(); // 1 이상 100,000 이하
        }
        int M = sc.nextInt(); // 총 예산
        sc.close();
        // N 이상 1,000,000,000 이하 (10^9=2^30=integer))
        System.out.println(binarySearch(budget, M));
    }

    public static int binarySearch(int[] budget, int M) {
        int left = 0; // 상한액 좌측
        // 상하액 우측은 예산 중 최대값 + 1
        // 최대값 + 1을 해야 상한액이 최대값이 되는 경우를 포함할 수 있음
        int right = Arrays.stream(budget).max().getAsInt() + 1;
        while (left < right) {
            // 상한액 좌측이 우측보다 작을 때
            // 즉, 상한액이 우측에 도달하지 않았을 때
            int mid = (left + right) / 2; // 중간값을 상한액으로 가정
            // System.out.println("mid : " + mid);
            int sum = 0;
            // 상한액보다 예산이 작은 경우 상한액을, 큰 경우 예산을 합산
            for (int i = 0; i < budget.length; i++) {
                sum += Math.min(budget[i], mid);
            }
            // 합산한 값이 총 예산보다 작거나 같으면 상한액을 높일 여지가 있음
            if (sum <= M) {
                left = mid + 1;
            } else {
                // 합산한 값이 총 예산보다 크면 상한액을 낮춰야 함
                right = mid;
            }
        }
        // 상한액 좌측이 우측보다 크거나 같을 때
        // 즉, 상한액이 우측에 도달했을 때 상한액을 반환
        // -1을 하는 이유는 현재의 left는 추론했던 상한액보다 1 큰 값이기 때문
        return left - 1;
    }
}
