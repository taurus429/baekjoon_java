package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p3124최소스패닝트리 {
	static int[] parent;
	
	static int find(int a) {
		if(parent[a] == a)
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA==rootB) {
			return false;
		}
		parent[rootA] = rootB;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; t++) {
			st= new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			parent = new int[node+1];
			for(int i=1; i<node+1; i++) {
				parent[i] = i;
			}
			int edge = Integer.parseInt(st.nextToken());
			int[][] input = new int[edge][3];
			for(int i=0; i<edge; i++) {
				st = new StringTokenizer(br.readLine());
				input[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			}
			Arrays.sort(input, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2] - o2[2];
				}
			});
			long ans =0;
			for(int i=0; i<edge; i++) {
				if(union(input[i][0], input[i][1])) {
					ans += input[i][2];
				}
			}
			System.out.println("#"+t+" "+ans);
		}
				
	}
}
