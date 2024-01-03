package boj2231;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		// N <=> abc
		// abc의 분해합이 N일 때, N의 생성자는 abc
		// abc + a + b + c = 101a+11b+2c
		StringBuilder sb;
		for (int a = 0; a < 10; a++) {
			for (int b = 0; b < 10; b++) {
				int c = (N - 101 * a - 11 * b) / 2;
				if (c < 10 && c > 0) {					
					sb = new StringBuilder();
					System.out.println(sb.append(a).append(b).append(c).toString());
				}
			}
		}
		
	}

}
