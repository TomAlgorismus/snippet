package boj15661; // 패키지 선언

import java.util.Scanner; // Scanner 클래스 임포트

public class Main {
    static int N; // 팀원의 수
    static int[][] S; // 능력치를 나타내는 2차원 배열
    static int score = Integer.MAX_VALUE; // 최소 점수 차이를 저장할 변수, 초기값은 최대 정수값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        N = sc.nextInt(); // 팀원의 수 입력 받기
        S = new int[N][N]; // 능력치 배열 초기화
        
        // 팀원 간 능력치 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt(); // 능력치 입력
            }
        }
        sc.close(); // Scanner 객체 닫기

        // 팀 조합 생성
        for (int r = 1; r <= N / 2 + 1; r++) {
            combine(new boolean[N], r, 0, 0); // 조합 함수 호출
        }
        System.out.println(score); // 최소 점수 차이 출력
    }
    
    // 팀 조합을 생성하는 메소드
    public static void combine(boolean[] visited, int r, int target, int depth) {
        if (depth == r) {
            score = Math.min(scoring(visited), score); // 점수 계산 및 최소값 갱신
            return;
        }
        if (target == N) return; // 모든 팀원을 고려했으면 종료
        visited[target] = true; // 현재 팀원을 포함시키는 경우
        combine(visited, r, target+1, depth+1);
        visited[target] = false; // 현재 팀원을 포함시키지 않는 경우
        combine(visited, r, target+1, depth);
    }

    // 점수 차이를 계산하는 메소드
    public static int scoring(boolean[] visited) {
        int tmp = 0; // 점수 차이를 계산할 변수
        // 팀 조합에 따른 점수 계산
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                if (visited[i] && visited[j]) { // 같은 팀인 경우 능력치 합산
                    tmp += S[i][j];
                } else if (!visited[i] && !visited[j]) { // 다른 팀인 경우 능력치 차감
                    tmp -= S[i][j];
                }
            }
        }
        return Math.abs(tmp); // 점수 차이의 절대값 반환
    }
}
