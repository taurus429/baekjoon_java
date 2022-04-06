package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
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
		int[][] fw = new int[node][node];
		for(int i=0; i<node; i++) {
			Arrays.fill(fw[i], Integer.MAX_VALUE);
		}
		for(int i=0; i<node; i++) {
			for(int j=0; j<node; j++) {
				if(possible[i][j]||i==j)
				fw[i][j] = 0;
			}
		}
		for (int k = 0; k < node; k++) {
			for (int i = 0; i < node; i++) {
				for (int j = 0; j < node; j++) {
					if (fw[i][k]==0 && fw[k][j]==0) {
						fw[i][j] = 0;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		m = Integer.parseInt(br.readLine());
		for (int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
			boolean[] visited = new boolean[node];
			queue.offer(new int[] { start, 0 });
			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				if(visited[cur[0]])
					continue;
				visited[cur[0]]=true;
				fw[start][cur[0]] = Math.min(cur[1], fw[start][cur[0]]);
				if (cur[0] == end) {
					sb.append(cur[1]).append("\n");
					break;
				}
				for (int i = 0; i < node; i++) {
					if (possible[cur[0]][i]&&!visited[i]) {
						if(fw[i][end]!=Integer.MAX_VALUE)
							queue.offer(new int[] { end, fw[i][end] +cur[1] });
						else
							queue.offer(new int[] { i, cur[1] });
					} else if(possible[i][cur[0]]&&!possible[cur[0]][i]&&!visited[i]) {
						if(fw[i][end]!=Integer.MAX_VALUE)
							queue.offer(new int[] { end, fw[i][end] + cur[1] + 1});
						else
							queue.offer(new int[] { i, cur[1] + 1 });
					}
				}
			}
		}
		System.out.println(sb);
	}
}