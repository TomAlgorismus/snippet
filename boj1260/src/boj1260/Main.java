package boj1260;

// https://www.acmicpc.net/problem/1260
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        boolean[][] graph = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph[from][to] = true;
        }
        sc.close();
        System.out.println(N + " " + M + " " + V);
        System.out.println(Arrays.deepToString(graph));
    }
}
