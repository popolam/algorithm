package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_25418_정수a를k로만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		boolean[] visited = new boolean[K + 1]; 
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{A,0});
        visited[A] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == K) {
                System.out.println(cur[1]);
                return;
            }
            if (cur[0] * 2 <= K) {
                visited[cur[0]*2] = true;
                q.offer(new int[]{cur[0]*2, cur[1]+1});
            }
            if (!visited[cur[0]+1])
                q.offer(new int[]{cur[0]+1, cur[1]+1});
        }
	}

}
