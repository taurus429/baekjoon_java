package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10655마라톤 {
	static int getdist(int[] a, int[] b) {
		return Math.abs(a[0] -b[0]) + Math.abs(a[1] - b[1]);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] checkpoint  = new int[N][];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			checkpoint[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		int[] one = new int[N-1];
		int distance =0;
		for(int i=0; i<N-1; i++) {
			one[i] = getdist(checkpoint[i], checkpoint[i+1]);
			distance+=one[i];
		}
		int[] two = new int[N-2];
		for(int i=0; i<N-2; i++) {
			two[i] = getdist(checkpoint[i], checkpoint[i+2]);
		}
		int save = 0;
		for(int i=0; i<N-2; i++) {
			save = Math.max(save, one[i] + one[i+1] -two[i]);
		}
		System.out.println(distance-save);
		
	}
}
