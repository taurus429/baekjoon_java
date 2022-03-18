package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p3273두수의합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int sum = Integer.parseInt(br.readLine());
		Arrays.sort(num);
		int start = 0;
		int end = n-1;
		int cnt =0;
		while(start<end) {
			if(num[start]+num[end]>sum) {
				end --;
			}else if(num[start]+num[end]<sum) {
				start ++;
			}else {
				cnt ++;
				start++;
				end --;
			}
		}
		System.out.println(cnt);
	}
}
