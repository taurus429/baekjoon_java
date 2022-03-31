package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11055가장큰증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] dp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			if(i==0) {
				dp[i] = num[i];
			} else {
				for(int j=0; j<i; j++) {
					if(num[j]<num[i]){
						dp[i] = Math.max(dp[i], dp[j]+num[i]);
					} else {
						dp[i] = Math.max(dp[i], num[i]);
					}
				}
			}
		}
		int ans = 0;
		for(int i=0; i<N; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
