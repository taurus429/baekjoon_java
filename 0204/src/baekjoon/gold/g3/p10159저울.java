package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10159저울 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] grid = new int[N][N];
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int big = Integer.parseInt(st.nextToken())-1;
			int small = Integer.parseInt(st.nextToken())-1;
			grid[big][small] = 1;
			grid[small][big] = -1;
		}
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(grid[i][k] == 1&&grid[k][j]==1) {
						grid[i][j] = 1;
						grid[j][i] = -1;
					} else if (grid[i][k] == -1 && grid[k][j] == -1) {
						grid[i][j] = -1;
						grid[j][i] = 1;
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			int count = -1;
			for(int j=0; j<N; j++) {
				if(grid[i][j]==0)
					count++;
			}
			System.out.println(count);
		}
	}
}
