package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p16398행성연결 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] parent;
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

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
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		parent = new int[N];
		for(int i=0; i<N; i++) {
			parent[i] = i;
		}
		int edge = N*(N-1)/2;
		Edge[] edgelist = new Edge[edge];
		int cnt =0;
		for(int i=0; i<N-1; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=i+1; j<N; j++) {
				edgelist[cnt++] = new Edge(i, j, Integer.parseInt(input[j]));
			}
		}
		Arrays.sort(edgelist);
		long w =0;
		for(Edge e: edgelist) {
			if(union(e.start, e.end))
				w+= e.weight;
		}
		System.out.println(w);
	}
}
