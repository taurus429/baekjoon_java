package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2931가스관 {
	static int[] dx = new int[] {0, 1, 0, -1};
	static int[] dy = new int[] {-1, 0, 1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int[] posM = {};
		char[][] grid = new char[height][width];
		for(int i=0; i<height; i++) {
			String input = br.readLine();
			for(int j=0; j<width; j++) {
				grid[i][j] = input.charAt(j);
				if(grid[i][j] == 'M') {
					posM = new int[] {i, j};
				}
			}
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {posM[0], posM[1], 4});
		int last[] = new int[2];
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			last[0] = cur[0];
			last[1] = cur[1];
			if(cur[2]==4) {
				for(int i=0; i<4; i++) {
					int ni = cur[0] + dy[i];
					int nj = cur[1] + dx[i];
					if(0<=ni&&ni<height&&0<=nj&&nj<width&&grid[ni][nj]!='.') {
						queue.offer(new int[] {ni, nj, i});
					}
				}
			} else {
				switch (grid[cur[0]][cur[1]]) {
				case '|':
				case '-':
				case '+':
					queue.offer(new int[] {cur[0] + dy[cur[2]], cur[1] + dx[cur[2]], cur[2]});
					break;
				case '1':
					if(cur[2]==0) {
						queue.offer(new int[] {cur[0] + dy[1], cur[1] + dx[1], 1});
					} else {
						queue.offer(new int[] {cur[0] + dy[2], cur[1] + dx[2], 2});
					}
					break;
				case '2':
					if(cur[2]==2) {
						queue.offer(new int[] {cur[0] + dy[1], cur[1] + dx[1], 1});
					} else {
						queue.offer(new int[] {cur[0] + dy[0], cur[1] + dx[0], 0});
					}
					break;
				case '3':
					if(cur[2]==1) {
						queue.offer(new int[] {cur[0] + dy[0], cur[1] + dx[0], 0});
					} else {
						queue.offer(new int[] {cur[0] + dy[3], cur[1] + dx[3], 3});
					}
					break;
				case '4':
					if(cur[2]==1) {
						queue.offer(new int[] {cur[0] + dy[2], cur[1] + dx[2], 2});
					} else {
						queue.offer(new int[] {cur[0] + dy[3], cur[1] + dx[3], 3});
					}
					break;
				default:
					break;
				}
			}
		}
		boolean[] connect = new boolean[4];
		System.out.print(last[0]+1+" ");
		System.out.print(last[1]+1+" ");
		for(int i=0; i<4; i++) {
			int ni = last[0] + dy[i];
			int nj = last[1] + dx[i];
			if(0<=ni&&ni<height&&0<=nj&&nj<width&&grid[ni][nj]!=0) {
				if(i==0&&(grid[ni][nj]=='|'||grid[ni][nj]=='+'||grid[ni][nj]=='1'||grid[ni][nj]=='4')) {
					connect[0] = true;
				} else if(i==1&&(grid[ni][nj]=='-'||grid[ni][nj]=='+'||grid[ni][nj]=='3'||grid[ni][nj]=='4')) {
					connect[1] = true;
				} else if(i==2&&(grid[ni][nj]=='|'||grid[ni][nj]=='+'||grid[ni][nj]=='2'||grid[ni][nj]=='3')) {
					connect[2] = true;
				} else if(i==3&&(grid[ni][nj]=='-'||grid[ni][nj]=='+'||grid[ni][nj]=='1'||grid[ni][nj]=='2')) {
					connect[3] = true;
				}
			}
		}
		if(connect[0]&&connect[1]&&connect[2]&&connect[3]) {
			System.out.println("+");
		}else if(connect[0]&&connect[2]) {
			System.out.println("|");
		}else if(connect[1]&&connect[3]) {
			System.out.println("-");
		}else if(connect[1]&&connect[2]) {
			System.out.println("1");
		}else if(connect[0]&&connect[1]) {
			System.out.println("2");
		}else if(connect[0]&&connect[3]) {
			System.out.println("3");
		}else if(connect[2]&&connect[3]) {
			System.out.println("4");
		}
	}
}
