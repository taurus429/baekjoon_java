package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2485가로수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static long gcd(long a, long b) {
		if (b > a) {
			long temp = a;
			a = b;
			b = temp;
		}
		while (b != 0) {
			long temp = a;
			a = b;
			b = temp % b;
		}
		return a;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		long[] num = new long[N];
		for (int i = 0; i < N; i++) {
			num[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(num);
		long interval = -1;
		for (int i = 0; i < N - 1; i++) {
			if (i == 0) {
				interval = num[i + 1] - num[i];
			} else {
				interval = gcd(num[i + 1] - num[i], interval);
			}
		}
		System.out.println((num[N-1]-num[0])/interval+1-N);

	}
}
