package baekjoon;

import java.util.Scanner;

public class BOJ_2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int[][] paper = new int[100][100];
		int[][] cp = new int[cnt][2];
		for(int i = 0; i < cnt; i++) {
			cp[i][0] = sc.nextInt();
			cp[i][1] = sc.nextInt();
		}
		
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper[i].length; j++) {
				paper[i][j] = 0;
			}
		}
		
		for(int i = 0; i < cnt; i++) {
			for (int j = cp[i][0]; j < cp[i][0] + 10; j++) {
				for (int k = cp[i][1]; k < cp[i][1] + 10; k++) {
					if(paper[j][k] == 0) {
						paper[j][k] = 1;
					}
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper[i].length; j++) {
				ans += paper[i][j];
			}
		}
		
		System.out.println(ans);
	}
}
