package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1922네트워크연결 {
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

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
	}
	static int find(int a) {
		if(parent[a] == a) return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA== rootB)
			return false;
		parent[rootA] = rootB;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int node = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		Edge[] edgeList = new Edge[edge];
		parent = new int[node];
		for(int i=0; i<node; i++) {
			parent[i] = i;
		}
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(edgeList);
		int w =0;
		for(int i=0; i<edge; i++) {
			if(union(edgeList[i].start, edgeList[i].end)) {
				w += edgeList[i].weight;
			}
		}
		System.out.println(w);
	}
}
