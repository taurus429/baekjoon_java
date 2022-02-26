package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1753최단경로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Node implements Comparable<Node>{// 노드를 저장할 클래스
		int end, weight;

		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) { // 노드를 정렬할 때 거리로 정렬하기 위해
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		PriorityQueue<Node> queue = new PriorityQueue<>();//후보 노드와 거리를 저장하는 우선순위 큐
		List<Node>[] list = new ArrayList[node];//인접 노드를 저장할 리스트
		for(int i=0; i<node; i++) {
			list[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[node];
		int[] distance = new int[node];
		Arrays.fill(distance, Integer.MAX_VALUE);
		int startNode = Integer.parseInt(br.readLine()) - 1;
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight)); //list의 start에 해당되는 인덱스에 목적 노드와 거리 저장
		}
		queue.add(new Node(startNode, 0)); //시작 노드를 큐에 넣음
		distance[startNode] = 0;//거리 0으로 초기화
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			int cur = current.end;
			
			if(visited[cur])//방문한 노드이면 패스
				continue;
			visited[cur] = true;
			
			for(Node n: list[cur]) {
				if(distance[n.end] > distance[cur] + n.weight) {//해당 노드에서의 간선이 최소값보다 작은 경우
					distance[n.end] = distance[cur] + n.weight; //거리값 배열 갱신
					queue.add(new Node(n.end, distance[n.end]));//큐에 넣음
				}
			}
		}
	
		for (int d : distance) {
			if (d == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(d);
			}
		}

	}
}
