package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p17070파이프옮기기1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[][][] map = new int[n][n][3];
		boolean[][] wall = new boolean[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				if(st.nextToken().equals("1")) {
					wall[i][j] = true;
				}
			}
		}
		map[0][1][0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!wall[i][j]) {
					if(j-1>=0&&!wall[i][j-1])
						map[i][j][0] += (map[i][j-1][0]+map[i][j-1][1]);
					if(i-1>=0&&j-1>=0&&!wall[i-1][j-1]&&!wall[i][j-1]&&!wall[i-1][j])
						map[i][j][1] += (map[i-1][j-1][0] + map[i-1][j-1][1] + map[i-1][j-1][2]);
					if(i-1>=0&&!wall[i-1][j])
						map[i][j][2] += (map[i-1][j][1]+map[i-1][j][2]);
				}
			}
		}
		System.out.println(map[n-1][n-1][0]+map[n-1][n-1][1]+map[n-1][n-1][2]);
	}
}
