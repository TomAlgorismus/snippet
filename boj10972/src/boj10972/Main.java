package boj10972; // 패키지 선언

import java.util.ArrayList; // ArrayList 클래스 임포트
import java.util.Arrays; // Arrays 클래스 임포트
import java.util.List; // List 인터페이스 임포트
import java.util.Scanner; // Scanner 클래스 임포트

public class Main {

    // 메인 메소드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        N = sc.nextInt(); // 순열의 크기 N 입력 받기
        arr = new int[N]; // 순열을 저장할 배열 초기화
        
        // 순열 입력 받기
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt(); // 숫자 입력
        }
        sc.close(); // Scanner 객체 닫기
        
        System.out.println(Arrays.toString(arr)); // 입력된 순열 출력
        int cp = checkPoint(); // 다음 순열의 변경점 찾기
        if (cp == -1) { // 변경점이 없으면 -1 출력 후 종료
            System.out.println(-1);
            return;
        }
        System.out.println(cp); // 변경점 출력
        
        find(cp); // 변경점을 기준으로 다음 순열 찾기
    }

    static int N; // 순열의 크기
    static int[] arr; // 순열 배열

    // 다음 순열의 변경점을 찾는 메소드
    static int checkPoint() {
        // 뒤에서부터 현재 숫자가 이전 숫자보다 큰 지점 찾기
        for (int i = 1; i < N; i++) {
            int idx = N - i;
            if (arr[idx - 1] < arr[idx]) {
                return idx; // 변경점 반환
            }
        }
        return -1; // 변경점이 없으면 -1 반환
    }

    // 다음 순열을 찾아 출력하는 메소드
    static void find(int cp) {
        // 변경점부터 뒤로 가면서 교환할 숫자 찾기
        for (int r = N - 1; r > 0; r--) {
            if (arr[cp - 1] < arr[r]) {
                // 숫자 교환
                int tmp = arr[r];
                arr[r] = arr[cp - 1];
                arr[cp - 1] = tmp;
                
                // 변경점 이전은 그대로 두고, 변경점 이후는 오름차순으로 정렬
                List<Integer> l = new ArrayList<>();
                Arrays.stream(Arrays.copyOfRange(arr, 0, cp))
                    .forEach(l::add); // 변경점 이전 부분 추가
                Arrays.stream(Arrays.copyOfRange(arr, cp, N))
                    .sorted()
                    .forEach(l::add); // 변경점 이후 정렬하여 추가
                StringBuilder sb = new StringBuilder();
                l.forEach((v) -> sb.append(v + " "));
                
                // 완성된 다음 순열 출력
                System.out.println(sb.toString().strip());
                return;
            }
        }
    }
}