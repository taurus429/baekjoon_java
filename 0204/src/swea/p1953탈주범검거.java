package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1953탈주범검거 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; t++) {
			st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int posI = Integer.parseInt(st.nextToken());
			int posJ = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int grid[][] = new int[height][width];
			for(int i=0; i<height; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0; j<width; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int num = height*width;
			ArrayList<Integer>[] adj = new ArrayList[num];
			for(int i=0; i<num; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<height; i++) {
				for(int j=0; j<width-1; j++) {
					if((grid[i][j]==1||grid[i][j]==3||grid[i][j]==4||grid[i][j]==5)&&(grid[i][j+1]==1||grid[i][j+1]==3||grid[i][j+1]==6||grid[i][j+1]==7)) {
						adj[i*width+j].add(i*width+j+1);
						adj[i*width+j+1].add(i*width+j);
					}
				}
			}
			for(int i=0; i<height-1; i++) {
				for(int j=0; j<width; j++) {
					if((grid[i][j]==1||grid[i][j]==2||grid[i][j]==5||grid[i][j]==6)&&(grid[i+1][j]==1||grid[i+1][j]==2||grid[i+1][j]==4||grid[i+1][j]==7)) {
						adj[i*width+j].add((i+1)*width+j);
						adj[(i+1)*width+j].add(i*width+j);
					}
				}
			}
			
			int ans  =0;
			boolean visited[] = new boolean[num];
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.offer(new int[] {width*posI+posJ, 0});
			ans ++;
			visited[width*posI+posJ] = true;
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				for(int next: adj[cur[0]]) {
					if(!visited[next]&&cur[1]<time-1) {
						visited[next] = true;
						ans ++;
						queue.offer(new int[] {next, cur[1]+1});
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}
