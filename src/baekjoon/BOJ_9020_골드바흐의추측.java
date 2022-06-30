package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9020_골드바흐의추측 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());

			boolean[] prime = new boolean[n + 1];
			Arrays.fill(prime, false);
			prime[1] = true;

			for (int i = 2; i < n + 1; i++) {
				if (!prime[i]) {
					if ((int) Math.pow(i, 2) > 10000) {
						break;
					} else {
						for (int j = (int) Math.pow(i, 2); j < n + 1; j += i) {
							prime[j] = true;
						}
					}
				}
			}
			
			outer:for (int i = n / 2; i > 1; i--) {
				if(!prime[i]) {
					for (int j = n / 2; j < n + 1; j++) {
						if(!prime[j]) {
							if(i + j == n) {
								System.out.println(i + " " + j);
								break outer;
							}
						}
					}
				}
			}
		}
	}
}
