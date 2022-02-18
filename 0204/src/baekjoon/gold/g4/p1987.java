package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1987 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] used = new boolean[26];
	static boolean[][] visited;
	static int[][] grid;
	static int height;
	static int width;
	static int[] dx = new int[] {0, 0, 1, -1};
	static int[] dy = new int[] {1, -1, 0, 0};
	static int max = Integer.MIN_VALUE;
	
	static void back(int posX, int posY, int cnt) {
		visited[posY][posX] = true;
		used[grid[posY][posX]] = true;
		if(cnt>max) {
			max = cnt;
		}
		for(int i=0; i<4; i++) {
			int ni = posY + dx[i];
			int nj = posX + dy[i];
			if(ni<height&&ni>=0&&nj<width&&nj>=0&&!visited[ni][nj]&&!used[grid[ni][nj]]) {
				back(nj, ni, cnt+1);
			}
		}
		visited[posY][posX] = false;
		used[grid[posY][posX]] = false;
	}
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		height = Integer.parseInt(input[0]);
		width = Integer.parseInt(input[1]);
		visited = new boolean[height][width];
		grid = new int[height][width];
		for(int i=0; i<height; i++) {
			String line = br.readLine();
			for(int j=0; j<width; j++) {
				grid[i][j] = line.charAt(j) - 65;
			}
		}

		back(0, 0, 0);
		System.out.println(max+1);
		
	}
}
