package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1744_수묶기 {
	static int N;
	static int[] arr;
	static int st, ed;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		
		int left = 0;
		int right = N - 1;
		ans = 0;
		
		// 0, 음수일 경우 처리
		for (; left < right; left += 2) {
			if (arr[left] < 1 && arr[left + 1] < 1) {
				ans += arr[left] * arr[left + 1];
			} else {
				break;
			}
		}

		// 양수일 경우 처리
		for (; right > 0; right -= 2) {
			// 1과는 곱하지 않게 조건문 추가.
			if (arr[right] > 1 && arr[right - 1] > 1) {
				ans += arr[right] * arr[right - 1];
			} else {
				break;
			}
		}
		
		// 남은 값들은 더해주기
		for (; right >= left; right--) {
			ans += arr[right];
		}
		
		System.out.println(ans);
	}
}
