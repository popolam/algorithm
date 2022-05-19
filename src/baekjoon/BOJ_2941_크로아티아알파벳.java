package baekjoon;

import java.util.Scanner;

public class BOJ_2941_크로아티아알파벳 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] alpha = {"c=", "c-","dz=","d-","lj","nj","s=","z="};

		String str = sc.nextLine();
		for(String apl : alpha) {
			if(str.contains(apl)) {
				str = str.replace(apl, "_");
			}
		}
		System.out.println(str +" "+str.length());

	}
}
