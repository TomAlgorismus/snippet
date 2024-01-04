package pg42839;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}
	
	static int N;
	static Set<Integer> set = new HashSet<>();
	
	public static int solution(String numbers) {
		N = numbers.length();
		set.clear();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(numbers.substring(i, i+1));
		}
		System.out.println(Arrays.toString(arr));
		for (int r = 1; r <= N; r++) {			
			permutate(arr, new int[r], new boolean[N], 0, r);
		}
		System.out.println(set);
		return countPrime();
	}
		
	public static void permutate(int[] arr, int[] tmp, boolean[] visited, int depth, int r) {
		if (depth == r) {
			System.out.println(Arrays.toString(tmp));
			String s = "";
			for (int v : tmp) {
				s += v;
			}
			set.add(Integer.valueOf(s));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			tmp[depth] = arr[i];
			visited[i] = true;
			permutate(arr, tmp, visited, depth + 1, r);
			visited[i] = false;
		}
	}
	
	public static int countPrime() {
		boolean[] prime = new boolean[set.stream().max(Comparator.naturalOrder()).get() + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 2; i < prime.length; i++) {
			if (prime[i] == true) {
				for (int j = i * 2; j < prime.length; j += i) {
					prime[j] = false;
				}
			}
		}
		int count = 0;
		for (int v : set) {
			if (prime[v]) count++;
		}
		return count;
	}
}
