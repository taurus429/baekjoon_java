package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5582공통부분문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int max =0;
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		for(int i=1; i<str1.length()+1; i++) {
			for(int j=1; j<str2.length()+1; j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}
