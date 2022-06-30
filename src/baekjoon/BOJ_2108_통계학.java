package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_2108_통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] cnt = new int[8001];
		
		double sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			cnt[arr[i] + 4000]++;
		}
		
		int avg = (int)Math.round(sum / N);
		System.out.println(avg);
		Arrays.sort(arr);
		int mid = arr[N / 2];
		System.out.println(mid);
		
		int max = Integer.MIN_VALUE;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < cnt.length; i++) {
			max = Math.max(max, cnt[i]);
		}
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i] == max) {
				list.add(i - 4000);
			}
		}
		
		if(list.size() == 1) {
			System.out.println(list.get(0));
		} else {
			System.out.println(list.get(1));
		}
		
		int range = arr[N - 1] - arr[0];
		System.out.println(range);
	}
}
