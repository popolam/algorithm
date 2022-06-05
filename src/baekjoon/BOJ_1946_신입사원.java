package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1946_신입사원 {
	static int N;
	static int[][] score;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			score = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i][0] = Integer.parseInt(st.nextToken());
				score[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(score, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
				
			});
			
			int ans = 1;
			int min = score[0][1];
			
			for (int i = 1; i < N; i++) {
				if(score[i][1] < min) {
					ans++;
					min = score[i][1];
				}
			}
			
			System.out.println(ans);
		}
	}
}
