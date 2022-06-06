package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339_단어수학 {
	static int N;
	static String[] word;
	static int[] value;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		word = new String[N];
		value = new int[26];
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
		}

		for (int i = 0; i < N; i++) {
			int temp = (int) Math.pow(10, word[i].length() - 1);
			for (int j = 0; j < word[i].length(); j++) {
				int charIdx = word[i].charAt(j) - 'A';
				value[charIdx] += temp;
				temp /= 10;
			}
		}

		Arrays.sort(value);

		int num = 9;
		for (int i = 25; i >= 0; i--) {
			if (value[i] == 0)	break;

			ans += (value[i] * num);
			num--;
		}
		System.out.println(ans);
	}
}
