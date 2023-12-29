package boj2775;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
			int k = scanner.nextInt();
			int n = scanner.nextInt();
			System.out.print(k + " ");
			System.out.println(n);
			// a층의 b호에 살려면, => k층의 n호
			// 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다.
			// 아파트에는 0층부터 있고 각 층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
			System.out.println(guess(k, n));
		}
		scanner.close();
	}

	public static int guess(int k, int n) {
		int arr[] = IntStream.range(0, n + 1).toArray();
		int temp[];
		for (int i = 0; i < k; i++) {
			temp = new int[n + 1];
			System.out.println(i);
			System.out.println(Arrays.toString(arr));
			for (int j = 0; j <= n; j++) {
				for (int v : Arrays.copyOfRange(arr, 1, j + 1)) {
					temp[j] += v;
				}
			}
			System.out.println(Arrays.toString(temp));
			arr = temp.clone();
		}
		return arr[n];
	}
}
