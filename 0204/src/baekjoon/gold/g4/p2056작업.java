package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2056작업 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N];
		int[] work = new int[N];
		Arrays.fill(time, Integer.MIN_VALUE);
		int[] from = new int[N];
		Stack<Integer>[] stack = new Stack[N];
		for (int i = 0; i < N; i++) {
			stack[i] = new Stack<Integer>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			work[i] = Integer.parseInt(st.nextToken());
			int before = Integer.parseInt(st.nextToken());
			for (int j = 0; j < before; j++) {
				int temp = Integer.parseInt(st.nextToken()) - 1;
				stack[i].push(temp);
				from[temp]++;
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			if (from[i] == 0) {
				queue.offer(i);
				time[i] = work[i];
			}
		}
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			while(!stack[cur].isEmpty()) {
				int temp = stack[cur].pop();
				from[temp] --;
				time[temp] = Math.max(time[temp], time[cur]+work[temp]);
				if(from[temp]==0) {
					queue.offer(temp);
				}
			}
		}
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			if(ans<time[i])
				ans = time[i];
		}
		System.out.println(ans);

	}
}
