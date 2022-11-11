package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1684같은나머지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] array = new int[N];
		int maxNum = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			maxNum = Math.max(maxNum, array[i]);
		}
		int answer = 0;
		for (int i = 1; i <= maxNum + 1; i++) {
			boolean find = true;
			int common = -1;
			int r = 0;
			for (int j = 0; j < N; j++) {
				r = array[j] % i;
				if (r < 0) {
					r += i;
				}
				if (j == 0) {
					common = r;
				} else {
					if (r != common) {
						find = false;
						break;
					}
				}
			}
			if (find)
				answer = Math.max(answer, i);
		}
		System.out.println(answer);
	}
}
