package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583_영역구하기 {
	static int N, M, K;
	static int[][] map;
	static int[][] square;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int cnt;
	static List<Integer> area;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		square = new int[K][4];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = square[i][1]; j < square[i][3]; j++) {
				for (int k = square[i][0]; k < square[i][2]; k++) {
					map[j][k] += 1;
				}
			}
		}
		
		area = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		
		System.out.println(cnt);
		Collections.sort(area);
		for (int i = 0; i < area.size(); i++) {
			System.out.print(area.get(i) + " ");
		}
	}

	private static void bfs(int r, int c) {
		Queue<Integer> q = new LinkedList<>();
		map[r][c] += 1;
		q.offer(r);
		q.offer(c);
		
		int sum = 1;
		while(!q.isEmpty()) {
			int nowR = q.poll();
			int nowC = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				
				if(nextR < 0 || nextR >= M || nextC < 0 || nextC >= N) continue;
				
				if(map[nextR][nextC] == 0) {
					map[nextR][nextC] += 1;
					sum += 1; 
					q.offer(nextR);
					q.offer(nextC);
				}
			}
		}
		area.add(sum);
	}
}
