package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2637장난감조립 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M =Integer.parseInt(br.readLine());
		boolean[] gibon = new boolean[N];
		Arrays.fill(gibon, true);
		int[][] input = new int[M][3];
		
		int[] from = new int[N];
		Stack<int[]>[] stack = new Stack[N];
		for(int i=0; i<stack.length; i++) {
			stack[i] = new Stack<int[]>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			input[i] = new int[] {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())};
			gibon[input[i][0]] = false;
			from[input[i][0]] ++;
			stack[input[i][1]].push(new int[] {input[i][0], input[i][2]});
		}
		int cnt =0;
		for(int i=0; i<N; i++) {
			if(gibon[i]==true) {
				cnt ++;
			}
		}
		int gibonidx[] = new int[cnt];
		int idx = 0;
		for(int i=0; i<N; i++) {
			if(gibon[i]==true) {
				gibonidx[idx++] = i;
			}
		}
		int need[][] = new int[N][cnt];
		for(int i=0; i<cnt; i++) {
			need[gibonidx[i]][i] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<N; i++) {
			if(from[i]==0)
				queue.offer(i);
		}
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			while(!stack[cur].isEmpty()) {
				int[] temp  = stack[cur].pop();
				from[temp[0]] --;
				if(from[temp[0]]==0) {
					queue.offer(temp[0]);
				}
				for(int i=0; i<cnt; i++)
					need[temp[0]][i] += need[cur][i] * temp[1];
			}
		}
		for(int i=0; i<cnt; i++) {
			System.out.println(gibonidx[i]+1+" "+need[N-1][i]);
		}
	}
}
