package baekjoon.gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2169로봇조종하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int[][] grid = new int[height][width];
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] sum = new int[width + 1];
		for (int j = 0; j < width; j++) {
			sum[j + 1] = sum[j] + grid[0][j];
		}
		int[][] dp = new int[height][width];
		int[][] right = new int[height][width];
		int[][] left = new int[height][width];
		for (int i = 0; i < width; i++) {
			dp[0][i] = sum[i + 1];
		}
		for (int i = 1; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (j == 0) {
					right[i][j] = dp[i - 1][j] + grid[i][j];
				} else {
					right[i][j] = Math.max(dp[i - 1][j] + grid[i][j], right[i][j - 1] + grid[i][j]);
				}
			}
			for (int j = width - 1; j >= 0; j--) {
				if (j == width - 1) {
					left[i][j] = dp[i - 1][j] + grid[i][j];
				} else {
					left[i][j] = Math.max(dp[i - 1][j] + grid[i][j], left[i][j + 1] + grid[i][j]);
				}
			}
			for (int j = 0; j < width; j++) {
				dp[i][j] = Math.max(left[i][j], right[i][j]);
			}
		}
		System.out.println(dp[height - 1][width - 1]);
	}
}
