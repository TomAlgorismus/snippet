// package boj11286;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 연산의 개수 N을 입력받음
        int N = sc.nextInt();

        // 절대값 힙을 구현하기 위한 우선순위 큐 생성
        // 절대값이 작은 순으로, 절대값이 같으면 실제 값이 작은 순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 == abs2) {
                return o1 - o2;
            }
            return abs1 - abs2;
        });

        // N번의 연산을 수행
        for (int i = 0; i < N; i++) {
            // 정수 x를 입력받음
            int x = sc.nextInt();

            // x가 0이면, 우선순위 큐에서 가장 작은 값을 출력하고 제거
            // 큐가 비어있으면 0을 출력
            if (x == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } 
            // x가 0이 아니면, x를 우선순위 큐에 추가
            else {
                pq.add(x);
            }
        }

        // 입력이 끝났으므로 Scanner 객체를 닫음
        sc.close();
    }
}