package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int V, E;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		adjList = new ArrayList[V+1];
		visited = new boolean[V+1];
		
		for (int i = 1; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adjList[s].add(e);
			
			adjList[e].add(s);
		}
		
		bfs();
		
		System.out.println(ans);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 0; i < adjList[now].size(); i++) {
				int next = adjList[now].get(i);
				if(!visited[next]) {
					visited[next] = true;
					q.offer(next);
					ans++;
				}
			}
		}
	}
}
