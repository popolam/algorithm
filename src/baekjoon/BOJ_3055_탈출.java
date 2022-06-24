package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055_탈출 {
	static char[][] map;
	static boolean[][] notMoved; // T : 이동 불가능, F : 이동 가능.
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Queue<Point> waters;

	static int[] moveX = { 0, 1, 0, -1 };
	static int[] moveY = { -1, 0, 1, 0 };
	static int x, y;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		map = new char[y][x];
		notMoved = new boolean[y][x];
		waters = new LinkedList<Point>();

		// 무조건 D와 S는 하나씩만 주어진다고 했으므로 null로 초기화해도 상관없다.
		Point startPoint = null;
		Point endPoint = null;

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			map[i] = line.toCharArray();
			for (int j = 0; j < x; j++) {
				switch (map[i][j]) {
				case 'D':
					endPoint = new Point(j, i);
					notMoved[i][j] = true;
					break;
				case 'S':
					startPoint = new Point(j, i);
					break;
				case '*':
					waters.add(new Point(j, i));
					notMoved[i][j] = true;
					break;
				case 'X':
					notMoved[i][j] = true;
					break;
				}
			}
		}

		int result = bfsEscape(startPoint, endPoint);
		System.out.println(result == -1 ? "KAKTUS" : result);
	}

	// 고슴도치 탈출 함수
	static int bfsEscape(Point start, Point end) {
		int time = 0;
		Queue<Point> goSumDoChi = new LinkedList<Point>();
		goSumDoChi.offer(start);

		while (true) {
			if (goSumDoChi.isEmpty()) {
				return -1;
			}
			// 물 셋팅
			bfsWater();

			// 고슴도치 이동시키기
			Queue<Point> nextGoSumDoChi = new LinkedList<Point>();
			while (!goSumDoChi.isEmpty()) {
				Point goSum = goSumDoChi.poll();
				for (int i = 0; i < 4; i++) {
					int nextX = goSum.x + moveX[i];
					int nextY = goSum.y + moveY[i];
					// 고슴도치가 이동해서 동굴에 도착할 수 있다면
					if (nextX == end.x && nextY == end.y) {
						return time + 1;
					}

					if (validPoint(nextX, nextY)) {
						notMoved[nextY][nextX] = true;
						nextGoSumDoChi.add(new Point(nextX, nextY));
					}
				}
			}
			goSumDoChi = nextGoSumDoChi;
			time++;
		}
	}

	// 물 상하좌우로 흐르는 것을 notMoved boolean 배열에 나타내는 함수
	static void bfsWater() {
		Queue<Point> nextWaters = new LinkedList<Point>();

		while (!waters.isEmpty()) {
			Point water = waters.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = water.x + moveX[i];
				int nextY = water.y + moveY[i];
				if (validPoint(nextX, nextY)) {
					notMoved[nextY][nextX] = true;
					nextWaters.add(new Point(nextX, nextY));
				}
			}
		}
		waters = nextWaters;
	}

	// 해당 지점에 이동할 수 있는지(물이든 고슴도치이든) 체크하는 함수
	static boolean validPoint(int pointX, int pointY) {
		if (pointX < 0 || pointX >= x) {
			return false;
		}
		if (pointY < 0 || pointY >= y) {
			return false;
		}
		if (notMoved[pointY][pointX]) {
			return false;
		}
		return true;
	}
}