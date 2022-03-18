package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1516게임개발 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N =Integer.parseInt(br.readLine());
		int[] build = new int[N];
		int[] time = new int[N];
		int[] before = new int[N];
		Arrays.fill(time, Integer.MIN_VALUE);
		Stack<Integer>[] stack = new Stack[N];
		for(int i=0; i<N; i++) {
			stack[i] = new Stack<>();
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			build[i] = Integer.parseInt(st.nextToken());
			
			int temp = Integer.parseInt(st.nextToken())-1;
			while(temp != -2) {
				stack[temp].push(i);
				before[i]++;
				temp = Integer.parseInt(st.nextToken())-1;
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<N; i++) {
			if(before[i]==0) {
				queue.offer(i);
				time[i] = build[i];
			}
		}
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			while(!stack[cur].isEmpty()) {
				int temp = stack[cur].pop();
				before[temp]--;
				time[temp] = Integer.max(time[temp], time[cur]+build[temp]);
				if(before[temp]==0) {
					queue.offer(temp);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(time[i]);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
