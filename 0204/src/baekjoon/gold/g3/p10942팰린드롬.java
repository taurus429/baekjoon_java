package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p10942팰린드롬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		HashMap<Integer, Integer>[] dp = new HashMap[N];
		for(int i=0; i<N; i++) {
			dp[i] = new HashMap<>();
			dp[i].put(1, 0);
		}
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<N; i++) {
			if(num[i]==num[i-1]) {
				dp[i].put(2, 0);
			}
			for(int t: dp[i-1].keySet()) {
				if(i-t-1>=0&&num[i-t-1]==num[i]) {
					dp[i].put(t+2, 0);
				}
			}
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = end - start + 1;
			if(dp[end-1].containsKey(len)) {
				sb.append(1).append("\n");
			}else {				
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
}
