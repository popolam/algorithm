package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14500_테트로미노 {
	static int N, M;
	static int[][] paper;
	static boolean[][] visited;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		paper = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, paper[i][j]);
				visited[i][j] = false;
				comb(0, 0, i, j, paper[i][j]);
			}
		}
		
		System.out.println(ans);
	}

	private static void comb(int cnt, int start, int r, int c, int sum) {
		if(cnt == 3) {
			ans = Math.max(ans, sum);
			return;
		}
		for (int d = start; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			
			comb(cnt + 1, d + 1, r, c, sum + paper[nr][nc]);
		}
	}

	private static void dfs(int r, int c, int cnt, int sum) {
		if(cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if(!visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, cnt + 1, sum + paper[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}
}
