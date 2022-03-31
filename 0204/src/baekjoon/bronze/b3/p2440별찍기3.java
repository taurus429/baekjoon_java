package baekjoon.bronze.b3;

import java.util.Scanner;

public class p2440별찍기3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
