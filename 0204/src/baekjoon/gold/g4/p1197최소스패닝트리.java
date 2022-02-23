package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1197최소스패닝트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int parent[];

	static public class Edge implements Comparable<Edge> {
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
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	
	public static boolean union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		if (p1 == p2)
			return false;

		if (p1 < p2) // 이거 때문에 7번 틀림
			parent[p2] = p1;
		else
			parent[p1] = p2;
		return true;
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		parent = new int[v];
		for (int i = 0; i < v; i++)
			parent[i] = i;
		Edge[] edgeList = new Edge[e];

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(a, b, w);
		}

		int weight = 0;
		Arrays.sort(edgeList);
		for (int i = 0; i < e; i++) {
			Edge now = edgeList[i];
			if (union(now.start, now.end)) {
				weight += now.weight;
			}
		}
		System.out.println(weight);
	}

}
