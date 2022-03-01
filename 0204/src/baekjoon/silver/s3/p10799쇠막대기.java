package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10799쇠막대기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		int cnt = -1;
		int ans = 0;
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i)=='(') {
				cnt ++;
			} else {
				if(input.charAt(i-1)=='(') {
					ans += cnt;
				}else {
					ans += 1;
				}
				cnt --;
			}
		}
		System.out.println(ans);
	}
}
