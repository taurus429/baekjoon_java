package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p15656N과M7 {
	static int N, M;
	static int[] com, num;
	static StringBuilder sb = new StringBuilder();
	static void combi(int cnt) {
		if(cnt==M) {
			for(int c: com) {
				sb.append(c).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			com[cnt] = num[i];
			combi(cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		com = new int[M];
		
		num = new int[N];
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		combi(0);
		System.out.println(sb);
	}
}
