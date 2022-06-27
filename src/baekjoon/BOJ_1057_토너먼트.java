package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1057_토너먼트 {
	static int N, A, B;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		ans = 1;
		for(int i = N; i >= 1; i /= 2) {
			if(((A + 1 == B) && (A % 2 == 1)) || ((B + 1 == A) && (B % 2 == 1))) {
				break;
			}
			A = A / 2 + A % 2;
			B = B / 2 + B % 2;
			ans++;
		}
		System.out.println(ans);
	}
}
