package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2239스도쿠 {
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static int[][] grid;
	static boolean find;
	static void back(int idx) {
		
		while(idx<=80&&grid[idx/9][idx%9]!=0) {
			idx++;
		}
		if(idx>80) {
			find = true;
			return;
		}
		boolean[] candidate = new boolean[10];
		Arrays.fill(candidate, true);
		prun(idx, candidate);
		for(int i=1; i<10; i++) {
			if(candidate[i]) {
				grid[idx/9][idx%9]=i;
				back(idx);
				if(find) {
					return;
				}
				grid[idx/9][idx%9]=0;
			}
		}
	}
	
	static void prun(int idx, boolean[] candidate) {
		for(int i=0; i<9; i++) {
			candidate[grid[i][idx%9]] = false;
			candidate[grid[idx/9][i]] = false;
		}
		int startI = idx/9/3;
		int startJ = idx%9/3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				candidate[grid[startI*3+i][startJ*3+j]] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		grid = new int[9][9];
		for(int i=0; i<9; i++) {
			String temp = br.readLine();
			for(int j=0; j<9 ;j++) {
				grid[i][j] = temp.charAt(j)-48;
			}
		}
		back(0);
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}
