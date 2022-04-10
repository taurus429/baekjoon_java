package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p13913숨바꼭질4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100001];
		int[] before = new int[100001];
		Arrays.fill(before, -1);
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {N, 0});
		visited[N] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[0]==K) {
				System.out.println(cur[1]);
				break;
			}
			if(cur[0]-1>=0&&!visited[cur[0]-1]) {
				queue.offer(new int[] {cur[0]-1, cur[1]+1});
				visited[cur[0]-1] = true;
				before[cur[0]-1] = cur[0];
			}
			if(cur[0]+1<100001&&!visited[cur[0]+1]) {
				queue.offer(new int[] {cur[0]+1, cur[1]+1});
				visited[cur[0]+1] = true;
				before[cur[0]+1] = cur[0];
			}
			if(cur[0]*2<100001&&!visited[cur[0]*2]) {
				queue.offer(new int[] {cur[0]*2, cur[1]+1});
				visited[cur[0]*2] = true;
				before[cur[0]*2] = cur[0];
			}
		}
		StringBuilder sb = new StringBuilder();
		int step = K;
		Stack<Integer> stack = new Stack<>();
		while(step!=-1) {
			stack.push(step);
			step = before[step];
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
	}
}
