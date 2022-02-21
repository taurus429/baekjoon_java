package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1238 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		for(int t=1; t<=10; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int edge = Integer.parseInt(st.nextToken())/2;
			int startNode = Integer.parseInt(st.nextToken())-1;
			boolean[][] adj = new boolean[100][100];
			boolean[] visited = new boolean[100];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<edge; i++) {
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				adj[start][end] = true;
			}
			Queue<Integer[]> queue = new LinkedList<Integer[]>();
			queue.add(new Integer[] {startNode, 0});
			visited[startNode] = true;
			int maxNode = -1;
			int maxturn = -1;
			while(!queue.isEmpty()) {
				Integer[] next= queue.poll();
				if(next[1]>maxturn) {
					maxNode=next[0];
					maxturn=next[1];
				} else if(next[1]==maxturn) {
					if(next[0]>maxNode) {
						maxNode = next[0];
					}
				}
				for(int i=0; i<100; i++) {
					if(!visited[i]&&adj[next[0]][i]) {
						visited[i] = true;
						queue.offer(new Integer[] {i, next[1]+1});
					}
				}
			}
			System.out.println("#"+t+" "+(maxNode+1));
		}
	}
}
