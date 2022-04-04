package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1956운동 {
	public static void main(String[] args) throws IOException {
		final int INF = Integer.MAX_VALUE;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] dist = new int [node][node];
		for(int i=0; i<node; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			dist[start][end] = Integer.parseInt(st.nextToken());
		}
		for(int k=0; k<node; k++) {
			for(int i=0; i<node; i++) {
				for(int j=0; j<node; j++) {
					if(dist[i][k] != INF && dist[k][j] != INF) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
		}
		int ans = INF;
		for(int i=0; i<node ;i++) {
			ans = Math.min(dist[i][i], ans);
		}
		if(ans != INF)
			System.out.println(ans);
		else
			System.out.println(-1);
	}
}
