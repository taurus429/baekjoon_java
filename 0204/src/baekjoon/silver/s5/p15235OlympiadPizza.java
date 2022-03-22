package baekjoon.silver.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p15235OlympiadPizza {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Queue<int[]> queue = new LinkedList<int[]>();
		st = new StringTokenizer(br.readLine());
		int[] time = new int[N];
		for(int i=0; i<N; i++) {
			queue.offer(new int[] {Integer.parseInt(st.nextToken()), i});
		}
		int t = 1;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[0]==1) {
				time[cur[1]] = t;
			} else {
				queue.offer(new int[] {cur[0]-1, cur[1]});
			}
			t++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(time[i]).append(" ");
		}
		System.out.println(sb);
	}
}
