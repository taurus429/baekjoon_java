package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p6236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] withdraw;
	static int N;
	static int M;
	static int calM(int money) {
		int cnt =0;
		int sum =0;
		for(int i=0; i<N; i++) {
			if(sum - withdraw[i] < 0) {
				cnt ++;
				sum = money;
			}
			sum -= withdraw[i];
			if(sum<0) {
				return Integer.MAX_VALUE;
			}
		}
		return cnt;
	}
	static void binary(int start, int end) {
		while (start < end) {
			int mid = start + (end-start)/2;
			if(calM(mid)<=M) {
				end = mid;
			}
			else {
				start = mid+1;
			}
		}
		System.out.println(start);
	}
	public static void main(String[] args) throws IOException {
		String input[] = br.readLine().split(" ");
		N =Integer.parseInt(input[0]);
		M =Integer.parseInt(input[1]);
		withdraw = new int[N];
		for(int i=0; i<N; i++) {
			withdraw[i] = Integer.parseInt(br.readLine());
		}
		binary(0, 1000000);
		
	}
}
