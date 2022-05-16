package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_15683_감시 {
	static int N, M;
	static int[][] map;
	static int[][] copyMap;
	static int[] output;

	static class CCTV {
		int num;
		int r;
		int c;

		CCTV(int num, int r, int c) {
			this.num = num;
			this.r = r;
			this.c = c;
		}
	}

	static ArrayList<CCTV> cctvList;
	static int[] dr = { -1, 0, 1, 0 }; 
	static int[] dc = { 0, 1, 0, -1 };
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		cctvList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvList.add(new CCTV(map[i][j], i, j));
				}
			}
		}

		ans = Integer.MAX_VALUE;
		output = new int[cctvList.size()]; 
		perm(0, cctvList.size());

		System.out.println(ans);
	}

	public static void perm(int depth, int r) {
		if (depth == r) {
			copyMap = new int[N][M];
			for (int i = 0; i < map.length; i++) {
				System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
			}

			for (int i = 0; i < cctvList.size(); i++) {
				direction(cctvList.get(i), output[i]);
			}

			getBlindSpot();

			return;
		}

		for (int i = 0; i < 4; i++) {
			output[depth] = i;
			perm(depth + 1, r);
		}
	}

	public static void direction(CCTV cctv, int d) {
		int cctvNum = cctv.num;

		if (cctvNum == 1) {
			if (d == 0)
				bfs(cctv, 0); 
			else if (d == 1)
				bfs(cctv, 1); 
			else if (d == 2)
				bfs(cctv, 2); 
			else if (d == 3)
				bfs(cctv, 3); 
		} else if (cctvNum == 2) {
			if (d == 0 || d == 2) {
				bfs(cctv, 0);
				bfs(cctv, 2); 
			} else {
				bfs(cctv, 1);
				bfs(cctv, 3); 
			}
		} else if (cctvNum == 3) {
			if (d == 0) {
				bfs(cctv, 0); 
				bfs(cctv, 1);
			} else if (d == 1) {
				bfs(cctv, 1); 
				bfs(cctv, 2);
			} else if (d == 2) {
				bfs(cctv, 2); 
				bfs(cctv, 3);
			} else if (d == 3) {
				bfs(cctv, 0); 
				bfs(cctv, 3);
			}
		} else if (cctvNum == 4) {
			if (d == 0) {
				bfs(cctv, 0); 
				bfs(cctv, 1);
				bfs(cctv, 3);
			} else if (d == 1) {
				bfs(cctv, 0); 
				bfs(cctv, 1);
				bfs(cctv, 2);
			} else if (d == 2) {
				bfs(cctv, 1); 
				bfs(cctv, 2);
				bfs(cctv, 3);
			} else if (d == 3) {
				bfs(cctv, 0); 
				bfs(cctv, 2);
				bfs(cctv, 3);
			}
		} else if (cctvNum == 5) { 
			bfs(cctv, 0);
			bfs(cctv, 1);
			bfs(cctv, 2);
			bfs(cctv, 3);
		}
	}

	public static void bfs(CCTV cctv, int d) {
		Queue<CCTV> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		queue.offer(cctv);
		visited[cctv.r][cctv.c] = true;

		while (!queue.isEmpty()) {
			CCTV ct = queue.poll();
			int nr = ct.r + dr[d];
			int nc = ct.c + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M || copyMap[nr][nc] == 6) {
				break;
			}

			if (copyMap[nr][nc] == 0) {
				copyMap[nr][nc] = -1; 
				queue.offer(new CCTV(cctv.num, nr, nc));
			} else { 
				queue.offer(new CCTV(cctv.num, nr, nc)); 
			}
		}
	}

	public static void getBlindSpot() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		ans = Math.min(ans, cnt);
	}
}