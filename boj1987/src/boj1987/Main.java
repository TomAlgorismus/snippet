package boj1987;

// https://www.acmicpc.net/problem/1987
import java.util.*;
import java.io.*;

public class Main {

    static int R, C; // 보드의 행과 열 크기
    static char[][] map; // 보드의 알파벳을 저장하는 배열
    static boolean[] visited; // 알파벳의 방문 여부를 저장하는 배열
    static int[] dr = { 0, 0, -1, 1 }; // 상, 하, 좌, 우 방향을 나타내는 행 이동 배열
    static int[] dc = { -1, 1, 0, 0 }; // 상, 하, 좌, 우 방향을 나타내는 열 이동 배열
    static int max = 0; // 지나갈 수 있는 최대 칸 수

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 세로 크기 입력
        C = Integer.parseInt(st.nextToken()); // 가로 크기 입력

        map = new char[R][C]; // 보드 초기화
        visited = new boolean[26]; // 알파벳 방문 여부 배열 초기화 (A-Z)

        // 보드의 알파벳 입력
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++)
                map[i][j] = str.charAt(j);
        }

        // DFS 탐색 시작
        dfs(0, 0, 1);

        // 결과 출력
        System.out.println(max);
    }

    static void dfs(int r, int c, int count) {
        max = Math.max(max, count); // 최대 칸 수 갱신
        visited[map[r][c] - 'A'] = true; // 현재 칸의 알파벳 방문 처리

        // 상하좌우 이동 탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i]; // 다음 행 위치
            int nc = c + dc[i]; // 다음 열 위치

            // 보드 범위를 벗어나거나 이미 방문한 알파벳은 탐색하지 않음
            if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[map[nr][nc] - 'A'])
                continue;

            dfs(nr, nc, count + 1); // 다음 칸으로 이동하여 탐색
        }

        visited[map[r][c] - 'A'] = false; // 현재 칸의 알파벳 방문 처리 해제
    }
}
