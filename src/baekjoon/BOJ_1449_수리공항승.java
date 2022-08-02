package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1449_수리공항승 {
	static int N, L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int[] pipe = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pipe[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(pipe);
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(i == N - 1) {
				count++;
				continue;
			}
			
			int hole = pipe[i++];
			while(N > i) {
				if(pipe[i] - hole <= L - 1) {
					i++;
				}
				else {
					break;
				}
			}
			count++;
			i--;
		}
		
		System.out.println(count);
	}
}
