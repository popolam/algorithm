package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541_잃어버린괄호 {
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] minus = br.readLine().split("-");
		for (int i = 0; i < minus.length; i++) {
			int sum = 0;
			String[] plus = minus[i].split("\\+");
			for(String num : plus) {
				sum += Integer.parseInt(num);
			}
			
			if(i == 0) {
				ans += sum;
			} else {
				ans -= sum;
			}
		}
		
		System.out.println(ans);
	}
}
