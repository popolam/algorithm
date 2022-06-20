package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {
	static int N;
	static List<Integer>[] adjList;
	static int[] parent;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		adjList =  new ArrayList[N + 1];
		parent = new int[N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adjList[s].add(e);
			adjList[e].add(s);
		}
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}

	private static void dfs(int v) {
		if(visited[v]) return;
		
		visited[v] = true;
		for (int i = 0; i < adjList[v].size(); i++) {
			if(!visited[adjList[v].get(i)]) {
				parent[adjList[v].get(i)] = v;
				dfs(adjList[v].get(i));
			}
		}
	}
}
