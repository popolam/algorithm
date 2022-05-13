package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static class Pos {
		int r;
		int c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int cnt;
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		list = new ArrayList<>();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		bfs();
		System.out.println(cnt);
		Collections.sort(list);
		for(int i: list) {
			System.out.println(i);
		}
	}
	private static void bfs() {
		Queue<Pos> queue = new LinkedList<Pos>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					cnt++;
					queue.offer(new Pos(i, j));
					map[i][j] = 2;
					int tmp = 1;
					
					while(!queue.isEmpty()) {
						Pos p = queue.poll();
						
						for (int d = 0; d < 4; d++) {
							int nr = p.r + dr[d];
							int nc = p.c + dc[d];
							
							if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
							
							if(map[nr][nc] == 1) {
								queue.offer(new Pos(nr, nc));
								map[nr][nc] = 2;
								tmp++;
							}
						}
					}
					list.add(tmp);
				}
			}
		}
	}
}
