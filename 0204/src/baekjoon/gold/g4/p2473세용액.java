package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2473세용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		long[] num = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Long.parseLong(st.nextToken());
		}
		
		long min = Long.MAX_VALUE;
		int a=-1;
		int b=-1;
		int c=-1;
		Arrays.sort(num);
		for(int i=0; i<n-2; i++) {
			int fixed = i;
			int start = i+1;
			int end = n-1;
			while(start<end) {
				long temp = Math.abs(num[fixed]+num[start]+num[end]);
				if(temp<min) {
					min = temp;
					a = fixed;
					b= start;
					c = end;
				}
				if(num[fixed]+num[start]+num[end]<0) {
					start ++;
				} else {
					end --;
				}
			}
		}
		System.out.println(num[a]+" "+num[b]+" "+num[c]);
	}
}
