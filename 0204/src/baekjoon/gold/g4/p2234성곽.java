package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2234성곽 {
	static int[][] wall;
	static boolean[][] visited, set;
	static int[][][] grid;
	
	static int bfs(int posI, int posJ) {
		int res = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {posI, posJ});
		visited[posI][posJ] = true;
		res ++;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int temp = wall[cur[0]][cur[1]];
			int south = temp/8;
			temp%=8;
			int east = temp/4;
			temp %= 4;
			int north = temp/2;
			temp%=2;
			int west = temp;
			if(south==0 && !visited[cur[0]+1][cur[1]]) {
				queue.offer(new int[] {cur[0]+1, cur[1]});
				visited[cur[0]+1][cur[1]] = true;
				res++;
			}
			if(east==0 && !visited[cur[0]][cur[1]+1]) {
				queue.offer(new int[] {cur[0], cur[1]+1});
				visited[cur[0]][cur[1]+1] = true;
				res++;
			}
			if(north==0 && !visited[cur[0]-1][cur[1]]) {
				queue.offer(new int[] {cur[0]-1, cur[1]});
				visited[cur[0]-1][cur[1]] = true;
				res++;
			}
			if(west==0 && !visited[cur[0]][cur[1]-1]) {
				queue.offer(new int[] {cur[0], cur[1]-1});
				visited[cur[0]][cur[1]-1] = true;
				res++;
			}
		}
		return res;
	}
	static void bfs(int posI, int posJ, int cnt, int num) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {posI, posJ});
		set[posI][posJ] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int temp = wall[cur[0]][cur[1]];
			grid[cur[0]][cur[1]]=new int[] {cnt, num};
			int south = temp/8;
			temp%=8;
			int east = temp/4;
			temp %= 4;
			int north = temp/2;
			temp%=2;
			int west = temp;
			if(south==0 && !set[cur[0]+1][cur[1]]) {
				queue.offer(new int[] {cur[0]+1, cur[1]});
				set[cur[0]+1][cur[1]] = true;
			}
			if(east==0 && !set[cur[0]][cur[1]+1]) {
				queue.offer(new int[] {cur[0], cur[1]+1});
				set[cur[0]][cur[1]+1] = true;
			}
			if(north==0 && !set[cur[0]-1][cur[1]]) {
				queue.offer(new int[] {cur[0]-1, cur[1]});
				set[cur[0]-1][cur[1]] = true;
			}
			if(west==0 && !set[cur[0]][cur[1]-1]) {
				queue.offer(new int[] {cur[0], cur[1]-1});
				set[cur[0]][cur[1]-1] = true;
			}
		}
		return;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		wall = new int[height][width];
		grid = new int[height][width][];
		visited = new boolean [height][width];
		set = new boolean [height][width];
		for(int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<width; j++) {
				wall[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int ans2 =0;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(!visited[i][j]) {
					int num = bfs(i, j);
					ans2 = Math.max(ans2, num);
					bfs(i, j, cnt, num);
					cnt ++;
				}
			}
		}
		int ans3 = 0;
		for(int i=0; i<height-1; i++) {
			for(int j=0; j<width; j++) {
				if(grid[i][j][0] != grid[i+1][j][0]) {
					ans3 = Math.max(ans3, grid[i][j][1] + grid[i+1][j][1]);
				}
			}
		}
		for(int i=0; i<height; i++) {
			for(int j=0; j<width-1; j++) {
				if(grid[i][j][0] != grid[i][j+1][0]) {
					ans3 = Math.max(ans3, grid[i][j][1] + grid[i][j+1][1]);					
				}
			}
		}
		System.out.println(cnt);
		System.out.println(ans2);
		System.out.println(ans3);
	}
}
