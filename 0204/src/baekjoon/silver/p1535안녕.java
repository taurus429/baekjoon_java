package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1535안녕 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][100];
		int[] happy = new int[N];
		int[] health = new int[N];
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			health[i] = Integer.parseInt(st.nextToken());
		}
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N+1; i++) {
			for(int j=0; j<100; j++) {
				if(j+health[i-1]>=100) {
					dp[i][j] = dp[i-1][j];
				}else {					
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j+health[i-1]] + happy[i-1] );
				}
			}
		}
		System.out.println(dp[N][0]);
	}
}
