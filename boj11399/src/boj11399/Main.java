package boj11399;

// https://www.acmicpc.net/problem/11399
import java.util.*;
import java.io.*;

public class Main {
    
    static int[] P;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사람의 수
        P = new int[N]; // 각 사람이 돈을 인출하는데 걸리는 시간
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt(); // 각 사람이 돈을 인출하는데 걸리는 시간 입력
        }
        sc.close();
        combination(new int[N], new boolean[N], 0);
        System.out.println(min);
    }

    static int min = Integer.MAX_VALUE;

    static void combination(int[] tmp, boolean[] visited, int depth) {
        if (depth == tmp.length) {
            System.out.print(Arrays.toString(tmp));
            int sum = 0;
            for (int i = 0; i < tmp.length; i++) {
                for (int j = 0; j <= i; j++) {
                    sum += P[tmp[j]];
                }
            }
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < tmp.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            tmp[depth] = i;
            combination(tmp, visited, depth + 1);
            visited[i] = false;
        }
    }
}
