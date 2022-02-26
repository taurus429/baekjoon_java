package baekjoon.platinum.p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class p1786찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String T = br.readLine();
		String P = br.readLine();
		int[] p = new int[P.length()];
		int j = 0;
		for (int i = 1; i < p.length; i++) {
			while (j > 0 && P.charAt(i) != P.charAt(j)) {
				j = p[j - 1];
			}
			if (P.charAt(i) == P.charAt(j)) {
				p[i] = ++j;
			}
		}
		ArrayList<Integer> position = new ArrayList<>();
		for (int i = 0; i < T.length(); i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j)) {
				j = p[j - 1];
			}
			if (T.charAt(i) == P.charAt(j)) {
				if (j == P.length() - 1) {
					if (i - P.length() + 2 > 0) {
						position.add(i - P.length() + 2);
					}
						j = p[j];
				} else {
					j++;
				}
			}
		}
		System.out.println(position.size());
		for (int pos : position) {
			System.out.print(pos + " ");
		}
	}
}
