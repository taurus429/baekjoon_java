package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3109 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] grid;
	static int width;
	static int height;
	static boolean found;
	static int[] path;
	static int[] longest;
	static int lenMax;
	static boolean[][] visited;

	static void connect(int line, int pipenum, int col) {
		if (col == width) {
			found = true;
			return;
		}
		for (int i = -1; i <= 1; i++) {
			if (line + i >= 0 && line + i < height && grid[line + i][col] == 0 && !visited[line + i][col]) {
				line += i;
				grid[line][col] = pipenum;
				visited[line][col] = true;
				connect(line, pipenum, col + 1);
				if (found) {
					return;
				}
				line -= i;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		height = Integer.parseInt(input[0]);
		width = Integer.parseInt(input[1]);
		grid = new int[height][width];
		visited = new boolean[height][width];

		for (int i = 0; i < height; i++) {
			String line = br.readLine();
			for (int j = 0; j < width; j++) {
				if (j == 0) {
					grid[i][j] = i + 1;
				} else {
					if (line.charAt(j) == 'x') {
						grid[i][j] = -1;
					}
				}
			}
		}
		for (int i = 0; i < height; i++) {
			found = false;
			connect(i, i + 1, 1);
		}
		int ans = 0;
		for (int i = 0; i < height; i++) {
			if (grid[i][width - 1] != 0) {
				ans++;
			}
		} 
		System.out.println(ans);

	}
}
