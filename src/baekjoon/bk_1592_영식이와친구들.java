package baekjoon;

import java.util.Scanner;

public class bk_1592_영식이와친구들 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 인원
        int M = sc.nextInt();	// max
        int L = sc.nextInt();	// interval

        int[] ball = new int[N];
        int curr=0;	// 1번 자리 시작
        do{
            ball[curr]++;
            if(ball[curr]%2==0){	// 홀수번
                curr=(curr-L+N)%N;
            }
            else{					// 짝수번
                curr=(curr+L)%N;
            }
        }while(ball[curr]<M);
        
        int ans = 0;		// 공을 던지는 총 횟수
        for(int i=0; i<N; i++){
            if(ball[i]>0) {
            	ball[i]--;
            }
            ans+=ball[i];
        }
        System.out.println(ans);

	}
}
