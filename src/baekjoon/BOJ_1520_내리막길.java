package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520_내리막길 {
	static int N, M;
	static int[][] map;
	static int[][] cnt;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		cnt = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cnt[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));
	}

	private static int dfs(int r, int c) {
		if(r == M - 1 && c == N - 1) {
			return 1;
		}
		
		if(cnt[r][c] != -1) {
			return cnt[r][c];
		}
		
		cnt[r][c] = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
			
			if(map[nr][nc] < map[r][c]) {
				cnt[r][c] += dfs(nr, nc);
			}
		}
		
		return cnt[r][c];
	}
}
