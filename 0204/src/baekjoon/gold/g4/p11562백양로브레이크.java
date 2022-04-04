package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p11562백양로브레이크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] possible = new boolean[node][node];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			if (Integer.parseInt(st.nextToken()) == 1) {
				possible[start][end] = true;
				possible[end][start] = true;
			} else {
				possible[start][end] = true;
			}
		}
//		for (int k = 0; k < node; k++) {
//			for (int i = 0; i < node; i++) {
//				for (int j = 0; j < node; j++) {
//					if (possible[i][k] && possible[k][j]) {
//						possible[i][j] = true;
//					}
//				}
//			}
//		}
		m = Integer.parseInt(br.readLine());
		for (int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			Queue<int[]> queue = new LinkedList<int[]>();
			boolean[] visited = new boolean[node];
			queue.offer(new int[] { start, 0 });
			visited[start] = true;
			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				if (cur[0] == end) {
					System.out.println(cur[1]);
					break;
				}
				for (int i = 0; i < node; i++) {
					if (possible[cur[0]][i]&&!visited[i]) {
						queue.offer(new int[] { i, cur[1] });
						visited[i] = true;
					} else if(possible[i][cur[0]]&&!visited[i]) {
						queue.offer(new int[] { i, cur[1]+1 });
						visited[i] = true;
					}
				}
			}
		}
	}
}
