package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class boj_14503_로봇청소기 {
	static int N, M;
	static int[][] map;
	static int r, c, dir;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];

		r = sc.nextInt();
		c = sc.nextInt();
		dir = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		ans = 1;
		dfs(r, c, dir);
		System.out.println(ans);

	}

	private static void dfs(int r, int c, int dir) {
		map[r][c] = 2;
		for (int i = 0; i < 4; i++) {
			dir -= 1;
			if (dir == -1)
				dir = 3;
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;

			if (map[nr][nc] == 0) {
				ans++;
				dfs(nr, nc, dir);
				return;
			}
		}

		dir = dir >= 2 ? dir - 2 : dir + 2;

		int nr = r + dr[dir];
		int nc = c + dc[dir];
		if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1) {
			dir = dir >= 2 ? dir - 2 : dir + 2;
			dfs(nr, nc, dir);
		}
	}
}
