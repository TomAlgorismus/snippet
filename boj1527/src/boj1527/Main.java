package boj1527; // 패키지 선언

import java.util.Scanner; // Scanner 클래스 임포트

public class Main {
    static int A, B, count; // 전역 변수 선언: 시작 범위 A, 끝 범위 B, 금민수의 개수 count

    // 메인 메소드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        A = sc.nextInt(); // 시작 범위 A 입력 받기
        B = sc.nextInt(); // 끝 범위 B 입력 받기
        sc.close(); // Scanner 객체 닫기

        // 1번 방법: A와 B 사이의 모든 수를 순회하며 금민수 여부 확인
        System.out.println("1. A와 B 사이의 모든 수를 검사하는 방법");
        count = 0;
        for (int i = A; i <= B; i++) {
            if (isGMS(i)) { // i가 금민수인지 확인
                System.out.println(i + " is GMS");
                count++;
            }
        }
        System.out.println(count);

        // 2번 방법: 백트래킹을 사용하여 금민수 생성
        System.out.println("2. 순열을 통한 백트래킹으로 미리 금민수를 생성하는 방법");
        count = 0;
        generateGMS(4); // 4로 시작하는 금민수 생성
        generateGMS(7); // 7로 시작하는 금민수 생성
        System.out.println(count);
    }

    // 금민수인지 확인하는 메서드
    public static boolean isGMS(int num) {
        while (num > 0) {
            int remain = num % 10; // 마지막 자리 수 확인
            if (remain != 4 && remain != 7) { // 4 또는 7이 아니면 false 반환
                return false;
            }
            num /= 10; // 다음 자리 수 확인을 위해 10으로 나눔
        }
        return true; // 모든 자리 수가 4 또는 7이면 true 반환
    }

    // 백트래킹을 사용하여 금민수를 생성하는 메서드
    public static void generateGMS(long num) {
        if (num > B) { // 생성된 숫자가 B를 초과하면 더 이상 진행하지 않음
            return;
        }
        if (num >= A) { // 생성된 숫자가 A 이상이면 금민수로 간주
            System.out.println(num + " is GMS");
            count++;
        }
        generateGMS(num * 10 + 4); // 다음 숫자를 생성하기 위해 4를 추가
        generateGMS(num * 10 + 7); // 다음 숫자를 생성하기 위해 7을 추가
    }
}
