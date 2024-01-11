package boj13251;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 상자에 있는 색상의 수
        System.out.println(M);
        int[] colors = new int[M]; // 각 색상별 돌의 개수를 저장하는 배열

        // 각 색상별 돌의 개수를 입력받음
        for (int i = 0; i < M; i++) {
            colors[i] = sc.nextInt();
        }

        int K = sc.nextInt(); // 연속으로 뽑을 돌의 개수
        System.out.println(M + " " + K);
        System.out.println(Arrays.toString(colors));
        sc.close();

        // 전체 경우의 수 계산
        double total = getCombination(IntStream.of(colors).sum(), K);
        System.out.println(total);

        double same = 0.0; // 동일한 색상의 돌을 뽑을 확률의 합
        // 각 색상별로 동일한 색상의 돌을 뽑을 확률을 계산
        for (int color : colors) {
            if (color < K) continue; // 해당 색상의 돌이 K개 미만이면 건너뜀
            double tmp = getCombination(color, K);
            System.out.println(tmp);
            same += tmp; // 확률 누적
        }
        System.out.println(same);

        // 최종 확률 계산 및 출력
        System.out.println(same / total);
    }

    // 조합을 계산하는 메서드: nCr = n! / (r! * (n-r)!)
    static double getCombination(int n, int r) {
        // 조합 nCr을 계산하는 메소드
        // nCr = n! / (r! * (n-r)!)
        // 이 식은 다음과 같이 변형될 수 있다:
        // nCr = (n * (n-1) * ... * (n-r+1)) / (r * (r-1) * ... * 1)
        // 예를 들어, 5C3 = (5 * 4 * 3) / (3 * 2 * 1)
        // 이는 큰 숫자에 대한 팩토리얼 계산을 피하기 위해 사용된다.
        System.out.println("n : " + n + " r : " + r);
        double result = 1.0;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }    
}
