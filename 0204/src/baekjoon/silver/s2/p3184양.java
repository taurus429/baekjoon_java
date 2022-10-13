package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p3184양 {
	static int height, width;
	static char[][] grid;
	static boolean[][] visited;
	static int[] dx = new int[] {0, 0, 1, -1};
	static int[] dy = new int[] {1, -1, 0, 0};
	static int finalSheep, finalWolf;

	static void bfs(int posI, int posJ) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { posI, posJ });
		visited[posI][posJ] = true;
		int sheep = 0;
		int wolf = 0;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			if(grid[cur[0]][cur[1]]=='o') {
				sheep ++;
			}else if(grid[cur[0]][cur[1]]=='v') {
				wolf ++;
			}
			for(int i=0; i<4; i++) {
				int ni = cur[0] + dy[i];
				int nj = cur[1] + dx[i];
				if(0<=ni&&ni<height&&0<=nj&&nj<width&&!visited[ni][nj]&&grid[ni][nj]!='#') {
					queue.offer(new int[] {ni, nj});
					visited[ni][nj] = true;
				}
			}
		}
		if(sheep<=wolf) {
			finalWolf += wolf;
		} else {
			finalSheep += sheep;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		grid = new char[height][width];
		for (int i = 0; i < height; i++) {
			String input = br.readLine();
			for (int j = 0; j < width; j++) {
				grid[i][j] = input.charAt(j);
			}
		}
		visited = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!visited[i][j]&&grid[i][j]!='#')
					bfs(i, j);
			}
		}
		System.out.println(finalSheep+" "+finalWolf);
	}
}
