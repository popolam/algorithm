package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3085_사탕게임 {
	static int N;
	static char[][] arr;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		ans = 0;
		// 좌우로 교체 후 비교
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				swapx(i, j);
				check();
				swapx(i, j);
			}
		}
		
		// 상하로 교체 후 비교
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {
				swapy(i, j);
				check();
				swapy(i, j);
			}
		}
		
		System.out.println(ans);
	}

	private static void swapx(int r, int c) {
		char tmp = arr[r][c];
		arr[r][c] = arr[r][c + 1];
		arr[r][c + 1] = tmp;
	}
	
	private static void swapy(int r, int c) {
		char tmp = arr[r][c];
		arr[r][c] = arr[r + 1][c];
		arr[r + 1][c] = tmp;
	}

	private static void check() {
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			tmp = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] == arr[i][j + 1]) {
					tmp++;
				} else {
					tmp = 1;
				}
				
				if (tmp > ans) {
					ans = tmp;
				}
			}
		}
		for (int j = 0; j < N; j++) {
			tmp = 1;
			for (int i = 0; i < N - 1; i++) {
				if (arr[i][j] == arr[i + 1][j]) {
					tmp++;
				} else {
					tmp = 1;
				}
				
				if (tmp > ans) {
					ans = tmp;
				}
			}
		}
	}
}
