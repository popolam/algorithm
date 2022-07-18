package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869_달팽이는올라가고싶다 {
	static int A, B, V;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		ans = (V-B) / (A-B);
		
		if((V-B) % (A-B) != 0) {
			ans++;
		}
		System.out.println(ans);
	}
}
