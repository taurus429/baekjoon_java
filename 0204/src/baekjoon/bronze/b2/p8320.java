package baekjoon.bronze.b2;

import java.util.Scanner;

public class p8320 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int sum = 0;
		for (int i = 1; i <= (int) Math.sqrt(num); i++) {
			sum += num / i - i + 1;
		}
		System.out.println(sum);
	}
}
