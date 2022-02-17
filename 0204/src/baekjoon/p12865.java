package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p12865 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][K + 1];
		int[][] things = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			things[i][0] = Integer.parseInt(st.nextToken());
			things[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < K + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					int w=0;
					if ((j - things[i - 1][0]) >= 0) {
						w =dp[i - 1][j - things[i - 1][0]] + things[i - 1][1];
					}
						dp[i][j] = Math.max(dp[i - 1][j], w);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
