package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11052카드구매하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N+1];
		st= new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N+1];
		dp[0] = card[0];
		for(int i=1; i<N+1; i++) {
			dp[i] = dp[0] + card[i];
			for(int j=1; j<i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + card[j]);
			}
		}
		System.out.println(dp[N]);
	}
}
