package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p3108로고 {
	static int[] parent;
	static int find(int a) {
		if(parent[a]==a)
			return a;
		parent[a]= find(parent[a]);
		return parent[a];
	}
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA!=rootB) {
			parent[rootA] = rootB;
		}
	}
	static boolean connected(int[] cord1, int[] cord2) {
		int c1x1 = cord1[0];
		int c1y1 = cord1[1];
		int c1x2 = cord1[2];
		int c1y2 = cord1[3];
		int c2x1 = cord2[0];
		int c2y1 = cord2[1];
		int c2x2 = cord2[2];
		int c2y2 = cord2[3];
		if(c1x1<=c2x1&&c2x1<=c1x2) {
			if((c2y1<=c1y1&&c1y1<=c2y2)||(c2y1<=c1y2&&c1y2<=c2y2))
				return true;
		}
		if(c1x1<=c2x2&&c2x2<=c1x2) {
			if((c2y1<=c1y1&&c1y1<=c2y2)||(c2y1<=c1y2&&c1y2<=c2y2))
				return true;
		}
		if(c1y1<=c2y1&&c2y1<=c1y2) {
			if((c2x1<=c1x1&&c1x1<=c2x2)||(c2x1<=c1x2&&c1x2<=c2x2))
				return true;
		}
		if(c1y1<=c2y2&&c2y2<=c1y2) {
			if((c2x1<=c1x1&&c1x1<=c2x2)||(c2x1<=c1x2&&c1x2<=c2x2))
				return true;
		}
		
		return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		parent = new int[N];
		for(int i=0; i<N; i++) {
			parent[i] = i;
		}
		int[][] cord = new int[N][4];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cord[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(connected(cord[i], cord[j])) {
					union(i, j);
				}
			}
		}
		boolean find = false;
		for(int i=0; i<N; i++) {
			if((cord[i][0]==0||cord[i][2]==0)&&cord[i][1]<=0&&cord[i][3]>=0) {
				find = true;
				break;
			}
			if((cord[i][1]==0||cord[i][3]==0)&&cord[i][0]<=0&&cord[i][2]>=0) {
				find = true;
				break;
			}
		}
		for(int i=0; i<N; i++) {
			find(i);
		}
		for(int i=0; i<N; i++) {
			find(i);
		}
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			set.add(parent[i]);
		}
		int ans = set.size();
		if(find)
			ans--;
		System.out.println(ans);
	}
}
