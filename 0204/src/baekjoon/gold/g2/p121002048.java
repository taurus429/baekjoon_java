package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p121002048 {
	static int N, max;
	
	static void L(int[][] grid) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] != 0) {
					queue.offer(grid[i][j]);
					grid[i][j] = 0;
				}
			}
			int idx = 0;
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				if (grid[i][idx] == 0) {
					grid[i][idx] += cur;
				} else if(grid[i][idx] == cur) {
					grid[i][idx] += cur;					
					idx++;
				} else {
					idx++;
					grid[i][idx] += cur;
				}
			}
		}
	}

	static void R(int[][] grid) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (grid[i][j] != 0) {
					queue.offer(grid[i][j]);
					grid[i][j] = 0;
				}
			}
			int idx = N - 1;
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				if (grid[i][idx] == 0) {
					grid[i][idx] += cur;
				} else if (grid[i][idx] == cur) {
					grid[i][idx] += cur;
					idx--;
				} else {
					idx--;
					grid[i][idx] += cur;
				}
			}
		}
	}

	static void U(int[][] grid) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[j][i] != 0) {
					queue.offer(grid[j][i]);
					grid[j][i] = 0;
				}

			}
			int idx = 0;
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				if (grid[idx][i] == 0) {
					grid[idx][i] += cur;
				} else if (grid[idx][i] == cur) {
					grid[idx][i] += cur;
					idx++;
				} else {
					idx++;
					grid[idx][i] += cur;
				}
			}
		}
	}

	static void D(int[][] grid) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (grid[j][i] != 0) {
					queue.offer(grid[j][i]);
					grid[j][i] = 0;
				}
			}
			int idx = N - 1;
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				if (grid[idx][i] == 0) {
					grid[idx][i] += cur;
				} else if (grid[idx][i] == cur) {
					grid[idx][i] += cur;
					idx--;
				} else {
					idx--;
					grid[idx][i] += cur;
				}
			}
		}
	}
	static int findMax(int[][] grid) {
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				max = Math.max(grid[i][j], max);
			}
		}
		return max;
	}
	static int[][] clone(int[][] grid){
		int[][] res = new int[N][];
		for(int i=0; i<N; i++) {
			res[i] = grid[i].clone();
		}
		return res;
	}
	
	static void recur(int cnt, int[][] grid) {
		if(cnt == 5) {
			max = Math.max(max, findMax(grid));
			return;
		}
		int[][] cloneU = clone(grid);
		int[][] cloneD = clone(grid);
		int[][] cloneR = clone(grid);
		int[][] cloneL = clone(grid);
		
		R(cloneR);
		L(cloneL);
		U(cloneU);
		D(cloneD);
		
		recur(cnt +1, cloneR);
		recur(cnt +1, cloneL);
		recur(cnt +1, cloneU);
		recur(cnt +1, cloneD);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recur(0, grid);
		System.out.println(max);
	}
}
