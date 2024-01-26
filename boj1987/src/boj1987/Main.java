package boj1987;

// https://www.acmicpc.net/problem/1987
import java.util.*;
import java.io.*;

class Data {
    int r;
    int c;
    boolean[] visited;
    int count;

    public Data(int r, int c, boolean[] visited, int count) {
        this.r = r;
        this.c = c;
        this.visited = visited;
        this.count = count;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = sc.next().toCharArray();
        }
        sc.close();
        System.out.println(Arrays.deepToString(board));
        dfs();
    }

    static char[][] board;
    static int R;
    static int C;

    public static void dfs() {
        Stack<Data> stack = new Stack();
        stack.push(new Data(0, 0, new boolean[26], 0));
        int max = 0;
        while (!stack.isEmpty()) {
            Data cursor = stack.pop();
            if (cursor.r < 0 || cursor.r >= R || cursor.c < 0 || cursor.c >= C) {
                continue;
            }
            int letter = board[cursor.r][cursor.c] - 'A';
            if (cursor.visited[letter]) {
                continue;
            }
            cursor.visited[letter] = true;
            cursor.count++;
            max = Math.max(max, cursor.count);
            stack.push(new Data(cursor.r + 1, cursor.c, cursor.visited.clone(), cursor.count));
            stack.push(new Data(cursor.r - 1, cursor.c, cursor.visited.clone(), cursor.count));
            stack.push(new Data(cursor.r, cursor.c + 1, cursor.visited.clone(), cursor.count));
            stack.push(new Data(cursor.r, cursor.c - 1, cursor.visited.clone(), cursor.count));
        }
        System.out.println(max);
    }
}