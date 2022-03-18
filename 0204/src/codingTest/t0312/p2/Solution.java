package codingTest.t0312.p2;

import java.util.Arrays;

public class Solution {
	static int[] clocki = new int[] { 0, 1, 0, -1 };
	static int[] clockj = new int[] { 1, 0, -1, 0 };
	static int N;
	static int[][] answer;
	static boolean[][] visited;

	static void visit(int posi, int posj, int num) {
		visited[posi][posj] = true;
		visited[posj][N - 1 - posi] = true;
		visited[N - 1 - posi][N - 1 - posj] = true;
		visited[N - 1 - posj][posi] = true;
		answer[posi][posj] = num;
		answer[posj][N - 1 - posi] = num;
		answer[N - 1 - posi][N - 1 - posj] = num;
		answer[N - 1 - posj][posi] = num;

	}

	public static int[][] solution(int n, boolean clockwise) {
		N = n;
		visited = new boolean[n][n];
		answer = new int[n][n];
		int posI = 0;
		int posJ = 0;
		int idx = 0;
		if (!clockwise) {
			idx = 1;
		}
		for (int i = 1; i <= n * n / 4; i++) {
			visit(posI, posJ, i);
			if (visited[posI + clocki[idx]][posJ + clockj[idx]]) {
				if (clockwise) {
					idx++;
					idx %= 4;
				} else {
					idx += 3;
					idx %= 4;
				}

			}
			posI = posI + clocki[idx];
			posJ = posJ + clockj[idx];
		}
		if (n % 2 == 1) {
			answer[n / 2][n / 2] = n * n / 4 + 1;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] res = solution(4, false);
		for (int[] r : res) {
			System.out.println(Arrays.toString(r));
		}
		
	}
}