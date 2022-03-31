package baekjoon.silver.s5;

import java.util.Scanner;

public class p1789수들의합 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long sum = scan.nextLong();
		System.out.println((int)Math.floor((-1+Math.sqrt(1+8*sum))/2));
	}
}
