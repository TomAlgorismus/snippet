package boj2501;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		List<Integer> measure = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int m = i + 1;
			if (N % m == 0) {
				measure.add(m);
			}
		}
		sc.close();
		if (measure.size() < K) {
			System.out.println(0);
		} else {
			System.out.println(measure.get(K-1));
		}
	}

}
