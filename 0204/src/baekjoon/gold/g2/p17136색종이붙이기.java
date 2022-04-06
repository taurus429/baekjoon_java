package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p17136색종이붙이기 {
	static boolean[][] grid;
	static int[] left;
	static int ans;

	static boolean check(int posI, int posJ, int size) {
		if (posI + size > 10 || posJ + size > 10)
			return false;
		for (int i = posI; i < posI + size; i++) {
			for (int j = posJ; j < posJ + size; j++) {
				if (!grid[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	static void fill(int posI, int posJ, int size) {
		for (int i = posI; i < posI + size; i++) {
			for (int j = posJ; j < posJ + size; j++) {
				grid[i][j] ^= true;
			}
		}
	}

	static void dfs(int idx) {
		if (idx == 100) {
			int sum = 0;
			for (int i = 0; i < 5; i++) {
				sum += (5 - left[i]);
			}
			ans = Math.min(ans, sum);
			return;
		}
		int i = idx / 10;
		int j = idx % 10;
		if (grid[i][j]) {
			for (int k = 1; k <= 5; k++) {
				if (left[k - 1] > 0 && check(i, j, k)) {
					fill(i, j, k);
					left[k - 1]--;
					dfs(idx + 1);
					left[k - 1]++;
					fill(i, j, k);
				}
			}
		} else {
			dfs(idx + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		left = new int[5];
		Arrays.fill(left, 5);
		grid = new boolean[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					grid[i][j] = true;
				}
			}
		}
		ans = Integer.MAX_VALUE;
		dfs(0);
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
}
