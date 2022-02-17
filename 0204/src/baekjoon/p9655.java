package baekjoon;

import java.util.Scanner;

public class p9655 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		if(num%2==0) {
			System.out.println("CY");
		}else {
			System.out.println("SK");
		}
	}
}
