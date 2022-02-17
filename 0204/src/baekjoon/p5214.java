package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p5214 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] getCombi(int n){
		int len = n*(n-1)/2;
		int cnt =0;
		int[][] res = new int[len][];
		for(int i=0; i<n-1; i ++) {
			for(int j=i+1; j<n; j++) {
				res[cnt] = new int[] {i,j};
				cnt++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int node = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int hyper = Integer.parseInt(input[2]);
		boolean[] visited = new boolean[hyper];
		boolean[][] hyperTube = new boolean[hyper][hyper];
		
		ArrayList<Integer>[] adj = new ArrayList[node];
		for(int i=0; i<node; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < hyper; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				adj[Integer.parseInt(st.nextToken()) - 1].add(i);
			}
		}
		if(node==1&&k==1&&hyper==1) {
			System.out.println(1);
			return;
		}
		
		for(int i=0; i<node; i++) {
			if(adj[i].size()>=2) {
				int[][] combi = getCombi(adj[i].size());
				for(int[] c: combi) {
					hyperTube[adj[i].get(c[0])][adj[i].get(c[1])] = true;
					hyperTube[adj[i].get(c[1])][adj[i].get(c[0])] = true;
				}
			}
		}
		
		boolean[] dest = new boolean[hyper];
		for(int end: adj[node-1]) {			
			dest[end] = true;
		}
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		for(int start: adj[0]) {			
			queue.offer(new Integer[] { start, 0 });
			visited[start] = true;
		}
		boolean find = false;
		while (!queue.isEmpty()) {
			Integer[] next = queue.poll();
			if (dest[next[0]]) {
				System.out.println(next[1]+2);
				find = true;
				break;
			}
			for(int i=0; i<hyper; i++) {
				if(hyperTube[next[0]][i]&&!visited[i]) {		
					queue.offer(new Integer[] { i, next[1]+1 });
					visited[i] = true;
				}
			}
			
		}
		if(!find) {
			System.out.println(-1);
		}

	}
}
