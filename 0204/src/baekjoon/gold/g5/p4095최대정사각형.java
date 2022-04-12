package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p4095최대정사각형 {
	static boolean[][] grid;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		while(!(height==0&&width==0)) {
			grid=  new boolean[height][width];
			for(int i=0; i<height; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<width; j++) {
					if(st.nextToken().equals("1")) {
						grid[i][j] = true;
					}
				}
			}
			int[][] dp = new int[height+1][width+1];
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					if(grid[i][j]) {
						int len = 1;
						int before = dp[i][j];
						for(int k=1; k<before+1; k++) {
							if(grid[i-k][j]&&grid[i][j-k]) {
								len ++;
							} else {
								break;
							}
						}
						dp[i+1][j+1] = len;
					}
				}
			}
			int ans = 0;
			for(int i=1; i<height+1; i++) {
				for(int j=1; j<width+1; j++) {
					ans = Math.max(ans, dp[i][j]);
				}
			}
			System.out.println(ans);
			st = new StringTokenizer(br.readLine());
			height = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			
		}
	}
}
