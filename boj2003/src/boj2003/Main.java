package boj2003;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 수열의 크기 N과 찾고자 하는 합 M을 입력받음
        int N = sc.nextInt(), M = sc.nextInt();

        // 수열을 저장할 배열 A 생성
        int[] A = new int[N];

        // N개의 정수를 입력받아 배열에 저장
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 입력이 끝났으므로 Scanner 객체를 닫음
        sc.close();

        // 투 포인터 알고리즘을 위한 변수들 초기화
        int left = 0, right = 0, sum = 0, count = 0;

        // 수열을 탐색하는 루프
        while (true) {
            // 현재 합이 M 이상이면, 합에서 A[left]를 빼고 left를 1 증가
            if (sum >= M) {
                sum -= A[left++];
            } 
            // right가 N이면, 모든 수를 확인한 것이므로 루프 종료
            else if (right == N) {
                break;
            } 
            // 위의 두 경우가 아니면, 합에 A[right]를 더하고 right를 1 증가
            else {
                sum += A[right++];
            }

            // 합이 M과 같으면, 경우의 수 count를 1 증가
            if (sum == M) {
                count++;
            }
        }

        // 합이 M이 되는 연속된 수들의 경우의 수 출력
        System.out.println(count);
    }
}