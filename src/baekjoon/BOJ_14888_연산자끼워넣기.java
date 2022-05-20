package baekjoon;

import java.util.Scanner;

public class BOJ_14888_연산자끼워넣기 {
	static int N;
	static int[] A;
	static int[] op;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		op = new int[4];
		for (int i = 0; i < 4; i++) {
			op[i] = sc.nextInt();
		}
		
		dfs(A[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int num, int index) {
		if(index == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				
				switch(i) {
				case 0:
					dfs(num + A[index], index+1);
					break;
				case 1:
					dfs(num - A[index], index+1);
					break;
				case 2:
					dfs(num * A[index], index+1);
					break;
				case 3:
					dfs(num / A[index], index+1);
					break;
				}
				op[i]++;
			}
		}
		}
}
