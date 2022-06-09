package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10974_모든순열 {
	static int N;
	static int[] arr;
	static int[] sel;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sel = new int[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		perm(0);
	}

	private static void perm(int cnt) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			sel[cnt] = arr[i];
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}
	}
}
