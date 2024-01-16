package boj11650;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {      
        Scanner sc = new Scanner(System.in);

        // 사용자로부터 좌표의 개수 N을 입력받음
        int N = sc.nextInt();

        // 좌표를 저장할 2차원 배열 초기화
        int[][] arr = new int[N][2];

        // N개의 좌표를 입력받아 배열에 저장
        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt(); // x좌표
            arr[i][1] = sc.nextInt(); // y좌표
        }
        // System.out.println(Arrays.deepToString(arr));
        sc.close(); // 스캐너 종료

        // 좌표 배열을 정렬
        Arrays.sort(arr, (a, b) -> {
            if(a[0] == b[0]) {
                // x좌표가 같을 경우 y좌표에 따라 정렬
                return a[1] - b[1];
            }
            else {
                // x좌표에 따라 정렬
                return a[0] - b[0];
            }
        });

        // 정렬된 좌표 출력
        for(int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
