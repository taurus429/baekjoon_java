package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p17135캐슬디펜스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int height;
	static int width;
	static int range;
	static boolean[][] grid;

	static ArrayList<int[]> getCombination() {
		ArrayList<int[]> res = new ArrayList<>();
		for (int i = 0; i < width - 2; i++) {
			for (int j = i + 1; j < width - 1; j++) {
				for (int k = j + 1; k < width; k++) {
					res.add(new int[] { i, j, k });
				}
			}
		}
		return res;
	}

	static int[] target(int posI, int posJ, boolean[][] grid) {
		int[] res = null;
		int minRange = Integer.MAX_VALUE;
		for (int i = range; i >= 1; i--) {
			int newI = posI + i - range - 1;
			for (int j = posJ - i + 1; j <= posJ + i - 1; j++) {
				if (newI >= 0 && j < width && j >= 0 && grid[newI][j]) {
					if (posI - newI + Math.abs(j - posJ) < minRange) {
						minRange = posI - newI + Math.abs(j - posJ);
						res = new int[] { newI, j };
					} else if (posI - newI + Math.abs(j - posJ) == minRange) {
						if (res[1] > j) {
							res = new int[] { newI, j };
						}
					}
				}
			}
		}

		return res;
	}

	static boolean[][] cloneGird() {
		boolean[][] res = new boolean[height][];
		for (int i = 0; i < height; i++) {
			res[i] = grid[i].clone();
		}
		return res;
	}

	static int simulate(int[] position, boolean[][] grid) {
		int kill = 0;
		int[][] enemy = new int[3][];
		for (int i = height - 1; i >= 1; i--) {
			enemy = new int[][] { target(i, position[0], grid), target(i, position[1], grid),
					target(i, position[2], grid) };
			for(int j=0; j<3; j++) {
				if(enemy[j]!= null && grid[enemy[j][0]][enemy[j][1]]) {
					grid[enemy[j][0]][enemy[j][1]] = false;
					kill ++;
				}
			}
		}
		return kill;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		height = Integer.parseInt(st.nextToken()) + 1;
		width = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());
		grid = new boolean[height][width];

		for (int i = 0; i < height - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < width; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			}
		}
		
		ArrayList<int[]> combi = getCombination();
		int max = 0;
		for (int[] c : combi) {
			int temp = simulate(c, cloneGird());
			if(temp>max) {
				max = temp;
			}
		}
		System.out.println(max);
		
	}
}
