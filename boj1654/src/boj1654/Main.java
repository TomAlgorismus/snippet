package boj1654;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // 빠른 입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = bf.readLine().split(" ");
        int K = Integer.parseInt(tmp[0]);
        int N = Integer.parseInt(tmp[1]);
        System.out.println(N + " " + K);
        
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            int v = Integer.parseInt(bf.readLine());
            System.out.println(v);
            arr[i] = v;
        }
        System.out.println(Arrays.toString(arr));

        // 기존의 K개의 랜선을 N개의 랜선으로 만들기 위해 자르는 최대 길이를 구하는 문제
        // 자르는 길이를 이분탐색으로 찾는다.
        // 이분탐색의 범위는 인덱스가 아니라 랜선의 길이
        // 중간길이 -> 최대값 + 최소값 / 2
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        int mid = (min + max) / 2;
    }
}
