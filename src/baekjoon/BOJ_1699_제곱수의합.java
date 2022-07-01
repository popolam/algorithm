package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1699_제곱수의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];
		
		for(int i = 1; i <= N; i++) {
			dp[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			// 최소가 되는 제곱수 = n의 이전 수 들 중 제곱수 + n - 제곱수의 최수항 개수 
			for(int j = 1; j * j <= i; j++) {
				if(dp[i] > dp[i - (j * j)] + 1) {
					dp[i] = dp[i - (j * j)] + 1;
				}
			}
		}
		
		System.out.println(dp[N]);
	}
}
