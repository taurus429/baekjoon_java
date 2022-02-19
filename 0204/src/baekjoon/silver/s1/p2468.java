package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2468 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] grid;
	static boolean[][] visited;
	static int N;
	static int[] di = {0, 0, 1, -1};
	static int[] dj = {1, -1, 0, 0};

	static int rain(int height) {
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && grid[i][j] > height) {
					bfs(i, j, height);
					res ++;
				}
			}
		}
		return res;
	}

	static void bfs(int i, int j, int height) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		while(!queue.isEmpty()) {
			int[] next = queue.poll();
			for(int k=0; k<4; k++) {
				int ni = next[0] + di[k];
				int nj = next[1] + dj[k];
				if(ni<N&& ni>=0&&nj<N&&nj>=0&&!visited[ni][nj]&&grid[ni][nj]>height) {
					visited[ni][nj] = true;
					queue.add(new int[] {ni, nj});
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 1;
		for (int i = 1; i <= 100; i++) {
			visited = new boolean[N][N];
			int res = rain(i);
			if (res == 0)
				break;
			if (max<res)
				max = res;
		}
		System.out.println(max);
	}
}
