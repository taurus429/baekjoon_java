package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p6603로또 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] com = new int[6];
	static int[] num;
	
	static void combi(int cnt, int idx) {
		if(cnt==6) {
			for(int i=0; i<6; i++) {
				sb.append(num[com[i]]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=idx; i<N; i++) {
			com[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	public static void main(String[] args) throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) {
				System.out.println(sb);
				return;
			}
			num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			combi(0, 0);
			sb.append("\n");
		}
	}
}
