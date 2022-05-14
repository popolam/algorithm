package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16234_인구이동 {

	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static int L;
	static int R;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int ans = 0;

		boolean isUpdated = false;
		while (true) {
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (update(map, i, j, visited)) {
						isUpdated = true;
					}
				}
			}
			if (!isUpdated) break;
			ans++;
			isUpdated = false;
		}
		System.out.println(ans);
	}

	public static boolean update(int[][] map, int i, int j, boolean[][] visited) {
		Queue<Pos> queue = new LinkedList<>();

		queue.offer(new Pos(i, j));

		Queue<Pos> openedQ = new LinkedList<>();
		int sum = 0;

		while (!queue.isEmpty()) {
			Pos p = queue.poll();
			int r = p.r;
			int c = p.c;

			if (visited[r][c]) continue;
			
			visited[r][c] = true;
			openedQ.offer(p);
			sum += map[r][c];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if (visited[nr][nc]) continue;

				int sub = Math.abs(map[r][c] - map[nr][nc]);
				if (sub >= L && sub <= R) {
					queue.offer(new Pos(nr, nc));
				}
			}
		}
		if (openedQ.size() <= 1) return false;
		
		sum = sum / openedQ.size();
		while (!openedQ.isEmpty()) {
			Pos curP = openedQ.poll();
			map[curP.r][curP.c] = sum;
		}
		
		return true;
	}
}