package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1767프로세서연결하기 {
	static int size, N, ans, maxConnect;

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

	static void fillright(boolean[][] grid, int posI, int posJ, boolean bool) {
		posJ++;
		while (posJ < N) {
			grid[posI][posJ++] = bool;
		}
	}

	static void fillleft(boolean[][] grid, int posI, int posJ, boolean bool) {
		posJ--;
		while (posJ >= 0) {
			grid[posI][posJ--] = bool;
		}
	}

	static void fillup(boolean[][] grid, int posI, int posJ, boolean bool) {
		posI++;
		while (posI >= 0) {
			grid[posI--][posJ] = bool;
		}
	}

	static void filldown(boolean[][] grid, int posI, int posJ, boolean bool) {
		posI--;
		while (posI < N) {
			grid[posI++][posJ] = bool;
		}
	}

	static void bfs(ArrayList<int[]> processor, boolean[][] grid, int cnt, int connect) {
		if(connect+N-cnt<maxConnect)
			return;
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
					ans = Math.min(ans, count - size);
				else {
					maxConnect = connect;
					ans = count;
				}
			}
			return;
		}
		int[] cur = processor.get(cnt).clone();
		if (checkdown(grid, cur[0], cur[1])) {
			filldown(grid, cur[0], cur[1], true);
			bfs(processor, grid, cnt + 1, connect + 1);
			filldown(grid, cur[0], cur[1], false);
		}
		cur = processor.get(cnt).clone();
		if (checkup(grid, cur[0], cur[1])) {
			fillup(grid, cur[0], cur[1], true);
			bfs(processor, grid, cnt + 1, connect + 1);
			fillup(grid, cur[0], cur[1], false);
		}
		cur = processor.get(cnt).clone();
		if (checkright(grid, cur[0], cur[1])) {
			fillright(grid, cur[0], cur[1], true);
			bfs(processor, grid, cnt + 1, connect + 1);
			fillright(grid, cur[0], cur[1], false);
		}
		cur = processor.get(cnt).clone();
		if (checkleft(grid, cur[0], cur[1])) {
			fillleft(grid, cur[0], cur[1], true);
			bfs(processor, grid, cnt + 1, connect + 1);
			fillleft(grid, cur[0], cur[1], false);
		}
		bfs(processor, grid, cnt + 1, connect);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			N = Integer.parseInt(br.readLine());
			boolean[][] grid = new boolean[N][N];
			ArrayList<int[]> processor = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if (st.nextToken().equals("1")) {
						grid[i][j] = true;
						if(i!=0&&i!=N-1&&j!=0&&j!=N-1)
						processor.add(new int[] { i, j });
					}
				}
			}
			maxConnect = 0;
			ans = Integer.MAX_VALUE;
			size = processor.size();
			System.out.println(size);
			bfs(processor, grid, 0, 0);
			System.out.println(maxConnect);
			System.out.println("#" + t + " " + ans);
		}
	}
}
