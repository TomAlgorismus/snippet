package boj1388;

// https://www.acmicpc.net/problem/1388
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken()); // 세로 크기
        int M = Integer.parseInt(st.nextToken()); // 가로 크기
        System.out.println(N + " " + M);
        matrix = new char[N][M]; // 세로, 가로
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
        sc.close();
        System.out.println(Arrays.deepToString(matrix)); // 
        System.out.println(searchRow() + searchColumn());
    }

    static char[][] matrix;

    static int searchRow() {
        int count = 0;
        for (int r = 0; r < matrix.length; r++) {
            System.out.println("r " + r);
            Stack<Character> stack = new Stack();
            for (int c = 0; c < matrix[0].length; c++) {
                if (stack.isEmpty() || stack.peek() == matrix[r][c]) {
                    stack.push(matrix[r][c]);
                } else if (stack.peek() != matrix[r][c]) {
                    if (stack.peek() == '-') {
                        count++;              
                        System.out.print('!');        
                    } else {
                        System.out.print('?');        
                    }
                    stack.clear();
                    stack.push(matrix[r][c]);
                }
                System.out.print(matrix[r][c]);
            }
            if (stack.peek() == '-') {
                count++;              
                System.out.print('!');        
            } else {
                System.out.print('?');        
            }
            System.out.println();
        }
        return count;
    }

    static int searchColumn() {
        int count = 0;
        for (int c = 0; c < matrix[0].length; c++) {
            System.out.println("c " + c);
            Stack<Character> stack = new Stack();
            for (int r = 0; r < matrix.length; r++) {
                if (stack.isEmpty() || stack.peek() == matrix[r][c]) {
                    stack.push(matrix[r][c]);
                } else if (stack.peek() != matrix[r][c]) {
                    if (stack.peek() == '|') {
                        count++;              
                        System.out.print('!');        
                    } else {
                        System.out.print('?');        
                    }
                    stack.clear();
                    stack.push(matrix[r][c]);
                }
                System.out.print(matrix[r][c]);
            }
            if (stack.peek() == '|') {
                count++;              
                System.out.print('!');        
            } else {
                System.out.print('?');        
            }
            System.out.println();
        }
        return count;
    }
}
