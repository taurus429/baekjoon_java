package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p5656벽돌깨기 {
	static int width, height, N, ans;
	static int[] dx = new int[] {0, 0, 1, -1};
	static int[] dy = new int[] {1, -1, 0, 0};
	static int[][] clone(int [][]grid){
		int[][] res = new int[height][width];
		for(int i=0; i<height; i++) {
			res[i] = grid[i].clone();
		}
		return res;
	}
	static void hit(int posI, int posJ, int[][] grid) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[height][width];
		queue.offer(new int[] {posI, posJ});
		visited[posI][posJ] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(grid[cur[0]][cur[1]]>1) {
				for(int i=1; i<grid[cur[0]][cur[1]]; i++) {
					for(int j=0; j<4; j++) {
						int ni= cur[0] + i*dy[j];
						int nj = cur[1] + i*dx[j];
						if(0<=ni&&ni<height&&0<=nj&&nj<width&&!visited[ni][nj]) {
							visited[ni][nj]=true;
							queue.offer(new int[] {ni, nj});
						}
					}
				}
			}
			grid[cur[0]][cur[1]] = 0;
		}
	}
	static void gravity(int[][] grid) {
		Queue<Integer> queue = new LinkedList<>();
		for(int j=0; j<width; j++) {
			for(int i=height-1; i>=0; i--) {
				if(grid[i][j] != 0) {
					queue.offer(grid[i][j]);
					grid[i][j] = 0;
				}
			}
			int pos = height-1;
			while(!queue.isEmpty()) {
				grid[pos--][j] = queue.poll();
			}
		}
	}
	static void dfs(int[][] grid, int cnt) {
		if(cnt==N) {
			int count = 0;
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					if(grid[i][j]!=0) {
						count ++;
					}
				}
			}
			ans = Math.min(ans, count);
			return;
		}
		for(int i=0; i<width; i++) {
			int h = height - 1;
			if(grid[height-1][i] != 0) {
				int[][] newgrid = clone(grid);
				while(h >= 0 && grid[h][i] != 0) {
					h--;
				}
				int posI = h+1;
				int posJ = i;
				hit(posI, posJ, newgrid);
				gravity(newgrid);
				dfs(newgrid, cnt+1);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			int[][] grid = new int[height][width];
			for(int i=0; i<height; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<width; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = Integer.MAX_VALUE;
			dfs(grid, 0);
			if(ans == Integer.MAX_VALUE)
				ans = 0;
			System.out.println("#" + t +" "+ans);
			
		}
	}
}
