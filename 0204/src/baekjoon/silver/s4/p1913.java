package baekjoon.silver.s4;

import java.util.Scanner;

public class p1913 {
	static int[][]grid;
	static int n;
	static int num;
	static void write(int depth) {
		int len = n - depth*2;
		if(len==1) {
			grid[depth][depth] = 1;
		} else if(len<=0) return;
		int posI = depth;
		int posJ = depth;
		for(int i=0; i<len-1; i++) {
			grid[posI][posJ] = num--;
			posI ++;
		}
		for(int i=0; i<len-1; i++) {
			grid[posI][posJ] = num--;
			posJ ++;
		}
		for(int i=0; i<len-1; i++) {
			grid[posI][posJ] = num--;
			posI --;
		}
		for(int i=0; i<len-1; i++) {
			grid[posI][posJ] = num--;
			posJ --;
		}
		write(depth +1);
	}
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int target = scan.nextInt();
		num = n*n;
		grid = new int[n][n];
		write(0);
		int ansI=0;
		int ansJ=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(target == grid[i][j]) {
					ansI = i+1;
					ansJ = j+1;
				}
				sb.append(grid[i][j]+" ");
			}
			sb.append("\n");
		}
		sb.append(ansI+" "+ansJ);
		System.out.println(sb);
	}
}
