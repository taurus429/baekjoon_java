package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3474교수가된현우 {
	
	static int zero(int num) {
		int five = 5;
		int res = 0;
		while(num>=five) {
			res += num/five;
			five *= 5;
		}
		return res;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		for(int n: num) {
			System.out.println(zero(n));
		}
	}
}
