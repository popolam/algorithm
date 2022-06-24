package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
	static int N, K;
	static boolean[] visited;
	static int min;
	static class Move {
		int pos;
		int time;
		
		public Move(int pos, int time) {
			this.pos = pos;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[100001];
		min = Integer.MAX_VALUE;
		bfs();
		
		System.out.println(min);
	}

	private static void bfs() {
		Queue<Move> q = new LinkedList<>();
		
		q.offer(new Move(N, 0));
		
		while(!q.isEmpty()) {
			Move move = q.poll();
			visited[move.pos] = true;
			
			// 목표지점에 도착했을 때
			if(move.pos == K) {
				min = Math.min(min, move.time);
			}
			
			// 순간이동을 했을 때 최대 거리를 넘어가지 않고, 해당 위치를 방문하지 않았다면
			if(move.pos * 2 <= 100000 && !visited[move.pos * 2]) {
				q.offer(new Move(move.pos * 2, move.time));
			}
			
			// 앞으로 이동 했을 때 최대 거리를 넘어가지 않고, 해당 위치를 방문하지 않았다면
			if(move.pos + 1 <= 100000 && !visited[move.pos + 1]) {
				q.offer(new Move(move.pos + 1, move.time + 1));
			}
			
			// 뒤로 이동했을 때 최대 거리를 넘어가지 않고, 해당 위치를 방문하지 않았다면
			if(move.pos - 1 >= 0 && !visited[move.pos - 1]) {
				q.offer(new Move(move.pos - 1, move.time + 1));
			}
		}
	}
}
