package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {
	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { 2, 1, 2, 1, -1, -2, -1, -2 };
	static int[] dc = { 1, 2, -1, -2, -2, -1, 2, 1 };

	static int[][] map;

	static boolean[][] visit;

	static int endR;
	static int endC;

	static int N, T;

	static Queue<Pos> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			visit = new boolean[N][N];
			list = new LinkedList<Pos>();

			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.offer(new Pos(r, c));
			visit[r][c] = true;

			st = new StringTokenizer(br.readLine());
			endR = Integer.parseInt(st.nextToken());
			endC = Integer.parseInt(st.nextToken());

			bfs();
		}
	}

	public static void bfs() {

		while (!list.isEmpty()) {
			Pos p = list.poll();

			if (p.r == endR && p.c == endC) {
				System.out.println(map[p.r][p.c]);
				return;
			}

			for (int d = 0; d < 8; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (!visit[nr][nc]) {
					visit[nr][nc] = true;
					map[nr][nc] = map[p.r][p.c] + 1;
					list.offer(new Pos(nr, nc));
				}
			}

		}
	}
}
