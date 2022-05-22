package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_4963_섬의개수 {
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int W, H;
	static int[][] map;
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			W = sc.nextInt();
			H = sc.nextInt();
			if(W == 0 && H == 0) {
				sc.close();
				break;
			}
			
			int ans = 0;
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
//				System.out.println(Arrays.toString(map[i]));
			}
//			System.out.println();
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j] == 1) {
						dfs(i, j);
						ans++;
					}
				}
			}
			
			System.out.println(ans);
		}
	}
	
	public static void dfs(int r, int c) {
		map[r][c] = 2;
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= H || nc < 0 || nc >= W) {
				continue;
			}
			
			if(map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
}
