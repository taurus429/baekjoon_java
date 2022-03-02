package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11659구간합구하기4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<N+1; i++) {
			nums[i] += nums[i-1];
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			System.out.println(-(nums[Integer.parseInt(st.nextToken())-1]-nums[Integer.parseInt(st.nextToken())]));
		}
	}
}
