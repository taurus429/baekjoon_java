package baekjoon.gold.g4;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class p10282해킹 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Edge implements Comparable<Edge>{
		int end, dist;

		public Edge(int end, int dist) {
			super();
			this.end = end;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return dist - o.dist;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<= testcase; t++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			int startnode = Integer.parseInt(st.nextToken())-1;
			
			boolean[] visited = new boolean[node];
			ArrayList<Edge>[] adj = new ArrayList[node];
			int[] distance = new int[node];
			for(int i=0; i<node; i++) {
				distance[i] = Integer.MAX_VALUE;
			}
			for(int i=0; i<node; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for(int i=0; i<edge; i++) {
				st = new StringTokenizer(br.readLine());
				int end = Integer.parseInt(st.nextToken())-1;
				int start = Integer.parseInt(st.nextToken())-1;
				int dist = Integer.parseInt(st.nextToken());
				adj[start].add(new Edge(end, dist));
			}
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			distance[startnode] = 0;
			pq.offer(new Edge(startnode, 0));
			
			while(!pq.isEmpty()) {
				Edge cur = pq.poll();
				if(visited[cur.end])
					continue;
				visited[cur.end] = true;
				
				for(Edge e: adj[cur.end]) {
					if(distance[e.end]>distance[cur.end]+e.dist) {
						distance[e.end]=distance[cur.end]+e.dist;
						pq.offer(new Edge(e.end, distance[e.end]));
					}
				}
			}
			int cnt =0;
			int time =0;
			for(int d: distance) {
				if(d==Integer.MAX_VALUE)
					continue;
				cnt++;
				time = Math.max(time, d);
			}
			System.out.println(cnt + " " + time);
		}
	}
}
