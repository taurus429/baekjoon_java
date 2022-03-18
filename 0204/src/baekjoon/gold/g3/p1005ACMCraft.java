package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1005ACMCraft {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<= testcase; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] build = new int[N+1];
			int[] from = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<N+1; i++) {
				build[i] = Integer.parseInt(st.nextToken());
			}
			Stack<Integer>[] stack = new Stack[N+1];
			for(int i=1; i<=N; i++) {
				stack[i] = new Stack<Integer>();
			}
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int before = Integer.parseInt(st.nextToken());
				int after = Integer.parseInt(st.nextToken());
				from[after] ++;
				stack[before].push(after);
			}
			int target = Integer.parseInt(br.readLine());
			int[] time = new int[N+1];
			Arrays.fill(time, Integer.MIN_VALUE);
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int i=1; i<=N; i++) {
				if(from[i]==0) {
					time[i] =build[i];
					queue.offer(i);
				}
			}
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				while(!stack[cur].isEmpty()) {
					int temp = stack[cur].pop();
					from[temp] --;
					time[temp] = Math.max(time[cur] + build[temp], time[temp]);
					if(from[temp]==0) {
						queue.offer(temp);
					}
				}
			}
			System.out.println(time[target]);
		}
	}
}
