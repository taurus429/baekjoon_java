package toss.p6;

import java.util.Arrays;

class Solution {
	

	static public long solution(int money, long[][] stocks) {
        int N = stocks.length;
        int[][] dp = new int[stocks.length + 1][money + 1];
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < money + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					long w=0;
					if ((j - dp[i - 1][0]) >= 0) {
						w =dp[i - 1][j - (int)dp[i - 1][0]] + dp[i - 1][1];
					}
						dp[i][j] = (int) Math.max(dp[i - 1][j], w);
				}
			}
		}
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
        return dp[N][money];
    }
	public static void main(String[] args) {
		solution(10, new long[][] {{1, 1}, {3, 5}, {3, 5}, {4, 9}});
	}
}