package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1260DFS와BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] visited; //방문배열
	static boolean[][] adj; //인접행렬
	static int node;
	
	static void dfs(int startNode) {
		visited[startNode] = true;
		System.out.print(startNode+1+" ");
		for(int i=0; i<node; i++) {
			if(!visited[i]&&adj[startNode][i]) {
				dfs(i);
			}
		}
	}
	static void bfs(int startNode) {
		Queue<Integer> queue = new LinkedList<Integer>();//링크드리스트 사용
		queue.add(startNode);
		visited[startNode] = true;
		while(!queue.isEmpty()) {
			int next = queue.poll();
			System.out.print(next+1 +" ");
			for(int i=0; i<node; i++) {
				if(!visited[i]&&adj[next][i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken())-1;
		adj = new boolean[node][node];
		visited = new boolean[node];
		
		for(int i=0; i<edge; i++) {//인접행렬 값 할당
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			adj[start][end] = true;
			adj[end][start] = true;
		}
		
		dfs(startNode);//dfs수행
		visited = new boolean[node];//방문 배열 초기화
		System.out.println();
		bfs(startNode);//bfs수행
	}
}
