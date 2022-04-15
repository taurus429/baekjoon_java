package baekjoon.gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2098외판원순회 {
	static int N;
	static int[][] dp;
	static int[][] adj;
	static int INF = 16000000;
	static int dfs(int node, int flag) {
		int min = INF;
		if(flag==(1<<N)-1) {
			if(adj[node][0]==0)
				return INF;
			return adj[node][0];
		}
		if(dp[node][flag]!=INF) {
			return dp[node][flag];
		}
		for(int i=0; i<N; i++) {
			if(((1<<i)&flag)==0&&adj[node][i]!=0) {
				min = Math.min(min, dfs(i, (1<<i)|flag) + adj[node][i]);
			}
		}
		dp[node][flag] = min;
		return min;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		adj = new int[N][N];
		dp = new int[N][(int)Math.pow(2, N)];
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], INF);
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(0,1));
		
	}
}
