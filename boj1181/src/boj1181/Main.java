package boj1181;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사용자로부터 단어의 개수 N을 입력받음
        int N = sc.nextInt();

        // 중복 단어 제거를 위한 HashSet 생성
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            // 단어를 하나씩 입력받아 Set에 추가
            set.add(sc.next());
        }
        sc.close(); // Scanner 종료
        System.out.println(set);

        // Set을 배열로 변환
        String[] arr = new String[set.size()];
        set.toArray(arr);

        // 배열을 정렬
        Arrays.sort(arr, (a, b) -> {
            if (a.length() == b.length()) {
                // 길이가 같을 경우 사전 순으로 정렬
                return a.compareTo(b);
            } else {
                // 길이에 따라 정렬
                return a.length() - b.length();
            }
        });
        // 정렬된 단어 출력
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
