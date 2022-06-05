package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585_거스름돈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int change = 1000 - n;
		int result = 0;
		int [] coins = {500,100,50,10,5,1};

        for(int coin : coins) {

            if (coin > change)
                continue;
            result += change / coin;
            change %= coin;

        }
        System.out.println(result);
	}
}
