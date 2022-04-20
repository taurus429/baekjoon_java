package baekjoon.bronze.b3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10992별찍기17 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++)
				System.out.print(" ");
			if (i == 0) {
				System.out.print("*");
			} else if (i == N - 1) {
				for (int j = 0; j < 2 * i + 1; j++)
					System.out.print("*");
				
			} else {
				System.out.print("*");
				for (int j = 0; j < 2 * i - 1; j++)
					System.out.print(" ");
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
