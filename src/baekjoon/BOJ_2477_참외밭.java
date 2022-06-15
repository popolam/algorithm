package baekjoon;

import java.util.Scanner;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int[] dir = new int[6];
		int[] len = new int[7];
		
		for (int i = 0; i < len.length - 1; i++) {
			dir[i] = sc.nextInt();
			len[i] = sc.nextInt();
		}
		len[6] = len[0];

		int[] area = new int[6];
		int maxArea = 0;
		int sum = 0;
		for (int i = 0; i < area.length; i++) {
			area[i] = len[i]*len[i+1];
			maxArea = Math.max(maxArea, area[i]);
			sum += area[i];
		}
		
		System.out.println((sum - (2 * maxArea)) * cnt);
		
		sc.close();
	}
}
