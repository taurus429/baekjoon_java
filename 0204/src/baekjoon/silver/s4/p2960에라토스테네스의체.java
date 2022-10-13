package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2960에라토스테네스의체 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int count=0;
		boolean[] remove = new boolean[N+1];
		for(int i=2; i<=N; i++) {
			if(!remove[i]) {
				for(int n=1; n*i<=N; n++) {
					if(!remove[n*i]) {
						remove[n*i] = true;
						count++;
						if(count==K) {
							System.out.println(n*i);
							return;
						}
					}
				}
			}
		}
	}
}
