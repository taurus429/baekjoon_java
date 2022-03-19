package baekjoon.gold.g4;

import java.util.Scanner;

public class p2661좋은수열 {
	static int N;
	static boolean find;
	static void make(String num) {
		if (num.length() == N) {
			System.out.println(num);
			find = true;
			return;
		}
		for (int i = 1; i <= 3; i++) {
			String newnum = num + i;
			boolean flag = true;
			int len = newnum.length();
			int k=1;
			while (len - 2 * k >= 0) {
				if(newnum.substring(len-2*k, len-k).equals(newnum.substring(len-k,len))) {
					flag = false;
					//System.out.println(false);
					//System.out.println(newnum);
					break;
				}
				k++;
			}
			if (flag&&!find)
				make(newnum);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		make("");
	}
}
