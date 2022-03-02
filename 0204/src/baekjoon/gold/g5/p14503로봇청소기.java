package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14503로봇청소기 {
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int [][]grid;
	static boolean[][]visited;
	static int[] di = new int[] {0, 1, 0, -1};
	static int[] dj = new int[] {-1, 0, 1, 0};
	static int cleaned, height, width;
	
	static void clean(int posI, int posJ, int direction) {
		boolean done = false;
		if(!visited[posI][posJ]) {
			visited[posI][posJ] = true;
			cleaned ++;
		}
		for(int i=0; i<4; i++) {
			int index = (i-direction+4) % 4;
			int ni = posI + di[index];
			int nj = posJ + dj[index];
			if(!done && 0<=ni && ni<height && 0<= nj && nj<height &&!visited[ni][nj] && grid[ni][nj] != 1) {
				clean(ni, nj, (3-index)%4);
				done = true;
			}
		}
		int back  = (5-direction)%4;
		int ni = posI + di[back];
		int nj = posJ + dj[back];
		if(!done && 0<=ni && ni<height && 0<= nj && nj<height && grid[ni][nj] != 1) {
			clean(ni, nj, direction);
		}else {
			return;
		}
	}
	
	public static void main(String[] args) throws IOException {
		st= new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		grid = new int[height][width];
		visited = new boolean[height][width];
		for(int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<width; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(r, c, direction);
		System.out.println(cleaned);
	}
}
