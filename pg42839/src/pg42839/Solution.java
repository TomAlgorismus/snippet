package pg42839; // 패키지 선언

import java.util.Arrays; // Arrays 클래스 임포트
import java.util.Comparator;
import java.util.HashSet; // HashSet 클래스 임포트
import java.util.Set; // Set 인터페이스 임포트

public class Solution {

	// 메인 메소드
	public static void main(String[] args) {
		System.out.println(solution("17")); // "17"을 사용한 솔루션 결과 출력
		System.out.println(solution("011")); // "011"을 사용한 솔루션 결과 출력
	}

	static int N; // 주어진 숫자의 길이
	static Set<Integer> set = new HashSet<>(); // 숫자 조합을 저장할 집합

	// 솔루션 메소드
	public static int solution(String numbers) {
		N = numbers.length(); // 주어진 숫자의 길이
		set.clear(); // set 초기화
		int[] arr = new int[N]; // 숫자를 저장할 배열

		// 주어진 숫자를 한 자리씩 배열에 저장
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(numbers.substring(i, i + 1));
		}
		System.out.println(Arrays.toString(arr)); // 배열 상태 출력

		// 1자리부터 N자리까지 가능한 모든 숫자 조합 생성
		for (int r = 1; r <= N; r++) {
			permutate(arr, new int[r], new boolean[N], 0, r);
		}
		System.out.println(set); // 생성된 숫자 조합 출력
		return countPrime(); // 소수의 개수 계산 및 반환
	}

	// 순열 생성 메소드
	public static void permutate(int[] arr, int[] tmp, boolean[] visited, int depth, int r) {
		if (depth == r) {
			// 순열이 완성되면 숫자로 변환하여 set에 추가
			String s = "";
			for (int v : tmp) {
				s += v;
			}
			set.add(Integer.valueOf(s));
			return;
		}
		// 모든 숫자에 대해 순열 생성 시도
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			tmp[depth] = arr[i];
			visited[i] = true;
			permutate(arr, tmp, visited, depth + 1, r);
			visited[i] = false;
		}
	}

	// 소수의 개수를 계산하는 메소드
	public static int countPrime() {
		// 에라토스테네스의 체 초기화
		boolean[] prime = new boolean[set.stream().max(Comparator.naturalOrder()).get() + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		// 에라토스테네스의 체를 사용하여 소수 판별
		for (int i = 2; i < prime.length; i++) {
			if (prime[i]) {
				for (int j = i * 2; j < prime.length; j += i) {
					prime[j] = false;
				}
			}
		}
		// 소수의 개수 계산
		int count = 0;
		for (int v : set) {
			if (prime[v])
				count++;
		}
		return count; // 소수 개수 반환
	}
}
