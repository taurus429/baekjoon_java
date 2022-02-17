package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2563 {
	static int[][] paper = new int[100][100];
	static void color(int startI, int startJ) {
		for(int i= startI; i<startI+10; i++) {
			for(int j=startJ; j<startJ+10; j++) {
				paper[i][j] = 1;
			}
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int cnt = Integer.parseInt(br.readLine());
		for(int i=0; i<cnt; i++) {
			String[] input = br.readLine().split(" ");
			color(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		int answer =0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				answer+= paper[i][j];
			}
		}
		System.out.println(answer);
	}
}
