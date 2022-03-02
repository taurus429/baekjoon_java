package baekjoon.gold.g4;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1520내리막길 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] grid, cnt;
	static int height, width;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static void setCnt(int i, int j) {
		if(i==0&&j==0) {
			cnt[i][j] = 1;
			return;
		}
		int sum = 0;
		for (int k = 0; k < 4; k++) {
			int ni = i + dx[k];
			int nj = j + dy[k];
			if (0 <= ni && ni < height && 0 <= nj && nj < width && grid[i][j] < grid[ni][nj]) {
				if (cnt[ni][nj] == -1) {
					setCnt(ni, nj);
				}
				sum += cnt[ni][nj];
			}
		}
		cnt[i][j] = sum;

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		grid = new int[height][width];
		cnt = new int[height][width];
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				cnt[i][j] = -1;
			}
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (cnt[i][j] == -1)
					setCnt(i, j);
			}
		}
		System.out.println(cnt[height-1][width-1]);
	}
}
