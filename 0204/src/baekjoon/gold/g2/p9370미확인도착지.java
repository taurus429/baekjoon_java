package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p9370미확인도착지 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class Node implements Comparable<Node> {
		int end, weight;

		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			int candi = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int startnode = Integer.parseInt(st.nextToken()) - 1;
			int g = Integer.parseInt(st.nextToken()) - 1;
			int h = Integer.parseInt(st.nextToken()) - 1;

			ArrayList<Node>[] adj = new ArrayList[node];
			for (int i = 0; i < node; i++) {
				adj[i] = new ArrayList<Node>();
			}
			int[] distance = new int[node];
			Arrays.fill(distance, Integer.MAX_VALUE);

			boolean[] visited = new boolean[node];

			int bridge = -1;
			for (int i = 0; i < edge; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				int weight = Integer.parseInt(st.nextToken());
				adj[start].add(new Node(end, weight));
				adj[end].add(new Node(start, weight));
				if ((start == g && end == h) || (start == h && end == g)) {
					bridge = weight;
				}
			}
			int[] candidate = new int[candi];
			for (int i = 0; i < candi; i++) {
				candidate[i] = Integer.parseInt(br.readLine()) - 1;
			}

			PriorityQueue<Node> pq = new PriorityQueue<>();
			distance[startnode] = 0;
			pq.add(new Node(startnode, 0));

			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				if (visited[cur.end])
					continue;
				visited[cur.end] = true;

				for (Node n : adj[cur.end]) {
					if (distance[n.end] > distance[cur.end] + n.weight) {
						distance[n.end] = distance[cur.end] + n.weight;
						pq.offer(new Node(n.end, distance[n.end]));
					}
				}
			}
			int bridgeEnd;
			int bridgeStart;
			if (distance[g] > distance[h]) {
				bridgeEnd = g;
				bridgeStart = h;
			} else {
				bridgeEnd = h;
				bridgeStart = g;
			}

			int[] nextdistance = new int[node];
			Arrays.fill(nextdistance, Integer.MAX_VALUE);
			Arrays.fill(visited, false);
			nextdistance[bridgeEnd] = 0;
			pq.add(new Node(bridgeEnd, 0));

			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				if (visited[cur.end])
					continue;
				visited[cur.end] = true;

				for (Node n : adj[cur.end]) {
					if (nextdistance[n.end] > nextdistance[cur.end] + n.weight) {
						nextdistance[n.end] = nextdistance[cur.end] + n.weight;
						pq.offer(new Node(n.end, nextdistance[n.end]));
					}
				}
			}

			Arrays.sort(candidate);
			for (int c : candidate) {
				if (distance[c] == distance[bridgeStart] + bridge + nextdistance[c])
					System.out.print((c + 1) + " ");
			}
			System.out.println();
		}
	}
}
