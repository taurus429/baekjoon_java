package baekjoon.platinum.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1948임계경로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int node = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		
		Stack<int[]>[] stack = new Stack[node];
		Stack<int[]>[] revStack = new Stack[node];
		for(int i=0; i<node; i++) {
			stack[i] = new Stack<int[]>();
			revStack[i] = new Stack<int[]>();
		}
		int[] from = new int[node];
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int dist = Integer.parseInt(st.nextToken());
			stack[start].push(new int[] {end, dist});
			revStack[end].push(new int[] {start, dist});			
			from[end] ++;
		}
		st = new StringTokenizer(br.readLine());
		int startnode = Integer.parseInt(st.nextToken())-1;
		int endnode = Integer.parseInt(st.nextToken())-1;
		int[] dist = new int[node];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {startnode, 0}); //노드, 거리, 거친도시
		while(!queue.isEmpty()) {
			int[] cur  = queue.poll();
			while(!stack[cur[0]].isEmpty()) {
				int[] temp = stack[cur[0]].pop();
				from[temp[0]] --;
				if(dist[temp[0]]<cur[1]+temp[1]) {
					dist[temp[0]] = cur[1]+temp[1];
				}
				if(from[temp[0]]==0) {
					queue.offer(new int[] {temp[0], dist[temp[0]]});
				}
			}
		}
		Queue<Integer> revQueue = new LinkedList<>();
		revQueue.offer(endnode);
		int cnt =0;
		boolean[] visited= new boolean[node];
		while(!revQueue.isEmpty()) {
			int cur = revQueue.poll();
			while(!revStack[cur].isEmpty()) {
				int next[] = revStack[cur].pop();
				if(next[1]+dist[next[0]]==dist[cur]) {
					cnt ++;
					if(!visited[next[0]]) {
						revQueue.offer(next[0]);
						visited[next[0]]= true;
					}
				}
			}
		}
		System.out.println(dist[endnode]);
		System.out.println(cnt);
	}
}
