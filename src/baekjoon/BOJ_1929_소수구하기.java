package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// false면 소수
		boolean[] prime = new boolean[N+1];
		Arrays.fill(prime, false);
		prime[1] = true;
		
		for (int i = 2; i < N + 1; i++) {
			if(!prime[i]) {
				if((int)Math.pow(i, 2) > 1000000) {
					break;
				} else {
					for (int j = (int)Math.pow(i, 2); j < N + 1; j += i) {
						prime[j] = true;
					}
				}
			}
		}
		
		for (int i = M; i < N + 1; i++) {
			if(!prime[i]) {
				System.out.println(i);
			}
		}
		
	}
}
