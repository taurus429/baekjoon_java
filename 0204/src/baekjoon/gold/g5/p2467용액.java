package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2467용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		long[] num = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		int start = 0;
		int end = n-1;
		long min = Long.MAX_VALUE;
		int minStart =-1;
		int minEnd = -1;
		while(start<end) {
			if(Math.abs(num[start]+num[end])<min) {
				min = Math.abs(num[start]+num[end]);
				minStart =start;
				minEnd = end;
			}
			if(num[start]+num[end]<0) {
				start++;
			}else if(num[start]+num[end]>0) {
				end--;
			}else {
				break;
			}
		}
		System.out.println(num[minStart]+" "+num[minEnd]);
	}
}
