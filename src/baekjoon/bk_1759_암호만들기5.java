package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bk_1759_암호만들기5 {
	static int L, C;
	static char[] c;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		
		c = new char[C];
		for (int i = 0; i < C; i++) {
			c[i] = sc.next().charAt(0);
		}
		Arrays.sort(c);
//		System.out.println(Arrays.toString(c));
		
		visited = new boolean[C];
		comb(0, 0);
	}
	private static void comb(int cnt, int start) {
		if(cnt == L) {
			StringBuilder sb = new StringBuilder();
			int ja = 0;
			int mo = 0;
			for (int i = 0; i < C; i++) {
				if(visited[i]) {
					sb.append(c[i]);
					if(c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') mo++;
					else ja++;
				}
			}
			if(mo >= 1 && ja >= 2) {
				System.out.println(sb.toString());
			}
			return;
		}
		for (int i = start; i < C; i++) {
			visited[i] = true;
			comb(cnt + 1, i + 1);
			visited[i] = false;
		}
	}
}
