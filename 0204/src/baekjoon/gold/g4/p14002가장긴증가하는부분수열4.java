package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p14002가장긴증가하는부분수열4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N][2];
		for(int i=0; i<N; i++) {
			dp[i][0] = 1;
			dp[i][1] = -1;
		}
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(num[i] > num[j]) {
					if(dp[j][0]+1>dp[i][0]) {
						dp[i][0] = dp[j][0] +1;
						dp[i][1] = j;
					}
				}
			}
		}
		int max =0;
		int idx = -1;
		for(int i=0; i<N; i++) {
			if(dp[i][0] > max) {
				max = dp[i][0];
				idx = i;
			}
		}
		Stack<Integer> stack = new Stack<>();
		while(idx!=-1) {
			stack.push(idx);
			idx=dp[idx][1];
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(num[stack.pop()]).append(" ");
		}
		System.out.println(max);
		System.out.println(sb);
	}
}
