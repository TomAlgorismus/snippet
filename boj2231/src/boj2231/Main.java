package boj2231;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		for (int i = 1; i <= N; i++)   {
			int s = Stream.of((i + "").split(""))
					.map((v) -> Integer.valueOf(v))
					.reduce((v1,v2) -> v1 + v2).get();
			if (i + s == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}

}
