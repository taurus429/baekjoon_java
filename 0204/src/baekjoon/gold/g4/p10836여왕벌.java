package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class p10836여왕벌 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] sum = new int[M][M];
		int[] line = new int[M-1];
		for(int i=0; i<N; i++) {
			st=  new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			if(two>=M-1) {
				for(int j=0; j<M-1; j++) {
					sum[0][j+1] += 2;
					line[j] += 2;
				}
				two -= (M-1);
			} else if(one+two>=M-1) {
				int idx = M-1-two;
				for(int j=0; j<idx; j++) {
					sum[0][j+1] += 1;
					line[j] += 1;
				}
				for(int j=idx; j<M-1; j++) {
					sum[0][j+1] += 2;
					line[j] += 2;
				}
				two =0;
				one -= idx;
			} else {
				int zeroidx = M-1-two-one;
				for(int j=0; j<zeroidx; j++) {
					sum[j+1][j+1] += 0;
					line[j] += 0;
				}
				for(int j=zeroidx; j<zeroidx+one; j++) {
					sum[0][j+1] += 1;
					line[j] += 1;
				}
				for(int j=zeroidx+one; j<M-1; j++) {
					sum[0][j+1] += 2;
					line[j] += 2;
				}
				two =0;
				one = 0;
				zero -= zeroidx;
			}
			if(two!=0) {
				two--;
				sum[0][0] += 2;
			} else if (one !=0) {
				one --;
				sum[0][0] += 1;
			} else {
				zero --;
				sum[0][0] += 0;
			}
			int idx = 1;
			for(int j=0; j<two; j++) {
				sum[idx++][0] += 2;
			}
			for(int j=0; j<one; j++) {
				sum[idx++][0] += 1;
			}
			for(int j=0; j<zero; j++) {
				sum[idx++][0] += 0;
			}
		}
		for(int i=1; i<M; i++) {
			for(int j=1; j<M; j++) {
				sum[i][j] += line[j-1];
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				sb.append(sum[i][j]+1).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
