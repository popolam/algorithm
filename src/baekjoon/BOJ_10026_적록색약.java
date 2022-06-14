package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026_적록색약 {
	static int N;
	static char[][] color;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		color = new char[N][];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			color[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j);
					ans++;
				}
			}
		}
		System.out.print(ans + " ");
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(color[i][j] == 'G') {
					color[i][j] = 'R';
				}
			}
		}
		visited = new boolean[N][N];
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j);
					ans++;
				}
			}
		}
		System.out.print(ans);
	}
	
	private static void dfs(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || color[nr][nc] != color[r][c]) continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc);
		}
	}
}
