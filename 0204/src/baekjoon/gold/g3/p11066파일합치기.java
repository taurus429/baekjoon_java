package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11066파일합치기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] num= new int[n];
			int[][] dp = new int[n][n];
			int[] sum = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			for(int i=0; i<n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				dp[i][i] = num[i];
			}
			for(int i=0; i<n; i++) {
				sum[i+1] = num[i] + sum[i];
			}
			for(int i=0; i<n-1; i++) {
				dp[i][i+1] = dp[i][i]+ dp[i+1][i+1];
			}
			for(int k=2; k<n; k++) {
				for(int i=0; i+k<n; i++) {
					for(int j= i; j<i+k; j++) {
						if(j==i) {
							dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j] + dp[j+1][i+k] + sum[i+k+1] - sum[i+1]);
						} else if (j==i+k-1) {
							dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j] + dp[j+1][i+k] + sum[i+k] - sum[i]);
						} else {
							dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j] + dp[j+1][i+k] + sum[i+k+1] - sum[i]);
						}
					}
				}
			}
			System.out.println(dp[0][n-1]);
		}
	}
}
