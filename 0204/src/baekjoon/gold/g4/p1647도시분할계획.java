package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1647도시분할계획 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	static class Edge implements Comparable<Edge> {
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
		if(parent[a] == a)
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) {
			return false;
		}else {
			parent[rootA] = rootB;
			return true;
		}
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		parent = new int[node];
		for(int i=0; i<node; i++) {
			parent[i] = i;
		}
		Edge[] edgelist = new Edge[edge];
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			edgelist[i] = new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
			
		}
		Arrays.sort(edgelist);
		int cnt =0;
		int w =0;
		for(int i=0; i<edge; i++) {
			if(union(edgelist[i].start, edgelist[i].end)) {
				cnt ++;
				w += edgelist[i].weight;
			}
			if(cnt == node -2) {
				break;
			}
		}
		System.out.println(w);
	}

}
