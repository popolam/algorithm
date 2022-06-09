package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10971_외판원순회2 {
	static int N;
	static int[][] cost;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			perm(i, i, 0, 0);
		}
		
		System.out.println(ans);
	}

	private static void perm(int start, int i, int cnt, int sum) {
		if(cnt == N && start == i) {
			ans = Math.min(ans, sum);
			return;
		}
		for (int j = 0; j < N; j++) {
			if(cost[i][j] == 0) continue;
			
			if(!visited[i] && cost[i][j] > 0) {
				visited[i] = true;
				sum += cost[i][j];
				perm(start, j, cnt + 1, sum);
				visited[i] = false;
				sum -= cost[i][j];
			}
		}
	}
}
