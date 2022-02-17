package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p14502 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] com = new int[3];
	static int c;
	static int[][] map;
	static ArrayList<int[]> candidate;
	static ArrayList<int[]> virus;
	static int height;
	static int width;
	static int[] di = new int[]{0, 0, 1, -1};
	static int[] dj = new int[]{1, -1, 0, 0};
	static int minimum = Integer.MAX_VALUE;
	
	static void bfs() {
		boolean[][] visited = new boolean[height][width];
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int[] v : virus) {
			visited[v[0]][v[1]] = true;
			queue.add(v);
		}
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			for(int i=0; i<4; i++) {
				int ni = curr[0] + di[i];
				int nj = curr[1] + dj[i];
				if(ni>=0 && ni < height && nj >= 0 && nj < width && !visited[ni][nj] && map[ni][nj] == 0) {
					visited[ni][nj] = true;
					queue.add(new int[] {ni, nj});
				}
			}
		}
		int sum = 0;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(visited[i][j]) {
					sum += 1;
				}
			}
		}
		if(sum<minimum) {
			minimum = sum;
		}
	}
	
	static void combi(int cnt, int index) {
		if(cnt == 3) {
			for(int co: com) {
				map[candidate.get(co)[0]][candidate.get(co)[1]] = 1;
			}
			bfs();
			for(int co: com) {
				map[candidate.get(co)[0]][candidate.get(co)[1]] = 0;
			}
			return;			
		} else {
			for(int i=index; i<c; i++) {
				com[cnt] = i;
				combi(cnt +1, i+1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		height= Integer.parseInt(input[0]);
		width = Integer.parseInt(input[1]);
		map = new int[height][width];
		candidate = new ArrayList<>();
		virus = new ArrayList<>();
		
		for(int i=0; i< height; i++) {
			input = br.readLine().split(" ");
			for(int j=0; j<width; j++) {
				if(input[j].equals("0")) {
					map[i][j] = 0;
					candidate.add(new int[]{i, j});
				} else if(input[j].equals("2")) {
					map[i][j] = 2;
					virus.add(new int[] {i,j});
				}else {
					map[i][j] = 1;
				}
			}
		}
		
		c= candidate.size();
		combi(0, 0);
		System.out.println(candidate.size() + virus.size() - 3 - minimum);
	}
}
