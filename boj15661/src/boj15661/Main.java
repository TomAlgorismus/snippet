package boj15661;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static int N; static int[][] S;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }
        sc.close();
        for (int r = 1; r <= N / 2; r++) {
            combine(new boolean[N], r, 0, 0, 0);
        }
        System.out.println(result);
    }
    
    public static void combine(boolean[] visited, int r, int target, int depth, int score) {
        if (depth == r) {
            System.out.println(Arrays.toString(visited));
            // score = score > scoring(visited) ? scoring(visited) : score;
            result = Math.min(result, Math.abs(score));
            return;
        }
        if (target == N) return;
        visited[target] = true;
        combine(visited, r, target+1, depth, score + addScore(visited, target));
        visited[target] = false;
        combine(visited, r, target+1, depth+1, score);
    }

    public static int addScore(boolean[] visited, int target) {
        int score = 0;
        for (int i = 0; i < visited.length; i++) {
            if (i == target) continue;
            if (visited[i]) {
                score += S[i][target] + S[target][i];
            } else {
                score -= S[i][target] + S[target][i];
            }
        }
        return score;
    }
}
