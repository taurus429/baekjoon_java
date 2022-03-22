package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p16918봄버맨 {
	static int[] dx = new int[] {0, 0, 1, -1};
	static int[] dy = new int[] {1, -1, 0, 0};
	static void fill(int[][] grid) {
		int height = grid.length;
		int width = grid[0].length;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				grid[i][j] ++;
			}
		}
	}
	static void explode(int[][] grid) {
		int height = grid.length;
		int width = grid[0].length;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(grid[i][j]==2) {
					grid[i][j] = 0;
					for(int k=0; k<4; k++) {
						int ni = i+dx[k];
						int nj = j+dy[k];
						if(0<=ni&&ni<height&&0<=nj&&nj<width&&grid[ni][nj]==1) {
							grid[ni][nj] = 0;
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int height = Integer.parseInt(input[0]);
		int width = Integer.parseInt(input[1]);
		int time = Integer.parseInt(input[2]);
		
		int[][] grid = new int[height][width];
		for(int i=0; i<height; i++) {
			String temp = br.readLine();
			for(int j=0; j<width; j++) {
				if(temp.charAt(j)=='O') {
					grid[i][j] = 1;
				}
			}
		}
		for(int i=0; i<time-1; i++) {
			if(i%2==0)
				fill(grid);
			else
				explode(grid);
		}
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(grid[i][j] == 0) {
					System.out.print(".");
				} else {
					System.out.print("O");
				}
			}
			System.out.println();
		}
	}
}
