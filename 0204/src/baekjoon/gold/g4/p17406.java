package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p17406 {
	static int direction;
	static int height;
	static int width;
	static int[] posI = new int[] { 0, 0, 1, 1 };
	static int[] posJ = new int[] { 0, 1, 0, 1 };

	static void turn1(int[][] map) {
		int temp = map[0][0];
		map[0][0] = map[1][0];
		map[1][0] = temp;
		temp = map[0][1];
		map[0][1] = map[1][1];
		map[1][1] = temp;

		if (direction == 0) {
			direction = 6;
		} else if (direction == 1) {
			direction = 5;
		} else if (direction == 2) {
			direction = 4;
		} else if (direction == 3) {
			direction = 7;
		} else if (direction == 4) {
			direction = 2;
		} else if (direction == 5) {
			direction = 1;
		} else if (direction == 6) {
			direction = 0;
		} else if (direction == 7) {
			direction = 3;
		}
	}

	static void turn2(int[][] map) {
		int temp = map[0][0];
		map[0][0] = map[0][1];
		map[0][1] = temp;
		temp = map[1][0];
		map[1][0] = map[1][1];
		map[1][1] = temp;

		if (direction == 0) {
			direction = 4;
		} else if (direction == 1) {
			direction = 7;
		} else if (direction == 2) {
			direction = 6;
		} else if (direction == 3) {
			direction = 5;
		} else if (direction == 4) {
			direction = 0;
		} else if (direction == 5) {
			direction = 3;
		} else if (direction == 6) {
			direction = 2;
		} else if (direction == 7) {
			direction = 1;
		}
	}

	static void turn3(int[][] map) {
		int temp = map[0][0];
		map[0][0] = map[1][0];
		map[1][0] = map[1][1];
		map[1][1] = map[0][1];
		map[0][1] = temp;

		if (direction == 0) {
			direction = 1;
		} else if (direction == 1) {
			direction = 2;
		} else if (direction == 2) {
			direction = 3;
		} else if (direction == 3) {
			direction = 0;
		} else if (direction == 4) {
			direction = 5;
		} else if (direction == 5) {
			direction = 6;
		} else if (direction == 6) {
			direction = 7;
		} else if (direction == 7) {
			direction = 4;
		}
	}

	static void turn4(int[][] map) {
		int temp = map[0][0];
		map[0][0] = map[0][1];
		map[0][1] = map[1][1];
		map[1][1] = map[1][0];
		map[1][0] = temp;

		if (direction == 0) {
			direction = 3;
		} else if (direction == 1) {
			direction = 0;
		} else if (direction == 2) {
			direction = 1;
		} else if (direction == 3) {
			direction = 2;
		} else if (direction == 4) {
			direction = 7;
		} else if (direction == 5) {
			direction = 4;
		} else if (direction == 6) {
			direction = 5;
		} else if (direction == 7) {
			direction = 6;
		}
	}

	static void turn5(int[][] map) {
		int temp = map[0][0];
		map[0][0] = map[1][0];
		map[1][0] = map[1][1];
		map[1][1] = map[0][1];
		map[0][1] = temp;
	}

	static void turn6(int[][] map) {
		int temp = map[0][0];
		map[0][0] = map[0][1];
		map[0][1] = map[1][1];
		map[1][1] = map[1][0];
		map[1][0] = temp;
	}

	static void copy(int src, int dest, int[][] grid, int[][] newGrid) {
		if (direction == 0) {
			int si = posI[src];
			int sj = posJ[src];
			int di = posI[dest];
			int dj = posJ[dest];
			for (int i = 0; i < height / 2; i++) {
				for (int j = 0; j < width / 2; j++) {
					newGrid[i + di * height / 2][j + dj * width / 2] = grid[i + si * height / 2][j + sj * width / 2];
				}
			}
		} else if (direction == 1) {
			int si = posI[src];
			int sj = posJ[src];
			int di = posI[dest];
			int dj = posJ[dest];
			for (int i = 0; i < height / 2; i++) {
				for (int j = 0; j < width / 2; j++) {
					newGrid[j + di * width / 2][-i - 1 + (dj + 1) * height / 2] = grid[i + si * height / 2][j
							+ sj * width / 2];
				}
			}
		} else if (direction == 2) {
			int si = posI[src];
			int sj = posJ[src];
			int di = posI[dest];
			int dj = posJ[dest];
			for (int i = 0; i < height / 2; i++) {
				for (int j = 0; j < width / 2; j++) {
					newGrid[-i - 1 + (di + 1) * height / 2][-j - 1 + (dj + 1) * width / 2] = grid[i + si * height / 2][j
							+ sj * width / 2];
				}
			}
		} else if (direction == 3) {
			int si = posI[src];
			int sj = posJ[src];
			int di = posI[dest];
			int dj = posJ[dest];
			for (int i = 0; i < height / 2; i++) {
				for (int j = 0; j < width / 2; j++) {
					newGrid[-j - 1 + (di + 1) * width / 2][i + dj * height / 2] = grid[i + si * height / 2][j
							+ sj * width / 2];
				}
			}
		} else if (direction == 4) {
			int si = posI[src];
			int sj = posJ[src];
			int di = posI[dest];
			int dj = posJ[dest];
			for (int i = 0; i < height / 2; i++) {
				for (int j = 0; j < width / 2; j++) {
					newGrid[i + di * height / 2][-j - 1 + (dj + 1) * width / 2] = grid[i + si * height / 2][j
							+ sj * width / 2];
				}
			}
		} else if (direction == 5) {
			int si = posI[src];
			int sj = posJ[src];
			int di = posI[dest];
			int dj = posJ[dest];
			for (int i = 0; i < height / 2; i++) {
				for (int j = 0; j < width / 2; j++) {
					newGrid[-j - 1 + (di + 1) * width / 2][-i - 1 + (dj + 1) * height / 2] = grid[i + si * height / 2][j
							+ sj * width / 2];
				}
			}
		} else if (direction == 6) {
			int si = posI[src];
			int sj = posJ[src];
			int di = posI[dest];
			int dj = posJ[dest];
			for (int i = 0; i < height / 2; i++) {
				for (int j = 0; j < width / 2; j++) {
					newGrid[-i - 1 + (di + 1) * height / 2][j + dj * width / 2] = grid[i + si * height / 2][j
							+ sj * width / 2];
				}
			}
		} else if (direction == 7) {
			int si = posI[src];
			int sj = posJ[src];
			int di = posI[dest];
			int dj = posJ[dest];
			for (int i = 0; i < height / 2; i++) {
				for (int j = 0; j < width / 2; j++) {
					newGrid[j + di * width / 2][i + dj * height / 2] = grid[i + si * height / 2][j + sj * width / 2];
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		height = Integer.parseInt(input[0]);
		width = Integer.parseInt(input[1]);
		int cnt = Integer.parseInt(input[2]);
		int[][] grid = new int[height][width];
		for (int i = 0; i < height; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < width; j++) {
				grid[i][j] = Integer.parseInt(input[j]);
			}
		}

		int[][] map = new int[][] { { 0, 1 }, { 2, 3 } };

		input = br.readLine().split(" ");
		for (int i = 0; i < cnt; i++) {
			String command = input[i];
			switch (command) {
			case "1":
				turn1(map);
				break;
			case "2":
				turn2(map);
				break;
			case "3":
				turn3(map);
				break;
			case "4":
				turn4(map);
				break;
			case "5":
				turn5(map);
				break;
			case "6":
				turn6(map);
				break;
			default:
				break;
			}
		}

		int[][] newGrid;
		if (direction % 2 == 1) {
			newGrid = new int[width][height];
		} else {
			newGrid = new int[height][width];
		}
		copy(map[0][0],0, grid, newGrid);
		copy(map[0][1],1, grid, newGrid);
		copy(map[1][0],2, grid, newGrid);
		copy(map[1][1],3, grid, newGrid);
		for (int[] line : newGrid) {
			for (int e : line) {
				System.out.print(e + " ");
			}
			System.out.println();
		}

	}
}
