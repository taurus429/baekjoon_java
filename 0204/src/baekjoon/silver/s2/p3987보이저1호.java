package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p3987보이저1호 {
	static int[] dx = new int[] { 0, 1, 0, -1 };
	static int[] dy = new int[] { -1, 0, 1, 0 };
	static char[][] grid;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		grid = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				grid[i][j] = line.charAt(j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int curI = Integer.parseInt(st.nextToken())-1;
		int curJ = Integer.parseInt(st.nextToken())-1;
		boolean[][][][] visited = new boolean[N][M][4][4];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { curI, curJ, 0, 0, 0});
		queue.offer(new int[] { curI, curJ, 0, 1, 1 });
		queue.offer(new int[] { curI, curJ, 0, 2, 2 });
		queue.offer(new int[] { curI, curJ, 0, 3, 3 });
		int maxDirection = -1;
		int maxMove = -1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int posI = cur[0];
			int posJ = cur[1];
			int move = cur[2];
			int direction = cur[3];
			int first = cur[4];
			if(move>maxMove) {
				if(visited[posI][posJ][direction][first]) {
					if(first==0) {
						System.out.println("U");
					} else if(first==1) {
						System.out.println("R");
					} else if(first==2) {
						System.out.println("D");
					} else {
						System.out.println("L");
					}
					System.out.println("Voyager");
					return;
				}
				maxMove = move;
				maxDirection = first;
			}
			if (grid[posI][posJ] == '/') {
				switch (direction) {
				case 0:
					direction = 1;
					break;
				case 1:
					direction = 0;
					break;
				case 2:
					direction = 3;
					break;
				case 3:
					direction = 2;
					break;
				}
			} else if (grid[posI][posJ] == '\\') {
				switch (direction) {
				case 0:
					direction = 3;
					break;
				case 1:
					direction = 2;
					break;
				case 2:
					direction = 1;
					break;
				case 3:
					direction = 0;
					break;
				}

			}
			visited[posI][posJ][direction][first] = true;
			int ni = posI + dy[direction];
			int nj = posJ + dx[direction];
			if (0 <= ni && ni < N && 0 <= nj && nj < M && grid[ni][nj] != 'C') {
				queue.offer(new int[] { ni, nj, move + 1, direction, first });
			}
		}
		if(maxDirection==0) {
			System.out.println("U");
		} else if(maxDirection==1) {
			System.out.println("R");
		} else if(maxDirection==2) {
			System.out.println("D");
		} else {
			System.out.println("L");
		}
		System.out.println(maxMove+1);
	}
}
