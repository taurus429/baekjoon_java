package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p13699점화식 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		dp[0] = 1;
		for(int i=1; i<N+1; i++) {
			long sum = 0;
			for(int j=0; j<i; j++) {
				sum += dp[j]*dp[i-j-1];
			}
			dp[i] = sum;
		}
		System.out.println(dp[N]);
	}
}
