package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2567_색종이2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[101][101];	//정상 (인덱스 편하게 쓰려고.. +1)
		int[][] map2 = new int[101][101];	//세로
		int count = 0;	//답
		int N = sc.nextInt();
		
		// 색종이 붙이기
		for(int n = 0 ; n < N ; n++) {
			int c = sc.nextInt();	//색종이 c값
			int r = sc.nextInt();	//색종이 r값
			for(int i = 0 ; i < 10 ; i++) {
				for (int j = 0; j < 10 ; j++) {
					map2[r+j][c+i] = map[c+i][r+j] = 1;
				}
			}
		}
		
		//색종이 붙인 후 검은부분과 도화지 경계 찾기
		//셀 하나씩 탐색, 오른쪽, 아래 방향만 보자.. (사방탐색 하면 두번씩 얻으니까..)
		for(int i = 1 ; i < 101 ; i++) {
			for(int j = 1 ; j < 101 ; j++) {
				if(map[i-1][j]!=map[i][j])count++;		//가로방향 경계
				if(map2[j-1][i] != map2[j][i]) count++;	//세로방향 경계
			}
		}
		System.out.println(count);

	}
}
