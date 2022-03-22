package baekjoon.silver.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2822점수계산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[8];
		for(int i=0; i<8; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		int[] clone = num.clone();
		Arrays.sort(clone);
		int x = clone[3];
		int sum =0;
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<8; i++) {
			if(num[i]>=x) {
				sum += num[i];
				sb.append(i+1).append(" ");
			}
		}
		System.out.println(sum);
		System.out.println(sb);
		
	}
}
