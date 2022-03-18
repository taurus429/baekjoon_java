package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1976여행가자 {
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
		if(rootA == rootB) {
			return false;
		}
		parent[rootA] = rootB;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int node =Integer.parseInt(br.readLine());
		int trip = Integer.parseInt(br.readLine());
		parent = new int[node];
		for(int i=0; i<node; i++) {
			parent[i] = i;
		}
		for(int i=0; i<node; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<node; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(j>i&&temp==1) {
					union(i, j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		boolean flag = true;;
		int root = find(Integer.parseInt(st.nextToken())-1);
		for(int i=0; i<trip-1; i++) {
			if(root != find(Integer.parseInt(st.nextToken())-1)) {
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
