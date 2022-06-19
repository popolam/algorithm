package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R, C, maxStepCount = 1;
	static char[][] map;
	static int[][] dp;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static final int A = 'A';
	static boolean[] visited = new boolean[26];	// A-Z 중 방문했던 알파벳
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		map = new char[R][C];
		dp = new int[R][C];
	
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}
		
		dp[0][0] = 1;
		dfs(0, 0, 1);
		System.out.println(maxStepCount);
	}
	
	// 알파벳 사용여부 배열로 
	private static int dfs(int x, int y, int count) {
		visited[map[y][x] - A] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = y + dr[d];
			int nc = x + dc[d];
			
			// map 범위 체크
			if(nc < 0 || nc >= C || nr < 0 || nr >= R) {
				continue;
			}
			
			char alphabet = map[nr][nc];
			if(visited[alphabet - A]) {
				continue;
			}
			
			int result = dfs(nc, nr, count + 1);
			maxStepCount = Math.max(maxStepCount, result);
		}
		
		visited[map[y][x] - A] = false;
		return count;
	}
}
