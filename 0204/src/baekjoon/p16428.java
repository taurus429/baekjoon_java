package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p16428 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		long a = Integer.parseInt(input[0]);
		long b = Integer.parseInt(input[1]);
		if (a >= 0 && b > 0) {
			System.out.println(a / b);
			System.out.println(a % b);
		} else
		if (a >= 0 && b < 0) {
			System.out.println(a / b);
			System.out.println(a % b);
		}
		if (a < 0 && b > 0) {
			System.out.println(a / b-1);
			System.out.println(a % b+b);
		}
		if (a < 0 && b < 0) {
			System.out.println(a / b+1);
			System.out.println(a % b-b);
		}
	}
}