package baekjoon.bronze.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p8958 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int t=0; t<testcase; t++) {
			String input = br.readLine();
			int cnt =0;
			int sum =0;
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i)=='O') {
					cnt ++;
					sum += cnt;
				}else {
					cnt =0;
				}
			}
			System.out.println(sum);
		}
	}
}
