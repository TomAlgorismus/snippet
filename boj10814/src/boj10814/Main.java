package boj10814;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(N);
        int[] ages = new int[N];
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            ages[i] = sc.nextInt();
            names[i] = sc.next();
        }
        sc.close();
        System.out.println(Arrays.toString(ages));
        System.out.println(Arrays.toString(names));
        Integer[] idxs = IntStream.range(0, N).boxed().toArray(Integer[]::new);
        Arrays.sort(idxs, (a, b) -> {
            if (ages[a] == ages[b]) {
                return Integer.compare(a, b);
            }
            return Integer.compare(ages[a], ages[b]);
        });
        System.out.println(Arrays.toString(idxs));
        for (int i : idxs) {
            System.out.println(ages[i] + " " + names[i]);
        }
    }
}
