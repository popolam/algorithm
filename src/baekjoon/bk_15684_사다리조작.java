package baekjoon;

import java.util.Scanner;

public class bk_15684_사다리조작 {
	static int N, M, H;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		map = new int[H + 1][N];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			map[a][b] = 1;
			map[a][b + 1] = -1;
		}

		if (isOdd() > 3) {
			System.out.println(-1);
			return;
		} else {
			for (int i = 0; i <= 3; i++) {
				if(dfs(0, i, 0, 0)) return;
			}
		}
		System.out.println(-1);
	}

	private static boolean dfs(int cnt, int size, int r, int c) {
		if (cnt == size) {
			if (ladderCheck()) {
				System.out.println(size);
				return true;
			}
			return false;
		}
		for (int i = r; i < H; i++) {
			for (int j = c; j < N - 1; j++) {
				if (map[i][j] != 0 || map[i][j + 1] != 0) continue;

				map[i][j] = 1;
				map[i][j + 1] = -1;
				if(dfs(cnt + 1, size, i, j + 2)) return true;
				map[i][j] = 0;
				map[i][j + 1] = 0;
			}
			c = 0;
		}
		return false;
	}

	private static boolean ladderCheck() {
		for (int i = 0; i < N; i++) {
			int nr = 0;
			int nc = i;

			while (nr <= H) {
				if (map[nr][nc] == 1) {
					nc++;
				} else if (map[nr][nc] == -1) {
					nc--;
				}
				nr++;
			}
			if (nc != i) return false;
		}
		return true;
	}

	private static int isOdd() {
		int oddNum = 0;
		for (int i = 0; i < N - 1; i++) {
			int num = 0;
			for (int j = 0; j < H; j++) {
				if (map[j][i] == 1)
					num++;
			}
			if (num % 2 == 1)
				oddNum++;
		}
		return oddNum;
	}
}
