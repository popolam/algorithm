package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_2217_로프 {
	static int N;
	static Integer[] possible;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		possible = new Integer[N];
		for (int i = 0; i < N; i++) {
			possible[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(possible, Collections.reverseOrder());
		
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, i * possible[i - 1]);
		}
		System.out.println(ans);
	}
}
