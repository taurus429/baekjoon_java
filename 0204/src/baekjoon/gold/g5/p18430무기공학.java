package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p18430무기공학 {
	static boolean[][] visited;
	static int N, height, width;
	static int ans = Integer.MIN_VALUE;
	static int[][] grid;

	static int boo1(int posI, int posJ) {
		if (visited[posI][posJ] || visited[posI][posJ + 1] || visited[posI + 1][posJ + 1]) {
			return -1;
		}
		visited[posI][posJ] = visited[posI][posJ + 1] = visited[posI + 1][posJ + 1] = true;
		return grid[posI][posJ] + 2 * grid[posI][posJ + 1] + grid[posI + 1][posJ + 1];
	}

	static int boo2(int posI, int posJ) {
		if (visited[posI + 1][posJ] || visited[posI][posJ + 1] || visited[posI + 1][posJ + 1]) {
			return -1;
		}
		visited[posI + 1][posJ] = visited[posI][posJ + 1] = visited[posI + 1][posJ + 1] = true;
		return grid[posI + 1][posJ] + grid[posI][posJ + 1] + 2 * grid[posI + 1][posJ + 1];
	}

	static int boo3(int posI, int posJ) {
		if (visited[posI][posJ] || visited[posI + 1][posJ] || visited[posI + 1][posJ + 1]) {
			return -1;
		}
		visited[posI][posJ] = visited[posI + 1][posJ] = visited[posI + 1][posJ + 1] = true;
		return grid[posI][posJ] + 2 * grid[posI + 1][posJ] + grid[posI + 1][posJ + 1];
	}

	static int boo4(int posI, int posJ) {
		if (visited[posI][posJ] || visited[posI][posJ + 1] || visited[posI + 1][posJ]) {
			return -1;
		}
		visited[posI][posJ] = visited[posI][posJ + 1] = visited[posI + 1][posJ] = true;
		return 2 * grid[posI][posJ] + grid[posI][posJ + 1] + grid[posI + 1][posJ];
	}

	static void reset1(int posI, int posJ) {
		visited[posI][posJ] = visited[posI][posJ + 1] = visited[posI + 1][posJ + 1] = false;
	}

	static void reset2(int posI, int posJ) {
		visited[posI + 1][posJ] = visited[posI][posJ + 1] = visited[posI + 1][posJ + 1] = false;
	}

	static void reset3(int posI, int posJ) {
		visited[posI][posJ] = visited[posI + 1][posJ] = visited[posI + 1][posJ + 1] = false;
	}

	static void reset4(int posI, int posJ) {
		visited[posI][posJ] = visited[posI][posJ + 1] = visited[posI + 1][posJ] = false;
	}

	static void dfs(int idx, int sum) {
		if (idx == N) {
			ans = Math.max(ans, sum);
			return;
		}
		int posI = idx / (width - 1);
		int posJ = idx % (width - 1);
		int res1 = boo1(posI, posJ);
		if (res1 != -1) {
			dfs(idx + 1, sum + res1);
			reset1(posI, posJ);
		}
		int res2 = boo2(posI, posJ);
		if (res2 != -1) {
			dfs(idx + 1, sum + res2);
			reset2(posI, posJ);
		}
		int res3 = boo3(posI, posJ);
		if (res3 != -1) {
			dfs(idx + 1, sum + res3);
			reset3(posI, posJ);
		}
		int res4 = boo4(posI, posJ);
		if (res4 != -1) {
			dfs(idx + 1, sum + res4);
			reset4(posI, posJ);
		}
		dfs(idx + 1, sum);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		grid = new int[height][width];
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[height][width];
		N = (height - 1) * (width - 1);
		dfs(0, 0);
		if (ans == Integer.MIN_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}
	}
}
