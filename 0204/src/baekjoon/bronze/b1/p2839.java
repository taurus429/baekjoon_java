package baekjoon.bronze.b1;

import java.util.Scanner;

public class p2839 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] dp = new int[5001];
		dp[0] = 0;
		dp[1] = -1;
		dp[2] = -1;
		dp[3] = 1;
		dp[4] = -1;
		dp[5] = 1;
		if(N<6) {
			System.out.println(dp[N]);
			return;
		}
		for (int i = 6; i <= N; i++) {
			dp[i] = -1;
			int candi1 = dp[i - 3];
			int candi2 = dp[i - 5];
			if (candi1 != -1) {
				dp[i] = candi1 + 1;
			}
			if (candi2 != -1) {
				if(dp[i]!=-1) {
				dp[i] = Math.min(dp[i], candi2+1);}
				else {
					dp[i] = candi2+1;
				}
			}
		}
		System.out.println(dp[N]);
	}
}
