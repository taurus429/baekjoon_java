package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class p6377roundandroundwego {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		label: while(true) {
			String input = "";
			try {
				input = br.readLine();
			} catch (IOException e) {
				break label;
			}
			int n = input.length();
			int[] num = new int[10];
			for(int i=0; i<n ;i++) {
				int temp = input.charAt(i) - 48;
				num[temp]++;
			}
			int realnum = Integer.parseInt(input);
			System.out.println(Arrays.toString(num));
			for(int i=2; i<=n; i++) {
				int[] num2 = new int[10];
				
			}
		}
	}
}
