package baekjoon.bronze.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13458시험감독 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] room = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			room[i] -= b;
			if(room[i]<0) {
				room[i] = 0;
			}
		}
		long sum = N;
		for(int i=0; i<N; i++) {
			if(room[i]!=0) {
			sum += (room[i]-1)/c+1;
			}
		}
		System.out.println(sum);
	}
}
