package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1939중량제한 {
	static int N;
	static HashMap<Integer, Integer>[] bridge;
	static boolean way(int start, int end, int weight) {
		boolean[] visited = new boolean[N];
		visited[start] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(Map.Entry<Integer, Integer> adj : bridge[cur].entrySet()) {
				int next = adj.getKey();
				int w = adj.getValue();
				if(!visited[next]&&w>=weight) {
					visited[next] = true;
					if(next==end)
						return true;
					queue.offer(next);
				}
			}
		}
		return visited[end];
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		bridge= new HashMap[N];
		for(int i=0; i<N; i++) {
			bridge[i] = new HashMap<>();
		}
		int maxWeight = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			if(bridge[start].containsKey(end)) {
				bridge[start].replace(end, Math.max(bridge[start].get(end), weight));
				bridge[end].replace(start, Math.max(bridge[end].get(start), weight));
			} else {
				bridge[start].put(end, weight);
				bridge[end].put(start, weight);
			}
			maxWeight = Math.max(maxWeight, weight);
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;
		
		int low = 1;
		int high = maxWeight;
		int max = 0;
		while(low<=high) {
			int mid = (low + high) / 2;
			
			boolean existed = way(start, end, mid);
			if(existed) {
				max = Math.max(max, mid);
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		System.out.println(max);
	}
}
