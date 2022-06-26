package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1002_터렛 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
			
            double d =  Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            
            if(d == 0 && r1 == r2) {
            	// 무한으로 교차하는 경우
            	System.out.println("-1");
            } else if(d > Math.abs(r2 - r1) && d < r1 + r2) {
            	// 두 점에서 만나는 경우
            	System.out.println("2");
            } else if(d == Math.abs(r2 - r1) ||  d == r1 + r2) {
            	// 한 점에서 만나는 경우
            	System.out.println("1");
            } else if(d > r1 + r2 || d < Math.abs(r2 - r1) || d == 0) {
            	// 만나지 않는 경우
            	System.out.println("0");
            }
		}
	}
}
