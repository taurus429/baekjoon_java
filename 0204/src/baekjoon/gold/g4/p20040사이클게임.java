package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p20040사이클게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	static int find(int a) {
		if(parent[a]==a)
			return a;
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
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		parent = new int[node+1];
		for(int i=1; i<=node; i++) {
			parent[i] = i;
		}
		for(int i=1; i<=edge; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!union(a, b)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
