package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4963섬의개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[][] grid;
	static int height, width;
	static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, -1, 1 };

	static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { i, j });
		grid[i][j] = false;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			for (int k = 0; k < 8; k++) {
				int ni = temp[0] + dy[k];
				int nj = temp[1] + dx[k];
				if (ni < height && ni >= 0 && nj < width && nj >= 0 && grid[ni][nj]) {
					grid[ni][nj] = false;
					queue.offer(new int[] { ni, nj });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		while (width != 0) {
			grid = new boolean[height][width];
			for (int i = 0; i < height; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < width; j++) {
					if (st.nextElement().equals("1")) {
						grid[i][j] = true;
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (grid[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
			st = new StringTokenizer(br.readLine());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());

		}
	}
}
