package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3085사탕게임 {
	static int N;
	static void copy(char[][] map, char[][] newCopy){
		for(int i=0; i<N; i++) {
			newCopy[i] = map[i].clone();
		}
	}
	static int checkMax(char[][] map) {
		int res = 0;
		for(int i=0; i<N; i++) {
			int length = 1;
			for(int j=0; j<N-1; j++) {
				if(map[i][j]==map[i][j+1]) {
					length++;
					res = Math.max(res, length);
				} else {
					length = 1;
				}
			}
		}
		for(int j=0; j<N; j++) {
			int length = 1;
			for(int i=0; i<N-1; i++) {
				if(map[i][j]==map[i+1][j]) {
					length++;
					res = Math.max(res, length);
				} else {
					length = 1;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				char candy = line.charAt(j);
				map[i][j] = candy;
			}
		}
		int answer = -1;
		
		char[][] changedMap = new char[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				if(map[i][j]!=map[i][j+1]) {
					copy(map, changedMap);
					char temp = map[i][j];
					changedMap[i][j] = changedMap[i][j+1];
					changedMap[i][j+1] = temp;
					answer = Math.max(answer, checkMax(changedMap));
				}
			}
		}
		for(int j=0; j<N; j++) {
			for(int i=0; i<N-1; i++) {
				if(map[i][j]!=map[i+1][j]) {
					copy(map, changedMap);
					char temp = map[i][j];
					changedMap[i][j] = changedMap[i+1][j];
					changedMap[i+1][j] = temp;
					answer = Math.max(answer, checkMax(changedMap));
				}
			}
		}
		
		System.out.println(answer);
		
	}
}
