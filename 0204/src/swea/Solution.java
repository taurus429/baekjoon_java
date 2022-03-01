package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] grid;
	static int zerocount;
	
	static void watch(int guardI, int guardJ) {
		int nj = guardJ;
		int ni = guardI+1;
		while(ni>=0&&ni<N&&nj>=0&&nj<N&&grid[ni][nj]==0) {
			grid[ni][nj] = 1;
			zerocount--;
			ni++;
		}
		ni = guardI-1;
		while(ni>=0&&ni<N&&nj>=0&&nj<N&&grid[ni][nj]==0) {
			grid[ni][nj] = 1;
			zerocount--;
			ni--;
		}
		ni = guardI;
		nj = guardJ+1;
		while(ni>=0&&ni<N&&nj>=0&&nj<N&&grid[ni][nj]==0) {
			grid[ni][nj] = 1;
			zerocount--;
			nj++;
		}
		nj = guardJ-1;
		while(ni>=0&&ni<N&&nj>=0&&nj<N&&grid[ni][nj]==0) {
			grid[ni][nj] = 1;
			zerocount--;
			nj--;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<= testcase; t++) {
			N = Integer.parseInt(br.readLine());
			grid = new int[N][N];
			
			int guardI = -1;
			int guardJ = -1;
			zerocount = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					if(grid[i][j]==2) {
						guardI = i;
						guardJ = j;
					} else if(grid[i][j] ==0) {
						zerocount++;
					}
				}
			}
			watch(guardI, guardJ);
			System.out.println("#"+t+" "+zerocount);
		}
	}
}
