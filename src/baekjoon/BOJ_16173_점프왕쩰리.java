package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16173_점프왕쩰리 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 1};
	static int[] dc = {1, 0};
	static String ans = "Hing";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
		System.out.println(ans);

	}

	private static void dfs(int r, int c) {
		if(map[r][c] == -1) {
			ans = "HaruHaru";
			return;
		}
		
		for (int d = 0; d < 2; d++) {
			int nr = r + dr[d] * map[r][c];
			int nc = c + dc[d] * map[r][c];
			if(nr >= N || nc >= N || visited[nr][nc]) continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc);
		}
		
	}
}
