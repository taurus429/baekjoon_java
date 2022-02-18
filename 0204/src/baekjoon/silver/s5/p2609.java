package baekjoon.silver.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2609 {
	public static int gcd(int a, int b) {
		int temp;
		while(b!=0) {
			temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int gcdRes;
		if(a>b) {
			gcdRes = gcd(a,b);
		} else {
			gcdRes = gcd(b,a);
		}
		System.out.println(gcdRes);
		System.out.println(a*b/gcdRes);
	}
}
