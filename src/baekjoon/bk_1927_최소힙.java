package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class bk_1927_최소힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> q =new PriorityQueue<>();
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int val = sc.nextInt();
			if(val != 0) {
				q.add(val);
			} else if (q.isEmpty()) {
				System.out.println("0");
			} else {
				System.out.println(q.poll());
			}
		}
	}
}
