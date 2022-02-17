package swea.p5215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] W = new int[N + 1];
			int[] V = new int[N + 1];
			int[] dp = new int[K + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				V[i] = Integer.parseInt(st.nextToken());
				W[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {

				for (int j = K; j - W[i] >= 0; j--) {
					dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
				}
			}
			System.out.println("#"+t+" "+dp[K]);
		}
	}
}