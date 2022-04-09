package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11657타임머신 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] dist = new int[M][3];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			dist[i] = new int[] { start, end, d };
		}
		long INF = Long.MAX_VALUE;
		long[] mindist = new long[N];
		for (int i = 1; i < N; i++) {
			mindist[i] = INF;
		}
		for (int n = 0; n < N; n++) {
			for (int i = 0; i < M; i++) {
				if (mindist[dist[i][0]] != INF && mindist[dist[i][1]] > dist[i][2] + mindist[dist[i][0]]) {
					if (n == N - 1) {
						System.out.println(-1);
						return;
					}
					mindist[dist[i][1]] = dist[i][2] + mindist[dist[i][0]];
				}
			}
		}
		for (int i = 1; i < N; i++) {
			if (mindist[i] != INF)
				System.out.println(mindist[i]);
			else
				System.out.println(-1);
		}
	}
}
