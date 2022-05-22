package baekjoon;

import java.util.Scanner;

public class BOJ_1244_스위치켜고끄기 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] light = new int[N];
		for (int i = 0; i < N; i++) {
			light[i] = sc.nextInt();
		}
		
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			int sung = sc.nextInt();
			if (sung == 1) {
				int num = sc.nextInt();
				for (int j = num - 1; j < N; j += num)
					light[j] = 1 ^ light[j];
			} else {
				int num = sc.nextInt() - 1;
				light[num] = 1 ^ light[num];
				int j = 1;
				while (num + j < N && num - j >= 0 && light[num + j] == light[num - j]) {
					light[num + j] = 1 ^ light[num + j];
					light[num - j] = 1 ^ light[num - j];
					j++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(light[i] + " ");
			if((i + 1) % 20 == 0) {
				System.out.println();
			}
		}

	}
}
