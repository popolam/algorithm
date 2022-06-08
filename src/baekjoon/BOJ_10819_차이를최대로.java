package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로 {
	static int N;
	static int[] arr;
	static int[] sel;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sel = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = Integer.MIN_VALUE;
		perm(0);
		
		System.out.println(ans);
	}

	private static void perm(int cnt) {
		if(cnt == N) {
//			System.out.println(Arrays.toString(sel));
			sum();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			sel[cnt] = arr[i];
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}
	}

	private static void sum() {
		int tmp = 0;
		for (int i = 1; i < N; i++) {
			tmp += Math.abs(sel[i - 1] - sel[i]);
		}
		ans = Math.max(ans, tmp);
	}
}
