package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
	static int N, S;
	static int[] num;
	static int[] sel;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		num = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			sel = new int[i];
			comb(0, 0, i);
		}
		
		System.out.println(ans);
	}

	private static void comb(int cnt, int start, int goal) {
		if(cnt == goal) {
//			System.out.println(Arrays.toString(sel));
			int sum = 0;
			for (int i = 0; i < goal; i++) {
				sum += sel[i];
			}
			if(S == sum) ans++;
			return;
		}
		for (int i = start; i < N; i++) {
			sel[cnt] = num[i];
			comb(cnt + 1, i + 1, goal);
		}
	}
}
