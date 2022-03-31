package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2636치즈 {
	static int height, width;
	static int[] dx = new int[] {1, -1, 0, 0};
	static int[] dy = new int[] {0, 0, 1, -1};
	static boolean[][] cheese;
	
	static int bfs() {
		boolean[][] visited = new boolean[height][width];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0, 0});
		visited[0][0] = true;
		ArrayList<int[]> melt = new ArrayList<>();
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i=0; i<4; i++) {
				int ni = cur[0] + dx[i];
				int nj = cur[1] + dy[i];
				if(0<=ni&&ni<height&&0<=nj&&nj<width&&!visited[ni][nj]) {
					if(!cheese[ni][nj]) { //치즈가 아닐 경우
						queue.offer(new int[] {ni, nj});
						visited[ni][nj] = true;
					} else { //치즈일 경우
						visited[ni][nj] = true;
						melt.add(new int[] {ni, nj});
					}
				}
			}
		}
		int res = 0;
		for(int[] m: melt) {
			if(cheese[m[0]][m[1]]) { // 녹을 경우만 카운트
				cheese[m[0]][m[1]] = false;
				res++;
			}
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		int cheeseCount = 0;
		cheese = new boolean[height][width];
		for(int i=0; i<height; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<width; j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					cheese[i][j] = true;
					cheeseCount ++;
				}
			}
		}
		int before = 0;
		int iter = 0;
		while(cheeseCount!=0) {
			iter ++;
			before = cheeseCount;
			cheeseCount -= bfs();
		}
		System.out.println(iter);
		System.out.println(before);
		
	}
}
