package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p2206 {
	static class Point {
		int x;
		int y;
		int move;
		int boom;

		public Point(int x, int y, int move, int boom) {
			this.x = x;
			this.y = y;
			this.move = move;
			this.boom = boom;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", move=" + move + ", boom=" + boom + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int height = Integer.parseInt(input[0]);
		int width = Integer.parseInt(input[1]);
		int[][] map = new int[height][width];
		int[] dy = new int[] { -1, 1, 0, 0 };// 상하좌우 순
		int[] dx = new int[] { 0, 0, -1, 1 };
		boolean[][][] visited = new boolean[2][height][width];
		String line;
		for (int i = 0; i < height; i++) {
			line = br.readLine();
			for (int j = 0; j < width; j++) {
				map[i][j] = line.charAt(j) - 48;
			}
		}
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0, 1, 0));
		visited[0][0][0] = true;
		int minMove = Integer.MAX_VALUE;

		while (queue.size() != 0) {
			Point nextPoint = queue.poll();
			if (nextPoint.x == width - 1 && nextPoint.y == height - 1) {
				if (nextPoint.move < minMove)
					minMove = nextPoint.move;
			}
			for (int i = 0; i < 4; i++) {
				int ni = nextPoint.y + dy[i];
				int nj = nextPoint.x + dx[i];
				if (ni >= 0 && ni < height && nj >= 0 && nj < width) {
					if (map[ni][nextPoint.x + dx[i]] == 1) {
						if (nextPoint.boom == 0) {
							if (!visited[1][ni][nj]) {
								queue.add(new Point(ni, nj, nextPoint.move + 1, 1));
								visited[1][ni][nj] = true;
							}
						}
					} else {
						if (!visited[nextPoint.boom][ni][nj]) {
							queue.add(new Point(ni, nj, nextPoint.move + 1, nextPoint.boom));
							visited[nextPoint.boom][ni][nj] = true;
						}

					}
				}
			}

		}
		if (minMove == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minMove);
		}
	}
}
