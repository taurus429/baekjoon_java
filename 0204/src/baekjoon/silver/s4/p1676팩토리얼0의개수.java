package baekjoon.silver.s4;

import java.util.Scanner;

public class p1676팩토리얼0의개수 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int two =0;
		int five = 0;
		for(int i=2; i<=N; i++) {
			int temp = i;
			while(temp%2==0) {
				two++;
				temp/=2;
			}
			temp = i;
			while(temp%5==0) {
				five++;
				temp/=5;
			}
		}
		System.out.println(Math.min(two, five));
	}
}
