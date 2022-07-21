package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {
	static int N, M;
	static String[] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new String[N];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine();
		}

		int min = Integer.MAX_VALUE;
		// 판이 8*8보다 클떄 시작점을 하나씩 옮김
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				// 위치에 맞는 Black or White를 저장하는 변수
				int oddb = 0;
				int evenb = 0;
				int oddw = 0;
				int evenw = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						// Black일 때 even or odd 위치인지 확인
						if (board[i + k].charAt(j + l) == 'B') { 
							if ((i + k + j + l) % 2 == 0) {
								evenb++;
							} else {
								oddb++;
							}
						} else if (board[i + k].charAt(j + l) == 'W') {
							// White일 때 even or odd 위치 인지 확인
							if ((i + k + j + l) % 2 == 0) {
								evenw++;
							} else {
								oddw++;
							}
						}
					}
				}
				
				if (min > oddb + evenw || min > oddw + evenb) {
					min = Math.min(oddb + evenw, oddw + evenb);
				}
			}
		}
		System.out.println(min);
	}
}