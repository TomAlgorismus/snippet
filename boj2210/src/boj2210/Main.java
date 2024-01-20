package boj2210;

// https://www.acmicpc.net/problem/2210
import java.util.*;
import java.io.*;

public class Main {
    // 5x5 숫자판
    static int[][] board = new int[5][5];
    // 중복되지 않는 6자리 수를 저장할 HashSet
    static Set<Integer> set = new HashSet<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 숫자판 입력
        for (int i = 0; i < 5; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        sc.close();
        // 모든 시작점에 대해 DFS 실행 (재귀 방식)
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                dfsByRecursive(r, c, 0, 0);
            }
        }
        System.out.println(set.size());  // 결과 출력
        
        // 모든 시작점에 대해 DFS 실행 (스택 방식)
        set.clear();
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                dfsByStack(r, c);
            }
        }
        System.out.println(set.size());  // 결과 출력
    }

    // 재귀를 사용한 DFS 구현
    public static void dfsByRecursive(int r, int c, int depth, int num) {
        if (depth == 6) { // 6자리 수 완성
            set.add(num);
            return;
        }
        // 경계 체크
        if (r < 0 || r >= 5 || c < 0 || c >= 5) {
            return;
        }
        // 상하좌우 이동
        dfsByRecursive(r + 1, c, depth + 1, num * 10 + board[r][c]);
        dfsByRecursive(r - 1, c, depth + 1, num * 10 + board[r][c]);
        dfsByRecursive(r, c + 1, depth + 1, num * 10 + board[r][c]);
        dfsByRecursive(r, c - 1, depth + 1, num * 10 + board[r][c]);
    }

    // 스택을 사용한 DFS 구현
    public static void dfsByStack(int r, int c) {
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{r, c, 0, 0});
        while (!stack.isEmpty()) {
            Integer[] next = stack.pop();
            // 다음 방문할 위치 및 현재까지 만들어진 숫자 추출
            int nextR = next[0];
            int nextC = next[1];
            int depth = next[2];
            int num = next[3];
            // 6자리 수 완성 및 경계 체크
            if (depth == 6 || nextR < 0 || nextR >= 5 || nextC < 0 || nextC >= 5) {
                if (depth == 6) set.add(num);
                continue;
            }
            // 상하좌우 이동
            stack.push(new Integer[]{nextR + 1, nextC, depth + 1, num * 10 + board[nextR][nextC]});
            stack.push(new Integer[]{nextR - 1, nextC, depth + 1, num * 10 + board[nextR][nextC]});
            stack.push(new Integer[]{nextR, nextC + 1, depth + 1, num * 10 + board[nextR][nextC]});
            stack.push(new Integer[]{nextR, nextC - 1, depth + 1, num * 10 + board[nextR][nextC]});
        }
    }
}
