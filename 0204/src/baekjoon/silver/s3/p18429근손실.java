package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p18429근손실 {
	static int N;
	static boolean[] visited;
	static int[] per, kit;
	static int ans;
	static void permutate(int cnt, int sum) {
		if(cnt == N) {
			ans ++;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]&&kit[i]+sum>=0) {
				visited[i] = true;
				per[cnt] = i;
				permutate(cnt+1, kit[i]+sum);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		kit = new int[N];
		visited = new boolean[N];
		per = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			kit[i] = Integer.parseInt(st.nextToken())-K;
		}
		permutate(0, 0);
		System.out.println(ans);
	}
}
