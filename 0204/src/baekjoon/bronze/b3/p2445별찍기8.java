package baekjoon.bronze.b3;

import java.util.Scanner;

public class p2445별찍기8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2 * N - 1; i++) {
			if (i <= N-1) {
				for (int j = 0; j <= i; j++) {
					sb.append("*");
				}
				for (int j = 0; j < (N - i-1) * 2; j++) {
					sb.append(" ");
				}
				for (int j = 0; j <= i; j++) {
					sb.append("*");
				}
			} else {
				for (int j = 0; j <= (2*N-2-i); j++) {
					sb.append("*");
				}
				for (int j = 0; j < (i-N+1) * 2; j++) {
					sb.append(" ");
				}
				for (int j = 0; j <= 2*N-2-i; j++) {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
