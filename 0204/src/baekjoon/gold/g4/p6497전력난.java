package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p6497전력난 {
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
		if (parent[a] == a)
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}

	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB)
			return false;
		parent[rootB] = rootA;
		return true;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		while (!(node == 0 && edge == 0)) {
			int sum = 0;
			Edge[] edgelist = new Edge[edge];
			parent = new int[node];
			for (int i = 0; i < node; i++) {
				parent[i] = i;
			}
			for (int i = 0; i < edge; i++) {
				st = new StringTokenizer(br.readLine());
				edgelist[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(edgelist);
			int w = 0;
			for (Edge e : edgelist) {
				sum += e.weight;
				if (union(e.start, e.end)) {
					w += e.weight;
				}
			}
			System.out.println(sum - w);
			st = new StringTokenizer(br.readLine());
			node = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
		}
	}
}
