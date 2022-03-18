package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p18352특정거리의도시찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int startnode = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adj = new ArrayList[node+1];
		for(int i=1; i<node+1; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<edge; i++) {
			st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adj[start].add(end);
		}
		boolean[] visited = new boolean[node+1];
		int[] distance = new int[node+1];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {startnode, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(visited[cur[0]])
				continue;
			visited[cur[0]] = true;
			distance[cur[0]] = cur[1];
			for(Integer n: adj[cur[0]]) {
				queue.add(new int[] {n, cur[1]+1});
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=1; i<node+1; i++) {
			if(distance[i] == K) {
				ans.add(i);
			}
		}
		if(ans.isEmpty()) {
			System.out.println(-1);
		}else {
			for(int a: ans) {
				System.out.println(a);
			}
		}
	}
}
