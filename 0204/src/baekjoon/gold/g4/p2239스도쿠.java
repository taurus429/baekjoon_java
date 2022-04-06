package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2239스도쿠 {
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static boolean done;
	static int[][] sudoku;
	static void back(int idx) {
		
		while(idx<=80&&sudoku[idx/9][idx%9]!=0) {
			idx++;
		}
		if(idx>80) {
			done = true;
			return;
		}
		boolean[] candidate = new boolean[10];
		Arrays.fill(candidate, true);
		prun(idx, candidate);
		for(int i=1; i<10; i++) {
			if(candidate[i]) {
				sudoku[idx/9][idx%9]=i;
				back(idx);
				if(done) {
					return;
				}
				sudoku[idx/9][idx%9]=0;
			}
		}
	}
	
	static void prun(int idx, boolean[] possible) {
		for(int i=0; i<9; i++) {
			possible[sudoku[i][idx%9]] = false;
			possible[sudoku[idx/9][i]] = false;
		}
		int startI = idx/9/3;
		int startJ = idx%9/3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				possible[sudoku[startI*3+i][startJ*3+j]] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		sudoku = new int[9][9];
		for(int i=0; i<9; i++) {
			String temp = br.readLine();
			for(int j=0; j<9 ;j++) {
				sudoku[i][j] = temp.charAt(j)-48;
			}
		}
		back(0);
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}
}
