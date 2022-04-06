package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17471게리맨더링 {
	static int N;
	static int ans = Integer.MAX_VALUE;
	static boolean[][] adj;
	static int[] popul;
	static int count(int[] party, int idx) {
		int res = 1;
		boolean[] search = new boolean[N];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(idx);
		search[idx] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i=0; i<N; i++) {
				if(adj[i][cur]&&!search[i]&&party[i]==party[cur]) {
					queue.offer(i);
					search[i] = true;
					res ++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		adj = new boolean[N][N];
		popul = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for(int j=0; j<m; j++) {
				int point = Integer.parseInt(st.nextToken()) -1;
				adj[point][i] = true;
				adj[i][point] = true;
			}
		}
		
		int[] party = new int[N];
		for(int i=1; i<(int)Math.pow(2, N)-1; i++) {
			Arrays.fill(party, -1);
			
			String bin = Integer.toBinaryString(i);
			int idx = N-1;
			for(int j= bin.length()-1; j>=0; j--) {
				if(bin.charAt(j)=='1')
					party[idx] =1;
				idx--;
			}
			int idx1 = -1;
			int idx2 = -1;
			for(int j=0; j<N; j++) {
				if(party[j]==1) {
					idx1 = j;
				}
			}
			for(int j=0; j<N; j++) {
				if(party[j]==-1) {
					idx2 = j;
				}
			}
			if(count(party, idx1)+count(party, idx2)==N) {
				int diff = 0;
				for(int j=0; j<N; j++) {
					diff += party[j] * popul[j];
				}
				ans = Math.min(ans, Math.abs(diff));
			}
			
			
		}
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else 
			System.out.println(ans);
		
	}
}
