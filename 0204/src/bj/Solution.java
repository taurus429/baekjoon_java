package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testcase; t++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int[][] grid = new int[n][n];
			int[][] sum = new int[n][n+1];
			
			for (int i=0; i<n; i++) {
				input = br.readLine().split(" ");
				for (int j=0;j<n;j++) {
					grid[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					sum[i][j+1] = sum[i][j] + grid[i][j];
				}
			}
			int flyCount =0;
			int maxCount = 0;
			for (int i=0; i<n-m+1; i++) {
				for (int j=0; j<n-m+1;j++) {
					for (int k=0; k<m; k++) {
						flyCount += (sum[i+k][j+m] - sum[i+k][j]);
					}
					if (flyCount > maxCount) {
						maxCount = flyCount;
					}
					flyCount =0;
				}
			}
			System.out.printf("#%d %d%n",t+1, maxCount);
			
		}
	}
}
