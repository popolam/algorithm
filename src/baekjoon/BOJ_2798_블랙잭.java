package baekjoon;

import java.util.Scanner;

public class BOJ_2798_블랙잭 {
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 카드 개수
		int M = sc.nextInt();	// 목표 숫자
		int[] card = new int[N];
		
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		//재귀함수를 통해 m과 가장 가까운 sum을 구한다
		search(card, 0, M, 0, 0);
		
		System.out.println(answer);

	}
	
	//카드 배열, 배열 인덱스, 합 기준수, 카드 몇개 뽑음?, 합
	static void search(int[] arr, int idx, int m, int count, int sum) {
		if(count == 3 && sum <= m) {	//성공조건(m값을 넘지 않으면서 3개 다 뽑음)
			answer = Math.abs(m-answer) > Math.abs(m-sum) ? sum : answer;
			return;
		}
		if(sum > m || idx == arr.length) return;	//실패(m값 넘음, 배열 끝까지 갔는데 3개 안더함)
		
		//해당 인덱스 안뽑음
		search(arr, idx+1, m, count, sum);
		//해당 인덱스 뽑음
		search(arr, idx+1, m, count+1, sum+arr[idx]);
		
	}

}
