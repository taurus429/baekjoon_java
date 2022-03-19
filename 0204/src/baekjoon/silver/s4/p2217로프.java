package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class p2217로프 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		Integer[] num = new Integer[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		int ans = Integer.MIN_VALUE;
		Arrays.sort(num, Collections.reverseOrder());
		for(int i=0; i<N; i++) {
			ans = Math.max(ans, num[i]*(i+1));
		}
		System.out.println(ans);
	}
}
