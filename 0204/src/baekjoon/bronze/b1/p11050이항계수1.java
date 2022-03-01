package baekjoon.bronze.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11050이항계수1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int fact(int n) {
		if(n==0)
			return 1;
		return n*fact(n-1);
	}
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		System.out.println(fact(N)/(fact(N-K)*fact(K)));
	}
}
