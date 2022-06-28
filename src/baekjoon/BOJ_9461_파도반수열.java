package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9461_파도반수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			long[] tri = new long[N + 1];
			tri[0] = 0;
			tri[1] = 1;
			if(N > 1) {
				tri[2] = 1;
			}
			for (int i = 3; i < N + 1; i++) {
				tri[i] = tri[i - 2] + tri[i - 3]; 
			}
			
			System.out.println(tri[N]);
		}
	}
}
