package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1080_행렬 {
	static int N, M;
	static int[][] A, B;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		B = new int[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = tmp.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = tmp.charAt(j) - '0';
			}
		}

		answer = 0;
		
		// 뭐 바꿀 수 있는게 없잖아.
		if (N < 3 || M < 3) {
			if (IsSame(A, B)) {
				answer = 0;
			} else {
				answer = -1;
			}
		} else {
			// 바꿔보자
			Solution();
		}

		if (!IsSame(A, B)) {
			answer = -1;
		}

		System.out.println(answer);
	}

	private static void Solution() {
		// 3*3 만 바꿀 수 있으니, ( N-2, M-2 ) 까지밖에 못감
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (A[i][j] != B[i][j]) {
					filp(i, j);
					answer++;
				}
			}
		}
	}

	private static void filp(int cr, int cn) {
		for (int i = cr; i < cr + 3; i++) {
			for (int j = cn; j < cn + 3; j++) {
				A[i][j] = A[i][j] ^ 1; // 뒤집기
			}
		}

	}

	private static boolean IsSame(int[][] matA, int[][] matB) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matA[i][j] != matB[i][j])
					return false;
			}
		}

		return true;
	}
}
