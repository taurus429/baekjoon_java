package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p17404RGB거리2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int INF = 1000 * 1000;
		int min = INF;
		int[] dp = new int[3];
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < N; i++) {
				if (i == 0) {
					for(int j=0; j<3; j++) {
						if(j==k) {
							dp[j] = house[i][j];
						}else {
							dp[j] = INF;
						}
					}
				} else {
					int[] temp = new int[3];
					temp[0] = Math.min(house[i][0]+dp[1], house[i][0]+dp[2]);
					temp[1] = Math.min(house[i][1]+dp[0], house[i][1]+dp[2]);
					temp[2] = Math.min(house[i][2]+dp[0], house[i][2]+dp[1]);
					dp = temp.clone();
				}
			}
			for(int i=0; i<3; i++) {
				if(i!=k) {
					min = Math.min(min, dp[i]);					
				}
			}
		}
		System.out.println(min);
	}
}
