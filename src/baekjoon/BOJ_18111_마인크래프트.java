package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111_마인크래프트 {
	static int N, M, B;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int time = Integer.MAX_VALUE;
	static int height = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(min, map[i][j]);
			}
		}

		for (int h = 0; h <= 256; h++) { // 높이를 0부터 256까지 높여가며 가능한 모든 경우를 탐색합니다.
			int remove = 0, inven = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] < h)
						inven += h - map[i][j]; // 현재 땅의 높이가 목표 높이보다 작으면 인벤토리에서 그 차이만큼 꺼내옵니다.
					if (map[i][j] > h)
						remove += map[i][j] - h; // 현재 땅의 높이가 목표 높이보다 높으면 그 차이만큼 제거합니다.
				}
			}
			if (remove + B >= inven) { // (제거된 땅의 높이+인벤토리에 가지고 있던 값 >= 인벤토리에서 사용할 값) 이면 해당 높이로 땅 고르기 작업이 가능합니다.
				int tmp = 2 * remove + inven; // 이때 걸리는 시간을 계산합니다.
				if (tmp <= time) { // 현재까지 걸리는 시간보다 작은 값이면 최소 시간을 업데이트하고, 최대 높이도 업데이트 합니다.
					time = tmp;
					height = h;
				}
			}
		}

		System.out.println(time + " " + height);
	}
}
