package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p18500미네랄2 {
	static int height, width, mineral;
	static boolean[][] grid;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static ArrayList<int[]> check(int posI, int posJ) {
		if(!grid[posI][posJ]) return null;
		boolean[][] visited = new boolean[height][width];
		ArrayList<int[]> res = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { posI, posJ });
		visited[posI][posJ] = true;
		res.add(new int[] { posI, posJ });
		boolean flag = false;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == height - 1)
				flag = true;
			for (int i = 0; i < 4; i++) {
				int ni = cur[0] + dy[i];
				int nj = cur[1] + dx[i];
				if (0 <= ni && ni < height && 0 <= nj && nj < width && !visited[ni][nj] && grid[ni][nj]) {
					queue.offer(new int[] { ni, nj });
					visited[ni][nj] = true;
					res.add(new int[] { ni, nj });
				}
			}
		}
		if (flag)
			return null;
		return res;
	}

	static void right(int h) {
		int k = width - 1;
		while (k >= 0 && !grid[h][k]) {
			k--;
		}
		if (k < 0)
			return;
		grid[h][k] = false;
		ArrayList<int[]> cluster = null;
		if (h + 1 < height)
			cluster = check(h + 1, k);
		if (cluster == null && h - 1 >= 0)
			cluster = check(h - 1, k);
		if (cluster == null && k - 1 >= 0)
			cluster = check(h, k - 1);
		if (cluster != null) {
			for (int[] c : cluster) {
				grid[c[0]][c[1]] = false;

			}
			int fall = 0;
			label: while (true) {
				for (int[] c : cluster) {
					if (c[0] + fall + 1 < height && !grid[c[0] + fall + 1][c[1]]) {

					} else {
						break label;
					}
				}
				fall++;
			}
			for (int[] c : cluster) {
				grid[c[0] + fall][c[1]] = true;
			}

		}

	}

	static void left(int h) {
		int k = 0;
		while (k < width && !grid[h][k]) {
			k++;
		}
		if (k == width)
			return;
		grid[h][k] = false;
		ArrayList<int[]> cluster = null;
		if (h + 1 < height) {
			cluster = check(h + 1, k);
		}
		if (cluster == null && h - 1 >= 0) {
			cluster = check(h - 1, k);
		}
		if (cluster == null && k + 1 < width) {
			cluster = check(h, k + 1);
		}
		if (cluster != null) {
			for (int[] c : cluster) {
				grid[c[0]][c[1]] = false;

			}
			int fall = 0;
			label: while (true) {
				for (int[] c : cluster) {
					if (c[0] + fall + 1 < height && !grid[c[0] + fall + 1][c[1]]) {

					} else {
						break label;
					}
				}
				fall++;
			}
			for (int[] c : cluster) {
				grid[c[0] + fall][c[1]] = true;
			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		grid = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			String line = br.readLine();
			for (int j = 0; j < width; j++) {
				if (line.charAt(j) == 'x') {
					grid[i][j] = true;
					mineral++;
				}
			}
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if (i % 2 == 0) { // right
				left(height - Integer.parseInt(st.nextToken()));
			} else { // left
				right(height - Integer.parseInt(st.nextToken()));
			}
		}
		for (boolean[] b : grid) {
			for (boolean a : b) {
				if (a) {
					System.out.print("x");
				} else
					System.out.print(".");
			}
			System.out.println();
		}
	}
}
