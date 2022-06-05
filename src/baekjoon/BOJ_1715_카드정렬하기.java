package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {
	static int N;
	static long ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<Long>();

		for (int i = 0; i < N; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}

		while (pq.size() > 1) {
			long temp1 = pq.poll();
			long temp2 = pq.poll();

			ans += temp1 + temp2;
			pq.add(temp1 + temp2);
		}

		System.out.println(ans);
	}
}
