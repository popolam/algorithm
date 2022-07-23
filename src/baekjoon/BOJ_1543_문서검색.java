package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543_문서검색 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sen = br.readLine();
		String find = br.readLine();
		int ans = 0;
		
		for(int i = 0; i < sen.length() - find.length() + 1; i++){
            String tmp = sen.substring(i, i + find.length());
            if(tmp.equals(find)){
                ans++;
                i += find.length() - 1;
            }
        }
		
		System.out.println(ans);
	}
}
