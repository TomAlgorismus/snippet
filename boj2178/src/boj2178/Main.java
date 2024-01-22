package boj2178;

// https://www.acmicpc.net/problem/2178
import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] maze;
    static int m;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // 세로
        m = sc.nextInt();   // 가로
        maze = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) == '1';
            }
        }
        sc.close();
        System.out.println(Arrays.deepToString(maze));
        bfs();
    }

    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int num = cur[2];
            if (r == n - 1 && c == m - 1) {
                System.out.println(num);
                break;
            }
            if (r < 0 || r >= n || c < 0 || c >= m) {
                continue;
            }    
            if (maze[r][c]) {
                maze[r][c] = false;
                q.add(new int[]{r + 1, c, num + 1});
                q.add(new int[]{r - 1, c, num + 1});
                q.add(new int[]{r, c + 1, num + 1});
                q.add(new int[]{r, c - 1, num + 1});
            }
        }
    }
}
