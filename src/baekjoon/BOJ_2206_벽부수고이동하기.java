package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
	static int N, M;
	static int[][] map;
	static int[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static class Point {
		int r;
		int c;
		int len;
		int crush;

		public Point(int r, int c, int len, int crush) {
			this.r = r;
			this.c = c;
			this.len = len;
			this.crush = crush;
		}
	}
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j] - '0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		ans = 0;
		bfs(0, 0);
		
		System.out.println(ans == 0 ? -1 : ans);
	}

	private static void bfs(int r, int c) {
		Point start = new Point(r, c, 1, 0);
		Queue<Point> q = new LinkedList<>();
		visited[r][c] = 0;
		q.offer(start);
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			int curR = cur.r;
			int curC = cur.c;
			int curLen = cur.len;
			int curCrush = cur.crush;
			
            // 도착지점을 만났다면 종료한다.
            if (curR == N - 1 && curC == M - 1) {
            	ans = curLen;
            	break;
            }
 
            for (int d = 0; d < 4; d++) {
                int nr = curR + dr[d];
                int nc = curC + dc[d];
 
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] > curCrush) {
                    if (map[nr][nc] == 0) {
                    	visited[nr][nc] = curCrush;
                    	q.offer(new Point(nr, nc, curLen + 1, curCrush));
                    } else { // 벽일 때
                        if (curCrush == 0) { // 지금까지 벽을 부순 횟수가 0이라면
                        	visited[nr][nc] = curCrush + 1;
                        	q.offer(new Point(nr, nc, curLen + 1, curCrush + 1));
                        }
                    }
                }
            }
		}
	}
}
