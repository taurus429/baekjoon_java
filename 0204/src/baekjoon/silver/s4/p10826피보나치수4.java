package baekjoon.silver.s4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class p10826피보나치수4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n==0) {
			System.out.println(0);
			return;
		}
		ArrayList<BigInteger> fibo = new ArrayList<>();
		fibo.add(BigInteger.ZERO);
		fibo.add(BigInteger.ONE);
		for(int i=0; i<n-1; i++) {
			int idx = fibo.size()-2;
			fibo.add(fibo.get(idx).add(fibo.get(idx+1)));
		}
		System.out.println(fibo.get(fibo.size()-1));
	}
}