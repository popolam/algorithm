package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2529_부등호 {
	static int k;
	static char[] arr = new char[10]; // 부등호는 최대 9개임
	static boolean[] visited = new boolean[10]; // 0~9까지 check
	static List<String> ans = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < k; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		dfs("", 0);
		Collections.sort(ans);
		
		System.out.println(ans.get(ans.size() - 1));
        System.out.println(ans.get(0));
	}

	private static void dfs(String num, int idx) {
		if (idx == k + 1) {
			ans.add(num);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (visited[i])
				continue;
			if (idx == 0 || ck(num.charAt(idx - 1) - '0', i, arr[idx - 1])) {
				visited[i] = true;
				dfs(num + i, idx + 1);
				visited[i] = false;
			}
		}
	}
	
	private static boolean ck(int a, int b, char c) {
        if (c == '<') {
            if (a > b) return false;
        } else if (c == '>') {
            if (a < b) return false;
        }
        return true;
    }
}
