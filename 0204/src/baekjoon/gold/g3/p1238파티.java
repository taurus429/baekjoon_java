package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1238파티 {
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
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int startnode = Integer.parseInt(st.nextToken())-1;
		
		ArrayList<Node>[] adj = new ArrayList[node];
		ArrayList<Node>[] rev = new ArrayList[node];
		boolean[] visited = new boolean[node];
		int[] distance = new int[node];
		int[] revdist = new int[node];
		for(int i=0; i<node; i++) {
			adj[i] = new ArrayList<Node>();
			rev[i] = new ArrayList<Node>();
			distance[i] = Integer.MAX_VALUE;
			revdist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adj[start].add(new Node(end, weight));
			rev[end].add(new Node(start,weight));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[startnode] = 0;
		pq.offer(new Node(startnode, 0));
		
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
		Arrays.fill(visited, false);
		revdist[startnode] = 0;
		pq.offer(new Node(startnode, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.end])
				continue;
			visited[cur.end]= true;
			
			for(Node n: rev[cur.end]) {
				if(revdist[n.end]>revdist[cur.end]+n.weight) {
					revdist[n.end]=revdist[cur.end]+n.weight;
					pq.offer(new Node(n.end, revdist[n.end]));
				}
			}
		}
		int max =0;
		for(int i=0; i<node; i++) {
			if(max<distance[i]+revdist[i])
				max = distance[i]+revdist[i];
		}
		System.out.println(max);
	}
}
