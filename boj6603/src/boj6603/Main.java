package boj6603; // 패키지 선언

import java.util.Arrays; // Arrays 클래스 사용을 위한 import
import java.util.Scanner; // Scanner 클래스 사용을 위한 import
import java.util.StringTokenizer; // StringTokenizer 클래스 사용을 위한 import

public class Main {

	// 메인 메소드
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
		StringTokenizer st;
		int r = 6; // 조합의 크기(로또 번호의 개수는 6개)
		// 입력 받은 값에 따라 반복
		while (true) {
			String line = scanner.nextLine(); // 한 줄을 입력 받음
			if (line.equals("0")) { // 입력 값이 0이면 반복 종료
				break;
			}
			st = new StringTokenizer(line); // 입력 받은 줄을 분리하기 위해 StringTokenizer 사용
			int k = Integer.parseInt(st.nextToken()); // 집합의 크기 k
			int[] arr = new int[k]; // k 크기의 배열 선언
			// k개의 숫자를 배열에 저장
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(Arrays.toString(arr)); // 입력 배열 출력
			// 조합 생성 함수 호출
			combinate(arr, new int[r], 0, 0);
			System.out.println(); // 줄 바꿈 출력
		}
		scanner.close(); // Scanner 객체 닫기
	}

	// 조합을 생성하는 재귀 함수
	public static void combinate(int[] input, int[] output, int target, int depth) {
		// 출력 배열이 완성되었을 때
		if (depth == output.length) {
			System.out.println(Arrays.toString(output)); // 생성된 조합 출력
			StringBuilder sb = new StringBuilder(); // 출력을 위한 StringBuilder 생성
			// 생성된 조합을 공백으로 구분하여 StringBuilder에 추가
			for (int v : output) {
				sb.append(v).append(" ");
			}
			System.out.println(sb.toString().strip()); // 조합을 문자열로 출력하고 공백 제거
			return;
		}
		// 입력 배열을 아직 다 탐색하지 않았을 때
		if (target < input.length) {
			output[depth] = input[target]; // 현재 target 값을 output에 저장
			// target을 증가시켜 다음 값을 선택 (선택하는 경우)
			combinate(input, output, target + 1, depth + 1);
			// target만 증가시키고 depth는 그대로 (선택하지 않는 경우)
			combinate(input, output, target + 1, depth);
		}
	}

}