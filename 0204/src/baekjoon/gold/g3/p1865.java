package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1865 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testcase; t++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int way = Integer.parseInt(st.nextToken());
			int worm = Integer.parseInt(st.nextToken());
			int[][] adj = new int[node + 1][node + 1];
			for (int i = 0; i < node + 1; i++) {
				for (int j = 0; j < node + 1; j++) {
					adj[i][j] = Integer.MAX_VALUE;
				}
			}
			int start;
			int end;
			int dist;
			for (int i = 0; i < way; i++) {
				st = new StringTokenizer(br.readLine());
				start = Integer.parseInt(st.nextToken()) - 1;
				end = Integer.parseInt(st.nextToken()) - 1;
				dist = Integer.parseInt(st.nextToken());
				if (adj[start][end] > dist) {
					adj[start][end] = dist;
					adj[end][start] = dist;
				}
			}
			for (int i = 0; i < worm; i++) {
				st = new StringTokenizer(br.readLine());
				start = Integer.parseInt(st.nextToken()) - 1;
				end = Integer.parseInt(st.nextToken()) - 1;
				dist = Integer.parseInt(st.nextToken());
				adj[start][end] = -dist;
			}
			for (int i = 0; i < node + 1; i++) {
				adj[node][i] = 0;
			}
			int[] distance = new int[node + 1];
			for (int i = 0; i < node; i++) {
				distance[i] = Integer.MAX_VALUE;
			}
			for (int i = 0; i < node; i++) {
				for (int j = 0; j < node + 1; j++) {
					if (distance[j] != Integer.MAX_VALUE) {
						for (int k = 0; k < node + 1; k++) {
							if (adj[j][k] != Integer.MAX_VALUE) {
								if (distance[j] + adj[j][k] < distance[k]) {
									distance[k] = distance[j] + adj[j][k];
								}
							}
						}
					}
				}
			}
			boolean possible = false;

			label: for (int j = 0; j < node + 1; j++) {
				if (distance[j] != Integer.MAX_VALUE) {
					for (int k = 0; k < node + 1; k++) {
						if (adj[j][k] != Integer.MAX_VALUE) {
							if (distance[j] + adj[j][k] < distance[k]) {
								possible = true;
								break label;
							}
						}
					}
				}
			}
			if (possible) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
