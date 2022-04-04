package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2629양팔저울 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int weight = Integer.parseInt(br.readLine());
		int[] w = new int[weight];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<weight; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] dp = new boolean[40001];
		dp[0] = true;
		for(int wei: w) {
			ArrayList<Integer> temp = new ArrayList<>();
			for(int i=0; i<40001; i++) {
				if(dp[i]) {
					temp.add(Math.abs(wei-i));
					temp.add(Math.abs(i+wei));
				}
			}
			for(int t: temp) {
				dp[t] = true;
			}
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			if(dp[Integer.parseInt(st.nextToken())]) {
				sb.append("Y ");
			}else {
				sb.append("N ");
			}
		}
		System.out.println(sb);
	}
}
