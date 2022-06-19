package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576_토마토 {
	static int N, M;
	static int[][] box;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static Queue<Point> ripe;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		box = new int[M][N];
		ripe = new LinkedList<>();
		boolean check = true;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				box[i][j] = sc.nextInt();
				if(box[i][j] == 1) {
					ripe.offer(new Point(i, j));
				}
			}
//			System.out.println(Arrays.toString(box[i]));
		}
		
		bfs();
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, box[i][j]);
				if(box[i][j] == 0) {
					check = false;
				}
			}
//			System.out.println(Arrays.toString(box[i]));
		}
		
		System.out.println(check ? max - 1 : -1);
	}
	
	public static void bfs() {
		while(!ripe.isEmpty()) {
			Point p = ripe.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr < 0 || nr >= M || nc < 0 || nc >= N) {
    				continue;
    			}
				
				if(box[nr][nc] == 0) {
					box[nr][nc] = box[p.r][p.c] + 1;
					ripe.offer(new Point(nr, nc));
				}
			}
		}
	}
}
