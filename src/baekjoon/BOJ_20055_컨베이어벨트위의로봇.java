package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {
	static int N, K;
	static int[] map; // 내구도
	static boolean[] robot; // 로봇 위치
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[2 * N];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0;
		while (isOK()) {
            int temp = map[2 * N - 1]; // 1. 벨트 한 칸 회전
            for (int i = 2 * N - 1; i > 0; i--) {
                map[i] = map[i - 1];
            }
            map[0] = temp;

            for (int i = N - 1; i > 0; i--) {    // 로봇도 벨트와 같이 회전
                robot[i] = robot[i - 1];
            }
            robot[0] = false;

            robot[N - 1] = false;
            for (int i = N - 1; i > 0; i--) {   // 2. 로봇 이동가능하면 이동
                if (robot[i - 1] && !robot[i] && map[i] >= 1) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    map[i]--;
                }
            }

            if (map[0] > 0) {     // 3. 올라가는 위치에 로봇 올리기
                robot[0] = true;
                map[0]--;
            }
            
            ans++;
        }
		
		System.out.println(ans);
	}

	private static boolean isOK() {
		int cnt = 0;

        for (int i = 0; i < 2 * N; i++) {
            if (map[i] == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
	}
}
