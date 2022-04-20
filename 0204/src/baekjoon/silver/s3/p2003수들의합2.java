package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2003수들의합2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		long M= Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		long[] sum = new long[N+1];
		for(int i=1; i<N+1; i++) {
			sum[i] = num[i-1] + sum[i-1];
		}
		int start =0;
		int end = 0;
		int cnt =0;
		while(start!=N+1&&end!=N+1) {
			if(sum[end]-sum[start]<M) {
				end++;
			}else if (sum[end]-sum[start]>M){
				start++;
			}else {
				cnt ++;
				start++;
			}
		}
		System.out.println(cnt);
	}
}
