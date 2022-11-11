package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1753최단경로 {
	static class Node implements Comparable<Node>{
		int end;
		int dist;
		
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
		
		public Node(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(br.readLine())-1;
		ArrayList<int[]>[] adj = new ArrayList[node];
		for(int i=0; i<node; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adj[start].add(new int[] {end, weight});
		}
		int[] minDist = new int[node];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(0, 0));
		boolean[] visited = new boolean[node];
		minDist[startNode] = 0;
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			if(visited[cur.end])
				continue;
			visited[cur.end] = true;
			for(int[] a: adj[cur.end]) {
				if(minDist[cur.end]+a[1]<minDist[a[0]]) {
					minDist[a[0]] = minDist[cur.end]+a[1];
					queue.offer(new Node(a[0], minDist[a[0]]));
				}
			}
		}
		for(int i=0; i<node; i++) {
			if(minDist[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(minDist[i]);
			}
		}
	}
}
