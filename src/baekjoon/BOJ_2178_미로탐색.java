package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178_미로탐색 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}

		bfs();
		System.out.println(map[N - 1][M - 1]);
	}

	private static void bfs() {
        Queue<Integer> queue_r = new LinkedList<Integer>();
        Queue<Integer> queue_c = new LinkedList<Integer>();

        queue_r.offer(0);
        queue_c.offer(0);

        visited[0][0] = true;

        while(!queue_c.isEmpty()){
        	int r = queue_r.poll();
            int c = queue_c.poll();

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr >= 0 && nc >=0 && nr < N && nc < M){
                    if(map[nr][nc] == 1 && !visited[nr][nc]){
                        queue_r.offer(nr);
                        queue_c.offer(nc);

                        visited[nr][nc] = true;

                        map[nr][nc] = map[r][c] + 1;
                    }
                }
            }
        }
    }
}
