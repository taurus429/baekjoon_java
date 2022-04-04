package baekjoon.bronze.b3;

import java.util.Scanner;

public class p10990별찍기15 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-i-1; j++) {
				sb.append(" ");
			}
			sb.append("*");
			for(int j=0; j<i-0; j++) {
				sb.append(" *");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
