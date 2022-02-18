package baekjoon.bronze.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p3985 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int len = Integer.parseInt(br.readLine());
		int[] cake = new int[len];
		boolean[] taken = new boolean[len];
		int cnt = Integer.parseInt(br.readLine());
		int maxExpect = 0;
		int exIdx = -1;
		for (int i = 1; i <= cnt; i++) {
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int expect = end -start;
			if(expect > maxExpect) {
				maxExpect =expect;
				exIdx = i;
			}
			for (int j = start - 1; j < end; j++) {
				if (!taken[j]) {
					cake[j] = i;
					taken[j] = true;
				}
			}
		}
		int[] res = new int[cnt];
		for(int i=0; i<len; i++) {
			if(cake[i]!=0) {
				res[cake[i]-1]++;
			}
		}
		int max = Integer.MIN_VALUE;
		int idx = -1;
		for(int i=0; i<cnt; i++) {
			if(res[i]>max) {
				max = res[i];
				idx = i+1;
			}
		}
		System.out.println(exIdx+" "+idx);
	}
}
