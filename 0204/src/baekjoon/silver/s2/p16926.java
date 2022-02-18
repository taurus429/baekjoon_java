package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p16926 {
	static int[][] grid;
	static int height;
	static int width;

	static void turn(int h, int w, int startI, int startJ) {
		if (h < 2 || w < 2) {
			return;
		} else {
			int temp = grid[startI][startJ];
			for (int i = 0; i < w - 1; i++) {
				grid[startI][startJ] = grid[startI][startJ + 1];
				startJ++;
			}
			for (int i = 0; i < h - 1; i++) {
				grid[startI][startJ] = grid[startI + 1][startJ];
				startI++;
			}
			for (int i = 0; i < w - 1; i++) {
				grid[startI][startJ] = grid[startI][startJ - 1];
				startJ--;
			}
			for (int i = 0; i < h - 1; i++) {
				grid[startI][startJ] = grid[startI - 1][startJ];
				startI--;
			}
			grid[startI + 1][startJ] = temp;
			turn(h - 2, w - 2, startI + 1, startJ + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		height = Integer.parseInt(input[0]);
		width = Integer.parseInt(input[1]);
		int cnt = Integer.parseInt(input[2]);

		grid = new int[height][width];
		for (int i = 0; i < height; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < width; j++) {
				grid[i][j] = Integer.parseInt(input[j]);
			}
		}
		for (int i = 0; i < cnt; i++) {
			turn(height, width, 0, 0);
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
