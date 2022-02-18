package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1992 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] grid;
	static void recur(int startI, int startJ, int len) {
		int sum = 0;
		for(int i=startI; i<startI+len; i++) {
			for(int j=startJ; j<startJ+len; j++) {
				sum += grid[i][j];
			}
		}
		if(sum == 0) {
			System.out.print(0);
		} else if(sum==len*len) {
			System.out.print(1);
		} else {
			System.out.print("(");
			recur(startI, startJ, len/2);
			recur(startI, startJ+len/2, len/2);
			recur(startI+len/2, startJ, len/2);
			recur(startI+len/2, startJ+len/2, len/2);
			System.out.print(")");
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				if(input.charAt(j)=='1') {
					grid[i][j] = 1;
				}
			}
		}
		recur(0, 0, N);
		
		
	}
}
