package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_15685_드래곤커브 {
	static int N;
	static boolean[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new boolean[101][101];

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			
			dragonCurve(x, y, d, g);
		}
		
		for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    ans++;
                }
            }
        }
		
		System.out.println(ans);
	}
	private static void dragonCurve(int x, int y, int d, int g) {
		List<Integer> list = new ArrayList<>();
        list.add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add((list.get(j) + 1) % 4);
            }
        }

        map[y][x] = true;
        for (int i = 0; i < list.size(); i++) {
            x += dx[list.get(i)];
            y += dy[list.get(i)];
            map[y][x] = true;
        }
	}
}
