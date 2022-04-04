package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1106호텔 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] value = new int[N];
		int[] cost = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		int idx = 2000000;
		int[][] dp = new int[N + 1][2000001];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= idx; j++) {
				if (j - cost[i - 1] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j],
							Math.max(dp[i][j - cost[i - 1]] + value[i - 1], dp[i - 1][j - cost[i - 1]] + value[i - 1]));
				} else {
					dp[i][j] = dp[i - 1][j];
				}
				if (dp[i][j] >= C) {
					idx = j;
					break;
				}
			}
		}
		System.out.println(idx);
	}
}
