package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p14938서강그라운드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Node>[] adj;
	static int node, range, max;
	static int[] item;
	
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
	static void getItem(int startnode) {
		boolean[] visited = new boolean[node];
		int[] distance = new int[node];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(startnode, 0));
		distance[startnode] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.end])
				continue;
			visited[cur.end]= true;
			
			for(Node n: adj[cur.end]) {
				if(distance[n.end]>distance[cur.end]+n.weight) {
					distance[n.end]=distance[cur.end]+n.weight;
					pq.offer(new Node(n.end, distance[n.end]));
				}
			}
		}
		int res =0;
		for(int i=0; i<node;i++) {
			if(distance[i]<=range) {
				res += item[i];
			}
		}
		max = Math.max(max, res);
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		
		item = new int[node];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<node; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		adj = new ArrayList[node];
		for(int i=0; i<node; i++) {
			adj[i] = new ArrayList<Node>();
		}
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int dist = Integer.parseInt(st.nextToken());
			adj[start].add(new Node(end, dist));
			adj[end].add(new Node(start, dist));
		}
		for(int i=0; i<node; i++)
			getItem(i);
		System.out.println(max);
	}
}
