package baekjoon.gold.g4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p4386별자리만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	static class Edge implements Comparable<Edge>{
		int start,end;
		double dist;
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if(dist<o.dist)
				return -1;
			return 1;
		}
		public Edge(int start, int end, double dist) {
			super();
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", dist=" + dist + "]";
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
		if(rootA == rootB)
			return false;
		parent[rootB] = rootA;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		Point[] pointlist = new Point[N];
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			pointlist[i] = new Point();
			pointlist[i].setLocation(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}
		parent= new int[N];
		for(int i=0; i<N; i++) {
			parent[i] = i;
		}
		int edge = N*(N-1)/2;
		Edge[] edgelist = new Edge[edge];
		int edgeCnt =0;
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				edgelist[edgeCnt] = new Edge(i, j, pointlist[i].distance(pointlist[j].getX(), pointlist[j].getY()));
				edgeCnt ++;
			}
		}
		Arrays.sort(edgelist);
		double answer = 0;
		for(Edge e : edgelist) {
			if(union(e.start, e.end)) {
				answer += e.dist;
			}
		}
		System.out.printf("%.2f",answer);
	}
}
