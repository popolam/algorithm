package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729_하노이탑이동순서 {
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		// 하노이 탑 공식 2^n - 1
		sb.append((int)Math.pow(2, N) - 1).append("\n");
		
		Hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}

	private static void Hanoi(int n, int a, int b, int c) {
		// 이동할 원반의 수가 1개일 때
		if(n == 1) {
			sb.append(a + " " + c).append("\n");
			return;
		}
		
		// a -> c 옮길 때
		// 먼저 n - 1개를 a -> b
		Hanoi(n - 1, a, c, b);
		
		// 1개를 a -> c
		sb.append(a + " " + c).append("\n");
		
		// n - 1개를 b -> c
		Hanoi(n - 1, b, a, c);
	}
}
