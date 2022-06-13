package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
	static int N, M;
	static boolean[] visited;
	static List<Integer>[] adjList;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			// 유향, 무향 그래프일 때
			adjList[s].add(e);
			
			// 무향 그래프일 때 
			adjList[e].add(s);
		}
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int v) {
		if(!visited[v]) {
			visited[v] = true;
			for (int i = 0; i < adjList[v].size(); i++) {
				dfs(adjList[v].get(i));
			}
		}
	}
}
