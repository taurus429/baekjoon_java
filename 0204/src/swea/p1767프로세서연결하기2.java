package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1767프로세서연결하기2 {
	static int size, N, ans, maxConnect, processorCnt;

	static boolean checkright(boolean[][] grid, int posI, int posJ) {
		boolean res = true;
		posJ++;
		while (posJ < N) {
			if (grid[posI][posJ++]) {
				res = false;
				break;
			}
		}
		return res;
	}

	static boolean checkleft(boolean[][] grid, int posI, int posJ) {
		boolean res = true;
		posJ--;
		while (posJ >= 0) {
			if (grid[posI][posJ--]) {
				res = false;
				break;
			}
		}
		return res;
	}

	static boolean checkdown(boolean[][] grid, int posI, int posJ) {
		boolean res = true;
		posI++;
		while (posI < N) {
			if (grid[posI++][posJ]) {
				res = false;
				break;
			}
		}
		return res;
	}

	static boolean checkup(boolean[][] grid, int posI, int posJ) {
		boolean res = true;
		posI--;
		while (posI >= 0) {
			if (grid[posI--][posJ]) {
				res = false;
				break;
			}
		}
		return res;
	}

	static void fillright(boolean[][] grid, int posI, int posJ) {
		while (posJ < N) {
			grid[posI][posJ++] = true;
		}
	}

	static void fillleft(boolean[][] grid, int posI, int posJ) {
		while (posJ >= 0) {
			grid[posI][posJ--] = true;
		}
	}

	static void fillup(boolean[][] grid, int posI, int posJ) {
		while (posI >= 0) {
			grid[posI--][posJ] = true;
		}
	}

	static void filldown(boolean[][] grid, int posI, int posJ) {
		while (posI < N) {
			grid[posI++][posJ] = true;
		}
	}

	static void clone(boolean[][] grid, boolean[][] newgrid) {
		for (int i = 0; i < N; i++) {
			newgrid[i] = grid[i].clone();
		}
	}

	static void bfs(ArrayList<int[]> processor, boolean[][] grid, int cnt, int connect) {
		if (cnt == size) {
			if (connect >= maxConnect) {
				int count = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (grid[i][j])
							count++;
					}
				}
				if (connect == maxConnect)
					ans = Math.min(ans, count - processorCnt);
				else {
					maxConnect = connect;
					ans = count - processorCnt;
				}
			}
			return;
		}
		int[] cur = processor.get(cnt).clone();
		if (checkdown(grid, cur[0], cur[1])) {
			boolean[][] newgrid = new boolean[N][N];
			clone(grid, newgrid);
			filldown(newgrid, cur[0], cur[1]);
			bfs(processor, newgrid, cnt + 1, connect + 1);
		}
		cur = processor.get(cnt).clone();
		if (checkup(grid, cur[0], cur[1])) {
			boolean[][] newgrid = new boolean[N][N];
			clone(grid, newgrid);
			fillup(newgrid, cur[0], cur[1]);
			bfs(processor, newgrid, cnt + 1, connect + 1);
		}
		cur = processor.get(cnt).clone();
		if (checkright(grid, cur[0], cur[1])) {
			boolean[][] newgrid = new boolean[N][N];
			clone(grid, newgrid);
			fillright(newgrid, cur[0], cur[1]);
			bfs(processor, newgrid, cnt + 1, connect + 1);
		}
		cur = processor.get(cnt).clone();
		if (checkleft(grid, cur[0], cur[1])) {
			boolean[][] newgrid = new boolean[N][N];
			clone(grid, newgrid);
			fillleft(newgrid, cur[0], cur[1]);
			bfs(processor, newgrid, cnt + 1, connect + 1);
		}
		boolean[][] newgrid = new boolean[N][N];
		clone(grid, newgrid);
		bfs(processor, grid, cnt + 1, connect);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			N = Integer.parseInt(br.readLine());
			boolean[][] grid = new boolean[N][N];
			processorCnt = 0;
			ArrayList<int[]> processor = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if (st.nextToken().equals("1")) {
						grid[i][j] = true;
						if(i!=0&&i!=N-1&&j!=0&&j!=N-1)
						processor.add(new int[] { i, j });
						processorCnt ++;
					}
				}
			}
			ans = Integer.MAX_VALUE;
			size = processor.size();
			bfs(processor, grid, 0, 0);
			System.out.println("#" + t + " " + ans);
		}
	}
}
