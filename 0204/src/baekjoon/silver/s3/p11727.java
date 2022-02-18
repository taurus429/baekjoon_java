package baekjoon.silver.s3;

import java.util.Scanner;

public class p11727 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		if (N < 3) {
			if (N == 1) {
				System.out.println(1);
			} else if (N == 2) {
				System.out.println(3);
			}
		} else {
			int[] dp = new int[N];
			dp[0] = 1;
			dp[1] = 3;
			for (int i = 2; i < N; i++) {
				dp[i] = (dp[i - 1] + 2 * dp[i - 2])%10007;
			}
			System.out.println(dp[N - 1]%10007);
		}
	}
}
