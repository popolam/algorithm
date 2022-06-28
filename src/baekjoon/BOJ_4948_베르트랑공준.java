package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_4948_베르트랑공준 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			
			boolean[] prime = new boolean[2 * n + 1];
			Arrays.fill(prime, false);
			
			for (int i = 2; i < 2 * n + 1; i++) {
				if(!prime[i]) {
					if((int)Math.pow(i, 2) > 123456 * 2) {
						break;
					} else {
						for (int j = (int)Math.pow(i, 2); j < 2 * n + 1; j += i) {
							prime[j] = true;
						}
					}
				}
			}
			
			int cnt = 0;
			for (int i = n + 1; i < 2 * n + 1; i++) {
				if(!prime[i]) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		
	}
}
