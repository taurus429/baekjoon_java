package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p1938통나무옮기기 {
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static boolean checkTurn(int[][] grid, int posI, int posJ) {
		boolean res = true;
		res &= grid[posI-1][posJ-1]==0;
		res &= grid[posI-1][posJ]==0;
		res &= grid[posI-1][posJ+1]==0;
		res &= grid[posI][posJ+1]==0;
		res &= grid[posI+1][posJ+1]==0;
		res &= grid[posI+1][posJ]==0;
		res &= grid[posI+1][posJ-1]==0;
		res &= grid[posI][posJ-1]==0;
		return res;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				char input = line.charAt(j);
				if (input == 48) {
					grid[i][j] = 0;
				} else if (input == 49) {
					grid[i][j] = 1;
				} else {
					grid[i][j] = line.charAt(j);
				}
			}
		}
		int[] start = {};
		int[] end = {};
		boolean BBB = false;
		boolean EEE = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!BBB && grid[i][j] == 'B') {
					BBB = true;
					if (j + 1 < N && grid[i][j + 1] == 'B') {
						start = new int[] { 0, i, j + 1, 0 };
						grid[i][j] = 0;
						grid[i][j + 1] = 0;
						grid[i][j + 2] = 0;
					} else {
						start = new int[] { 1, i + 1, j, 0 };
						grid[i][j] = 0;
						grid[i + 1][j] = 0;
						grid[i + 2][j] = 0;
					}
				}
				if (!EEE && grid[i][j] == 'E') {
					EEE = true;
					if (j + 1 < N && grid[i][j + 1] == 'E') {
						end = new int[] { 0, i, j + 1, 0 };
						grid[i][j] = 0;
						grid[i][j + 1] = 0;
						grid[i][j + 2] = 0;
					} else {
						end = new int[] { 1, i + 1, j, 0 };
						grid[i][j] = 0;
						grid[i + 1][j] = 0;
						grid[i + 2][j] = 0;
					}
				}
			}
		}
		boolean[][][] visited = new boolean[2][N][N];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(start);
		visited[start[0]][start[1]][start[2]] = true;
		int ans = -1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == end[0] && cur[1] == end[1] && cur[2] == end[2]) {
				ans = cur[3];
				break;
			}
			if (cur[0] == 0) {// 가로
				for (int i = 0; i < 4; i++) {
					int ni = cur[1] + dy[i];
					int nj = cur[2] + dx[i];
					if (0 <= ni && ni < N && 0 <= nj - 1 && nj + 1 < N && !visited[0][ni][nj]) {
						if (grid[ni][nj - 1] == 0 && grid[ni][nj] == 0 && grid[ni][nj + 1] == 0) {
							visited[0][ni][nj] = true;
							queue.offer(new int[] { 0, ni, nj, cur[3] + 1 });
						}
					}
				}
				if (0 <= cur[1] - 1 && cur[1] + 1 < N && 0 <= cur[2] - 1 && cur[2] + 1 < N) {
					if (!visited[1][cur[1]][cur[2]]) {
						if (checkTurn(grid, cur[1], cur[2])) {
							visited[1][cur[1]][cur[2]] = true;
							queue.offer(new int[] { 1, cur[1], cur[2], cur[3] + 1 });
						}
					}
				}
			} else { // 세로
				for (int i = 0; i < 4; i++) {
					int ni = cur[1] + dy[i];
					int nj = cur[2] + dx[i];
					if (0 <= nj && nj < N && 0 <= ni - 1 && ni + 1 < N && !visited[1][ni][nj]) {
						if (grid[ni-1][nj] == 0 && grid[ni][nj] == 0 && grid[ni+1][nj] == 0) {
							visited[1][ni][nj] = true;
							queue.offer(new int[] { 1, ni, nj, cur[3] + 1 });
						}
					}
				}
				if (0 <= cur[1] - 1 && cur[1] + 1 < N && 0 <= cur[2] - 1 && cur[2] + 1 < N) {
					if (!visited[0][cur[1]][cur[2]]) {
						if (checkTurn(grid, cur[1], cur[2])) {
							visited[0][cur[1]][cur[2]] = true;
							queue.offer(new int[] { 0, cur[1], cur[2], cur[3] + 1 });
						}
					}
				}
			}
		}
		if(ans!=-1) {
			System.out.println(ans);
		}else {
			System.out.println(0);
		}
	}
}
