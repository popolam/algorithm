package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13305_주유소 {
	static int N;
	static long[] len;
	static long[] pay;
	static long min, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		len = new long[N - 1];
		pay = new long[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N - 1; i++) {
			len[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			pay[i] = Long.parseLong(st.nextToken());
		}
		
		min = Long.MAX_VALUE;
		for (int i = 0; i < N - 1; i++) {
			min = Math.min(min, pay[i]);
			ans += min * len[i];
		}
		
		System.out.println(ans);
	}
}
