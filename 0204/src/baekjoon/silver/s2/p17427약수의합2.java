package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class p17427약수의합2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += i*(N/i);
		}
		System.out.println(sum);
	}
}
