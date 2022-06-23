package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389_케빈베이컨의6단계법칙 {
	static int N, M;
	static List<Integer>[] adjList;
	static int[] person;
	static int[] sel;
	static int min, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];
		person = new int[N + 1];
		sel = new int[2];

		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
			person[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			adjList[s].add(e);
			adjList[e].add(s);
		}

		min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			int a = bfs(i);
			if (a < min) {
				min = a;
				ans = i;
			}
		}

		System.out.println(ans);
	}

	public static int addCnt(int[] visited) {
		int sum = 0;
		for (int e : visited) {
			sum += e;
		}

		return sum;
	}

	public static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] visited = new int[N + 1];
		boolean[] marked = new boolean[N + 1];
		queue.add(start);
		marked[start] = true;

		while (!queue.isEmpty()) {
			int first = queue.poll();
			for (int e : adjList[first]) {
				if (visited[e] == 0 && !marked[e]) {
					queue.offer(e);
					marked[e] = true;

					visited[e] = visited[first] + 1;
				}
			}
		}

		return addCnt(visited);
	}
}
