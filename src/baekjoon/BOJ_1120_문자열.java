package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120_문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String x = st.nextToken();
		String y = st.nextToken();

		int ans = x.length();

		for (int i = 0; i < y.length() - x.length() + 1; i++) {
			int cha = 0;

			for (int j = 0; j < x.length(); j++) {
				if (x.charAt(j) != y.charAt(j + i)) {
					cha++;
				}
			}
			if (ans > cha) {
				ans = cha;
			}
		}

		System.out.println(ans);
	}
}
