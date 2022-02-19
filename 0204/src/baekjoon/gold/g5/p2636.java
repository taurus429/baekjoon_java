package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2636 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int height;
	static int width;
	static boolean[][] visited;
	static int[] di = new int[] { 0, 0, 1, -1 };
	static int[] dj = new int[] { 1, -1, 0, 0 };
	static int[][] cheese;

	static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { i, j });
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			for (int k = 0; k < 4; k++) {
				int ni = next[0] + di[k];
				int nj = next[1] + dj[k];
				if (ni >= 0 && ni < height && nj >= 0 && nj < width) {
					if(cheese[ni][nj]==1) {
						cheese[ni][nj] = 2;
					}else if (!visited[ni][nj] && cheese[ni][nj] == 0) {
						visited[ni][nj] = true;
						queue.offer(new int[] { ni, nj });
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		cheese = new int[height][width];
		int cheeseCount = 0;
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < width; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if (cheese[i][j] == 1)
					cheeseCount++;
			}
		}
		int time = 0;
		int before = 0;
		while (true) {
			time++;
			visited = new boolean[height][width];
			bfs(0,0);
			before = cheeseCount;
			cheeseCount = 0;
			
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (cheese[i][j] == 2) {
						cheese[i][j] = 0;
					} else if (cheese[i][j] == 1) {
						cheeseCount++;
					}
				}
			}
			if (cheeseCount == 0) {
				break;
			}

		}
		System.out.println(time);
		System.out.println(before);

	}
}
