package boj2942; // 패키지 선언

import java.util.Scanner; // Scanner 클래스 임포트

public class Main {
    // 메인 메소드
    public static void main(String[] args) {
        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt(); // 빨간 사과의 수 R 입력 받기
        int G = scanner.nextInt(); // 초록 사과의 수 G 입력 받기
        scanner.close(); // Scanner 객체 닫기

        // R과 G의 최대 공약수를 구함
        int gcd = getGCD(R, G);

        // 최대 공약수의 약수들을 이용하여 가능한 조합을 출력
        // for (int i = 1; i <= gcd; i++) { // 기존 코드
        for (int i = 1; i < (int) Math.sqrt(gcd) + 1; i++) { // 최적화된 코드
            if (gcd % i != 0) continue; // i가 gcd의 약수가 아니면 건너뛰기
            // 선수의 수, 빨간 사과의 배분, 초록 사과의 배분 출력
            System.out.println(gcd / i + " " + R / gcd * i + " " + G / gcd * i);
            if (i != gcd / i) { // i가 약수의 절반 이하일 때만 짝이 되는 약수도 출력
                int j = gcd / i;
                System.out.println(j + " " + R / gcd * i + " " + G / gcd * i);
            }
        }
    }

    // 최대 공약수를 구하는 메서드
    public static int getGCD(int a, int b) {
        // a가 b보다 작은 경우 두 값을 교환
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        // 유클리드 호제법을 이용하여 최대 공약수 계산
        while (a % b != 0) {
            a = a % b;
            // a와 b의 값을 서로 교환
            int temp = a;
            a = b;
            b = temp;
        }
        // 최대 공약수 반환
        return b;
    }
}
