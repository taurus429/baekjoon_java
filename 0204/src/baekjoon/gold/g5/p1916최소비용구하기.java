package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1916최소비용구하기 {
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		int node =Integer.parseInt(br.readLine());
		int edge =Integer.parseInt(br.readLine());
		int[] distance = new int[node];
		boolean[] visited = new boolean[node];
		for(int i=0; i<node; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		ArrayList<Node>[] adj = new ArrayList[node];
		for(int i=0; i<node; i++) {
			adj[i] = new ArrayList<Node>();
		}
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adj[start].add(new Node(end, weight));
		}
		st = new StringTokenizer(br.readLine());
		int startnode = Integer.parseInt(st.nextToken())-1;
		int endnode = Integer.parseInt(st.nextToken())-1;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(startnode, 0));
		distance[startnode] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.end])
				continue;
			visited[cur.end] = true;
			
			for(Node n:adj[cur.end]) {
				if(distance[n.end]>distance[cur.end]+n.weight) {
					distance[n.end]=distance[cur.end]+n.weight;
					pq.offer(new Node(n.end, distance[n.end]));
				}
			}
		}
		System.out.println(distance[endnode]);
	}
}
