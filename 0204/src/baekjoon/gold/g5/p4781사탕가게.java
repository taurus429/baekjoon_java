package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4781사탕가게 {
	static int getPrice(String input) {
		int res = 0;
		StringTokenizer st = new StringTokenizer(input, ".");
		int high = Integer.parseInt(st.nextToken());
		int low = Integer.parseInt(st.nextToken());
		res = high * 100 + low;
		return res;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int price = getPrice(st.nextToken());
		while(!(N==0&&price==0)) {
			int[] cal = new int[N];
			int[] pri = new int[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				cal[i] = Integer.parseInt(st.nextToken());
				pri[i] = getPrice(st.nextToken());
			}
			int[][] dp = new int[N+1][price+1];
			for(int i=1; i<=N; i++) {
				for(int j=0; j<price+1; j++) {
					if(j-pri[i-1]>=0) {
						dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i-1][j-pri[i-1]]+cal[i-1], dp[i][j-pri[i-1]]+cal[i-1]));
					} else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			System.out.println(dp[N][price]);
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			price = getPrice(st.nextToken());
		}
	}
}
