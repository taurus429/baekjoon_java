package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2623음악프로그램 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] before = new int[N];
		Stack<Integer>[] stack = new Stack[N];
		for(int i=0; i<N; i++) {
			stack[i] = new Stack<Integer>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int connect = Integer.parseInt(st.nextToken());
			int pre = 0;
			int post = Integer.parseInt(st.nextToken())-1;
			for(int j=0; j<connect-1; j++) {
				pre = post;
				post = Integer.parseInt(st.nextToken())-1;
				stack[pre].push(post);
				before[post] ++;
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		int cnt =0;
		for(int i=0; i<N; i++) {
			if(before[i]==0) {
				queue.offer(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur+1);
			sb.append("\n");
			cnt ++;
			while(!stack[cur].isEmpty()) {
				int temp = stack[cur].pop();
				before[temp]--;
				if(before[temp]==0) {
					queue.offer(temp);
				}
			}
		}
		if(cnt == N) {
			System.out.println(sb);
		} else {
			System.out.println(0);
		}
	}
}
