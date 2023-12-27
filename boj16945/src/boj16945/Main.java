package boj16945;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int[][] arr = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int el = scanner.nextInt();
				System.out.print(el);			
				arr[i][j] = el;
			}
			System.out.println();
		}
		int[][][] squares = getSquares();
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < 8; i++) {
			int[][] s = squares[i];
			int cost = 0;
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					cost += Math.abs(s[j][k] - arr[j][k]);
				}
			}			
			minCost = minCost > cost ? cost : minCost;
		}
		System.out.println(minCost);
		scanner.close();
	}
	
	public static int[][][] getSquares() {
		int[][] ms = {
				{8, 3, 4},
				{1, 5, 9},
				{6, 7, 2}
			};
		int[][][] msArr = new int[8][3][3];
		for (int i = 0; i < 8; i++) {
			if (i == 0) {				
				msArr[i] = ms.clone();
			} else {				
				int[][] rt = new int[3][3];
				if (i < 4) {				
					for (int j = 0; j < 3; j++) {
						for (int k = 0; k < 3; k++) {
							rt[k][2-j] = msArr[i-1][j][k]; // 시계 방향으로 회전
						}
					}
				} else {
					for (int j = 0; j < 3; j++) {
						for (int k = 0; k < 3; k++) {
							rt[j][2-k] = msArr[i-4][j][k]; // 좌우 반전
						}
					}
				}
				msArr[i] = rt.clone();
			}
			for (int[] r : msArr[i]) {
				System.out.println(Arrays.toString(r));
			}
			System.out.println();
		}
		return msArr;
	}
}
