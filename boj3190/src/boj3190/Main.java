package boj3190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("HELLO");
		int N = Integer.parseInt(bf.readLine());
//		System.out.println("N " + N);
		int[][] board = new int[N][N];
		int K = Integer.parseInt(bf.readLine());
//		System.out.println("K " + K);
		for (int i = 0; i < K; i++) {
			String input = bf.readLine();
			String[] coord = input.split(" ");
			int x = Integer.parseInt(coord[0]);
			int y = Integer.parseInt(coord[1]);
//			System.out.println("x " + x + " y " + y);
			board[x][y] = 1;
		}
//		for (int[] row : board) {
//			System.out.println(Arrays.toString(row));			
//		}
		int L = Integer.parseInt(bf.readLine());
//		System.out.println("L " + L);
		Map<Integer, String> turn = new HashMap<>();
		for (int i = 0; i < L; i++) {
			String input = bf.readLine();
//			System.out.println(input);
			String[] d = input.split(" ");
//			System.out.println(Arrays.toString(d));
			turn.put(Integer.parseInt(d[0]), d[1]);
		}
//		System.out.println(direction);
		int second = 1;
		Deque<Coord> deque = new ArrayDeque<Coord>();
		deque.addLast(new Coord(0, 0, "R"));
		while (true) {
			System.out.println(deque);
			Coord coord = deque.peek();
			int nr = coord.r;
			int nc = coord.c;
			if (turn.containsKey(second)) {
				String t = turn.get(second);
				if (t.equals("D")) {
					switch (coord.direction) {
					case "R":
						coord.direction = "D";
						break;
					case "L":
						coord.direction = "U";
						break;
					case "U":
						coord.direction = "R";
						break;
					case "D":
						coord.direction = "L";
						break;
					}
				} else {
					switch (coord.direction) {
					case "R":
						coord.direction = "U";
						break;
					case "L":
						coord.direction = "D";
						break;
					case "U":
						coord.direction = "L";
						break;
					case "D":
						coord.direction = "R";
						break;
					}
				}
				System.out.println("방향 전환 " + coord.direction);
			}
			switch (coord.direction) {
			case "R":
				nc = coord.c + 1;
				break;
			case "L":
				nc = coord.c - 1;
				break;
			case "U":
				nr = coord.r - 1;
				break;
			case "D":
				nr = coord.r + 1;
				break;
			}
			System.out.println("seconds " + second + " nr " + nr + " nc " + nc + " direction " + coord.direction);
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				System.out.println("* 판 바깥으로");
				break;
			}
			if (deque.contains(new Coord(nc, nr, ""))) {
				System.out.println("** 몸과 충돌");
				break;
			}
			System.out.println("nr " + nr + " nc " + nc);
			if (board[nr][nc] == 1) {
				System.out.println("*** 사과 먹음");
				deque.addFirst(new Coord(nr, nc, coord.direction));
				board[nr][nc] = 0;
				continue;
			}
			int size = deque.size();
			String nd = coord.direction;
			for (int i = 0; i < size; i++) {
				Coord c = deque.poll();
				deque.addLast(new Coord(nr, nc, nd));
				nr = c.r;
				nc = c.c;
				nd = c.direction;
			}
			second++;
		}
		System.out.println(second + 1);
	}
}

class Coord {
	int r;
	int c;
	String direction;

	Coord(int r, int c, String direction) {
		this.r = r;
		this.c = c;
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "r " + r + " c " + c;
	}

	@Override
	public boolean equals(Object object) {
		if (object != null && object instanceof Coord) {
			Coord obj = (Coord) object;
			return obj.r == this.r && obj.c == this.c;
		}

		return false;
	}
}
