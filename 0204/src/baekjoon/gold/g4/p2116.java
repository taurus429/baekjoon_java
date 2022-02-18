package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2116 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] side;
	
	static int getIndex(int num, int[] dice) {
		for(int i=0; i<6; i++) {
			if(dice[i] == num)
				return i;
		}
		return -1;
	}
	static int getMax(int[] dice) {
		int max =0;
		for(int d: dice) {
			if(d>max) {
				max = d;
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		int[][] dice = new int[N][6];
		side = new int[N][4];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans =0;
		int[] diceTop = new int[] {5, 3, 4, 1, 2, 0};
		for(int i=0 ;i<6; i++) {
			int sum =0;
			int bottomNum = i+1;
			int bottomIdx = getIndex(bottomNum, dice[0]);
			int topIdx = diceTop[bottomIdx];
			int cnt =0;
			for(int j=0; j<6; j++) {
				if(j!=bottomIdx&&j!=topIdx) {
					side[0][cnt++] = dice[0][j];
				}
			}
			for(int j=1; j<N; j++) {
				bottomIdx = getIndex(dice[j-1][topIdx], dice[j]);
				topIdx = diceTop[bottomIdx];
				cnt =0;
				for(int k=0; k<6; k++) {
					if(k!=bottomIdx&&k!=topIdx) {
						side[j][cnt++] = dice[j][k];
					}
				}
			}
			for(int[] a: side) {
				sum += getMax(a);
			}
			if(sum>ans) {
				ans = sum;
			}
		}
		System.out.println(ans);
	}
}
