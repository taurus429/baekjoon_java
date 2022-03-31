package baekjoon.gold.g4;

import java.util.Scanner;

public class p10993별찍기18 {
	static void star(int posI, int posJ, boolean[][] grid, int level) {
		if(level==0)
			return;
		int width = (int) (2*Math.pow(2, level) -3);
		int height = (int) (Math.pow(2, level) -1);
		if(level%2==0) {
			for(int i=0; i<width; i++) {
				grid[posI][posJ+i] = true;
			}
			for(int i=0; i<height; i++) {
				grid[posI+i][posJ+i] = true;
				grid[posI+i][posJ+width-1-i] = true;
			}
			star(posI+1, posJ+width/4+1, grid, level-1);
		} else {
			for(int i=0; i<width; i++) {
				grid[posI+height-1][posJ+i] = true;
			}
			for(int i=0; i<height; i++) {
				grid[posI+height-1-i][posJ+i] = true;
				grid[posI+height-1 -i][posJ+width-1-i] = true;
			}
			star(posI+height/2, posJ+width/4+1, grid, level-1);
		}
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int width = (int) (2*Math.pow(2, N) -3);
		int height = (int) (Math.pow(2, N) -1);
		boolean[][] grid=  new boolean[height][width];
		star(0, 0, grid, N);
		StringBuilder sb = new StringBuilder();
		if(N%2==0) {
			for(int i=0; i<height;i ++) {
				for(int j=0; j<width-i; j++){
					if(grid[i][j]) {
						sb.append("*");
					} else {
						sb.append(" ");
					}
				}
				sb.append("\n");
			}
			
		} else {
			for(int i=0; i<height;i ++) {
				for(int j=0; j<width/2+1+i; j++){
					if(grid[i][j]) {
						sb.append("*");
					} else {
						sb.append(" ");
					}
				}
				sb.append("\n");
			}
		}
		
		sb.deleteCharAt(sb.lastIndexOf("\n"));
		System.out.println(sb);
	}
}
