package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p7579앱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int memory = Integer.parseInt(st.nextToken());
		int[] mem = new int[N];
		int[] cost = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			mem[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			idx += cost[i];
		}
		int[][] dp = new int[N+1][idx+1];
		for(int i=1; i<N+1; i++) {
			for(int j=0; j<=idx; j++) {
				if(j<cost[i-1]) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i-1]]+mem[i-1]);
				}
				if(dp[i][j]>=memory) {
					idx=j;
					break;
				}
			}
		}
		System.out.println(idx);
	}
}
