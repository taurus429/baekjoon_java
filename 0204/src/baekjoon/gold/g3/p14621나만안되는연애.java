package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p14621나만안되는연애 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	
	static class Edge implements Comparable<Edge>{
		int start,end,weight;
	
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}


		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
	}
	static int find(int a) {
		if(parent[a] == a) return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	static boolean union(int a, int b) {
		int rootA= find(a);
		int rootB= find(b);
		if(rootA==rootB)
			return false;
		parent[rootB] = rootA;
		return true;
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		parent = new int[node];
		for(int i=0; i<node; i++) {
			parent[i] = i;
		}
		boolean[] gender = new boolean[node];
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<node; i++) {
			if(st.nextToken().equals("M")) {
				gender[i] = true;
			}
		}
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			if(gender[start]^gender[end]) {
				queue.offer(new Edge(start, end, weight));
			}
		}
		int w =0;
		int edgeCnt = 0;
		while(!queue.isEmpty()) {
			
			Edge current = queue.poll();
			if(union(current.start, current.end)) {
				w += current.weight;
				edgeCnt ++;
			}
		}
		if(edgeCnt == node -1) {
			System.out.println(w);
		}else {
			System.out.println(-1);
		}
	}
}
