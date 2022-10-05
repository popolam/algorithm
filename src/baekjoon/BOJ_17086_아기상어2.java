package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2 {
	static int N, M;
	static int[][] map;
	static int[][] visited;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static Queue<Node> q = new LinkedList<>();
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = Integer.MAX_VALUE;
				if (map[i][j] == 1) { // 아기 상어의 위치를 모두 queue에 넣음
					q.offer(new Node(i, j));
					visited[i][j] = 0; // 아기 상어의 거리를 0으로 설정
				}
			}
		}

		bfs();
		System.out.println(ans);
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Node p = q.poll();

			for (int d = 0; d < 8; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (visited[nr][nc] > visited[p.r][p.c] + 1) { // 아기 상어의 안전 거리 계산(최소)
					visited[nr][nc] = visited[p.r][p.c] + 1;
					ans = Math.max(ans, visited[nr][nc]); // 안전 거리 중 최대값 ans에 저장
					q.offer(new Node(nr, nc));
				}
			}
		}
	}
}
