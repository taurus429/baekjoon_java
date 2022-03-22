package baekjoon.silver.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14582오늘도졌다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] team1 = new int[9];
		int[] team2 = new int[9];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<9; i++) {
			team1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<9; i++) {
			team2[i] = Integer.parseInt(st.nextToken());
		}
		int score1 = 0;
		int score2 = 0;
		for(int i=0; i<18; i++) {
			if(i%2==0) {
				score1 += team1[i/2];
			} else {
				score2 += team2[i/2];
			}
			if(score1>score2) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");
		return;
	}
}
