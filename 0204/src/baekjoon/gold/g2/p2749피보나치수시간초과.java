package baekjoon.gold.g2;

import java.util.ArrayList;
import java.util.Scanner;

public class p2749피보나치수시간초과 {
	static public long fibo(long l) {
		if(l==0) {
			return 0;
		} else if (l==1) {
			return 1;
		}else {
			return fibo(l-1) + fibo(l-2);
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		System.out.println(fibo(n));
	}
}
