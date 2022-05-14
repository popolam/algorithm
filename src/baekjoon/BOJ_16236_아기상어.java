package baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16236_아기상어 {

	static int N;
	static int[][] map;
	static int ans;
	static boolean visited[][];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int sharkSize;
	static int eatFish;
	static int minLevel;
	static int babySharkR, babySharkC;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];
		visited = new boolean[N][N];
		babySharkR = 0;
		babySharkC = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					babySharkR = i;
					babySharkC = j;
					map[i][j] = 0;
				}

			}
		}

		sharkSize = 2;
		ans = 0;
		minLevel = 0;
		eatFish = 0;

		bfs(new int[] { babySharkR, babySharkC, 0 });

		System.out.println(ans);
	}

	public static void bfs(int[] info) {
		Queue<int[]> que = new LinkedList<>();
		visited[info[0]][info[1]] = true;
		que.offer(info);

		boolean isNext = false;
		List<int[]> list = new ArrayList<>();

		while (!que.isEmpty()) {
			int[] data = que.poll();
			int r = data[0];
			int c = data[1];
			int level = data[2];

			if (level != minLevel) {
				if (!list.isEmpty()) {
					Collections.sort(list, new Comparator<int[]>() {
						@Override
						public int compare(int[] o1, int[] o2) {
							return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
						}

					});

					int[] fish = list.get(0);
					int fishR = fish[0];
					int fishC = fish[1];

					babySharkR = fishR;
					babySharkC = fishC;

					eatFish++;

					map[fishR][fishC] = 0;
					ans += level;

					if (eatFish == sharkSize) {
						eatFish = 0;
						sharkSize++;
					}

					visited = new boolean[N][N];
					minLevel = 0;
					isNext = true;
					break;
				} else {
					minLevel = level;
				}
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] > sharkSize) continue;

				visited[nr][nc] = true; 
				if (map[nr][nc] > 0 && map[nr][nc] < sharkSize) { 
					list.add(new int[] { nr, nc }); 
				}

				que.offer(new int[] { nr, nc, level + 1 });

			}
		}

		if (isNext) {
			bfs(new int[] { babySharkR, babySharkC, 0 });
		}
	}

}