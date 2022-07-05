package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄 {
	static int N, M;
	static int[] pack;
	static int[] one;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pack = new int[M];
		one = new int[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pack[i] = Integer.parseInt(st.nextToken());
			one[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(pack);
        Arrays.sort(one);
        if (N < 6) {
            ans += Math.min(pack[0], one[0] * N);
        } else {
            int tmp = Math.min(pack[0], one[0] * 6);
            ans += tmp * (N / 6);
            ans += Math.min(tmp, one[0] * (N % 6));
        }
        
        System.out.println(ans);
	}
}
