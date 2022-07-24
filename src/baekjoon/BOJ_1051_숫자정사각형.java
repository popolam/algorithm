package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051_숫자정사각형 {
	static int N, M;
	static int[][] square;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		square = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				square[i][j] = tmp[j] - '0';
			}
		}

		ans = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// for문 조건문에 i+k가 n보다 작고 j+k가 m보다 작아 입력받은 배열을 벗어나지 못하도록 한다
				for (int k = 1; i + k < N && j + k < M; k++) { 
					// 왼쪽 상단의 꼭지점이랑 다른 꼭지점을 비교하여 모두가 동일하다면 꼭지점으로 이루어진 정사각형이다
					if (square[i][j] == square[i + k][j] && square[i][j] == square[i][j + k]
							&& square[i][j] == square[i + k][j + k])
						ans = Math.max(ans, (k + 1) * (k + 1));
				}
			}
		}
		System.out.println(ans);
	}
}
