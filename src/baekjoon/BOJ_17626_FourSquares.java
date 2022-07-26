package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17626_FourSquares {
	static int n;
	static int[] data;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		data = new int[n + 1];
		data[1] = 1;
		
		for(int i = 2; i < data.length; i++){
            ans = 4;

            for(int j = 1; j * j <= i; j++){
                ans = Math.min(ans, data[i - j*j]);
            }
            data[i] = ans + 1;
        }
        System.out.println(data[n]);
	}
}
