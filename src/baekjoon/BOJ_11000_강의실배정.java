package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_강의실배정 {
	static int N;
	static class Lec {
		int s;
		int t;
		public Lec(int s, int t) {
			this.s = s;
			this.t = t;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		List<Lec> lecList = new ArrayList<>();
		PriorityQueue<Integer> room = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			lecList.add(new Lec(s, t));
		}
		Collections.sort(lecList, new Comparator<Lec>() {

			@Override
			public int compare(Lec o1, Lec o2) {
				if(o1.s == o2.s) return o1.t < o2.t ? -1 : 1;
				return o1.s < o2.s ? -1 : 1;
			}
			
		});
		
		for (Lec l: lecList) {
			if (room.isEmpty()) { // 강의실이 없으면 추가
				room.add(l.t);
				continue;
			}
			
			// 다음 강의가 시작하는 시간 이전에 
			// 강의가 끝나는 강의실이 있으면 해당 강의실에서 강의 시작
			if (room.peek() <= l.s) {
				room.poll();
			}
			room.add(l.t);
		}
		
		System.out.println(room.size());
	}
}
