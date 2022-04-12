package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p5643키순서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<= testcase; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int[][] table = new int[N][N];
			for(int i=0; i<M; i++) {
				st= new StringTokenizer(br.readLine());
				int big = Integer.parseInt(st.nextToken())-1;
				int small = Integer.parseInt(st.nextToken())-1;
				table[big][small] = 1;
				table[small][big] = -1;
			}
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(table[i][k]==1&&table[k][j]==1) {
							table[i][j] = 1;
						} else if(table[i][k] ==-1&&table[k][j]==-1) {
							table[i][j] = -1;
						}
					}
				}
			}
			int ans  =0;
			for(int i=0; i<N; i++) {
				int count = 0;
				for(int j=0; j<N; j++) {
					if(table[i][j]!=0)
						count++;
				}
				if(count==N-1)
					ans++;
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}
