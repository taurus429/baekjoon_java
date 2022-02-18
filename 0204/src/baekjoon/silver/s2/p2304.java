package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p2304 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int cnt = Integer.parseInt(br.readLine());
		int[][] grid = new int[cnt][2];
		for(int i=0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			grid[i] = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		}
		Arrays.sort(grid, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
			
		});
		int max = 0;
		for(int[] g:grid) {
			if(g[1]>max) {
				max = g[1];
			}
		}
		int point = 0;
		int height =0;
		int sum =0;
		for(int i=0; i<cnt; i++) {
			if(grid[i][1]>height) {
				sum+=(grid[i][0] - point)*height;
				height = grid[i][1];
				point = grid[i][0];
			}
		}
		height = 0;
		for(int i=cnt-1; i>=0; i--) {
			if(grid[i][1]>height) {
				sum+=(point - grid[i][0])*height;
				height = grid[i][1];
				point = grid[i][0];
			}
		}
		int maxstart=0;
		int maxend=0;
		for(int i=0; i<cnt; i++) {
			if(grid[i][1] == max) {
				maxstart = grid[i][0];
				break;
			}
		}
		for(int i=cnt-1; i>=0; i--) {
			if(grid[i][1] == max) {
				maxend = grid[i][0];
				break;
			}
		}
		System.out.println(sum+max*(maxend-maxstart+1));
	}
}
