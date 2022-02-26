package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17144미세먼지안녕 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int height, width, cleaner;
	static int[][] grid;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static void dustMove(Queue<int[]> dust, int[][] temp) {
		while (!dust.isEmpty()) {
			int[] d = dust.poll();
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int ni = dy[i] + d[0];
				int nj = dx[i] + d[1];
				if (ni >= 0 && ni < height && nj >= 0 && nj < width && grid[ni][nj] != -1) {
					temp[ni][nj] += grid[d[0]][d[1]] / 5;
					cnt++;
				}
			}
			grid[d[0]][d[1]] -= grid[d[0]][d[1]] / 5 * cnt;
		}
	}

	static void clean() {

		for (int i = cleaner - 2; i > 0; i--) {
			grid[i][0] = grid[i - 1][0];
		}
		for (int i = 0; i < width - 1; i++) {
			grid[0][i] = grid[0][i + 1];
		}
		for (int i = 0; i < cleaner - 1; i++) {
			grid[i][width - 1] = grid[i + 1][width - 1];
		}
		for (int i = width - 2; i > 0; i--) {
			grid[cleaner - 1][i + 1] = grid[cleaner - 1][i];
		}
		grid[cleaner - 1][1] = 0;

		for (int i = cleaner + 1; i < height - 1; i++) {
			grid[i][0] = grid[i + 1][0];
		}
		for (int i = 0; i < width - 1; i++) {
			grid[height - 1][i] = grid[height - 1][i + 1];
		}
		for (int i = height - 2; i >= cleaner; i--) {
			grid[i + 1][width - 1] = grid[i][width - 1];
		}
		for (int i = width - 2; i > 0; i--) {
			grid[cleaner][i + 1] = grid[cleaner][i];
		}
		grid[cleaner][1] = 0;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		Queue<int[]> dust = new LinkedList<int[]>();
		grid = new int[height][width];

		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] > 4) {
					dust.offer(new int[] { i, j });
				} else if (grid[i][j] == -1) {
					cleaner = i;
				}
			}
		}
		for (int t = 0; t < time; t++) {
			int[][] temp = new int[height][width];
			dustMove(dust, temp);
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					grid[i][j] += temp[i][j];
				}
			}
			clean();
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					if (grid[i][j] > 4) {
						dust.offer(new int[] { i, j });
					}
				}
			}
		}
		int sum =0;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(grid[i][j]>0) {
					sum += grid[i][j];
				}
			}
		}
		System.out.println(sum);
	}
}
