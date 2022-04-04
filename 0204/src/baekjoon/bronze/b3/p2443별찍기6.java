package baekjoon.bronze.b3;

import java.util.Scanner;

public class p2443별찍기6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N * 2 - 1; i++) {
			for (int j = 0; j < Math.abs(N - 1 - i); j++) {
				sb.append(" ");
			}
			if (i < N) {
				for (int j = 0; j < i * 2 + 1; j++) {
					sb.append("*");
				}
			} else {
				for (int j = 0; j < (N-(i+1-N)) * 2 - 1; j++) {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
