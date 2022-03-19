package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2583영역구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int height, width;
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {1, 0, -1, 0};
	static int bfs(boolean[][] grid, int posI, int posJ) {
		int cnt =1;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {posI, posJ});
		grid[posI][posJ] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i=0; i<4; i++) {
				int ni = cur[0] + di[i];
				int nj = cur[1] + dj[i];
				if(0<=ni&&ni<height&&0<=nj&&nj<width&&!grid[ni][nj]) {
					grid[ni][nj] = true;
					cnt ++;
					queue.offer(new int[] {ni, nj});
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[][] grid = new boolean[height][width];
		
		for(int t=0; t<k; t++) {
			st = new StringTokenizer(br.readLine());
			int startJ = Integer.parseInt(st.nextToken());
			int startI = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()) - startJ;
			int h = Integer.parseInt(st.nextToken()) - startI;
			
			for(int i=startI; i<startI+h; i++) {
				for(int j=startJ; j<startJ+w; j++) {
					grid[i][j] = true;
				}
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(!grid[i][j]) {
					ans.add(bfs(grid, i, j));
				}
			}
		}
		Integer[] array =ans.toArray(new Integer[ans.size()]);
		System.out.println(array.length);
		Arrays.sort(array);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<array.length; i++) {
			sb.append(array[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
