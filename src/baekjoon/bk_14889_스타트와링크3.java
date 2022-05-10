package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bk_14889_스타트와링크3 {
	static int N;
	static int[][] act;
	static int[] person;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		act = new int[N][N];
		person = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				act[i][j] = sc.nextInt();
			}
			person[i] = i;
		}
		
		ans = Integer.MAX_VALUE;
		comb(0, 0);
		
		System.out.println(ans);
	}

	private static void comb(int cnt, int start) {
		if(cnt == N / 2) {
//			System.out.println(Arrays.toString(visited));
			List<Integer> a = new ArrayList<>();
			List<Integer> b = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if(visited[i]) {
					a.add(person[i]);
				} else {
					b.add(person[i]);
				}
			}
			
//			System.out.println(Arrays.toString(a.toArray()));
//			System.out.println(Arrays.toString(b.toArray()));
//			System.out.println();
			
			int sumA = 0;
			int sumB = 0;
			for (int i = 0; i < a.size() - 1; i++) {
				for (int j =i + 1; j < a.size(); j++) {
					if(i != j) {
//						System.out.println("[" + a.get(i) + "][" + a.get(j) + "]");
//						System.out.println("[" + b.get(i) + "][" + b.get(j) + "]");
						sumA += (act[a.get(i)][a.get(j)] + act[a.get(j)][a.get(i)]);
						sumB += (act[b.get(i)][b.get(j)] + act[b.get(j)][b.get(i)]);
					}
				}
			}
//			System.out.println(sumA);
//			System.out.println(sumB);
//			System.out.println();
			ans = Math.min(ans, Math.abs(sumA - sumB));
			return;
		}
		for (int i = start; i < N; i++) {
			visited[i] = true;
			comb(cnt + 1, i + 1);
			visited[i] = false;
		}
	}
}
