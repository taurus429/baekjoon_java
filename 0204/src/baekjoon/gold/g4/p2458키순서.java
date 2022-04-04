package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2458키순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] height = new int[node][node];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			height[start][end] = 1;
			height[end][start] = -1;
		}
		for (int k = 0; k < node; k++) {
			for (int i = 0; i < node; i++) {
				for (int j = 0; j < node; j++) {
					if (height[i][k] == 1 && height[k][j] == 1) {
						height[i][j] = 1;
						height[j][i] = -1;
					}
				}
			}
		}
		int ans = 0;
		for(int i=0; i<node; i++) {
			int count = 0;
			for(int j=0; j<node; j++) {
				if(height[i][j] != 0)
					count ++;
			}
			if(count == node -1) {
				ans ++;
			}
		}
		System.out.println(ans);
	}
}
