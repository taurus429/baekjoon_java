package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1717집합의표현 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	static int find(int a) {
		if(parent[a] ==a)
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB)
			return false;
		parent[rootA] = rootB;
		return true;
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int input = Integer.parseInt(st.nextToken());
		parent = new int[node+1];
		for(int i=0; i<node+1; i++) {
			parent[i] = i;
		}
		for(int i=0; i<input; i++) {
			st = new StringTokenizer(br.readLine());
			int sel = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(sel==0) {
				union(a,b);
			}else {
				if(find(a)==find(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
}
