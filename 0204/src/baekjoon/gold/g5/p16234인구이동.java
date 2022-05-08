package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16234인구이동 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, R, L;
	static boolean[][] visited;
	static int[][] grid;
	
	static boolean bfs(int posI, int posJ) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {posI, posJ});
		visited[posI][posJ]= true;
		ArrayList<int[]> country = new ArrayList<>();
		int sum = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			sum += grid[cur[0]][cur[1]];
			country.add(cur);
			for(int i=0; i<4; i++) {
				int ni = cur[0] + dy[i];
				int nj = cur[1] + dx[i];
				if(0<=ni&&ni<N&&0<=nj&&nj<N&&!visited[ni][nj]&&Math.abs(grid[cur[0]][cur[1]]-grid[ni][nj])<=R&&L<=Math.abs(grid[cur[0]][cur[1]]-grid[ni][nj])) {
					queue.offer(new int[] {ni, nj});
					visited[ni][nj] = true;
				}
			}
		}
		for(int[] c: country) {
			grid[c[0]][c[1]] = sum/country.size();
		}
		if(country.size()>1)
			return true;
		return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		grid= new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans  =0;
		boolean find = true;
		while(find) {
			find = false;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						find |=bfs(i, j);
					}
				}
			}
			if(find)
				ans++;
		}
		System.out.println(ans);
	}
}
