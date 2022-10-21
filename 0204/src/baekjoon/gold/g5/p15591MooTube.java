package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p15591MooTube {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		ArrayList<int[]>[] adj = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			adj[i] = new ArrayList<int[]>();
		}
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[n1].add(new int[] {n2, weight});
			adj[n2].add(new int[] {n1, weight});
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.add(new int[] {v, Integer.MAX_VALUE});
			int res = 0;
			boolean[] visited = new boolean[N+1];
			visited[v] = true;
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				for(int[] adjs: adj[cur[0]]) {
					if(!visited[adjs[0]]&&Math.min(adjs[1], cur[1]) >= k) {
						queue.offer(new int[] {adjs[0], Math.min(adjs[1], cur[1])});
						res ++;
						visited[adjs[0]] = true;
					}
				}
			}
			sb.append(res);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
