package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p4195친구네트워크 {
	static int[] parent, count;
	static int find(int a) {
		if(a==parent[a])
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA>rootB) {
			int temp = rootA;
			rootA = rootB;
			rootB = temp;
		}
		if(rootA== rootB)
			return false;
		parent[rootB] = rootA;
		count[rootA] += count[rootB];
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; t++) {
			HashMap<String, Integer> map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			int idx = 0;
			int[][] friend = new int[N][2];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				if(!map.containsKey(f1)) {
					map.put(f1, idx++);
				}
				if(!map.containsKey(f2)) {
					map.put(f2, idx++);
				}
				friend[i] = new int[] {map.get(f1), map.get(f2)};
			}
			parent = new int[idx];
			for(int i=0; i<idx; i++) {
				parent[i] =i;
			}
			count = new int[idx];
			Arrays.fill(count, 1);
			for(int[] f: friend) {
				union(f[0], f[1]);
				System.out.println(count[find(f[0])]);
			}
		}
	}
}
