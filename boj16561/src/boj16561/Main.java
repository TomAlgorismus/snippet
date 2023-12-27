package boj16561;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 입력으로 정수 n을 받습니다.
        int cnt = 0; // 가능한 조합의 수를 저장할 변수입니다.

        // 3으로 시작해서 n - 6까지 3씩 증가하는 i 루프입니다.
        for (int i = 3; i <= n - 6; i += 3) {
            // 3으로 시작해서 n - 3 - i까지 3씩 증가하는 j 루프입니다.
            for (int j = 3; j <= n - 3 - i; j += 3) {
                // i, j, n - i - j가 3의 배수이면 조합으로 카운트합니다.
                cnt++;
            }
        }

        // 가능한 조합의 수를 출력합니다.
        System.out.println(cnt);
        scanner.close(); // 스캐너를 닫습니다.
    }
}
