package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2567 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] grid = new int[102][102];
		int cnt = Integer.parseInt(br.readLine());
		for(int i=0 ;i<cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int startX = Integer.parseInt(st.nextToken())+1;
			int startY = Integer.parseInt(st.nextToken())+1;
			for(int k =startX; k< startX+10; k++) {
				for(int j =startY; j< startY+10; j++) {
					grid[k][j] = 1;
				}
			}
		}
		int edge = 0;
		for(int i=0; i<102; i++) {
			for(int j=0; j<101; j++) {
				int res = grid[i][j]^grid[i][j+1];
				if(res == 1) {
					edge ++;
				}
			}
		}
		for(int i=0; i<101; i++) {
			for(int j=0; j<102; j++) {
				int res = grid[i][j] ^ grid[i+1][j];
				if(res ==1) {
					edge++;
				}
			}
		}
		System.out.println(edge);
	}
}
