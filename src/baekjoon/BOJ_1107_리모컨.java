package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1107_리모컨 {
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		while (M-- > 0)
			list.add(sc.nextInt());

		// 채널 100부터 시작하므로 100에서 원하는 채널까지 +키 또는 -키만으로 이동했을 때의 횟수를 최솟값 min에 저장
		int min = Math.abs(N - 100);
		
		// 이동하려고 하는 채널이 0부터 50만까지이다. 밑에서부터 위로 50만까지 갈 수도 있지만, 위에서부터 밑으로 50만까지 갈 수 있으므로 0부터 100만까지의 모든 숫자를 확인
		for (int i = 0; i <= 1000000; i++) {
			int length = chk(i);

			if (length > 0)
				min = Math.min(min, Math.abs(N - i) + length);
		}
		System.out.print(min);
	}
	
//	임의로 만든 채널 i가 버튼 조작으로 이동 가능한지 메서드 chk()
	private static int chk(int num) {
		int length = 0;
		if (num == 0)
			return list.contains(num) ? 0 : 1;
		
		while (num > 0) {
			// 만약 고장난 번호키이면 해당 채널은 숫자키를 눌러 움직일 수 없다는 의미로 0을 반환
			if (list.contains(num % 10))
				return 0;
			
			length++;
			num /= 10;
		}
		return length;
	}
}