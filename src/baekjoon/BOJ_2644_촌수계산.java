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

public class BOJ_2644_촌수계산 {
	static int V, E;
	static int[] person;
	static int A, B;
	static List<Integer>[] adjList;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		person = new int[V + 1];
		adjList = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		E = Integer.parseInt(br.readLine());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adjList[s].add(e);
			adjList[e].add(s);
		}
		
		bfs(A);
		
		if(person[B] == 0) {
			System.out.println(-1);			
		} else {
			System.out.println(person[B]);			
		}
	}

	private static void bfs(int a) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(a);
		
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int i = 0; i < adjList[p].size(); i++) {
				if(person[adjList[p].get(i)] == 0) {
					person[adjList[p].get(i)] = person[p] + 1;
					q.offer(adjList[p].get(i));
				}
			}
		}
	}
}
