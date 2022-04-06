package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2660회장뽑기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int f1 = Integer.parseInt(st.nextToken())-1;
		int f2 = Integer.parseInt(st.nextToken())-1;
		
		int[][] friend = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(friend[i], Integer.MAX_VALUE);
		}
		for(int i=0; i<N; i++) {
			friend[i][i] = 0;
		}
		while(f1!=-2&&f2!=-2) {
			friend[f1][f2] = 1;
			friend[f2][f1] = 1;
			st = new StringTokenizer(br.readLine());
			f1 = Integer.parseInt(st.nextToken())-1;
			f2 = Integer.parseInt(st.nextToken())-1;
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(friend[i][k]!=Integer.MAX_VALUE && friend[k][j] != Integer.MAX_VALUE) {
						friend[i][j] = Math.min(friend[i][j], friend[i][k] + friend[k][j]);
					}
				}
			}
		}
		ArrayList<Integer> candi = new ArrayList<>();
		int minScore = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			int score = 0;
			for(int j=0; j<N; j++) {
				score = Math.max(score, friend[i][j]);
			}
			if(score<minScore) {
				minScore = score;
				candi.clear();
				candi.add(i);
			} else if(score==minScore) {
				candi.add(i);
			}
		}
		System.out.println(minScore+" "+candi.size());
		for(int c: candi)
			System.out.print((c+1)+" ");
	}
}
