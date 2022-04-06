package baekjoon.gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17472다리만들기2 {
	static int[] dy = new int[] {0, 0, 1, -1};
	static int[] dx = new int[] {1, -1, 0, 0};
	static int height, width;
	static boolean[][] land;
	static int[][] grid;
	static int[] parent;
	
	static int find(int a) {
		if(parent[a]==a) {
			return a;
		}
		parent[a] = find(parent[a]);
		return parent[a];
	}
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA==rootB)
			return false;
		parent[rootA] = rootB;
		return true;
	}
	
	static void bfs(int posI, int posJ, int idx, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {posI, posJ});
		visited[posI][posJ] = true;
		grid[posI][posJ] = idx;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i=0; i<4; i++) {
				int ni = cur[0] + dy[i];
				int nj = cur[1] + dx[i];
				if(0<=ni&&ni<height&&0<=nj&&nj<width&&!visited[ni][nj]&&land[ni][nj]) {
					visited[ni][nj] = true;
					grid[ni][nj] = idx;
					queue.offer(new int[] {ni, nj});
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		land= new boolean[height][width];
		for(int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<width; j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					land[i][j] = true;
				}
			}
		}
		int cnt = 1;
		boolean[][] visited = new boolean[height][width];
		grid = new int[height][width];
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(land[i][j]&&!visited[i][j])
					bfs(i, j, cnt++, visited);
			}
		}
		cnt--;
		int INF = Integer.MAX_VALUE;
		int[][] dist = new int[cnt][cnt];
		for(int i=0; i<cnt; i++) {
			Arrays.fill(dist[i], INF);
		}
		for(int i=0; i<height; i++) {
			for(int j=0; j<width-1; j++) {
				if(grid[i][j]==0&&grid[i][j+1]!=0) {
					int d =1;
					while(j-d>=0&&grid[i][j-d]==0) {
						d++;
					}
					if(j-d>=0&&d>1) {
						dist[grid[i][j+1]-1][grid[i][j-d]-1] = Math.min(dist[grid[i][j+1]-1][grid[i][j-d]-1], d);
					}
				}
			}
		}
		for(int i=0; i<height-1; i++) {
			for(int j=0; j<width; j++) {
				if(grid[i][j]==0&&grid[i+1][j]!=0) {
					int d =1;
					while(i-d>=0&&grid[i-d][j]==0) {
						d++;
					}
					if(i-d>=0&&d>1) {
						dist[grid[i+1][j]-1][grid[i-d][j]-1] = Math.min(dist[grid[i+1][j]-1][grid[i-d][j]-1], d);
					}
				}
			}
		}
		
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2)->o1[2]-o2[2]);
		for(int i=0; i<cnt; i++) {
			for(int j=0; j<cnt; j++) {
				if(dist[i][j]!=INF)
				queue.offer(new int[] {i, j, dist[i][j]});
			}
		}
		
		parent = new int[cnt];
		for(int i=0; i<cnt; i++) {
			parent[i] = i;
		}
		int bridge = 0;
		int bridgeCnt = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(union(cur[0], cur[1])) {
				bridge += cur[2];
				bridgeCnt ++;
			}
		}
		if(bridgeCnt != cnt -1) {
			System.out.println(-1);
		} else {
			System.out.println(bridge);
		}
	}
}
