package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1043 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] visited;
	static int N;
	static boolean[] truth;
	static boolean[][] adj;
	
	static void dfs(int idx) {
		visited[idx] = true;
		truth[idx] = true;
		for(int i=0; i<N; i++) {
			if(!visited[i]&&adj[idx][i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int[] witness = new int[w];
		truth = new boolean[N];
		adj = new boolean[N][N];
		
		for(int i=0; i<w; i++) {
			witness[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<int[]> party = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int participate = Integer.parseInt(st.nextToken());
			int[] people = new int[participate];
			for(int j=0; j<participate; j++) {
				people[j] = Integer.parseInt(st.nextToken());
			}
			party.add(people);
		}
		for(int[] temp: party) {
			for(int i=0; i<temp.length-1; i++) {
				for(int j=i+1; j<temp.length; j++) {
					adj[temp[i]-1][temp[j]-1] = true;
					adj[temp[j]-1][temp[i]-1] = true;
				}
			}
		}
		
		for(int temp: witness) {
			visited = new boolean[N];
			dfs(temp-1);
		}
		int cnt =0;
		for(int temp[]: party) {
			if(!truth[temp[0]-1])
				cnt ++;
		}
		System.out.println(cnt);

	}
}
