package boj1715;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 카드 묶음의 개수 N을 입력받음
        int N = sc.nextInt();

        // 카드 묶음을 저장할 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // N번의 연산을 수행하여 각 카드 묶음의 카드 개수를 우선순위 큐에 추가
        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }

        // 입력이 끝났으므로 Scanner 객체를 닫음
        sc.close();

        // 카드 묶음을 합치는 데 필요한 비용을 저장할 변수
        int answer = 0;

        // 모든 카드 묶음이 하나가 될 때까지 다음의 연산을 반복
        while (pq.size() > 1) {
            // 우선순위 큐에서 가장 작은 두 개의 카드 묶음을 꺼냄
            int a = pq.poll();
            int b = pq.poll();

            // 두 카드 묶음을 합친 후, 그 비용을 answer에 더함
            answer += a + b;

            // 합친 카드 묶음을 다시 우선순위 큐에 추가
            pq.add(a + b);
        }

        // 모든 카드 묶음이 하나가 되면, 그동안 누적된 비용인 answer를 출력
        System.out.println(answer);
    }
}