package baekjoon;

import java.util.Scanner;

public class BOJ_17135_캐슬디펜스 {
	static int n, m, d, ans;
	static int[][] map, mapCopy;
	static boolean[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		map = new int[n+1][m+1];
		mapCopy = new int[n+1][m+1];
		sel = new boolean[m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				map[i][j] = sc.nextInt();
		}

		combi(0, 0);

		System.out.println(ans);

	}

	public static void copymap() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				mapCopy[i][j] = map[i][j];
	}

	public static void combi(int s, int depth) {
		if (depth == 3) {
			copymap(); 
			simul(); 
			return;
		}
		for (int i = s; i < m; i++) {
			if (!sel[i]) {
				sel[i] = true;
				combi(i, depth + 1);
				sel[i] = false;
			}
		}
	}

	public static void simul() {
		int tempsum = 0;
		for (int time = 0; time < n; time++) {
			int[][] kill = new int[3][2];
			for(int i=0;i<3;i++)
				kill[i][0]=n;
			int loc = 0;
			for (int archor = 0; archor < m; archor++) {
				if (sel[archor]) {

					int mindist = 9999;
					for (int j = 0; j < m; j++) {
						for (int i = n - time - 1; i >= 0; i--) {
							int tempdist = Math.abs(n - time - i) + Math.abs(archor - j);
							if (mapCopy[i][j] == 1 && tempdist <= d && tempdist < mindist) {
								mindist = tempdist;
								kill[loc][0] = i;
								kill[loc][1] = j;
							}
						}
					}
					loc++;
				}
			}
			for (int i = 0; i < 3; i++) {
				if (mapCopy[kill[i][0]][kill[i][1]] == 1) {
					mapCopy[kill[i][0]][kill[i][1]] = 0;
					tempsum++;
				}
			}
		}
		if (tempsum > ans)
			ans = tempsum;
	}
}