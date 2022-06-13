package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	static int N, K;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
		} else {
			bfs(N, K);
			System.out.println(ans);
		}
	}

	private static void bfs(int N, int K) {
		Queue<Integer> queue = new LinkedList<>();

		int[] check = new int[100001];
		queue.add(N);

		int pop;
		while (!queue.isEmpty()) {
			pop = queue.poll();
			if (pop == K) {
				ans = check[pop];
				return;
			}

			for (int i : new int[] { pop + 1, pop - 1, pop * 2 }) {
				if (0 <= i && i < check.length && check[i] == 0) {
					check[i] = check[pop] + 1;
					queue.add(i);
				}

			}
		}
		
		ans = 1;
	}

}
