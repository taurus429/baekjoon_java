package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p4485녹색옷입은애가젤다지2 {
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
			return weight-o.weight;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int p = 1;
		while(N!=0) {
			int[][] thief = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					thief[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int node = (int) Math.pow(N, 2)+1;
			boolean[] visited = new boolean[node];
			ArrayList<Node>[] adj = new ArrayList[node];
			for(int i=0; i<node; i++) {
				adj[i] = new ArrayList<Node>();
			}
			adj[0].add(new Node(1, thief[0][0]));
			for(int i=1; i<node; i++) {
				int posI = (i-1)/N;
				int posJ = (i-1)%N;
				if(posJ<N-1) {
					adj[i].add(new Node(i+1, thief[posI][posJ+1]));
				}
				if(posJ>0) {
					adj[i].add(new Node(i-1, thief[posI][posJ-1]));					
				}
				if(posI<N-1) {
					adj[i].add(new Node(i+N, thief[posI+1][posJ]));
				}
				if(posI>0) {
					adj[i].add(new Node(i-N, thief[posI-1][posJ]));
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			int[] distance = new int[node];
			Arrays.fill(distance, Integer.MAX_VALUE);
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
			System.out.print("Problem "+ p+": ");
			System.out.println(distance[node-1]);
			p++;
			N=Integer.parseInt(br.readLine());
		}
	}
}
