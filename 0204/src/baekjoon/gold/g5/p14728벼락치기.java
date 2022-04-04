package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p14728벼락치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		int[] score = new int[N];
		int[] cost = new int[N];
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			score[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N+1][time+1];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<time+1; j++) {
				if(j-cost[i-1]>=0) {
					dp[i][j] = Math.max(dp[i-1][j-cost[i-1]] + score[i-1], dp[i-1][j]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][time]);
	}
}
