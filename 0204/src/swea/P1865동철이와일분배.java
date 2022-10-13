package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1865동철이와일분배 {
	static int N;
	static double max;
	static boolean[] visited;
	static int[][] percent;
	
	static void dfs(int idx, double res) {
		if(res*100<=max)
			return;
		if(idx==N) {
			max = Math.max(max, res*100);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(idx+1, res*percent[idx][i]);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		cal(0.9f, 15.98f);
		cal(0.9f, 12.51f);
		cal(0.9f, 9.52f);
		cal(0.9f, 6.94f);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for(int t=0; t<testcase; t++) {
			N = Integer.parseInt(br.readLine());
			percent = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					percent[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[N];
			max = 0;
			dfs(0, 1);
			max *= 100;
			System.out.println("#"+(t+1)+" "+String.format("%.6f", max));
		}
	}
}
