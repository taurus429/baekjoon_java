package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1766문제집 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Stack<Integer>[] stack = new Stack[N];
		for(int i=0; i<N; i++) {
			stack[i] = new Stack<Integer>();
		}
		int[] before = new int[N];
		
		for(int i=0; i<M; i++) {
			st = new  StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken())-1;
			int next = Integer.parseInt(st.nextToken())-1;
			stack[first].push(next);
			before[next]++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			if(before[i]==0) {
				pq.offer(i);
			} 
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur+1);
			sb.append(" ");
			while(!stack[cur].isEmpty()) {
				int temp = stack[cur].pop();
				before[temp]--;
				if(before[temp]==0)
					pq.offer(temp);
			}
		}
		System.out.println(sb);
	}
}
