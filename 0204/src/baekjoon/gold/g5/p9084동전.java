package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p9084동전 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] coin = new int[N];
			for (int i = 0; i < N; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
			int money = Integer.parseInt(br.readLine());
			int[][] dp = new int[N + 1][money + 1];
			for (int i = 0; i < N + 1; i++)
				dp[i][0] = 1;
			for (int j = 0; j < N; j++) {
				for (int i = 1; i <= money; i++) {
					dp[j + 1][i] = dp[j][i];
					if (i - coin[j] >= 0) {
						dp[j + 1][i] += dp[j + 1][i - coin[j]];
					}
				}
			}
			System.out.println(dp[N][money]);
		}
	}
}
