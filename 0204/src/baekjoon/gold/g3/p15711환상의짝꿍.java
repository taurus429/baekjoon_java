package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p15711환상의짝꿍 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[2000002];
		long[] nums = new long[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i] = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
		}
		ArrayList<Integer> prime = new ArrayList<>();
		prime.add(2);
		for (int i = 3; i < 2000002; i += 2) {
			int temp = (int) Math.sqrt(i);
			boolean flag = false;
			for (int p : prime) {
				if (temp < p)
					break;
				if (i % p == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				prime.add(i);
				isPrime[i] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (nums[i] < 4) {
				sb.append("NO\n");
			} else if (nums[i] % 2 == 0) {
				sb.append("YES\n");
			} else {
				long num = nums[i] - 2;
				if (num < 2000000) {
					if (isPrime[(int)num]) {
						sb.append("YES\n");
					} else {
						sb.append("NO\n");
					}
				} else {
					long temp = (long) Math.sqrt(num);
					boolean flag = false;
					for (int p : prime) {
						if (temp < p)
							break;
						if (num % p == 0) {
							flag = true;
							break;
						}
					}
					if (!flag) {
						sb.append("YES\n");
					} else {
						sb.append("NO\n");
					}
				}
			}
		}
		System.out.println(sb);
	}
}
