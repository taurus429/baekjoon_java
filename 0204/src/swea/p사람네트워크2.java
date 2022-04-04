package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p사람네트워크2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] dist = new int[N][N];
			int INF = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(Integer.parseInt(st.nextToken())==1) {
						dist[i][j] = 1;
					} else {
						dist[i][j] = INF;
					}
					if(i==j)
						dist[i][j] = 0;
				}
			}
			
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					if(i==k)
						continue;
					for(int j=0; j<N; j++) {
						if(i==j || k==j)
							continue;
						if(dist[i][k]!=INF&&dist[k][j]!=INF) {
							dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
						}
					}
				}
			}
			int minsum = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				int sum = 0;
				for(int j=0; j<N; j++) {
					sum += dist[i][j];
					if(sum>minsum)
						continue;
				}
				if(sum<minsum) {
					minsum = sum;
				}
			}
			System.out.println("#"+t+" "+minsum);
		}
	}
}
