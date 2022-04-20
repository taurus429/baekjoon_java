package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10971외판원순회2 {
	static int N, ans;
	static int[] way;
	static int[][] adj;
	static boolean[] visited;
	static void dfs(int cnt, int sum) {
		if(sum>= ans) {
			return;
		}
		if(cnt == N) {
			sum += adj[way[N-1]][0];
			ans = Math.min(ans, sum);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				way[cnt] = i;
				dfs(cnt+1, sum+adj[way[cnt-1]][i]);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		adj = new int[N][N];
		visited = new boolean[N];
		way = new int[N];
		ans = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0]=true;
		dfs(1, 0);
		System.out.println(ans);
	}
}
