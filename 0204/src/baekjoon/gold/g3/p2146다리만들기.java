package baekjoon.gold.g3;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class p2146다리만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][][] grid;
	static int[] di = new int[] {1, 0, -1, 0};
	static int[] dj = new int[] {0, 1, 0 ,-1};
	static int N;
	static boolean[][] visited;
	static void bfs(int posI, int posJ, int land) {
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		queue.add(new Integer[] {posI, posJ});
		visited[posI][posJ] = true;
		grid[posI][posJ][1] = land;
		while(!queue.isEmpty()) {
			Integer[] cur = queue.poll();
			for(int i=0; i<4; i++) {
				int ni = cur[0] + di[i];
				int nj = cur[1] + dj[i];
				if(0<=ni&&ni<N&&0<=nj&&nj<N&&!visited[ni][nj]&&grid[ni][nj][0]==1) {
					visited[ni][nj] = true;
					grid[ni][nj][1] = land;
					queue.offer(new Integer[] {ni, nj});
				}
			}
		}
	}
	static int landCnt() {
		int res = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]&&grid[i][j][0]==1) {
					bfs(i, j, res);
					res ++;
				}
			}
		}
		return res-1;
	}
	static void make() {
		boolean[][] bridge = new boolean[N][N];
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-1; j++) {
				if(grid[i][j][0] == 1 && grid[i][j+1][0]==0) {
					bridge[i][j+1] = true;
				}
				if(grid[i][j+1][0] == 1 && grid[i][j][0]==0) {
					bridge[i][j] = true;
				}
				if(grid[i][j][0] == 1 && grid[i+1][j][0]==0) {
					bridge[i+1][j] = true;
				}
				if(grid[i+1][j][0] == 1 && grid[i][j][0]==0) {
					bridge[i][j] = true;
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N][2];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(landCnt());
	}
}
