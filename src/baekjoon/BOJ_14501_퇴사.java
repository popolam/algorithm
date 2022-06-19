package baekjoon;

import java.util.Scanner;

public class BOJ_14501_퇴사 {
	static int N;
	static int[] day, pay;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		day = new int[N];
		pay = new int[N];
		
		for (int i = 0; i < N; i++) {
			day[i] = sc.nextInt();
			pay[i] = sc.nextInt();
		}
		
		ans = 0;
		dfs(0, 0);
		
		System.out.println(ans);
	}
	private static void dfs(int idx, int p) {
		if(idx >= N) {
			ans = Math.max(ans, p);
			return;
		}
		if(idx + day[idx] <= N) {
			dfs(idx + day[idx], p + pay[idx]);
		} else {
			dfs(idx + day[idx], p);
		}
		dfs(idx + 1, p);
	}
}
