package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class p6588골드바흐의추측 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int input = -1;
		int max = -1;
		ArrayList<Integer> num = new ArrayList<>();
		while (input != 0) {
			input = Integer.parseInt(br.readLine());
			if (input > max) {
				max = input;
			}
			if (input != 0)
				num.add(input);
		}
		boolean[] prime = new boolean[max + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 0; i < max + 1; i++) {
			if (prime[i]) {
				int mul = 2;
				while (i * mul < max + 1) {
					prime[i * mul] = false;
					mul++;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < max + 1; i++) {
			if (prime[i]) {
				cnt++;
			}
		}
		int[] p = new int[cnt];
		int idx = 0;
		for (int i = 0; i < max + 1; i++) {
			if (prime[i]) {
				p[idx] = i;
				idx++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int n : num) {
			int start = 0;
			int end = cnt - 1;
			boolean find = false;
			while (start <= end) {
				if (p[start] + p[end] < n) {
					start++;
				} else if (p[start] + p[end] > n) {
					end--;
				} else {
					find = true;
					break;
				}
			}
			if (find) {
				sb.append(n+ " = "+ p[start] + " + " + p[end]+"\n");
			} else {
				sb.append("Goldbach's conjecture is wrong.\n");
			}
		}
		System.out.println(sb);
	}
}
