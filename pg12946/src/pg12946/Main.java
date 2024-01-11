package pg12946;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Arrays.stream(solution(2)).forEach(a -> System.out.println(Arrays.toString(a)));        
        Arrays.stream(solution(3)).forEach(a -> System.out.println(Arrays.toString(a)));        
    }

    static List<int[]> list = new ArrayList<>();

    public static int[][] solution(int n) {
        hanoi(n, 1, 3);
        return list.toArray(new int[list.size()][2]);
    }

    public static void hanoi(int n, int from, int to) {
        if (n == 1) {
            System.out.println(from + " " + to);
            list.add(new int[] {from, to});
            return;
        }
        // n-1개를 현재 사용되지 않고 있는 보조 기둥을 찾아서 이동 시킴
        hanoi(n - 1, from, 6 - from - to); // 6 -> 1 + 2 + 3
        // n번째 원판을 목표 기둥으로 이동 시킴
        list.add(new int[] {from, to});
        System.out.println(from + " " + to);
        // 보조 기둥에 있는 n-1개의 원판들을 목표 기둥으로 이동 시킴
        hanoi(n - 1, 6 - from - to, to);
    }

}
