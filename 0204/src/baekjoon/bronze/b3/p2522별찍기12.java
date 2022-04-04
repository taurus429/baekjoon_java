package baekjoon.bronze.b3;

import java.util.Scanner;

public class p2522별찍기12 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2 * N - 1; i++) {
			if (i <= N-1) {
				for (int j = 0; j < N-i-1; j++) {
					sb.append(" ");
				}
				for (int j = 0; j < i+1; j++) {
					sb.append("*");
				}
			} else {
				for (int j = 0; j <= i-N; j++) {
					sb.append(" ");
				}
				for (int j = 0; j < 2*N-i-1; j++) {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
