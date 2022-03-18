package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p9205맥주마시면서걸어가기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int t=0; t<testcase; t++) {
			int n =Integer.parseInt(br.readLine())+1;
			st = new StringTokenizer(br.readLine());
			int[] start = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int[][] convi = new int[n][2];
			for(int i=0; i<n-1; i++) {
				st = new StringTokenizer(br.readLine());
				convi[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			}
			st = new StringTokenizer(br.readLine());
			convi[n-1] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.offer(start);
			boolean flag = false;
			boolean[] visited = new boolean[n];
			label: while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				for(int i=0; i<n; i++) {
					if(!visited[i]&&(Math.abs(cur[0]-convi[i][0])+Math.abs(cur[1]-convi[i][1]))<=1000) {
						visited[i] = true;
						if(i==n-1) {
							break label;
						}
						queue.offer(convi[i]);
					}
				}
			}
			if(visited[n-1]) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
	}
}
