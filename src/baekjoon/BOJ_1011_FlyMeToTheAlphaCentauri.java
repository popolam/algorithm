package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1011_FlyMeToTheAlphaCentauri {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int distance = y - x;
			int cnt = 0;
			
			int maxMove = (int)Math.sqrt(distance);	// 제곱근(소수점 제거)
			
			if(maxMove == Math.sqrt(distance)) {
				cnt = maxMove * 2 - 1;
			} else if(distance <= maxMove * maxMove + maxMove) {
				cnt = maxMove * 2;
			} else {
				cnt = maxMove * 2 + 1;
			}
			
			System.out.println(cnt);
		}
	}
}
