package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14501퇴사 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] sche;
	static int n, max;
	
	static void check(int idx, int bound, int sum) {
		if(idx==n) {
			max = Math.max(max, sum);
			return;
		}
		if(idx>bound&&sche[idx][0]+idx-1<=n-1) {
			check(idx+1, sche[idx][0]+idx-1, sum+sche[idx][1]);
		}
		check(idx+1, bound, sum);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		sche = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			sche[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		check(0, -1, 0);
		System.out.println(max);
	}
}
