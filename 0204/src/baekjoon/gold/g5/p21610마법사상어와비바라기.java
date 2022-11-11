package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p21610마법사상어와비바라기 {
	static int N;
	static int[] dx = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = new int[] {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] nearx = new int[] {-1, 1, 1, -1};
	static int[] neary = new int[] {-1, -1, 1, 1};
	static int[][] grid;
	static ArrayList<int[]> cloud;
	static void print() {
		for (int i=0; i<N; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
		System.out.println();
	}
	static void process(int d, int s) {
		ArrayList<int[]> temp = new ArrayList<>();
		for(int[] c: cloud) {
			int ni = (c[0] + (dy[d] + N) * s) % N;
			int nj = (c[1] + (dx[d] + N) * s) % N;
			temp.add(new int[] {ni, nj});
		}
		print();
		boolean[][] visited = new boolean[N][N];
		int tempGrid[][] = new int[N][N];
		for(int [] t: temp) {
			grid[t[0]][t[1]] += 1;
			visited[t[0]][t[1]] = true;
			for(int i=0; i<4; i++) {
				int ni = t[0] + neary[i];
				int nj = t[1] + nearx[i];
				if(0<=ni&&ni<N&&0<=nj&&nj<N&&grid[ni][nj]>0) {
					tempGrid[t[0]][t[1]] += 1;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				grid[i][j] += tempGrid[i][j];
			}
		}
		
		print();
		cloud = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(grid[i][j]>=2 && !visited[i][j]) {
					cloud.add(new int[] {i, j});
					grid[i][j] -= 2;
				}
			}
		}
		System.out.println("물제거");
		print();
		for(int [] c: cloud) {
			System.out.println(Arrays.toString(c));
		}
		print();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		grid = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cloud = new ArrayList<>();
		cloud.add(new int[] {N-1, 0});
		cloud.add(new int[] {N-2, 0});
		cloud.add(new int[] {N-1, 1});
		cloud.add(new int[] {N-2, 1});
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			process(d, s);
		}
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum += grid[i][j];
			}
		}
		System.out.println(sum);
	}
}
