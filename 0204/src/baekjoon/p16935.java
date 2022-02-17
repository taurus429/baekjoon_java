package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p16935 {
	static int[][] grid;
	static int height;
	static int width;

	static void print() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void turn1() {
		int[][] tempGrid = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				tempGrid[i][j] = grid[height - i - 1][j];
			}
		}
		for (int i = 0; i < height; i++) {
			grid[i] = tempGrid[i].clone();
		}
	}

	static void turn2() {
		int[][] tempGrid = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				tempGrid[i][j] = grid[i][width - j - 1];
			}
		}
		for (int i = 0; i < height; i++) {
			grid[i] = tempGrid[i].clone();
		}
	}

	static void turn3() {
		int[][] tempGrid = new int[width][height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				tempGrid[j][height - 1 - i] = grid[i][j];
			}
		}
		int temp = height;
		height = width;
		width = temp;
		grid = new int[height][width];
		for (int i = 0; i < height; i++) {
			grid[i] = tempGrid[i].clone();
		}
	}

	static void turn4() {
		int[][] tempGrid = new int[width][height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				tempGrid[width - 1 - j][i] = grid[i][j];
			}
		}
		int temp = height;
		height = width;
		width = temp;
		grid = new int[height][width];
		for (int i = 0; i < height; i++) {
			grid[i] = tempGrid[i].clone();
		}
	}
	static void turn5() {
		int[][] tempGrid = new int[height/2][width/2];
		for (int i = 0; i < height/2; i++) {
			for (int j = 0; j < width/2; j++) {
				tempGrid[i][j] = grid[i][j];
			}
		}
		for(int i=0; i<height/2; i++) {
			for (int j=0; j<width/2; j++) {
				grid[i][j] = grid[i+height/2][j];
			}
		}
		for(int i=height/2; i<height; i++) {
			for(int j=0; j<width/2; j++) {
				grid[i][j] = grid[i][j+width/2];
			}
		}
		for(int i=height/2; i<height; i++) {
			for(int j=width/2; j<width; j++) {
				grid[i][j] = grid[i-height/2][j];
			}
		}
		for(int i=0; i<height/2; i++) {
			for (int j= width/2; j<width; j++) {
				grid[i][j] = tempGrid[i][j-width/2];
			}
		}
	}
	static void turn6() {
		int[][] tempGrid = new int[height/2][width/2];
		for (int i = 0; i < height/2; i++) {
			for (int j = 0; j < width/2; j++) {
				tempGrid[i][j] = grid[i][j];
			}
		}
		for(int i=0; i<height/2; i++) {
			for (int j=0; j<width/2; j++) {
				grid[i][j] = grid[i][j+width/2];
			}
		}
		for(int i=0; i<height/2; i++) {
			for (int j= width/2; j<width; j++) {
				grid[i][j] = grid[i+height/2][j];
			}
		}
		for(int i=height/2; i<height; i++) {
			for(int j=width/2; j<width; j++) {
				grid[i][j] = grid[i][j-width/2];
			}
		}
		for(int i=height/2; i<height; i++) {
			for(int j=0; j<width/2; j++) {
				grid[i][j] = tempGrid[i-height/2][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		height = Integer.parseInt(input[0]);
		width = Integer.parseInt(input[1]);
		int cnt = Integer.parseInt(input[2]);
		grid = new int[height][width];
		for (int i = 0; i < height; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < width; j++) {
				grid[i][j] = Integer.parseInt(input[j]);
			}
		}
		input = br.readLine().split(" ");
		for(int i=0;i<cnt;i++) {
			String command = input[i];
			switch (command) {
			case "1":
				turn1();
				break;
			case "2":
				turn2();
				break;
			case "3":
				turn3();
				break;
			case "4":
				turn4();
				break;
			case "5":
				turn5();
				break;
			case "6":
				turn6();
				break;
			default:
				break;
			}
		}
		print();
	}
}
