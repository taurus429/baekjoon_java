package baekjoon.bronze.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10163 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] grid = new int[1001][1001];
		int N= Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int lenX = Integer.parseInt(st.nextToken());
			int lenY = Integer.parseInt(st.nextToken());

			for(int j= startX; j<startX+lenX; j++) {
				for(int k= startY; k<startY+lenY; k++) {
					grid[j][k] = i;
				}
			}
		}
		for(int i=1; i<=N; i++) {
			int count =0;
			for(int j=0; j<1001; j++) {
				for(int k=0; k<1001; k++) {
					if(grid[j][k]==i) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
