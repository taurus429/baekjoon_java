package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2252줄세우기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] from;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		from = new int[N+1];
		Stack<Integer>[] stack = new Stack[N+1];
		for(int i=0; i<N+1; i++) {
			stack[i] = new Stack<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			from[back] ++;
			stack[front].push(back);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(from[i]==0) {
				queue.offer(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur);
			sb.append(" ");
			while(!stack[cur].isEmpty()) {
				int temp = stack[cur].pop();
				from[temp] --;
				if(from[temp] == 0) {
					queue.offer(temp);
				}
			}
		}
	
		System.out.println(sb);
	}
}
