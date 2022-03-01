package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p기지국 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] adi = { -1, 0, 1, 0 };
	static int[] adj = { 0, 1, 0, -1 };
	static int[] bdi = { -1, 0, 1, 0, -2, 0, 2, 0 };
	static int[] bdj = { 0, 1, 0, -1, 0, 2, 0, -2 };
	static int[] cdi = { -1, 0, 1, 0, -2, 0, 2, 0, -3, 0, 3, 0 };
	static int[] cdj = { 0, 1, 0, -1, 0, 2, 0, -2, 0, 3, 0, -3 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			int n = Integer.parseInt(br.readLine());
			char[][] grid = new char[n][n];
			for (int i = 0; i < n; i++) {
				String temp = br.readLine();
				for (int j = 0; j < n; j++) {
					grid[i][j] = temp.charAt(j);
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 'A') {
						for (int k = 0; k < 4; k++) {
							int ni = adi[k] + i;
							int nj = adj[k] + j;
							System.out.println(ni + " " + nj);
							if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 'H') {
								grid[ni][nj] = 'X';
							}
						}
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(grid[i][j]);
				}
				System.out.println();
			}
		}
	}
}
