package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1504특정한최단경로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Node implements Comparable<Node>{
		int end, weight;

		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int node= Integer.parseInt(st.nextToken());
		int edge= Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[node];
		int[] distance = new int[node];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		ArrayList<Node>[] adj = new ArrayList[node];
		for(int i=0; i<node; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0 ;i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adj[start].add(new Node(end, weight));
			adj[end].add(new Node(start, weight));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken())-1;
		int v2 = Integer.parseInt(st.nextToken())-1;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[0] = 0;
		pq.offer(new Node(0, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.end])
				continue;
			visited[cur.end] = true;
			for(Node n: adj[cur.end]) {
				if(distance[n.end]>distance[cur.end]+n.weight) {
					distance[n.end]=distance[cur.end]+n.weight;
					pq.offer(new Node(n.end, distance[n.end]));
				}
				
			}
		}
		
		int[] v1distance = new int[node];
		Arrays.fill(visited, false);
		Arrays.fill(v1distance, Integer.MAX_VALUE);
		v1distance[v1] = 0;
		pq.offer(new Node(v1, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.end])
				continue;
			visited[cur.end] = true;
			
			for(Node n: adj[cur.end]) {
				if(v1distance[n.end]>v1distance[cur.end]+n.weight) {
					v1distance[n.end]=v1distance[cur.end]+n.weight;
					pq.offer(new Node(n.end, v1distance[n.end]));
				}
				
			}
		}
		
		int[] v2distance = new int[node];
		Arrays.fill(visited, false);
		Arrays.fill(v2distance, Integer.MAX_VALUE);
		v2distance[v2] = 0;
		pq.offer(new Node(v2, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.end])
				continue;
			visited[cur.end] = true;
			
			for(Node n: adj[cur.end]) {
				if(v2distance[n.end]>v2distance[cur.end]+n.weight) {
					v2distance[n.end]=v2distance[cur.end]+n.weight;
					pq.offer(new Node(n.end, v2distance[n.end]));
				}
				
			}
		}
		int res1;
		int res2;
		if(distance[v1]==Integer.MAX_VALUE||v1distance[v2]==Integer.MAX_VALUE||v2distance[node-1]==Integer.MAX_VALUE) {
			res1 = Integer.MAX_VALUE;
		}else {			
			res1 = distance[v1] +v1distance[v2]+v2distance[node-1];
		}
		if(distance[v2]==Integer.MAX_VALUE||v2distance[v1]==Integer.MAX_VALUE||v1distance[node-1]==Integer.MAX_VALUE) {
			res2 = Integer.MAX_VALUE;
		}else {			
			res2 = distance[v2] +v2distance[v1]+v1distance[node-1];
		}
		int res = Math.min(res1, res2);
		if(res==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
	}
}
