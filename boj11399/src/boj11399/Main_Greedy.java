// package boj11399;

// // https://www.acmicpc.net/problem/11399
// import java.util.*;
// import java.io.*;

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int N = sc.nextInt(); // 사람의 수
//         int[] P = new int[N]; // 각 사람이 돈을 인출하는데 걸리는 시간
//         for (int i = 0; i < N; i++) {
//             P[i] = sc.nextInt(); // 각 사람이 돈을 인출하는데 걸리는 시간 입력
//         }
//         sc.close();
//         // 오름차순으로 정렬
//         Arrays.sort(P);
//         int sum = 0; // 각 사람이 돈을 인출하는데 필요한 시간의 합
//         for (int i = 1; i < N; i++) {
//             // i번째 사람이 돈을 인출하는데 걸리는 시간은
//             // i-1번째 사람이 돈을 인출하는데 걸리는 시간에 i번째 사람이 돈을 인출하는데 걸리는 시간을 더한 값
//             P[i] += P[i - 1];
//             sum += P[i]; // 각 사람이 돈을 인출하는데 필요한 시간의 합
//         }
//         System.out.println(sum + P[0]); // 각 사람이 돈을 인출하는데 필요한 시간의 합 + 0번째 사람이 돈을 인출하는데 걸리는 시간
//     }
// }
