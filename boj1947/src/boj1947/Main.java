package boj1947;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = IntStream.range(1, N + 1).toArray();
		sc.close();
		permute(new int[N], new boolean[N], 0);
		System.out.println(count % 1000000000);
	}

	static int N;
	static int[] arr;
	static long count = 0;

	public static void permute(int[] tmp, boolean[] visited, int depth) {
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				if (tmp[i] == i + 1) {
					return;
				}
			}
			System.out.println(Arrays.toString(tmp));
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			tmp[depth] = arr[i];
			permute(tmp, visited, depth + 1);
			visited[i] = false;
		}
	}

}
