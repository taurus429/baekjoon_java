package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class room {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int maxMove;
	static int index;
	static int[][] grid;
	static boolean[][] visited;
	static Queue<Integer[]> queue = new LinkedList<Integer[]>();
	static int[] di = new int[] { 0, 0, 1, -1 };
	static int[] dj = new int[] { 1, -1, 0, 0 };
	static StringBuilder sb = new StringBuilder();
	static void bfs(int posI, int posJ) {
		boolean found= false;
		queue.clear();
		queue.offer(new Integer[] { posI, posJ, 0 });
		visited[posI][posJ] = true;
		while (!queue.isEmpty()) {
			Integer[] next = queue.poll();
			if (next[2] >= maxMove) {
				found = true;
				if (next[2] > maxMove) {
					maxMove = next[2];
					index = Math.min(grid[next[0]][next[1]], grid[posI][posJ]);
				} else {
					if (Math.min(grid[next[0]][next[1]], grid[posI][posJ]) < index) {
						maxMove = next[2];
						index = Math.min(grid[next[0]][next[1]], grid[posI][posJ]);
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				int ni = di[i] + next[0];
				int nj = dj[i] + next[1];
				if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj]
						&& Math.abs(grid[next[0]][next[1]] - grid[ni][nj]) == 1) {
					queue.offer(new Integer[] { ni, nj, next[2] + 1 });
					visited[ni][nj] = true;
				}
			}
		}
		if(found) 
			visited = new boolean[n][n];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			n = Integer.parseInt(br.readLine());
			grid = new int[n][n];
			maxMove = Integer.MIN_VALUE;
			index = Integer.MAX_VALUE;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					bfs(i, j);
				}
			}
			sb.append("#"+t +" "+ index+" "+(maxMove+1));
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
