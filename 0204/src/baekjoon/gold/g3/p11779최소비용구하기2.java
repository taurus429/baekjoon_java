package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p11779최소비용구하기2 {
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
		int node = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		
		boolean[] visited = new boolean[node];
		int[][] distance = new int[node][2];
		for(int i=0; i<node; i++) {
			distance[i][0] = Integer.MAX_VALUE;
		}
		ArrayList<Node>[] adj = new ArrayList[node];
		for(int i=0; i<node; i++) {
			adj[i] = new ArrayList<Node>();
		}
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			adj[start].add(new Node(end, weight));
		}
		st = new StringTokenizer(br.readLine());
		int startnode = Integer.parseInt(st.nextToken()) - 1;
		int endnode = Integer.parseInt(st.nextToken()) - 1;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[startnode][0] = 0;
		pq.offer(new Node(startnode, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.end])
				continue;
			visited[cur.end] = true;
			
			for(Node n: adj[cur.end]) {
				if(distance[n.end][0]>distance[cur.end][0]+n.weight) {
					distance[n.end][0]=distance[cur.end][0]+n.weight;
					distance[n.end][1]=cur.end;
					pq.offer(new Node(n.end, distance[n.end][0]));
				}
			}
		}
		System.out.println(distance[endnode][0]);
		int temp = endnode;
		Stack<Integer> stack = new Stack<>();
		stack.push(endnode+1);
		while(true) {
			temp = distance[temp][1];
			stack.push(temp+1);
			if(temp ==startnode)
				break;
		}
		System.out.println(stack.size());
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			int s = stack.pop();
			sb.append(s);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
