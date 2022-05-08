package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2644촌수계산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] adj = new ArrayList[N];
		for(int i=0; i<N; i++) {
			adj[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken())-1;
			int child = Integer.parseInt(st.nextToken())-1;
			adj[parent].add(child);
			adj[child].add(parent);
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {start, 0});
		visited[start] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[0]==end) {
				System.out.println(cur[1]);
				return;
			}
			for(int a: adj[cur[0]]) {
				if(!visited[a]) {
					visited[a] = true;
					queue.offer(new int[] {a, cur[1]+1});
				}
			}
		}
		System.out.println(-1);
	}
}
