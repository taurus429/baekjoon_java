package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p11437LCA {
	static class Node {
		ArrayList<Integer> parent = new ArrayList<>();
		int depth;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N + 1];
		ArrayList<Integer>[] adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			adj[node1].add(node2);
			adj[node2].add(node1);
		}
		Node[] nodes = new Node[N + 1];
		for (int i = 0; i < N + 1; i++) {
			nodes[i] = new Node();
		}
		nodes[1].depth = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 1, 0 });
		visited[1] = true;
		int[] depth = new int[N+1];
		int[][] ac = new int[N+1][16];
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			depth[cur[0]] = depth[cur[1]] + 1;
			ac[cur[0]][0] = cur[1];
			
			for(int i=1; i<16; i++) {
				int temp = ac[cur[0]][i-1];
				ac[cur[0]][i] = ac[temp][i-1];
			}
			

			for (int next : adj[cur[0]]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.offer(new int[] { next, cur[0] });
				}
			}
		}

		N = Integer.parseInt(br.readLine());
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (depth[a] > depth[b]) {
				while (depth[a] != depth[b]) {
					int dif = depth[a] - depth[b];
					int res = (int) (Math.log(dif) / Math.log(2));
					a = ac[a][res];
				}
			} else if (depth[a] < depth[b]) {
				while (depth[a] != depth[b]) {
					int dif = depth[b] - depth[a];
					int res = (int) (Math.log(dif) / Math.log(2));
					b = ac[b][res];
				}
			}
			if(a==b) {
				System.out.println(a);
				continue;
			}
			label: while (true) {
				for (int i = 0; i < 16; i++) {
					if(ac[a][i]==ac[b][i]) {
						if(i==0) {
							break label;
						} else {
							a= ac[a][i-1];
							b= ac[b][i-1];
						}
						break;
					}
				}
			}
			System.out.println(ac[a][0]);
		}
		
	}
}
