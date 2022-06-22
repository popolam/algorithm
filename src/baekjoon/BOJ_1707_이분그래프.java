package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707_이분그래프 {
	static int V, E;
	static List<Integer>[] adjList;
	static int[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[V + 1];
			check = new int[V + 1];
			
			for (int i = 0; i <= V; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				adjList[s].add(e);
				adjList[e].add(s);
			}
			
			boolean flag = true;
			for(int i=1; i<=V; i++) {
				if(check[i]==0 && !bfs(i)) {
					flag = false;
					break;
				}
			}
						
			System.out.println(flag ? "YES" : "NO");
			
		}
	}

	private static boolean bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		check[start] = 1;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int e: adjList[node]) {
				if(check[e] == 0) {
					check[e] = check[node] == 1 ? 2 : 1;
					q.add(e);
				} else {
					if(check[e] == check[node])
						return false;
				}
			}
		}
		
		return true;
	}
}
