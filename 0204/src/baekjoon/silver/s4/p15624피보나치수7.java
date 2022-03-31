package baekjoon.silver.s4;

import java.util.ArrayList;
import java.util.Scanner;

public class p15624피보나치수7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n==0) {
			System.out.println(0);
			return;
		}
		int bignum = 1000000007;
		ArrayList<Integer> fibo = new ArrayList<>();
		fibo.add(0);
		fibo.add(1);
		for(int i=0; i<n-1; i++) {
			int idx = fibo.size()-2;
			fibo.add((fibo.get(idx)+fibo.get(idx+1))%bignum);
		}
		System.out.println(fibo.get(fibo.size()-1));
	}
}
