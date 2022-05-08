package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10994별찍기19 {
	static boolean[][] grid;
	static void draw(int posI, int n) {
		for(int i=posI; i<posI+4*n-3; i++) {
			grid[i][posI] = true;
			grid[i][posI+4*n-4] = true;
			grid[posI][i] = true;
			grid[posI+4*n-4][i] = true;
		}
		if(n>0) {
			draw(posI+2, n-1);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int len = 4*N-3;
		grid = new boolean[len][len];
		draw(0, N);
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(grid[i][j]) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
