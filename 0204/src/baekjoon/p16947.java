package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p16947 {
	static boolean[][] adj;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Stack<Integer> stack = new Stack<Integer>();
	static Queue<Integer[]> queue = new LinkedList<>();
	static boolean[] visited;
	static int n;
	static boolean found;
	static int start;
	static boolean[] circle;
	static int[] distance;

	static void dfs(int node, int before) {
		if (visited[node]) {// 순환점 발견
			start = node;
			found = true;
			return;
		}
		visited[node] = true;
		stack.push(node);
		for (int i = 0; i < n; i++) {
			if (adj[node][i] && before != i) {
				dfs(i, node);
				if (found)
					return;
			}
		}
		visited[node] = false;
		stack.pop();
	}
	static void bfs(int node) {
		visited = new boolean[n];
		
		queue.offer(new Integer[] {node, 0});
		visited[node] = true;
		Integer[] next;
		while(!queue.isEmpty()) {
			next = queue.poll();
			for(int i=0; i<n; i++) {
				if(!visited[i]&&adj[next[0]][i]) {
					if(circle[i]) {
						queue.offer(new Integer[] {i, 0});
						visited[i] = true;
					}else {
						queue.offer(new Integer[] {i, next[1]+1});
						distance[i] = next[1] +1;
						visited[i] = true;
					}
				}
			}
		}
		
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		adj = new boolean[n][n];
		visited = new boolean[n];
		distance = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			adj[a][b] = true;
			adj[b][a] = true;
		}
		stack.push(0);
		dfs(0, -1);
		circle = new boolean[n];
		int temp = stack.pop();
		while (!stack.isEmpty()) {
			circle[temp] = true;
			if (temp == start) {
				break;
			}
			temp = stack.pop();
		}
		int circleP=0;
		for(int i=0; i<n; i++) {
			if(circle[i]) {
				circleP = i;
				break;
			}
		}
		bfs(circleP);
		for(int d: distance) {
			System.out.print(d+" ");
		}

	}
}
