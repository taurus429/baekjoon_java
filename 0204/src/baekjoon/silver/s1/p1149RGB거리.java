package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1149RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			dp[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				ArrayList<Integer> before = new ArrayList<>();
				for(int k=0; k<3; k++) {
					if(j!=k) {
						before.add(k);
					}
				}
				dp[i][j] = Math.min(dp[i][j]+dp[i-1][before.get(0)], dp[i][j]+dp[i-1][before.get(1)]);
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			ans = Math.min(ans, dp[N-1][i]);
		}
		System.out.println(ans);
	}
}
