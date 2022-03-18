package codingTest.samsungA.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int cnt, min;
	static int[][] client, monster;
	
	static void clean(int posI, int posJ, int move, int turn, boolean[] target) {
		if(turn==cnt) {
			min = Math.min(min, move);
		}
		for(int i=0; i<8; i++) {
			if(target[i]) {
				if(i<4) {
					int dist = Math.abs(monster[i][0]-posI) + Math.abs(monster[i][1] - posJ);
					target[i] = false;
					target[i+4] = true;
					clean(monster[i][0], monster[i][1], move+dist, turn+1, target);
					target[i] = true;
					target[i+4] = false;
				} else {
					int dist = Math.abs(client[i-4][0]-posI) + Math.abs(client[i-4][1] - posJ);
					target[i] = false;
					clean(client[i-4][0], client[i-4][1], move+dist, turn+1, target);
					target[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] grid = new int[N][N];
			client = new int[4][2];
			monster = new int[4][2];
			boolean[] target = new boolean[8];
			int temp = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					if(grid[i][j]>0) {
						monster[grid[i][j]-1] = new int[] {i, j};
						target[grid[i][j]-1] = true;
						temp ++;
					}else if(grid[i][j]<0) {
						client[grid[i][j]*-1 -1] = new int[] {i, j};
					}
				}
			}
			cnt = temp*2;
			min = Integer.MAX_VALUE;
			clean(0, 0, 0, 0, target);
			System.out.println("#"+t+" "+min);
		}
	}
}
