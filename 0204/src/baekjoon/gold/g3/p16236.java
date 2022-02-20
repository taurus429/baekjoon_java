package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] grid;
	static int eatCount;
	static int sharkSize = 2;
	static int[] sharkPos;
	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };
	static boolean[][] visited;
	static Comparator<int[]> comparator = new Comparator<int[]>() {
		
		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if(o1[2]!=o2[2]) {
				return o1[2]-o2[2];
			}else if(o1[0]!=o2[0]){
				return o1[0] - o2[0];
			}else {
				return o1[1] - o2[0];
			}
		}
	};

	static int[] bfs(int[] sharkPos) {
		visited = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { sharkPos[0], sharkPos[1], 0 });
		visited[sharkPos[0]][sharkPos[1]] = true;
		int[] minMove = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ni = next[0] + di[i];
				int nj = next[1] + dj[i];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj] && sharkSize >= grid[ni][nj]) {
					if(sharkSize!=grid[ni][nj]&&grid[ni][nj]!=0) {
						
						if(next[2]+1<minMove[2]) {
							minMove = new int[] {ni, nj, next[2] +1};
						}else if(next[2]+1 == minMove[2]) {
							if(ni<minMove[0]) {
								minMove = new int[] {ni, nj, next[2] +1};								
							}else if(ni==minMove[0]) {
								if(nj<minMove[1]) {									
									minMove = new int[] {ni, nj, next[2] +1};								
								}
							}
						}
					}
					visited[ni][nj] = true;
					queue.add(new int[] {ni, nj, next[2]+1});
				}
			}
		}
		return minMove;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 9) {
					sharkPos = new int[] { i, j };
					grid[i][j] = 0;
				}
			}
		}
		int time = 0;
		while(true) {
			int[] nextMove = bfs(sharkPos);
			if(nextMove[0] == Integer.MAX_VALUE)
				break;
			time += nextMove[2];
			sharkPos[0] = nextMove[0];
			sharkPos[1] = nextMove[1];
			grid[nextMove[0]][nextMove[1]] = 0;
			eatCount ++;
			if(eatCount==sharkSize) {
				eatCount=0;
				sharkSize++;
			}
		}
		System.out.println(time);
	}
}
