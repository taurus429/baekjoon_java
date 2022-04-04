package baekjoon.bronze.b3;

import java.util.Scanner;

public class p10991별찍기16 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-i-1; j++) {
				sb.append(" ");
			}
			sb.append("*");
			if(i==0) {
				sb.append("\n");
				continue;
			}
			for(int j=0; j<i*2-1; j++) {
				sb.append(" ");
			}
			sb.append("*");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
