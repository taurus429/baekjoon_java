package baekjoon.silver.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p16435스네이크버드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[] fruit = new int[N];
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			fruit[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(fruit);
		for(int i=0; i<N; i++) {
			if(fruit[i]<=h) {
				h++;
			} else {
				break;
			}
		}
		System.out.println(h);
	}
}
