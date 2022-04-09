package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p4803트리 {
	static int[] parent;

	static int find(int a) {
		if (a == parent[a])
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}

	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB) {
			parent[rootB] = rootA;
			parent[rootA] = 0;
			return false;
		} else if (rootA < rootB) {
			parent[rootB] = rootA;
		} else {
			parent[rootA] = rootB;
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int testcase = 1;
		while (node != 0 || m != 0) {
			parent = new int[node + 1];
			for (int i = 0; i < node + 1; i++)
				parent[i] = i;
			HashSet<Integer> tree = new HashSet<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			for (int i = 1; i <= node; i++) {
				int pi = find(i);
				if (pi > 0)
					tree.add(pi);
			}
			if (tree.isEmpty())
				System.out.println("Case " + testcase + ": No trees.");
			else if (tree.size() == 1)
				System.out.println("Case " + testcase + ": There is one tree.");
			else
				System.out.println("Case " + testcase + ": A forest of " + tree.size() + " trees.");
			testcase++;
			st = new StringTokenizer(br.readLine());
			node = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
		}

	}
}