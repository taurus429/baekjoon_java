package swea.p1215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String input = br.readLine();
		String[] stringNumber = input.split(" ");
		int[] number = new int[8];
		for (int i = 0; i < 8; i++) {
			number[i] = Integer.parseInt(stringNumber[i]);
		}
		boolean res;
		do {
			res = cycle(number);
		} while (res);
		for (int a: number) {
			System.out.print(a+" ");
		}
	}

	static boolean cycle(int[] number) {
		for (int i = 1; i < 6; i++) {
			number[0] -= i;
			if (number[0] < 0) {
				number[0] = 0;
			}
			int temp = number[0];
			for (int j = 0; j < 7; j++) {
				number[j] = number[j + 1];
			}
			number[7] = temp;
			if (temp==0) return false;
		}
		return true;
	}
}