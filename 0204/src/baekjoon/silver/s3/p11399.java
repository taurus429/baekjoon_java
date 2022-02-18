package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p11399 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String[] stringInput = br.readLine().split(" ");
		int[] input = new int[len];
		for(int i=0; i<len; i++) {
			input[i] = Integer.parseInt(stringInput[i]);
		}
		Arrays.sort(input);
		for(int i=1; i<len; i++) {
			input[i] = input[i] + input[i-1];
		}
		int sum =0;
		for (int i=0; i<len; i++) {
			sum += input[i];
		}
		System.out.println(sum);
		
	}
}
