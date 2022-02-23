package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class p3289서로소집합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] parent;
	public static int find(int a) {
		if(a==parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parent[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<= testcase; t++) {
			sb = new StringBuilder();
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine(), " ");
			int N= Integer.parseInt(st.nextToken());
			int M= Integer.parseInt(st.nextToken());
			parent = new int[N];
			for(int i=0; i<N; i++) {
				parent[i] = i;
			}
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int command= Integer.parseInt(st.nextToken());
				int a= Integer.parseInt(st.nextToken()) -1;
				int b= Integer.parseInt(st.nextToken()) -1;
				if(command==0) {
					union(a, b);
				}else {
					if(find(a) == find(b)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
			}
			System.out.println(sb);
		}
	}
}
