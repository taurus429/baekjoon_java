package baekjoon.gold.g2;

import java.util.ArrayList;
import java.util.Scanner;

public class p2749피보나치수3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong()%1500000;
		if(n==0) {
			System.out.println(0);
			return;
		}
		int bignum = 1000000;
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
